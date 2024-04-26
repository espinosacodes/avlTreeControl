package model;

public class Car implements  Comparable<Car>{
    private String brand;
    private String model;
    private String plate;

    public Car(String brand, String model, String plate) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    @Override
    public int compareTo(Car otherCar){
        return this.plate.compareTo(otherCar.plate);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", model=" + model + ", plate=" + plate + '}';
    }


}
