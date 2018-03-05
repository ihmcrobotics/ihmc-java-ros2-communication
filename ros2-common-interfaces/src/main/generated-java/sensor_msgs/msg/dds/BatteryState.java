package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Constants are chosen to match the enums in the linux kernel
 * defined in include/linux/power_supply.h as of version 3.7
 * The one difference is for style reasons the constants are
 * all uppercase not mixed case.
 */
public class BatteryState implements Settable<BatteryState>, EpsilonComparable<BatteryState>
{
   /**
    * Power supply status constants
    */
   public static final byte POWER_SUPPLY_STATUS_UNKNOWN = (byte) 0;
   public static final byte POWER_SUPPLY_STATUS_CHARGING = (byte) 1;
   public static final byte POWER_SUPPLY_STATUS_DISCHARGING = (byte) 2;
   public static final byte POWER_SUPPLY_STATUS_NOT_CHARGING = (byte) 3;
   public static final byte POWER_SUPPLY_STATUS_FULL = (byte) 4;
   /**
    * Power supply health constants
    */
   public static final byte POWER_SUPPLY_HEALTH_UNKNOWN = (byte) 0;
   public static final byte POWER_SUPPLY_HEALTH_GOOD = (byte) 1;
   public static final byte POWER_SUPPLY_HEALTH_OVERHEAT = (byte) 2;
   public static final byte POWER_SUPPLY_HEALTH_DEAD = (byte) 3;
   public static final byte POWER_SUPPLY_HEALTH_OVERVOLTAGE = (byte) 4;
   public static final byte POWER_SUPPLY_HEALTH_UNSPEC_FAILURE = (byte) 5;
   public static final byte POWER_SUPPLY_HEALTH_COLD = (byte) 6;
   public static final byte POWER_SUPPLY_HEALTH_WATCHDOG_TIMER_EXPIRE = (byte) 7;
   public static final byte POWER_SUPPLY_HEALTH_SAFETY_TIMER_EXPIRE = (byte) 8;
   /**
    * Power supply technology (chemistry) constants
    */
   public static final byte POWER_SUPPLY_TECHNOLOGY_UNKNOWN = (byte) 0;
   public static final byte POWER_SUPPLY_TECHNOLOGY_NIMH = (byte) 1;
   public static final byte POWER_SUPPLY_TECHNOLOGY_LION = (byte) 2;
   public static final byte POWER_SUPPLY_TECHNOLOGY_LIPO = (byte) 3;
   public static final byte POWER_SUPPLY_TECHNOLOGY_LIFE = (byte) 4;
   public static final byte POWER_SUPPLY_TECHNOLOGY_NICD = (byte) 5;
   public static final byte POWER_SUPPLY_TECHNOLOGY_LIMN = (byte) 6;
   private std_msgs.msg.dds.Header header_;
   /**
    * Voltage in Volts (Mandatory)
    */
   private float voltage_;
   /**
    * Negative when discharging (A)  (If unmeasured NaN)
    */
   private float current_;
   /**
    * Current charge in Ah  (If unmeasured NaN)
    */
   private float charge_;
   /**
    * Capacity in Ah (last full capacity)  (If unmeasured NaN)
    */
   private float capacity_;
   /**
    * Capacity in Ah (design capacity)  (If unmeasured NaN)
    */
   private float design_capacity_;
   /**
    * Charge percentage on 0 to 1 range  (If unmeasured NaN)
    */
   private float percentage_;
   /**
    * The charging status as reported. Values defined above
    */
   private byte power_supply_status_;
   /**
    * The battery health metric. Values defined above
    */
   private byte power_supply_health_;
   /**
    * The battery chemistry. Values defined above
    */
   private byte power_supply_technology_;
   /**
    * True if the battery is present
    */
   private boolean present_;
   /**
    * An array of individual cell voltages for each cell in the pack
    */
   private us.ihmc.idl.IDLSequence.Float cell_voltage_;
   /**
    * If individual voltages unknown but number of cells known set each to NaN
    * The location into which the battery is inserted. (slot number or plug)
    */
   private java.lang.StringBuilder location_;
   /**
    * The best approximation of the battery serial number
    */
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

