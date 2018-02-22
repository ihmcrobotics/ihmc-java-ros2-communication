package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "NavSatStatus" defined in NavSatStatus_.idl.
 *
 * This file was automatically generated from NavSatStatus_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit NavSatStatus_.idl instead.
 */
public class NavSatStatus implements Settable<NavSatStatus>, EpsilonComparable<NavSatStatus>
{
   private byte status_;
   private int service_;

   public NavSatStatus()
   {

   }

   public NavSatStatus(NavSatStatus other)
   {
      set(other);
   }

   public void set(NavSatStatus other)
   {
      status_ = other.status_;

      service_ = other.service_;
   }

   public byte getStatus()
   {
      return status_;
   }

   public void setStatus(byte status)
   {
      status_ = status;
   }

   public int getService()
   {
      return service_;
   }

   public void setService(int service)
   {
      service_ = service;
   }

   @Override
   public boolean epsilonEquals(NavSatStatus other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.status_, other.status_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.service_, other.service_, epsilon))
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
      if (!(other instanceof NavSatStatus))
         return false;

      NavSatStatus otherMyClass = (NavSatStatus) other;

      if (this.status_ != otherMyClass.status_)
         return false;

      if (this.service_ != otherMyClass.service_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("NavSatStatus {");
      builder.append("status=");
      builder.append(this.status_);

      builder.append(", ");
      builder.append("service=");
      builder.append(this.service_);

      builder.append("}");
      return builder.toString();
   }
}