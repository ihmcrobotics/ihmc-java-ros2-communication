# Copyright 2014-2015 Open Source Robotics Foundation, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import os

from rosidl_cmake import expand_template
from rosidl_cmake import get_newest_modification_time
from rosidl_cmake import read_generator_arguments
from rosidl_parser import Field
from rosidl_parser import MessageSpecification
from rosidl_parser import parse_message_file
from rosidl_parser import parse_service_file
from rosidl_parser import Type


# used by the template
ROS2_TO_ROS1_TYPES = {
    'bool': 'bool',
    'byte': 'int8',
    'char': 'uint8',
    'int8': 'int8',
    'uint8': 'uint8',
    'int16': 'int16',
    'uint16': 'uint16',
    'int32': 'int32',
    'uint32': 'uint32',
    'int64': 'int64',
    'uint64': 'uint64',
    'float32': 'float32',
    'float64': 'float64',
    'string': 'string',
    'std_msgs/Header' : 'Header',
    'builtin_interfaces/Time' : 'time',
    'builtin_interfaces/Duration' : 'duration'
}

def generate_ros_msg(generator_arguments_file, subfolders, extension_module_name):
    args = read_generator_arguments(generator_arguments_file)

    template_file = os.path.join(args['template_dir'], 'msg.ros1.em')
    assert os.path.exists(template_file), \
        "The template '%s' does not exist" % template_file

    # look for extensions for the default functions
    functions = {
        'get_include_directives': get_include_directives,
        'get_post_struct_lines': get_post_struct_lines,
        'ros2_type_to_ros1': ros2_type_to_ros1,
    }
    if extension_module_name is not None:
        pkg = __import__(extension_module_name)
        module_name = extension_module_name.rsplit('.', 1)[1]
        if hasattr(pkg, module_name):
            module = getattr(pkg, module_name)
            for function_name in functions.keys():
                if hasattr(module, function_name):
                    functions[function_name] = \
                        getattr(module, function_name)

    pkg_name = args['package_name']
    latest_target_timestamp = get_newest_modification_time(args['target_dependencies'])

    for ros_interface_file in args['ros_interface_files']:
        subfolder = os.path.basename(os.path.dirname(ros_interface_file))
        extension = os.path.splitext(ros_interface_file)[1]
        output_path = os.path.join(args['output_dir'], subfolder)
        for sub in subfolders:
            output_path = os.path.join(output_path, sub)
        if extension == '.msg':
            spec = parse_message_file(pkg_name, ros_interface_file)
            generated_file = os.path.join(output_path, '%s.msg' % spec.base_type.type)

            data = {'spec': spec, 'subfolder': subfolder, 'subfolders': subfolders}
            data.update(functions)
            expand_template(
                template_file, data, generated_file,
                minimum_timestamp=latest_target_timestamp)

        elif extension == '.srv':
            srv_spec = parse_service_file(pkg_name, ros_interface_file)
            request_fields = [
                Field(
                    Type('uint64', context_package_name=pkg_name),
                    'client_guid_0', default_value_string=None),
                Field(
                    Type('uint64', context_package_name=pkg_name),
                    'client_guid_1', default_value_string=None),
                Field(
                    Type('int64', context_package_name=pkg_name),
                    'sequence_number', default_value_string=None),
                Field(
                    Type('%s_Request' % srv_spec.srv_name, context_package_name=pkg_name),
                    'request', default_value_string=None)
            ]
            response_fields = [
                Field(
                    Type('uint64', context_package_name=pkg_name),
                    'client_guid_0', default_value_string=None),
                Field(
                    Type('uint64', context_package_name=pkg_name),
                    'client_guid_1', default_value_string=None),
                Field(
                    Type('int64', context_package_name=pkg_name),
                    'sequence_number', default_value_string=None),
                Field(
                    Type('%s_Response' % srv_spec.srv_name, context_package_name=pkg_name),
                    'response', default_value_string=None)
            ]
            constants = []
            sample_spec_request = MessageSpecification(
                srv_spec.pkg_name, 'Sample_%s_Request' % srv_spec.srv_name, request_fields,
                constants)
            sample_spec_response = MessageSpecification(
                srv_spec.pkg_name, 'Sample_%s_Response' % srv_spec.srv_name, response_fields,
                constants)

            generated_files = [
                (sample_spec_request, os.path.join(
                    output_path, '%s.msg' % sample_spec_request.base_type.type)),
                (sample_spec_response, os.path.join(
                    output_path, '%s.msg' % sample_spec_response.base_type.type)),
            ]

            for spec, generated_file in generated_files:
                data = {'spec': spec, 'subfolder': 'srv', 'subfolders': subfolders}
                data.update(functions)
                expand_template(
                    template_file, data, generated_file,
                    minimum_timestamp=latest_target_timestamp)

    return 0



# used by the template
def get_include_directives(spec, subfolders):
    include_directives = set()
    for field in spec.fields:
        if field.type.is_primitive_type():
            continue
        include_directive = '#include "%s/%s.msg"' % \
            ('/'.join([field.type.pkg_name] + subfolders), field.type.type)
        include_directives.add(include_directive)
    return sorted(include_directives)


# used by the template
def get_post_struct_lines(spec):
    return []

# used by the template
def ros2_type_to_ros1(type_):
    """
    Convert a ROS 2 type into a ROS 1 type.

    Example input: uint32, std_msgs/String
    Example output: uint32_t, std_msgs::String_<ContainerAllocator>

    @param type: The message type
    @type type: rosidl_parser.Type
    """
    string_upper_bound = None
    compound_type = '%s/%s' % (type_.pkg_name, type_.type)

    if type_.type in ROS2_TO_ROS1_TYPES or type_.is_primitive_type():
        ros1_type = ROS2_TO_ROS1_TYPES[type_.type]
    elif compound_type in ROS2_TO_ROS1_TYPES:
        ros1_type = ROS2_TO_ROS1_TYPES[compound_type]
    else:
        if type_.type.endswith('_Request') or type_.type.endswith('_Response'):
            # ros1_type = '%s::srv::dds_::%s_' % (type_.pkg_name, type_.type)
            ros1_type = compound_type
        else:
            ros1_type = compound_type
    return _ros2_type_to_ros1(type_, ros1_type, string_upper_bound=string_upper_bound)


def _ros2_type_to_ros1(type_, ros1_type, string_upper_bound=None):
    if type_.is_array:
        return ['', '', '%s[]' % ros1_type]
    else:
        return ['', '', ros1_type]
