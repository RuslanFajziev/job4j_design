package ru.job4j.design.lspcars;

public class ParkingAllCars implements Parking {
    private Car[] autos;
    private Car[] trucks;
    private int markerAuto = 0;
    private int markerTruck = 0;
    private int sizeAuto;
    private int sizeTruck;

    public ParkingAllCars(Car[] autos, Car[] trucks) {
        this.autos = autos;
        this.trucks = trucks;
        sizeAuto = autos.length;
        sizeTruck = trucks.length;
    }

    @Override
    public boolean parkCar(Car car) {
        int size = car.getSize();
        if (size > 1 && (sizeTruck - markerTruck) >= 1) {
            for (int i = markerTruck; i < markerTruck + 1; i++) {
                trucks[i] = car;
            }
            markerTruck += 1;
            return true;
        } else {
            if ((sizeAuto - markerAuto) >= size) {
                int newMarkerCars = markerAuto + size;
                for (int i = markerAuto; i < newMarkerCars; i++) {
                    autos[i] = car;
                }
                markerAuto = newMarkerCars;
                return true;
            }
        }
        return false;
    }
}