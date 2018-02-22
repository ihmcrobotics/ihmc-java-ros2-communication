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

import geometry_msgs.msg.dds.PosePubSubType.AbstractPosePubSubTypeImplementation;
import us.ihmc.euclid.geometry.Pose3D;
import us.ihmc.euclid.tuple3D.Point3D;
import us.ihmc.euclid.tuple4D.Quaternion;

public class Pose3DPubSubTypeImpl extends AbstractPosePubSubTypeImplementation
{

   @Override
   protected void copy(Pose3D src, Pose3D dest)
   {
      dest.set(src);
   }

   @Override
   protected Point3D getPosition(Pose3D data)
   {
      return (Point3D) data.getPosition();
   }

   @Override
   protected Quaternion getOrientation(Pose3D data)
   {
      return (Quaternion) data.getOrientation();
   }

   @Override
   public Pose3D createData()
   {
      return new Pose3D();
   }

}
