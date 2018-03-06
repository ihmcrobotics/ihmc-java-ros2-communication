package ros_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * we don't support this
 * int32[] nums [-200, -100, 0, 100, 200]
 */
public class TwoNum implements Settable<TwoNum>, EpsilonComparable<TwoNum>
{
   private ros_msgs.msg.dds.Num num1_;
   private us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num> num2_;
   /**
    * Should be ros_msgs::msg::dds::Num num3[3];
    */
   private ros_msgs.msg.dds.Num[] num3_;
   private us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num> num4_;
   private java.lang.StringBuilder str1_;
   private java.lang.StringBuilder str2_;
   private us.ihmc.idl.IDLSequence.StringBuilderHolder str3_;
   private us.ihmc.idl.IDLSequence.StringBuilderHolder str4_;
   private us.ihmc.idl.IDLSequence.StringBuilderHolder str5_;

   public TwoNum()
   {
      num1_ = new ros_msgs.msg.dds.Num();
      num2_ = new us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num>(100, ros_msgs.msg.dds.Num.class, new ros_msgs.msg.dds.NumPubSubType());

      num3_ = new ros_msgs.msg.dds.Num[3];
      for (int b = 0; b < num3_.length; ++b)
      {
         num3_[b] = new ros_msgs.msg.dds.Num();
      }

      num4_ = new us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num>(3, ros_msgs.msg.dds.Num.class, new ros_msgs.msg.dds.NumPubSubType());

      str1_ = new java.lang.StringBuilder(255);

      str2_ = new java.lang.StringBuilder(10);

      str3_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(5, "type_d");
      str4_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(100, "type_d");
      str5_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder(5, "type_d");
   }

   public TwoNum(TwoNum other)
   {
      set(other);
   }

   public void set(TwoNum other)
   {
      ros_msgs.msg.dds.NumPubSubType.staticCopy(other.num1_, num1_);
      num2_.set(other.num2_);
      for (int d = 0; d < num3_.length; ++d)
      {
         ros_msgs.msg.dds.NumPubSubType.staticCopy(other.num3_[d], num3_[d]);
      }

      num4_.set(other.num4_);
      str1_.setLength(0);
      str1_.append(other.str1_);

      str2_.setLength(0);
      str2_.append(other.str2_);

      str3_.set(other.str3_);
      str4_.set(other.str4_);
      str5_.set(other.str5_);
   }

   public ros_msgs.msg.dds.Num getNum1()
   {
      return num1_;
   }

   public us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num> getNum2()
   {
      return num2_;
   }

   /**
    * Should be ros_msgs::msg::dds::Num num3[3];
    */
   public ros_msgs.msg.dds.Num[] getNum3()
   {
      return num3_;
   }

   public us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num> getNum4()
   {
      return num4_;
   }

   public java.lang.String getStr1AsString()
   {
      return getStr1().toString();
   }

   public java.lang.StringBuilder getStr1()
   {
      return str1_;
   }

   public void setStr1(String str1)
   {
      str1_.setLength(0);
      str1_.append(str1);
   }

   public java.lang.String getStr2AsString()
   {
      return getStr2().toString();
   }

   public java.lang.StringBuilder getStr2()
   {
      return str2_;
   }

   public void setStr2(String str2)
   {
      str2_.setLength(0);
      str2_.append(str2);
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getStr3()
   {
      return str3_;
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getStr4()
   {
      return str4_;
   }

   public us.ihmc.idl.IDLSequence.StringBuilderHolder getStr5()
   {
      return str5_;
   }

   @Override
   public boolean epsilonEquals(TwoNum other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.num1_.epsilonEquals(other.num1_, epsilon))
         return false;

      if (this.num2_.isEnum())
      {
         if (!this.num2_.equals(other.num2_))
            return false;
      }
      else if (this.num2_.size() == other.num2_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.num2_.size(); i++)
         {
            if (!this.num2_.get(i).epsilonEquals(other.num2_.get(i), epsilon))
               return false;
         }
      }

      for (int f = 0; f < num3_.length; ++f)
      {
         if (!this.num3_[f].epsilonEquals(other.num3_[f], epsilon))
            return false;
      }

      if (this.num4_.isEnum())
      {
         if (!this.num4_.equals(other.num4_))
            return false;
      }
      else if (this.num4_.size() == other.num4_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.num4_.size(); i++)
         {
            if (!this.num4_.get(i).epsilonEquals(other.num4_.get(i), epsilon))
               return false;
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.str1_, other.str1_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.str2_, other.str2_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str3_, other.str3_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str4_, other.str4_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str5_, other.str5_, epsilon))
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
      if (!(other instanceof TwoNum))
         return false;

      TwoNum otherMyClass = (TwoNum) other;

      if (!this.num1_.equals(otherMyClass.num1_))
         return false;

      if (!this.num2_.equals(otherMyClass.num2_))
         return false;

      for (int h = 0; h < num3_.length; ++h)
      {
         if (!this.num3_[h].equals(otherMyClass.num3_[h]))
            return false;
      }
      if (!this.num4_.equals(otherMyClass.num4_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.str1_, otherMyClass.str1_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.str2_, otherMyClass.str2_))
         return false;

      if (!this.str3_.equals(otherMyClass.str3_))
         return false;

      if (!this.str4_.equals(otherMyClass.str4_))
         return false;

      if (!this.str5_.equals(otherMyClass.str5_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TwoNum {");
      builder.append("num1=");
      builder.append(this.num1_);

      builder.append(", ");
      builder.append("num2=");
      builder.append(this.num2_);

      builder.append(", ");
      builder.append("num3=");
      builder.append(java.util.Arrays.toString(this.num3_));

      builder.append(", ");
      builder.append("num4=");
      builder.append(this.num4_);

      builder.append(", ");
      builder.append("str1=");
      builder.append(this.str1_);

      builder.append(", ");
      builder.append("str2=");
      builder.append(this.str2_);

      builder.append(", ");
      builder.append("str3=");
      builder.append(this.str3_);

      builder.append(", ");
      builder.append("str4=");
      builder.append(this.str4_);

      builder.append(", ");
      builder.append("str5=");
      builder.append(this.str5_);

      builder.append("}");
      return builder.toString();
   }
}