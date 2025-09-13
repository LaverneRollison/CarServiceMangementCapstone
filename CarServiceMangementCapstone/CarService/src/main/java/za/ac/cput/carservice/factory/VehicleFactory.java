package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Vehicle;

public class VehicleFactory {

    private VehicleFactory() {
    }

    public static Vehicle createVehicle(
            String make,
            String model,
            int year,
            String licensePlate) {

        if (make == null || make.isBlank()) {
            throw new IllegalArgumentException("Vehicle make is required");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Vehicle model is required");
        }
        if (year <= 1985) {
            throw new IllegalArgumentException("Year must be valid");
        }
        if (licensePlate == null || licensePlate.isBlank()) {
            throw new IllegalArgumentException("License plate is required");
        }

        return new Vehicle.Builder()
                .setMake(make.trim())
                .setModel(model.trim())
                .setYear(year)
                .setLicensePlate(licensePlate.trim())
                .build();
    }
}
