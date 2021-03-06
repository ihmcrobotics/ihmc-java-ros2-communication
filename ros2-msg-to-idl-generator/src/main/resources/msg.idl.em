@###############################################
@#
@# ROS interface to DDS interface converter
@#
@# EmPy template for generating <msg>.idl files
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
@
@{
from rosidl_generator_cpp import escape_string
from rosidl_generator_dds_idl import MSG_TYPE_TO_IDL
}@
@
#ifndef __@(spec.base_type.pkg_name)__@(subfolder)__@(spec.base_type.type)__idl__
#define __@(spec.base_type.pkg_name)__@(subfolder)__@(spec.base_type.type)__idl__

@#############################
@# Include dependency messages
@#############################
@[if spec.base_type.type.startswith('Sample_')]
@[  for line in get_include_directives(spec, ['srv'] + subfolders)]@
@(line)
@[  end for]@
@[else]@
@[  for line in get_include_directives(spec, ['msg'] + subfolders)]@
@(line)
@[  end for]@
@[end if]@
module @(spec.base_type.pkg_name)
{
  module @(subfolder)
  {
    module dds
    {
@##################
@# Define constants
@##################
@# Constants
@[for constant in spec.constants]@
   @[if constant.comments]@
   /**
   @[for comment in constant.comments]@
    * @(comment)
   @[end for]@
    */
   @[end if]@
   const @(MSG_TYPE_TO_IDL[constant.type]) @(constant.name) =
@[  if constant.type == 'bool']@
      @('TRUE' if constant.value else 'FALSE');
@[  elif constant.type == 'char']@
      '\@(constant.value)';
@[  elif constant.type == 'int8']@
      @(constant.value if constant.value >= 0 else (constant.value + 256));
@[  elif constant.type == 'string']@
      "@(escape_string(constant.value))";
@[  else]@
      @(constant.value);
@[  end if]@

@[end for]
@#@{
@#typedefs = set([])
@#for field in spec.fields:
@#  idl_typedef, idl_typedef_var, _ = msg_type_to_idl(field.type)
@#  if idl_typedef and idl_typedef_var and (idl_typedef, idl_typedef_var) not in typedefs:
@#    print('%s %s__%s__%s' % (idl_typedef, spec.base_type.pkg_name, spec.base_type.type, idl_typedef_var))
@#    typedefs.add((idl_typedef, idl_typedef_var))
@#}@
@################################
@# Message struct with all fields
@################################
   @[if spec.header_comments]@
   /**
   @[for comment in spec.header_comments]@
    * @(comment)
   @[end for]@
    */
   @[end if]@
   @@TypeCode(type="@(spec.base_type.pkg_name)::@(subfolder)::dds_::@(spec.base_type.type)_")
      struct @(spec.base_type.type)
      {
@[if spec.fields]@
@[  for field in spec.fields]@
    @[if field.comments]@
    /**
    @[for comment in field.comments]@
     * @(comment)
    @[end for]@
     */
    @[end if]@
@[ if field.default_value ]@
    @("@defaultValue(value=" + str(field.default_value) + ")")
@{    idl_typedef, idl_typedef_var, idl_type = msg_type_to_idl(field.type)}@
@#@[    if idl_typedef and idl_typedef_var]@
@#@(      spec.base_type.pkg_name)__@(spec.base_type.type)__@(idl_type) @(field.name);
@#@[    else]@
        @(idl_type) @(field.name)@(idl_typedef_var);
@#@[    end if]@
@[else]@
@{    idl_typedef, idl_typedef_var, idl_type = msg_type_to_idl(field.type)}@
@#@[    if idl_typedef and idl_typedef_var]@
@#@(      spec.base_type.pkg_name)__@(spec.base_type.type)__@(idl_type) @(field.name);
@#@[    else]@
    @(idl_type) @(field.name)@(idl_typedef_var);
@#@[    end if]@
@[end if]@
@[  end for]@
@[else]@
        boolean unused_placeholder_field;
@[end if]@
      };
@[for line in get_post_struct_lines(spec)]@
@(line)

@[end for]@
    };
  };
};

#endif
