package ru.job4j.design.lspcars;

public class GarageBigCar implements Garages {
    Car[] cars;

    public GarageBigCar(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public boolean parkCar(Car car) {
        return false;
    }
}