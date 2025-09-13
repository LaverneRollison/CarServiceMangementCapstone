package za.ac.cput.carservice.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long vehicleId;
    private String make;
    private String model;
    private int year;
    private String licensePlate;

    public Vehicle() {

    }

    private Vehicle(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.licensePlate = builder.licensePlate;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + getVehicleId() + "/" +
                "make=" + getMake() + "/" +
                "model=" + getModel() + "/" +
                "year=" + getYear() + "/" +
                "licensePlate=" + getLicensePlate() + "}";
    }

    public static class Builder {
        private Long vehicleId;
        private String make;
        private String model;
        private int year;
        private String licensePlate;

        public Builder setVehicleId(Long vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.vehicleId = vehicle.vehicleId;
            this.make = vehicle.make;
            this.model = vehicle.model;
            this.year = vehicle.year;
            this.licensePlate = vehicle.licensePlate;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
