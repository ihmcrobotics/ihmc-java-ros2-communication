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

import geometry_msgs.msg.dds.Point32PubSubType.AbstractPoint32PubSubTypeImplementation;
import us.ihmc.euclid.tuple3D.Point3D32;

public class Point3D32PubSubTypeImpl extends AbstractPoint32PubSubTypeImplementation
{

   @Override
   protected void copy(Point3D32 src, Point3D32 dest)
   {
      dest.set(src);
   }

   @Override
   protected float getX(Point3D32 data)
   {
      return data.getX32();
   }

   @Override
   protected void setX(Point3D32 data, float x)
   {
      data.setX(x);
   }

   @Override
   protected float getY(Point3D32 data)
   {
      return data.getY32();
   }

   @Override
   protected void setY(Point3D32 data, float y)
   {
      data.setY(y);
   }

   @Override
   protected float getZ(Point3D32 data)
   {
      return data.getZ32();
   }

   @Override
   protected void setZ(Point3D32 data, float z)
   {
      data.setZ(z);
   }

   @Override
   public Point3D32 createData()
   {
      return new Point3D32();
   }

}
