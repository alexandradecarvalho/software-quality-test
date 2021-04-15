package tqs.lab4.ex2;

import java.util.Objects;

public class Car {
    private long carId;
    private String maker;
    private String model;

    public Car(){
    }

    public Car(String maker, String model){
        this.maker = maker;
        this.model = model;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                Objects.equals(maker, car.maker) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, maker, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
