package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Car extends Vehicle{
    private double fuelConsumption;
    private double capacity;
    private String fuel;
    private int power;
    private String gearboxType;
    private int yearOfCreation;
    private Date registrationDate;
    private Date insuranceDate;
    private Date dateOfView;
    private Date tireChangeDate;
    private int oilChange;

    public Car(String type, String registrationNumber, String brand, String model, double fuelConsumption, double capacity, String fuel, int power, String gearboxType, int yearOfCreation, Date registrationDate, Date insuranceDate, Date dateOfView, Date tireChangeDate, int oilChange) {
        super(type, registrationNumber, brand, model);
        this.fuelConsumption = fuelConsumption;
        this.capacity = capacity;
        this.fuel = fuel;
        this.power = power;
        this.gearboxType = gearboxType;
        this.yearOfCreation = yearOfCreation;
        this.registrationDate = registrationDate;
        this.insuranceDate = insuranceDate;
        this.dateOfView = dateOfView;
        this.tireChangeDate = tireChangeDate;
        this.oilChange = oilChange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (this.fuelConsumption <= 0) {
            throw new IllegalArgumentException("Invalid fuel consumption.");
        }
        this.fuelConsumption = fuelConsumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if (this.capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity.");
        }
        this.capacity = capacity;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (this.power <= 0) {
            throw new IllegalArgumentException("Invalid power.");
        }
        this.power = power;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        if (this.yearOfCreation < 0 || this.yearOfCreation > getCurrentYear()) {
            throw new IllegalArgumentException("Invalid year of creation.");
        }
        this.yearOfCreation = yearOfCreation;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        if (this.registrationDate == null || this.registrationDate.getYear() > getCurrentYear()) {
            throw new IllegalArgumentException("Invalid registration date.");
        }
        this.registrationDate = registrationDate;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        if (this.insuranceDate == null || this.insuranceDate.getYear() > getCurrentYear()) {
            throw new IllegalArgumentException("Invalid insurance date.");
        }
        this.insuranceDate = insuranceDate;
    }

    public Date getDateOfView() {
        return dateOfView;
    }

    public void setDateOfView(Date dateOfView) {
        if (this.dateOfView == null || this.dateOfView.getYear() > getCurrentYear()) {
            throw new IllegalArgumentException("Invalid view date.");
        }
        this.dateOfView = dateOfView;
    }

    public Date getTireChangeDate() {
        return tireChangeDate;
    }

    public void setTireChangeDate(Date tireChangeDate) {
        if (this.tireChangeDate == null || this.tireChangeDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid tire change date.");
        }
        this.tireChangeDate = tireChangeDate;
    }

    public int getOilChange() {
        return oilChange;
    }

    public void setOilChange(int oilChange) {
        if (this.oilChange < 0) {
            throw new IllegalArgumentException("Invalid kilometers for oil change.");
        }
        this.oilChange = oilChange;
    }

    private int getCurrentYear() {
        return Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
    }
}
