package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "ListParametersResult" defined in ListParametersResult_.idl.
 *
 * This file was automatically generated from ListParametersResult_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit ListParametersResult_.idl instead.
 */
public class ListParametersResult implements Settable<ListParametersResult>, EpsilonComparable<ListParametersResult>
{
   /**
    * All parameters under the given prefixes.
    */
   private us.ihmc.idl.IDLSequence.StringBuilderHolder names_;
   /**
    * All prefixes under the given prefixes.
    * TODO(wjwwood): link to prefix definition and rules.
    */
   private us.ihmc.idl.IDLSequence.StringBuilderHolder prefixes_;

   public ListParametersResult()
   {
      names_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
      prefixes_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
   }

   /**
    * All parameters under the given prefixes.
    */

   public ListParametersResult(ListParametersResult other)
   {
      set(other);
   }

   /**
    * All prefixes under the given prefixes.
    * TODO(wjwwood): link to prefix definition and rules.
    */

   public void set(ListParametersResult other)
   {
      names_.set(other.names_);
      prefixes_.set(other.prefixes_);
   }

   /**
    * All parameters under the given prefixes.
    */
   public us.ihmc.idl.IDLSequence.StringBuilderHolder getNames()
   {
      return names_;
   }

   /**
    * All prefixes under the given prefixes.
    * TODO(wjwwood): link to prefix definition and rules.
    */
   public us.ihmc.idl.IDLSequence.StringBuilderHolder getPrefixes()
   {
      return prefixes_;
   }

   @Override
   public boolean epsilonEquals(ListParametersResult other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.names_, other.names_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.prefixes_, other.prefixes_, epsilon))
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
      if (!(other instanceof ListParametersResult))
         return false;

      ListParametersResult otherMyClass = (ListParametersResult) other;

      if (!this.names_.equals(otherMyClass.names_))
         return false;

      if (!this.prefixes_.equals(otherMyClass.prefixes_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ListParametersResult {");
      builder.append("names=");
      builder.append(this.names_);

      builder.append(", ");
      builder.append("prefixes=");
      builder.append(this.prefixes_);

      builder.append("}");
      return builder.toString();
   }
}