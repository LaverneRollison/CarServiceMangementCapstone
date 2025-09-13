package za.ac.cput.carservice.factory;
import za.ac.cput.carservice.domain.ServiceOrder;

import java.time.LocalDate;
public class ServiceOrderFactory {
    private ServiceOrderFactory() {

    }

    public static ServiceOrder createServiceOrder(Long bookingId,
                                                  Long mechanicId,
                                                  LocalDate serviceDate,
                                                  String description,
                                                  String status) {

        if (bookingId == null || bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID is required and must be greater than 0");
        }
        if (mechanicId == null || mechanicId <= 0) {
            throw new IllegalArgumentException("Mechanic ID is required and must be greater than 0");
        }
        if (serviceDate == null) {
            throw new IllegalArgumentException("Service date is required");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status is required");
        }

        return new ServiceOrder.Builder()
                .setBookingId(bookingId)
                .setMechanicId(mechanicId)
                .setServiceDate(serviceDate)
                .setDescription(description)
                .setStatus(status)
                .build();
    }

}
