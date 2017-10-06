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

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

public class RealtimeNode
{
   private final RosNode node;

   private final ArrayList<RealtimePublisher<?>> publishers = new ArrayList<>();

   private final RealtimeNodeThread realtimeNodeThread = new RealtimeNodeThread();
   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;

   public RealtimeNode(PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, int domainId) throws IOException
   {
      this.node = new RosNode(name, namespace, domainId);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }

   public <T> RealtimePublisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, RosQosProfile qosProfile, int queueSize) throws IOException
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeNode that is already spinning");
         }
         RosPublisher<T> rosPublisher = node.createPublisher(topicDataType, topicName, qosProfile);
         RealtimePublisher<T> realtimePublisher = new RealtimePublisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      } finally
      {
         startupLock.unlock();
      }

   }

   /**
    * Start publishing data for this RealtimeNode
    * 
    * A periodic thread is spawned that will publish all data every millisecond. 
    * 
    */
   public void spin()
   {
      startupLock.lock();
      if (spinning)
      {
         throw new RuntimeException("This RealtimeNode is already spinning");
      }
      spinning = true;
      scheduler.schedule(realtimeNodeThread, 1, TimeUnit.MILLISECONDS);
      startupLock.unlock();
   }

   private class RealtimeNodeThread implements Runnable
   {

      @Override
      public void run()
      {
         for (int i = 0; i < publishers.size(); i++)
         {
            publishers.get(i).spin();
         }
      }

   }
}
