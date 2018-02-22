package rcl_interfaces.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "SetParametersResult" defined in SetParametersResult_.idl.
 *
 * This file was automatically generated from SetParametersResult_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit SetParametersResult_.idl instead.
 */
public class SetParametersResult implements Settable<SetParametersResult>, EpsilonComparable<SetParametersResult>
{
   private boolean successful_;
   private java.lang.StringBuilder reason_;

   public SetParametersResult()
   {

      reason_ = new java.lang.StringBuilder(255);
   }

   public SetParametersResult(SetParametersResult other)
   {
      set(other);
   }

   public void set(SetParametersResult other)
   {
      successful_ = other.successful_;

      reason_.setLength(0);
      reason_.append(other.reason_);
   }

   public boolean getSuccessful()
   {
      return successful_;
   }

   public void setSuccessful(boolean successful)
   {
      successful_ = successful;
   }

   public java.lang.String getReasonAsString()
   {
      return getReason().toString();
   }

   public java.lang.StringBuilder getReason()
   {
      return reason_;
   }

   public void setReason(String reason)
   {
      reason_.setLength(0);
      reason_.append(reason);
   }

   @Override
   public boolean epsilonEquals(SetParametersResult other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.successful_, other.successful_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.reason_, other.reason_, epsilon))
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
      if (!(other instanceof SetParametersResult))
         return false;

      SetParametersResult otherMyClass = (SetParametersResult) other;

      if (this.successful_ != otherMyClass.successful_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.reason_, otherMyClass.reason_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SetParametersResult {");
      builder.append("successful=");
      builder.append(this.successful_);

      builder.append(", ");
      builder.append("reason=");
      builder.append(this.reason_);

      builder.append("}");
      return builder.toString();
   }
}