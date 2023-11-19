package Models;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private String name;
    private List<Car> availableCars;

    public Garage(String name, List<Car> availableCars) {
        this.name = name;
        this.availableCars = availableCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    public void addCar(Car car) {
        availableCars.add(car);
    }

    public void removeCar(Car car) {
        availableCars.remove(car);
    }

    public List<Car> searchByRegNum(String regNum) {
        List<Car> result = new ArrayList<>();
        for (Car car : availableCars) {
            if (car.getRegistrationNumber().equals(regNum)) {
                result.add(car);
            }
        }
        return result;
    }

    public void updateCarInfo(String regNum, Car updatedCar) {
        boolean found = false;
        for (Car car : availableCars) {
            if (car.getRegistrationNumber().equals(regNum)) {
                car.setBrand(updatedCar.getBrand());
                car.setModel(updatedCar.getModel());
                car.setFuelConsumption(updatedCar.getFuelConsumption());
                car.setCapacity(updatedCar.getCapacity());
                car.setFuel(updatedCar.getFuel());

                System.out.println("Информацията за колата с регистрационен номер " + regNum + " е успешно обновена.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Колата с регистрационен номер " + regNum + " не е намерена.");
        }
    }


    public void printCarInfo() {
        for (Car car : availableCars) {
            System.out.println(car.getRegistrationNumber() + " - " + car.getBrand() + " " + car.getModel());
        }
    }
}
