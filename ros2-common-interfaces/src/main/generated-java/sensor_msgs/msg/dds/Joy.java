package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Reports the state of a joystick's axes and buttons.
 */
public class Joy extends Packet<Joy> implements Settable<Joy>, EpsilonComparable<Joy>
{
   /**
    * The timestamp is the time at which data is received from the joystick.
    */
   public std_msgs.msg.dds.Header header_;
   /**
    * The axes measurements from a joystick.
    */
   public us.ihmc.idl.IDLSequence.Float axes_;
   /**
    * The buttons measurements from a joystick.
    */
   public us.ihmc.idl.IDLSequence.Integer buttons_;

   public Joy()
   {
      header_ = new std_msgs.msg.dds.Header();
      axes_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");

      buttons_ = new us.ihmc.idl.IDLSequence.Integer(100, "type_2");
   }

   public Joy(Joy other)
   {
      set(other);
   }

   public void set(Joy other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      axes_.set(other.axes_);
      buttons_.set(other.buttons_);
   }

   /**
    * The timestamp is the time at which data is received from the joystick.
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * The axes measurements from a joystick.
    */
   public us.ihmc.idl.IDLSequence.Float getAxes()
   {
      return axes_;
   }

   /**
    * The buttons measurements from a joystick.
    */
   public us.ihmc.idl.IDLSequence.Integer getButtons()
   {
      return buttons_;
   }

   @Override
   public boolean epsilonEquals(Joy other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.axes_, other.axes_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.buttons_, other.buttons_, epsilon))
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
      if (!(other instanceof Joy))
         return false;

      Joy otherMyClass = (Joy) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!this.axes_.equals(otherMyClass.axes_))
         return false;

      if (!this.buttons_.equals(otherMyClass.buttons_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Joy {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("axes=");
      builder.append(this.axes_);

      builder.append(", ");
      builder.append("buttons=");
      builder.append(this.buttons_);

      builder.append("}");
      return builder.toString();
   }
}