   /**
    * Voltage in Volts (Mandatory)
    */
   public float getVoltage()
   {
      return voltage_;
   }

   /**
    * Voltage in Volts (Mandatory)
    */
   public void setVoltage(float voltage)
   {
      voltage_ = voltage;
   }

   /**
    * Negative when discharging (A)  (If unmeasured NaN)
    */
   public float getCurrent()
   {
      return current_;
   }

   /**
    * Negative when discharging (A)  (If unmeasured NaN)
    */
   public void setCurrent(float current)
   {
      current_ = current;
   }

   /**
    * Current charge in Ah  (If unmeasured NaN)
    */
   public float getCharge()
   {
      return charge_;
   }

   /**
    * Current charge in Ah  (If unmeasured NaN)
    */
   public void setCharge(float charge)
   {
      charge_ = charge;
   }

   /**
    * Capacity in Ah (last full capacity)  (If unmeasured NaN)
    */
   public float getCapacity()
   {
      return capacity_;
   }

   /**
    * Capacity in Ah (last full capacity)  (If unmeasured NaN)
    */
   public void setCapacity(float capacity)
   {
      capacity_ = capacity;
   }

   /**
    * Capacity in Ah (design capacity)  (If unmeasured NaN)
    */
   public float getDesignCapacity()
   {
      return design_capacity_;
   }

   /**
    * Capacity in Ah (design capacity)  (If unmeasured NaN)
    */
   public void setDesignCapacity(float design_capacity)
   {
      design_capacity_ = design_capacity;
   }

   /**
    * Charge percentage on 0 to 1 range  (If unmeasured NaN)
    */
   public float getPercentage()
   {
      return percentage_;
   }

   /**
    * Charge percentage on 0 to 1 range  (If unmeasured NaN)
    */
   public void setPercentage(float percentage)
   {
      percentage_ = percentage;
   }

   /**
    * The charging status as reported. Values defined above
    */
   public byte getPowerSupplyStatus()
   {
      return power_supply_status_;
   }

   /**
    * The charging status as reported. Values defined above
    */
   public void setPowerSupplyStatus(byte power_supply_status)
   {
      power_supply_status_ = power_supply_status;
   }

   /**
    * The battery health metric. Values defined above
    */
   public byte getPowerSupplyHealth()
   {
      return power_supply_health_;
   }

   /**
    * The battery health metric. Values defined above
    */
   public void setPowerSupplyHealth(byte power_supply_health)
   {
      power_supply_health_ = power_supply_health;
   }

   /**
    * The battery chemistry. Values defined above
    */
   public byte getPowerSupplyTechnology()
   {
      return power_supply_technology_;
   }

   /**
    * The battery chemistry. Values defined above
    */
   public void setPowerSupplyTechnology(byte power_supply_technology)
   {
      power_supply_technology_ = power_supply_technology;
   }

   /**
    * True if the battery is present
    */
   public boolean getPresent()
   {
      return present_;
   }

   /**
    * True if the battery is present
    */
   public void setPresent(boolean present)
   {
      present_ = present;
   }

   /**
    * An array of individual cell voltages for each cell in the pack
    */
   public us.ihmc.idl.IDLSequence.Float getCellVoltage()
   {
      return cell_voltage_;
   }

   /**
    * If individual voltages unknown but number of cells known set each to NaN
    * The location into which the battery is inserted. (slot number or plug)
    */
   public java.lang.String getLocationAsString()
   {
      return getLocation().toString();
   }

   /**
    * If individual voltages unknown but number of cells known set each to NaN
    * The location into which the battery is inserted. (slot number or plug)
    */
   public java.lang.StringBuilder getLocation()
   {
      return location_;
   }

   /**
    * If individual voltages unknown but number of cells known set each to NaN
    * The location into which the battery is inserted. (slot number or plug)
    */
   public void setLocation(String location)
   {
      location_.setLength(0);
      location_.append(location);
   }

   /**
    * The best approximation of the battery serial number
    */
   public java.lang.String getSerialNumberAsString()
   {
      return getSerialNumber().toString();
   }

   /**
    * The best approximation of the battery serial number
    */
   public java.lang.StringBuilder getSerialNumber()
   {
      return serial_number_;
   }

   /**
    * The best approximation of the battery serial number
    */
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