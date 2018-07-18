#!/usr/bin/env python3

__metaclass__ = type

import sys
import argparse

from rosidl_generator_ros1 import generate_ros_msg

def main(argv=sys.argv[1:]):
    parser = argparse.ArgumentParser(
        description='Generate ROS 1 compatible interfaces from ROS 2 .msg definitions.',
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

    return generate_ros_msg(
        args.generator_arguments_file,
        args.subfolders,
        args.extension
    )


if __name__ == '__main__':
    sys.exit(main())
