package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class ColorRGBA extends Packet<ColorRGBA> implements Settable<ColorRGBA>, EpsilonComparable<ColorRGBA>
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
      this();
      set(other);
   }

   public void set(ColorRGBA other)
   {

      r_ = other.r_;


      g_ = other.g_;


      b_ = other.b_;


      a_ = other.a_;

   }


   public void setR(float r)
   {
      r_ = r;
   }
   public float getR()
   {
      return r_;
   }


   public void setG(float g)
   {
      g_ = g;
   }
   public float getG()
   {
      return g_;
   }


   public void setB(float b)
   {
      b_ = b;
   }
   public float getB()
   {
      return b_;
   }


   public void setA(float a)
   {
      a_ = a;
   }
   public float getA()
   {
      return a_;
   }


   public static Supplier<ColorRGBAPubSubType> getPubSubType()
   {
      return ColorRGBAPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ColorRGBAPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ColorRGBA other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.r_, other.r_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.g_, other.g_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.b_, other.b_, epsilon)) return false;


      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.a_, other.a_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ColorRGBA)) return false;

      ColorRGBA otherMyClass = (ColorRGBA) other;


      if(this.r_ != otherMyClass.r_) return false;


      if(this.g_ != otherMyClass.g_) return false;


      if(this.b_ != otherMyClass.b_) return false;


      if(this.a_ != otherMyClass.a_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ColorRGBA {");

      builder.append("r=");
      builder.append(this.r_);      builder.append(", ");

      builder.append("g=");
      builder.append(this.g_);      builder.append(", ");

      builder.append("b=");
      builder.append(this.b_);      builder.append(", ");

      builder.append("a=");
      builder.append(this.a_);
      builder.append("}");
      return builder.toString();
   }
}
