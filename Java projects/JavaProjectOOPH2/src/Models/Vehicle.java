package Models;

public abstract class Vehicle {
    private String type;
    private String registrationNumber;
    private String brand;
    private String model;

    public Vehicle(String type, String registrationNumber, String brand, String model) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (this.type == null || this.type.length() > 100) {
            throw new IllegalArgumentException("Invalid type.");
        }
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (this.registrationNumber == null || this.registrationNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid registration number.");
        }
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (this.brand == null || this.brand.length() > 20) {
            throw new IllegalArgumentException("Invalid brand.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (this.model == null || this.model.length() > 20) {
            throw new IllegalArgumentException("Invalid type.");
        }
        this.model = model;
    }
}
