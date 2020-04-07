package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Log extends Packet<Log> implements Settable<Log>, EpsilonComparable<Log>
{

   /**
          * #
          * # Severity level constants
          * #
          * debug level
          */
   public static final byte DEBUG = (byte) 10;

   /**
          * general level
          */
   public static final byte INFO = (byte) 20;

   /**
          * warning level
          */
   public static final byte WARN = (byte) 30;

   /**
          * error level
          */
   public static final byte ERROR = (byte) 40;

   /**
          * fatal/critical level
          */
   public static final byte FATAL = (byte) 50;

   /**
            * #
            * # Fields
            * #
            */
   public builtin_interfaces.msg.dds.Time stamp_;

   public byte level_;

   /**
            * the name representing the logger this message came from
            */
   public java.lang.StringBuilder name_;

   /**
            * message
            */
   public java.lang.StringBuilder msg_;

   /**
            * file the message came from
            */
   public java.lang.StringBuilder file_;

   /**
            * function the message came from
            */
   public java.lang.StringBuilder function_;

   /**
            * line the message came from
            */
   public long line_;

   public Log()
   {

      stamp_ = new builtin_interfaces.msg.dds.Time();


      name_ = new java.lang.StringBuilder(255);

      msg_ = new java.lang.StringBuilder(255);

      file_ = new java.lang.StringBuilder(255);

      function_ = new java.lang.StringBuilder(255);


   }

   public Log(Log other)
   {
      this();
      set(other);
   }

   public void set(Log other)
   {

      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);

      level_ = other.level_;


      name_.setLength(0);
      name_.append(other.name_);


      msg_.setLength(0);
      msg_.append(other.msg_);


      file_.setLength(0);
      file_.append(other.file_);


      function_.setLength(0);
      function_.append(other.function_);


      line_ = other.line_;

   }



   /**
            * #
            * # Fields
            * #
            */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }


   public void setLevel(byte level)
   {
      level_ = level;
   }
   public byte getLevel()
   {
      return level_;
   }


   /**
            * the name representing the logger this message came from
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * the name representing the logger this message came from
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * the name representing the logger this message came from
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }


   /**
            * message
            */
   public void setMsg(java.lang.String msg)
   {
      msg_.setLength(0);
      msg_.append(msg);
   }

   /**
            * message
            */
   public java.lang.String getMsgAsString()
   {
      return getMsg().toString();
   }
   /**
            * message
            */
   public java.lang.StringBuilder getMsg()
   {
      return msg_;
   }


   /**
            * file the message came from
            */
   public void setFile(java.lang.String file)
   {
      file_.setLength(0);
      file_.append(file);
   }

   /**
            * file the message came from
            */
   public java.lang.String getFileAsString()
   {
      return getFile().toString();
   }
   /**
            * file the message came from
            */
   public java.lang.StringBuilder getFile()
   {
      return file_;
   }


   /**
            * function the message came from
            */
   public void setFunction(java.lang.String function)
   {
      function_.setLength(0);
      function_.append(function);
   }

   /**
            * function the message came from
            */
   public java.lang.String getFunctionAsString()
   {
      return getFunction().toString();
   }
   /**
            * function the message came from
            */
   public java.lang.StringBuilder getFunction()
   {
      return function_;
   }


   /**
            * line the message came from
            */
   public void setLine(long line)
   {
      line_ = line;
   }
   /**
            * line the message came from
            */
   public long getLine()
   {
      return line_;
   }


   public static Supplier<LogPubSubType> getPubSubType()
   {
      return LogPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return LogPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Log other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;


      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.level_, other.level_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.msg_, other.msg_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.file_, other.file_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.function_, other.function_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.line_, other.line_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Log)) return false;

      Log otherMyClass = (Log) other;


      if (!this.stamp_.equals(otherMyClass.stamp_)) return false;

      if(this.level_ != otherMyClass.level_) return false;


      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;


      if (!us.ihmc.idl.IDLTools.equals(this.msg_, otherMyClass.msg_)) return false;


      if (!us.ihmc.idl.IDLTools.equals(this.file_, otherMyClass.file_)) return false;


      if (!us.ihmc.idl.IDLTools.equals(this.function_, otherMyClass.function_)) return false;


      if(this.line_ != otherMyClass.line_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Log {");

      builder.append("stamp=");
      builder.append(this.stamp_);      builder.append(", ");

      builder.append("level=");
      builder.append(this.level_);      builder.append(", ");

      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");

      builder.append("msg=");
      builder.append(this.msg_);      builder.append(", ");

      builder.append("file=");
      builder.append(this.file_);      builder.append(", ");

      builder.append("function=");
      builder.append(this.function_);      builder.append(", ");

      builder.append("line=");
      builder.append(this.line_);
      builder.append("}");
      return builder.toString();
   }
}
