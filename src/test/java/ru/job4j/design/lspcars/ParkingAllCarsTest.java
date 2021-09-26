package ru.job4j.design.lspcars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingAllCarsTest {
    @Test
    public void checkParking1() {
        Car[] autos = new Car[5];
        Car[] trucks = new Car[2];

        ParkingAllCars parkingAllCars = new ParkingAllCars(autos, trucks);
        Car carBig1 = new Truck(2);
        Car carBig2 = new Truck(3);
        Car carBig3 = new Truck(4);
        Car carSmall1 = new Auto();
        Car carSmall2 = new Auto();
        parkingAllCars.parkCar(carBig1); //true trucks
        parkingAllCars.parkCar(carBig2); //true trucks
        parkingAllCars.parkCar(carBig3); //true autos
        assertTrue(parkingAllCars.parkCar(carSmall1)); //true autos
        assertFalse(parkingAllCars.parkCar(carSmall2)); //false
    }

    @Test
    public void checkParking2() {
        Car[] autos = new Car[5];
        Car[] trucks = new Car[2];

        ParkingAllCars parkingAllCars = new ParkingAllCars(autos, trucks);
        Car carBig1 = new Truck(2);
        Car carBig2 = new Truck(3);
        Car carBig3 = new Truck(4);
        Car carSmall1 = new Auto();
        Car carSmall2 = new Auto();
        parkingAllCars.parkCar(carSmall1); //true autos
        parkingAllCars.parkCar(carSmall2); //true autos
        parkingAllCars.parkCar(carBig1); //true trucks
        parkingAllCars.parkCar(carBig3); //true trucks
        assertTrue(parkingAllCars.parkCar(carBig2)); //true autos
    }
}