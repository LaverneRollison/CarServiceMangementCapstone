package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Booking;
import java.time.LocalDate;

public class BookingFactory {

    private BookingFactory() {
    }

    public static Booking createBooking(
            Long customerId,
            Long vehicleId,
            LocalDate scheduledDate,
            String status) {

        if (customerId == null || customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be valid");
        }
        if (vehicleId == null || vehicleId <= 0) {
            throw new IllegalArgumentException("Vehicle ID must be valid");
        }
        if (scheduledDate == null || scheduledDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date must be today or in the future");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be null or blank");
        }

        return new Booking.Builder()
                .setCustomerId(customerId)
                .setVehicleId(vehicleId)
                .setScheduledDate(scheduledDate)
                .setStatus(status.trim())
                .build();
    }
}
