package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "JoyFeedbackArray" defined in JoyFeedbackArray_.idl.
 *
 * This file was automatically generated from JoyFeedbackArray_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit JoyFeedbackArray_.idl instead.
 */
public class JoyFeedbackArray implements Settable<JoyFeedbackArray>, EpsilonComparable<JoyFeedbackArray>
{
   private us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.JoyFeedback> array_;

   public JoyFeedbackArray()
   {
      array_ = new us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.JoyFeedback>(100, sensor_msgs.msg.dds.JoyFeedback.class,
                                                                                   new sensor_msgs.msg.dds.JoyFeedbackPubSubType());
   }

   public JoyFeedbackArray(JoyFeedbackArray other)
   {
      set(other);
   }

   public void set(JoyFeedbackArray other)
   {
      array_.set(other.array_);
   }

   public us.ihmc.idl.IDLSequence.Object<sensor_msgs.msg.dds.JoyFeedback> getArray()
   {
      return array_;
   }

   @Override
   public boolean epsilonEquals(JoyFeedbackArray other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (this.array_.isEnum())
      {
         if (!this.array_.equals(other.array_))
            return false;
      }
      else if (this.array_.size() == other.array_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.array_.size(); i++)
         {
            if (!this.array_.get(i).epsilonEquals(other.array_.get(i), epsilon))
               return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof JoyFeedbackArray))
         return false;

      JoyFeedbackArray otherMyClass = (JoyFeedbackArray) other;

      if (!this.array_.equals(otherMyClass.array_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("JoyFeedbackArray {");
      builder.append("array=");
      builder.append(this.array_);

      builder.append("}");
      return builder.toString();
   }
}