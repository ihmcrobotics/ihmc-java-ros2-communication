package us.ihmc;/*
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

import ros_msgs.msg.dds.CustomBoiPubSubType;

public class CustomBoiPubSubTypeImpl extends CustomBoiPubSubType.AbstractCustomBoiPubSubTypeImplementation
{

   @Override
   protected void copy(CustomBoi src, CustomBoi dest)
   {
      dest.setX(src.getX());
      dest.setY(src.getY());
      dest.setZ(src.getZ());
   }

   @Override
   protected float getX(CustomBoi data)
   {
      return data.getX();
   }

   @Override
   protected void setX(CustomBoi data, float x)
   {
      data.setX(x);
   }

   @Override
   protected float getY(CustomBoi data)
   {
      return data.getY();
   }

   @Override
   protected void setY(CustomBoi data, float y)
   {
      data.setY(y);
   }

   @Override
   protected float getZ(CustomBoi data)
   {
      return data.getZ();
   }

   @Override
   protected void setZ(CustomBoi data, float z)
   {
      data.setZ(z);
   }

   @Override
   public CustomBoi createData()
   {
      return new CustomBoi();
   }

}
