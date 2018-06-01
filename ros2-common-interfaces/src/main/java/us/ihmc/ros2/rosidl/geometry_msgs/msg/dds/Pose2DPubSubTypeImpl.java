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

import geometry_msgs.msg.dds.Pose2DPubSubType.AbstractPose2DPubSubTypeImplementation;
import us.ihmc.euclid.geometry.Pose2D;

public class Pose2DPubSubTypeImpl extends AbstractPose2DPubSubTypeImplementation
{

   @Override
   protected void copy(Pose2D src, Pose2D dest)
   {
      dest.set(src);
   }

   @Override
   protected double getX(Pose2D data)
   {
      return data.getX();
   }

   @Override
   protected void setX(Pose2D data, double x)
   {
      data.setX(x);
   }

   @Override
   protected double getY(Pose2D data)
   {
      return data.getY();
   }

   @Override
   protected void setY(Pose2D data, double y)
   {
      data.setY(y);
   }

   @Override
   protected double getTheta(Pose2D data)
   {
      return data.getYaw();
   }

   @Override
   protected void setTheta(Pose2D data, double theta)
   {
      data.setYaw(theta);
   }

   @Override
   public Pose2D createData()
   {
      return new Pose2D();
   }

}
