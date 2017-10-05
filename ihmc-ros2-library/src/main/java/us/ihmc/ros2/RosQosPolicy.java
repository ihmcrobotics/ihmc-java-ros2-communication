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
package us.ihmc.ros2;

import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;

public class RosQosPolicy
{
   public enum RosDurability
   {
      VOLATILE_DURABILITY_QOS, TRANSIENT_LOCAL_DURABILITY_QOS
   }

   private HistoryQosPolicyKind history = HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS;
   private int size = 10;
   private ReliabilityKind reliability = ReliabilityKind.RELIABLE;
   private RosDurability durability = RosDurability.VOLATILE_DURABILITY_QOS;

   public HistoryQosPolicyKind getHistory()
   {
      return history;
   }

   public void setHistory(HistoryQosPolicyKind history)
   {
      this.history = history;
   }

   public int getSize()
   {
      return size;
   }

   public void setSize(int size)
   {
      this.size = size;
   }

   public ReliabilityKind getReliability()
   {
      return reliability;
   }

   public void setReliability(ReliabilityKind reliability)
   {
      this.reliability = reliability;
   }

   public RosDurability getDurability()
   {
      return durability;
   }

   public void setDurability(RosDurability durability)
   {
      this.durability = durability;
   }

}
