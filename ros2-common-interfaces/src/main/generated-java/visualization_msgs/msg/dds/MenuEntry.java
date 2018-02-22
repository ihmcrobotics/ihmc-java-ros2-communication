package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MenuEntry" defined in MenuEntry_.idl.
 *
 * This file was automatically generated from MenuEntry_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MenuEntry_.idl instead.
 */
public class MenuEntry implements Settable<MenuEntry>, EpsilonComparable<MenuEntry>
{
   private long id_;
   private long parent_id_;
   private java.lang.StringBuilder title_;
   private java.lang.StringBuilder command_;
   private byte command_type_;

   public MenuEntry()
   {

      title_ = new java.lang.StringBuilder(255);

      command_ = new java.lang.StringBuilder(255);
   }

   public MenuEntry(MenuEntry other)
   {
      set(other);
   }

   public void set(MenuEntry other)
   {
      id_ = other.id_;

      parent_id_ = other.parent_id_;

      title_.setLength(0);
      title_.append(other.title_);

      command_.setLength(0);
      command_.append(other.command_);

      command_type_ = other.command_type_;
   }

   public long getId()
   {
      return id_;
   }

   public void setId(long id)
   {
      id_ = id;
   }

   public long getParentId()
   {
      return parent_id_;
   }

   public void setParentId(long parent_id)
   {
      parent_id_ = parent_id;
   }

   public java.lang.String getTitleAsString()
   {
      return getTitle().toString();
   }

   public java.lang.StringBuilder getTitle()
   {
      return title_;
   }

   public void setTitle(String title)
   {
      title_.setLength(0);
      title_.append(title);
   }

   public java.lang.String getCommandAsString()
   {
      return getCommand().toString();
   }

   public java.lang.StringBuilder getCommand()
   {
      return command_;
   }

   public void setCommand(String command)
   {
      command_.setLength(0);
      command_.append(command);
   }

   public byte getCommandType()
   {
      return command_type_;
   }

   public void setCommandType(byte command_type)
   {
      command_type_ = command_type;
   }

   @Override
   public boolean epsilonEquals(MenuEntry other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.parent_id_, other.parent_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.title_, other.title_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.command_, other.command_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.command_type_, other.command_type_, epsilon))
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
      if (!(other instanceof MenuEntry))
         return false;

      MenuEntry otherMyClass = (MenuEntry) other;

      if (this.id_ != otherMyClass.id_)
         return false;

      if (this.parent_id_ != otherMyClass.parent_id_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.title_, otherMyClass.title_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.command_, otherMyClass.command_))
         return false;

      if (this.command_type_ != otherMyClass.command_type_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MenuEntry {");
      builder.append("id=");
      builder.append(this.id_);

      builder.append(", ");
      builder.append("parent_id=");
      builder.append(this.parent_id_);

      builder.append(", ");
      builder.append("title=");
      builder.append(this.title_);

      builder.append(", ");
      builder.append("command=");
      builder.append(this.command_);

      builder.append(", ");
      builder.append("command_type=");
      builder.append(this.command_type_);

      builder.append("}");
      return builder.toString();
   }
}