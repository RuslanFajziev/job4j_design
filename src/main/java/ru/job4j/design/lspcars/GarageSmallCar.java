package ru.job4j.design.lspcars;

public class GarageSmallCar implements Garages {
    Car[] cars;

    public GarageSmallCar(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public boolean parkCar(Car car) {
        return false;
    }
}