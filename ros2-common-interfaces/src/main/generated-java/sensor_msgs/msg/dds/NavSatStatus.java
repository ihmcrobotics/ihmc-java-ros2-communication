package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Navigation Satellite fix status for any Global Navigation Satellite System.
 * Whether to output an augmented fix is determined by both the fix
 * type and the last time differential corrections were received.  A
 * fix is valid when status >= STATUS_FIX.
 * Bits defining which Global Navigation Satellite System signals were
 * used by the receiver.
 */
public class NavSatStatus extends Packet<NavSatStatus> implements Settable<NavSatStatus>, EpsilonComparable<NavSatStatus>
{
   /**
    * unable to fix position
    */
   public static final byte STATUS_NO_FIX = (byte) 255;
   /**
    * unaugmented fix
    */
   public static final byte STATUS_FIX = (byte) 0;
   /**
    * with satellite-based augmentation
    */
   public static final byte STATUS_SBAS_FIX = (byte) 1;
   /**
    * with ground-based augmentation
    */
   public static final byte STATUS_GBAS_FIX = (byte) 2;
   public static final int SERVICE_GPS = 1;
   public static final int SERVICE_GLONASS = 2;
   /**
    * includes BeiDou.
    */
   public static final int SERVICE_COMPASS = 4;
   public static final int SERVICE_GALILEO = 8;
   public byte status_;
   public int service_;

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
