package diagnostic_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "DiagnosticStatus" defined in DiagnosticStatus_.idl.
 *
 * This file was automatically generated from DiagnosticStatus_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit DiagnosticStatus_.idl instead.
 */
public class DiagnosticStatus implements Settable<DiagnosticStatus>, EpsilonComparable<DiagnosticStatus>
{
   /**
    * Level of operation enumerated above.
    */
   private byte level_;
   /**
    * A description of the test/component reporting.
    */
   private java.lang.StringBuilder name_;
   /**
    * A description of the status.
    */
   private java.lang.StringBuilder message_;
   /**
    * A hardware unique string.
    */
   private java.lang.StringBuilder hardware_id_;
   private us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue> values_;

   public DiagnosticStatus()
   {

      name_ = new java.lang.StringBuilder(255);

      message_ = new java.lang.StringBuilder(255);

      hardware_id_ = new java.lang.StringBuilder(255);

      values_ = new us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue>(100, diagnostic_msgs.msg.dds.KeyValue.class,
                                                                                     new diagnostic_msgs.msg.dds.KeyValuePubSubType());
   }

   public DiagnosticStatus(DiagnosticStatus other)
   {
      set(other);
   }

   public void set(DiagnosticStatus other)
   {
      level_ = other.level_;

      name_.setLength(0);
      name_.append(other.name_);

      message_.setLength(0);
      message_.append(other.message_);

      hardware_id_.setLength(0);
      hardware_id_.append(other.hardware_id_);

      values_.set(other.values_);
   }

   /**
    * Level of operation enumerated above.
    */
   public byte getLevel()
   {
      return level_;
   }

   /**
    * Level of operation enumerated above.
    */
   public void setLevel(byte level)
   {
      level_ = level;
   }

   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }

   /**
    * A description of the test/component reporting.
    */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
    * A description of the test/component reporting.
    */
   public void setName(String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   public java.lang.String getMessageAsString()
   {
      return getMessage().toString();
   }

   /**
    * A description of the status.
    */
   public java.lang.StringBuilder getMessage()
   {
      return message_;
   }

   /**
    * A description of the status.
    */
   public void setMessage(String message)
   {
      message_.setLength(0);
      message_.append(message);
   }

   public java.lang.String getHardwareIdAsString()
   {
      return getHardwareId().toString();
   }

   /**
    * A hardware unique string.
    */
   public java.lang.StringBuilder getHardwareId()
   {
      return hardware_id_;
   }

   /**
    * A hardware unique string.
    */
   public void setHardwareId(String hardware_id)
   {
      hardware_id_.setLength(0);
      hardware_id_.append(hardware_id);
   }

   public us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue> getValues()
   {
      return values_;
   }

   @Override
   public boolean epsilonEquals(DiagnosticStatus other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.level_, other.level_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.message_, other.message_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.hardware_id_, other.hardware_id_, epsilon))
         return false;

      if (this.values_.isEnum())
      {
         if (!this.values_.equals(other.values_))
            return false;
      }
      else if (this.values_.size() == other.values_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.values_.size(); i++)
         {
            if (!this.values_.get(i).epsilonEquals(other.values_.get(i), epsilon))
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
      if (!(other instanceof DiagnosticStatus))
         return false;

      DiagnosticStatus otherMyClass = (DiagnosticStatus) other;

      if (this.level_ != otherMyClass.level_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.message_, otherMyClass.message_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.hardware_id_, otherMyClass.hardware_id_))
         return false;

      if (!this.values_.equals(otherMyClass.values_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("DiagnosticStatus {");
      builder.append("level=");
      builder.append(this.level_);

      builder.append(", ");
      builder.append("name=");
      builder.append(this.name_);

      builder.append(", ");
      builder.append("message=");
      builder.append(this.message_);

      builder.append(", ");
      builder.append("hardware_id=");
      builder.append(this.hardware_id_);

      builder.append(", ");
      builder.append("values=");
      builder.append(this.values_);

      builder.append("}");
      return builder.toString();
   }
}