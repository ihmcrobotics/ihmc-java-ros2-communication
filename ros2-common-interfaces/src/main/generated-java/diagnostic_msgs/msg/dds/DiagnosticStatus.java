package diagnostic_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This message holds the status of an individual component of the robot.
       */
public class DiagnosticStatus extends Packet<DiagnosticStatus> implements Settable<DiagnosticStatus>, EpsilonComparable<DiagnosticStatus>
{
   /**
          * Possible levels of operations.
          */
   public static final byte OK = (byte) 0;
   public static final byte WARN = (byte) 1;
   public static final byte ERROR = (byte) 2;
   public static final byte STALE = (byte) 3;
   /**
            * Level of operation enumerated above.
            */
   public byte level_;
   /**
            * A description of the test/component reporting.
            */
   public java.lang.StringBuilder name_;
   /**
            * A description of the status.
            */
   public java.lang.StringBuilder message_;
   /**
            * A hardware unique string.
            */
   public java.lang.StringBuilder hardware_id_;
   /**
            * An array of values associated with the status.
            */
   public us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue>  values_;

   public DiagnosticStatus()
   {
      name_ = new java.lang.StringBuilder(255);
      message_ = new java.lang.StringBuilder(255);
      hardware_id_ = new java.lang.StringBuilder(255);
      values_ = new us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue> (100, new diagnostic_msgs.msg.dds.KeyValuePubSubType());

   }

   public DiagnosticStatus(DiagnosticStatus other)
   {
      this();
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
   public void setLevel(byte level)
   {
      level_ = level;
   }
   /**
            * Level of operation enumerated above.
            */
   public byte getLevel()
   {
      return level_;
   }

   /**
            * A description of the test/component reporting.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * A description of the test/component reporting.
            */
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
            * A description of the status.
            */
   public void setMessage(java.lang.String message)
   {
      message_.setLength(0);
      message_.append(message);
   }

   /**
            * A description of the status.
            */
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
            * A hardware unique string.
            */
   public void setHardwareId(java.lang.String hardware_id)
   {
      hardware_id_.setLength(0);
      hardware_id_.append(hardware_id);
   }

   /**
            * A hardware unique string.
            */
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
            * An array of values associated with the status.
            */
   public us.ihmc.idl.IDLSequence.Object<diagnostic_msgs.msg.dds.KeyValue>  getValues()
   {
      return values_;
   }


   public static Supplier<DiagnosticStatusPubSubType> getPubSubType()
   {
      return DiagnosticStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return DiagnosticStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(DiagnosticStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.level_, other.level_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.message_, other.message_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.hardware_id_, other.hardware_id_, epsilon)) return false;

      if (this.values_.size() != other.values_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.values_.size(); i++)
         {  if (!this.values_.get(i).epsilonEquals(other.values_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof DiagnosticStatus)) return false;

      DiagnosticStatus otherMyClass = (DiagnosticStatus) other;

      if(this.level_ != otherMyClass.level_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.message_, otherMyClass.message_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.hardware_id_, otherMyClass.hardware_id_)) return false;

      if (!this.values_.equals(otherMyClass.values_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("DiagnosticStatus {");
      builder.append("level=");
      builder.append(this.level_);      builder.append(", ");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("message=");
      builder.append(this.message_);      builder.append(", ");
      builder.append("hardware_id=");
      builder.append(this.hardware_id_);      builder.append(", ");
      builder.append("values=");
      builder.append(this.values_);
      builder.append("}");
      return builder.toString();
   }
}
