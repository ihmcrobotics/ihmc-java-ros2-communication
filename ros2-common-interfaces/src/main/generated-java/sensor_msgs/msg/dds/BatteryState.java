package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "BatteryState" defined in BatteryState_.idl.
 *
 * This file was automatically generated from BatteryState_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit BatteryState_.idl instead.
 */
public class BatteryState implements Settable<BatteryState>, EpsilonComparable<BatteryState>
{
   private std_msgs.msg.dds.Header header_;
   private float voltage_;
   private float current_;
   private float charge_;
   private float capacity_;
   private float design_capacity_;
   private float percentage_;
   private byte power_supply_status_;
   private byte power_supply_health_;
   private byte power_supply_technology_;
   private boolean present_;
   private us.ihmc.idl.IDLSequence.Float cell_voltage_;
   private java.lang.StringBuilder location_;
   private java.lang.StringBuilder serial_number_;

   public BatteryState()
   {
      header_ = new std_msgs.msg.dds.Header();

      cell_voltage_ = new us.ihmc.idl.IDLSequence.Float(100, "type_5");

      location_ = new java.lang.StringBuilder(255);

      serial_number_ = new java.lang.StringBuilder(255);
   }

   public BatteryState(BatteryState other)
   {
      set(other);
   }

   public void set(BatteryState other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      voltage_ = other.voltage_;

      current_ = other.current_;

      charge_ = other.charge_;

      capacity_ = other.capacity_;

      design_capacity_ = other.design_capacity_;

      percentage_ = other.percentage_;

      power_supply_status_ = other.power_supply_status_;

      power_supply_health_ = other.power_supply_health_;

      power_supply_technology_ = other.power_supply_technology_;

      present_ = other.present_;

      cell_voltage_.set(other.cell_voltage_);
      location_.setLength(0);
      location_.append(other.location_);

      serial_number_.setLength(0);
      serial_number_.append(other.serial_number_);
   }

   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public float getVoltage()
   {
      return voltage_;
   }

   public void setVoltage(float voltage)
   {
      voltage_ = voltage;
   }

   public float getCurrent()
   {
      return current_;
   }

   public void setCurrent(float current)
   {
      current_ = current;
   }

   public float getCharge()
   {
      return charge_;
   }

   public void setCharge(float charge)
   {
      charge_ = charge;
   }

   public float getCapacity()
   {
      return capacity_;
   }

   public void setCapacity(float capacity)
   {
      capacity_ = capacity;
   }

   public float getDesignCapacity()
   {
      return design_capacity_;
   }

   public void setDesignCapacity(float design_capacity)
   {
      design_capacity_ = design_capacity;
   }

   public float getPercentage()
   {
      return percentage_;
   }

   public void setPercentage(float percentage)
   {
      percentage_ = percentage;
   }

   public byte getPowerSupplyStatus()
   {
      return power_supply_status_;
   }

   public void setPowerSupplyStatus(byte power_supply_status)
   {
      power_supply_status_ = power_supply_status;
   }

   public byte getPowerSupplyHealth()
   {
      return power_supply_health_;
   }

   public void setPowerSupplyHealth(byte power_supply_health)
   {
      power_supply_health_ = power_supply_health;
   }

   public byte getPowerSupplyTechnology()
   {
      return power_supply_technology_;
   }

   public void setPowerSupplyTechnology(byte power_supply_technology)
   {
      power_supply_technology_ = power_supply_technology;
   }

   public boolean getPresent()
   {
      return present_;
   }

   public void setPresent(boolean present)
   {
      present_ = present;
   }

   public us.ihmc.idl.IDLSequence.Float getCellVoltage()
   {
      return cell_voltage_;
   }

   public java.lang.String getLocationAsString()
   {
      return getLocation().toString();
   }

   public java.lang.StringBuilder getLocation()
   {
      return location_;
   }

   public void setLocation(String location)
   {
      location_.setLength(0);
      location_.append(location);
   }

   public java.lang.String getSerialNumberAsString()
   {
      return getSerialNumber().toString();
   }

   public java.lang.StringBuilder getSerialNumber()
   {
      return serial_number_;
   }

   public void setSerialNumber(String serial_number)
   {
      serial_number_.setLength(0);
      serial_number_.append(serial_number);
   }

   @Override
   public boolean epsilonEquals(BatteryState other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.voltage_, other.voltage_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.current_, other.current_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.charge_, other.charge_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.capacity_, other.capacity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.design_capacity_, other.design_capacity_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.percentage_, other.percentage_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_status_, other.power_supply_status_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_health_, other.power_supply_health_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_technology_, other.power_supply_technology_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.present_, other.present_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.cell_voltage_, other.cell_voltage_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.location_, other.location_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.serial_number_, other.serial_number_, epsilon))
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
      if (!(other instanceof BatteryState))
         return false;

      BatteryState otherMyClass = (BatteryState) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.voltage_ != otherMyClass.voltage_)
         return false;

      if (this.current_ != otherMyClass.current_)
         return false;

      if (this.charge_ != otherMyClass.charge_)
         return false;

      if (this.capacity_ != otherMyClass.capacity_)
         return false;

      if (this.design_capacity_ != otherMyClass.design_capacity_)
         return false;

      if (this.percentage_ != otherMyClass.percentage_)
         return false;

      if (this.power_supply_status_ != otherMyClass.power_supply_status_)
         return false;

      if (this.power_supply_health_ != otherMyClass.power_supply_health_)
         return false;

      if (this.power_supply_technology_ != otherMyClass.power_supply_technology_)
         return false;

      if (this.present_ != otherMyClass.present_)
         return false;

      if (!this.cell_voltage_.equals(otherMyClass.cell_voltage_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.location_, otherMyClass.location_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.serial_number_, otherMyClass.serial_number_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BatteryState {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("voltage=");
      builder.append(this.voltage_);

      builder.append(", ");
      builder.append("current=");
      builder.append(this.current_);

      builder.append(", ");
      builder.append("charge=");
      builder.append(this.charge_);

      builder.append(", ");
      builder.append("capacity=");
      builder.append(this.capacity_);

      builder.append(", ");
      builder.append("design_capacity=");
      builder.append(this.design_capacity_);

      builder.append(", ");
      builder.append("percentage=");
      builder.append(this.percentage_);

      builder.append(", ");
      builder.append("power_supply_status=");
      builder.append(this.power_supply_status_);

      builder.append(", ");
      builder.append("power_supply_health=");
      builder.append(this.power_supply_health_);

      builder.append(", ");
      builder.append("power_supply_technology=");
      builder.append(this.power_supply_technology_);

      builder.append(", ");
      builder.append("present=");
      builder.append(this.present_);

      builder.append(", ");
      builder.append("cell_voltage=");
      builder.append(this.cell_voltage_);

      builder.append(", ");
      builder.append("location=");
      builder.append(this.location_);

      builder.append(", ");
      builder.append("serial_number=");
      builder.append(this.serial_number_);

      builder.append("}");
      return builder.toString();
   }
}