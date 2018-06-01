/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package us.ihmc.ros2.rosidl.geometry_msgs.msg.dds;

import geometry_msgs.msg.dds.PointPubSubType.AbstractPointPubSubTypeImplementation;
import us.ihmc.euclid.tuple3D.Point3D;

public class Point3DPubSubTypeImpl extends AbstractPointPubSubTypeImplementation
{

   @Override
   protected void copy(Point3D src, Point3D dest)
   {
      dest.set(src);
   }

   @Override
   protected double getX(Point3D data)
   {
      return data.getX();
   }

   @Override
   protected void setX(Point3D data, double x)
   {
      data.setX(x);
   }

   @Override
   protected double getY(Point3D data)
   {
      return data.getY();
   }

   @Override
   protected void setY(Point3D data, double y)
   {
      data.setY(y);
   }

   @Override
   protected double getZ(Point3D data)
   {
      return data.getZ();
   }

   @Override
   protected void setZ(Point3D data, double z)
   {
      data.setZ(z);
   }

   @Override
   public Point3D createData()
   {
      return new Point3D();
   }

}
