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

import geometry_msgs.msg.dds.QuaternionPubSubType.AbstractQuaternionPubSubTypeImplementation;
import us.ihmc.euclid.tuple4D.Quaternion;

public class QuaternionPubSubTypeImpl extends AbstractQuaternionPubSubTypeImplementation
{

   @Override
   protected void copy(Quaternion src, Quaternion dest)
   {
      dest.set(src);
   }

   @Override
   protected double getX(Quaternion data)
   {
      return data.getX();
   }

   @Override
   protected void setX(Quaternion data, double x)
   {
      data.setUnsafe(x, data.getY(), data.getZ(), data.getS());
   }

   @Override
   protected double getY(Quaternion data)
   {
      return data.getY();
   }

   @Override
   protected void setY(Quaternion data, double y)
   {
      data.setUnsafe(data.getX(), y, data.getZ(), data.getS());
   }

   @Override
   protected double getZ(Quaternion data)
   {
      return data.getZ();
   }

   @Override
   protected void setZ(Quaternion data, double z)
   {
      data.setUnsafe(data.getX(), data.getY(), z, data.getS());
   }

   @Override
   protected double getW(Quaternion data)
   {
      return data.getS();
   }

   @Override
   protected void setW(Quaternion data, double w)
   {
      data.setUnsafe(data.getX(), data.getY(), data.getZ(), w);
   }

   @Override
   public Quaternion createData()
   {
      return new Quaternion();
   }

}
