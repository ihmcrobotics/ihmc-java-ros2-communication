@###############################################
@#
@# ROS 2 interface to ROS 1 interface converter
@#
@# EmPy template for converting .msg and .srv
@# files to work with ROS 1
@#
@###############################################
@# Start of Template
@#
@# Context:
@#  - spec (rosidl_parser.MessageSpecification)
@#    Parsed specification of the .msg file
@#  - subfolder (string)
@#    The subfolder / subnamespace of the message
@#    Either 'msg' or 'srv'
@#  - subfolders (list of strings)
@#    The subfolders under the package name
@#    in which the type gets defined which are not part of the namespace
@#  - get_include_directives (function)
@#  - msg_type_to_idl (function)
@###############################################
@{
from rosidl_generator_cpp import escape_string
from rosidl_generator_ros1 import ROS2_TO_ROS1_TYPES
}@
@#
@# Find the header field and inline it first since it has special meaning in ROS 1
@#
@{header_field = None}@
@[for field in spec.fields]@
@{_, _, converted_type = ros2_type_to_ros1(field.type)}@
@[if converted_type.startswith('Header')]@
@{header_field = field}@
@[if field.comments]@
@[for comment in field.comments]@
# @(comment)
@[end for]@
@[end if]@
@(converted_type) @(field.name)

@[if header_field]@
@{spec.fields.remove(header_field)}@
@[end if]@
@[break]@
@[end if]@
@[end for]@
@#
@#
@# Constants
@#
@[for constant in spec.constants]@
@{converted_type = ROS2_TO_ROS1_TYPES[constant.type]}@
@[if constant.comments]@
@[for comment in constant.comments]@
# @(comment)
@[end for]@
@[end if]@
@[if converted_type.startswith('string')]@
@(converted_type) @(constant.name)="@(escape_string(constant.value))"

@[else]@
@(converted_type) @(constant.name)=@(constant.value)

@[end if]@
@[end for]@
@#
@#
@# Fields
@#
@[for field in spec.fields]@
@{_, _, converted_type = ros2_type_to_ros1(field.type)}@
@[if field.comments]@
@[for comment in field.comments]@
# @(comment)
@[end for]@
@[end if]@
@[if field.default_value]@
# Field default value @(field.default_value)
@[end if]@
@(converted_type) @(field.name)

@[end for]@

