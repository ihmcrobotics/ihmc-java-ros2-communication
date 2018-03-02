package shape_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Representation of a plane, using the plane equation ax + by + cz + d = 0.
 */
public class Plane implements Settable<Plane>, EpsilonComparable<Plane>
{
   /**
    * a := coef[0]
    * b := coef[1]
    * c := coef[2]
    * d := coef[3]
    */
   private double[] coef_;

   public Plane()
   {
      coef_ = new double[4];
   }

   public Plane(Plane other)
   {
      set(other);
   }

   public void set(Plane other)
   {
      for (int b = 0; b < coef_.length; ++b)
      {
         coef_[b] = other.coef_[b];
      }
   }

   /**
    * a := coef[0]
    * b := coef[1]
    * c := coef[2]
    * d := coef[3]
    */
   public double[] getCoef()
   {
      return coef_;
   }

   @Override
   public boolean epsilonEquals(Plane other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      for (int d = 0; d < coef_.length; ++d)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.coef_[d], other.coef_[d], epsilon))
            return false;
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
      if (!(other instanceof Plane))
         return false;

      Plane otherMyClass = (Plane) other;

      for (int f = 0; f < coef_.length; ++f)
      {
         if (this.coef_[f] != otherMyClass.coef_[f])
            return false;
      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Plane {");
      builder.append("coef=");
      builder.append(java.util.Arrays.toString(this.coef_));

      builder.append("}");
      return builder.toString();
   }
}