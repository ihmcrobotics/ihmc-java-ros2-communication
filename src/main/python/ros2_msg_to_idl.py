#!/usr/bin/env python3

__metaclass__ = type

import sys
import argparse


sys.path.insert(0, "../../thirdparty/python/")
sys.path.insert(0, "../../../thirdparty/rosidl/rosidl_parser")
sys.path.insert(0, "../../../thirdparty/rosidl/rosidl_generator_cpp")
sys.path.insert(0, "../../../thirdparty/rosidl_dds/rosidl_generator_dds_idl")




from rosidl_generator_dds_idl import generate_dds_idl




def main(argv=sys.argv[1:]):
    parser = argparse.ArgumentParser(
        description='Generate the DDS interfaces for ROS interfaces.',
        formatter_class=argparse.ArgumentDefaultsHelpFormatter)
    parser.add_argument(
        '--generator-arguments-file',
        required=True,
        help='The location of the file containing the generator arguments')
    parser.add_argument(
        '--subfolders',
        nargs='*',
        help='The subfolders between the package name and the interface '
             'definition')
    parser.add_argument(
        '--extension',
        nargs='?',
        help='The Python module extending the generator')
    args = parser.parse_args(argv)

    return generate_dds_idl(
        args.generator_arguments_file,
        args.subfolders,
        args.extension
    )


if __name__ == '__main__':
    sys.exit(main())


