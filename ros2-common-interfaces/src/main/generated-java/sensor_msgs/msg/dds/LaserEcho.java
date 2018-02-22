package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "LaserEcho" defined in LaserEcho_.idl.
 *
 * This file was automatically generated from LaserEcho_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit LaserEcho_.idl instead.
 */
public class LaserEcho implements Settable<LaserEcho>, EpsilonComparable<LaserEcho>
{
   private us.ihmc.idl.IDLSequence.Float echoes_;

   public LaserEcho()
   {
      echoes_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");
   }

   public LaserEcho(LaserEcho other)
   {
      set(other);
   }

   public void set(LaserEcho other)
   {
      echoes_.set(other.echoes_);
   }

   public us.ihmc.idl.IDLSequence.Float getEchoes()
   {
      return echoes_;
   }

   @Override
   public boolean epsilonEquals(LaserEcho other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.echoes_, other.echoes_, epsilon))
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
      if (!(other instanceof LaserEcho))
         return false;

      LaserEcho otherMyClass = (LaserEcho) other;

      if (!this.echoes_.equals(otherMyClass.echoes_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("LaserEcho {");
      builder.append("echoes=");
      builder.append(this.echoes_);

      builder.append("}");
      return builder.toString();
   }
}