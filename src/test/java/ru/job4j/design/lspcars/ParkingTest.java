//package ru.job4j.design.lspcars;
//
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class ParkingTest {
//    @Test
//    public void checkParking1() {
//        Car[] carsSmall = new Car[5];
//        Car[] carsBig = new Car[2];
//        GarageBigCar garageBigCar = new GarageBigCar(carsBig);
//        GarageSmallCar garageSmallCar = new GarageSmallCar(carsSmall);
//        List<Garages> lstGarage = List.of(garageBigCar, garageSmallCar);
//        Parking parking = new Parking(lstGarage);
//        Car carBig1 = new Car(2);
//        Car carBig2 = new Car(3);
//        Car carBig3 = new Car(4);
//        Car carSmall1 = new Car(1);
//        Car carSmall2 = new Car(1);
//        parking.find(carBig1); //true garageBigCar
//        parking.find(carBig2); //true garageBigCar
//        parking.find(carBig3); //true garageSmallCar
//        parking.find(carSmall1); //true garageSmallCar
//        assertFalse(parking.find(carSmall2)); //false
//    }
//
//    @Test
//    public void checkParking2() {
//        Car[] carsSmall = new Car[5];
//        Car[] carsBig = new Car[2];
//        GarageBigCar garageBigCar = new GarageBigCar(carsBig);
//        GarageSmallCar garageSmallCar = new GarageSmallCar(carsSmall);
//        List<Garages> lstGarage = List.of(garageBigCar, garageSmallCar);
//        Parking parking = new Parking(lstGarage);
//        Car carBig1 = new Car(2);
//        Car carBig2 = new Car(3);
//        Car carBig3 = new Car(4);
//        Car carSmall1 = new Car(1);
//        Car carSmall2 = new Car(1);
//        parking.find(carBig1); //true garageBigCar
//        parking.find(carBig2); //true garageBigCar
//        parking.find(carSmall1); //true garageSmallCar
//        assertTrue(parking.find(carBig3)); //true garageSmallCar
//    }
//}