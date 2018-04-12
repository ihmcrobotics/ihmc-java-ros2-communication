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

/**
 * ROS2 QoS profile settings
 * 
 * Provides a quick way to set the ROS2 QoS settings. Provided options are
 * 
 * - History KEEP_LAST or KEEP_ALL (default KEEP_LAST)
 * - Size default history size (default 1)
 * - Reliablity RELIABLE or BEST EFFORT (default RELIABLE)
 * - Durability (default VOLATILE)
 * - avoidRosNamespaceConventions Use the Node name directly for communication with pure RTPS/DDS nodes
 * 
 * @author Jesper Smith
 *
 */
public class RosQosProfile
{
   public static RosQosProfile DEFAULT() 
   {
      return new RosQosProfile();
   }
   
   public static final RosQosProfile KEEP_HISTORY(int depth)  
   {
      return new RosQosProfile(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS, depth, ReliabilityKind.RELIABLE, RosDurability.TRANSIENT_LOCAL, false);
   }
   
   public static final RosQosProfile BEST_EFFORT()
   {
      return new RosQosProfile(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS, 1, ReliabilityKind.BEST_EFFORT, RosDurability.VOLATILE, false);
   }
   
   
   public enum RosDurability
   {
      VOLATILE, TRANSIENT_LOCAL
   }

   private HistoryQosPolicyKind history = HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS;
   private int depth = 1;
   private ReliabilityKind reliability = ReliabilityKind.RELIABLE;
   private RosDurability durability = RosDurability.VOLATILE;
   private boolean avoidRosNamespaceConventions = false;
   
   public RosQosProfile()
   {
      
   }
   
   
   public RosQosProfile(HistoryQosPolicyKind history, int depth, ReliabilityKind reliability, RosDurability durability, boolean avoidRosNamespaceConventions)
   {
      this();
      this.history = history;
      this.depth = depth;
      this.reliability = reliability;
      this.durability = durability;
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }


   /**
    * 
    * @return the History QoS Policy
    */
   public HistoryQosPolicyKind getHistory()
   {
      return history;
   }

   /**
    * Set the History QoS Policy
    * 
    * - KEEP_LAST: only store up to N samples, configurable via the queue depth option.
    * - KEEP_ALL: store all samples, subject to the configured resource limits of the DDS vendor.
    * 
    * default: KEEP_LAST
    * 
    * @param history
    */
   public void setHistory(HistoryQosPolicyKind history)
   {
      this.history = history;
   }

   /**
    * 
    * @return the history queue depth
    */
   public int getSize()
   {
      return depth;
   }

   /**
    * Set the history queue depth
    * 
    * Increasing this number will allocate memory for every message in the queue
    * 
    * default: 1
    * 
    * @param depth
    */
   public void setSize(int depth)
   {
      this.depth = depth;
   }

   /**
    * 
    * @return reliability kind
    */
   public ReliabilityKind getReliability()
   {
      return reliability;
   }

   /**
    * Set reliability qos policy
    * 
    * BEST_EFFORT: attempt to deliver samples, but may lose them if the network is not robust.
    * RELIABLE: guarantee that samples are delivered, may retry multiple times.
    * 
    * @param reliability
    */
   public void setReliability(ReliabilityKind reliability)
   {
      this.reliability = reliability;
   }

   /**
    * 
    * @return Durability qos policy
    */
   public RosDurability getDurability()
   {
      return durability;
   }

   /**
    * Set durability qos policy
    * 
    * - TRANSIENT_LOCAL: only applies to DataWriters. DataWriter becomes responsible of persisting samples until a corresponding DataReader becomes available.
    * - VOLATILE: no attempt is made to persist samples.

    * 
    * @param durability
    */
   public void setDurability(RosDurability durability)
   {
      this.durability = durability;
   }

   /**
    * 
    * @return true if no Ros Namespace mangling should be done
    */
   public boolean isAvoidRosNamespaceConventions()
   {
      return avoidRosNamespaceConventions;
   }

   /**
    * Set to true to use the Node namespace as partition and the topic name as is
    * 
    * This is for interacting with existing RTPS/DDS nodes
    * 
    * @param avoidRosNamespaceConventions
    */
   public void setAvoidRosNamespaceConventions(boolean avoidRosNamespaceConventions)
   {
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }
   
   

}
