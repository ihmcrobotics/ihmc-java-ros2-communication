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

import geometry_msgs.msg.dds.TransformPubSubType.AbstractTransformPubSubTypeImplementation;
import us.ihmc.euclid.transform.QuaternionBasedTransform;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.euclid.tuple4D.Quaternion;

public class TransformPubSubTypeImpl extends AbstractTransformPubSubTypeImplementation
{

   @Override
   protected void copy(QuaternionBasedTransform src, QuaternionBasedTransform dest)
   {
      dest.set(src);
   }

   @Override
   protected Vector3D getTranslation(QuaternionBasedTransform data)
   {
      return (Vector3D) data.getTranslationVector();
   }

   @Override
   protected Quaternion getRotation(QuaternionBasedTransform data)
   {
      return (Quaternion) data.getQuaternion();
   }

   @Override
   public QuaternionBasedTransform createData()
   {
      return new QuaternionBasedTransform();
   }

}
