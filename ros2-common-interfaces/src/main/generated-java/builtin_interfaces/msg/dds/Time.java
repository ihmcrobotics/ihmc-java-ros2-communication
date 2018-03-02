package builtin_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class Time implements Settable<Time>, EpsilonComparable<Time>
{
   private int sec_;
   private long nanosec_;

   public Time()
   {

   }

   public Time(Time other)
   {
      set(other);
   }

   public void set(Time other)
   {
      sec_ = other.sec_;

      nanosec_ = other.nanosec_;
   }

   public int getSec()
   {
      return sec_;
   }

   public void setSec(int sec)
   {
      sec_ = sec;
   }

   public long getNanosec()
   {
      return nanosec_;
   }

   public void setNanosec(long nanosec)
   {
      nanosec_ = nanosec;
   }

   @Override
   public boolean epsilonEquals(Time other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sec_, other.sec_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.nanosec_, other.nanosec_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof Time))
         return false;

      Time otherMyClass = (Time) other;

      if (this.sec_ != otherMyClass.sec_)
         return false;

      if (this.nanosec_ != otherMyClass.nanosec_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Time {");
      builder.append("sec=");
      builder.append(this.sec_);

      builder.append(", ");
      builder.append("nanosec=");
      builder.append(this.nanosec_);

      builder.append("}");
      return builder.toString();
   }
}