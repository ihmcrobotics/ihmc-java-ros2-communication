package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * MenuEntry message.
 * Each InteractiveMarker message has an array of MenuEntry messages.
 * A collection of MenuEntries together describe a
 * menu/submenu/subsubmenu/etc tree, though they are stored in a flat
 * array.  The tree structure is represented by giving each menu entry
 * an ID number and a "parent_id" field.  Top-level entries are the
 * ones with parent_id = 0.  Menu entries are ordered within their
 * level the same way they are ordered in the containing array.  Parent
 * entries must appear before their children.
 * Example:
 * - id = 3
 * parent_id = 0
 * title = "fun"
 * - id = 2
 * parent_id = 0
 * title = "robot"
 * - id = 4
 * parent_id = 2
 * title = "pr2"
 * - id = 5
 * parent_id = 2
 * title = "turtle"
 *
 * Gives a menu tree like this:
 * - fun
 * - robot
 * - pr2
 * - turtle
 */
public class MenuEntry implements Settable<MenuEntry>, EpsilonComparable<MenuEntry>
{
   /**
    * ID is a number for each menu entry.  Must be unique within the
    * control, and should never be 0.
    */
   private long id_;
   /**
    * ID of the parent of this menu entry, if it is a submenu.  If this
    * menu entry is a top-level entry, set parent_id to 0.
    */
   private long parent_id_;
   /**
    * menu / entry title
    */
   private java.lang.StringBuilder title_;
   /**
    * Arguments to command indicated by command_type (below)
    */
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

   /**
    * ID is a number for each menu entry.  Must be unique within the
    * control, and should never be 0.
    */
   public long getId()
   {
      return id_;
   }

   /**
    * ID is a number for each menu entry.  Must be unique within the
    * control, and should never be 0.
    */
   public void setId(long id)
   {
      id_ = id;
   }

   /**
    * ID of the parent of this menu entry, if it is a submenu.  If this
    * menu entry is a top-level entry, set parent_id to 0.
    */
   public long getParentId()
   {
      return parent_id_;
   }

   /**
    * ID of the parent of this menu entry, if it is a submenu.  If this
    * menu entry is a top-level entry, set parent_id to 0.
    */
   public void setParentId(long parent_id)
   {
      parent_id_ = parent_id;
   }

   /**
    * menu / entry title
    */
   public java.lang.String getTitleAsString()
   {
      return getTitle().toString();
   }

   /**
    * menu / entry title
    */
   public java.lang.StringBuilder getTitle()
   {
      return title_;
   }

   /**
    * menu / entry title
    */
   public void setTitle(String title)
   {
      title_.setLength(0);
      title_.append(title);
   }

   /**
    * Arguments to command indicated by command_type (below)
    */
   public java.lang.String getCommandAsString()
   {
      return getCommand().toString();
   }

   /**
    * Arguments to command indicated by command_type (below)
    */
   public java.lang.StringBuilder getCommand()
   {
      return command_;
   }

   /**
    * Arguments to command indicated by command_type (below)
    */
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