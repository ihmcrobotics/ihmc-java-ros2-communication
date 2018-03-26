package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class ColorRGBA implements Settable<ColorRGBA>, EpsilonComparable<ColorRGBA>
{
   public float r_;
   public float g_;
   public float b_;
   public float a_;

   public ColorRGBA()
   {

   }

   public ColorRGBA(ColorRGBA other)
   {
      set(other);
   }

   public void set(ColorRGBA other)
   {
      r_ = other.r_;

      g_ = other.g_;

      b_ = other.b_;

      a_ = other.a_;
   }

   public float getR()
   {
      return r_;
   }

   public void setR(float r)
   {
      r_ = r;
   }

   public float getG()
   {
      return g_;
   }

   public void setG(float g)
   {
      g_ = g;
   }

   public float getB()
   {
      return b_;
   }

   public void setB(float b)
   {
      b_ = b;
   }

   public float getA()
   {
      return a_;
   }

   public void setA(float a)
   {
      a_ = a;
   }

   @Override
   public boolean epsilonEquals(ColorRGBA other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.r_, other.r_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.g_, other.g_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.b_, other.b_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.a_, other.a_, epsilon))
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
      if (!(other instanceof ColorRGBA))
         return false;

      ColorRGBA otherMyClass = (ColorRGBA) other;

      if (this.r_ != otherMyClass.r_)
         return false;

      if (this.g_ != otherMyClass.g_)
         return false;

      if (this.b_ != otherMyClass.b_)
         return false;

      if (this.a_ != otherMyClass.a_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ColorRGBA {");
      builder.append("r=");
      builder.append(this.r_);

      builder.append(", ");
      builder.append("g=");
      builder.append(this.g_);

      builder.append(", ");
      builder.append("b=");
      builder.append(this.b_);

      builder.append(", ");
      builder.append("a=");
      builder.append(this.a_);

      builder.append("}");
      return builder.toString();
   }
}