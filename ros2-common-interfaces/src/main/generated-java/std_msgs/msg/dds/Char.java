package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Char" defined in Char_.idl.
 *
 * This file was automatically generated from Char_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Char_.idl instead.
 */
public class Char implements Settable<Char>, EpsilonComparable<Char>
{
   private char data_;

   public Char()
   {
   }

   public Char(Char other)
   {
      set(other);
   }

   public void set(Char other)
   {
      data_ = other.data_;
   }

   public char getData()
   {
      return data_;
   }

   public void setData(char data)
   {
      data_ = data;
   }

   @Override
   public boolean epsilonEquals(Char other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon))
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
      if (!(other instanceof Char))
         return false;

      Char otherMyClass = (Char) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Char {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}