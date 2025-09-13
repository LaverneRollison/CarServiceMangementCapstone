package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long customerId;
    private Long vehicleId;
    private LocalDate scheduledDate;
    private String status;

    public Booking(){

    }

    private Booking (Builder builder){
        this.bookingId = builder.bookingId;
        this.customerId = builder.customerId;
        this.vehicleId = builder.vehicleId;
        this.scheduledDate = builder.scheduledDate;
        this.status = builder.status;
    }

    public Long getBookingId(){
        return bookingId;
    }

    public Long getCustomerId(){
        return customerId;
    }

    public Long getVehicleId(){
        return vehicleId;
    }

    public LocalDate getScheduledDate(){
        return scheduledDate;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Booking{" +
                "bookingId=" + getBookingId() + "/" +
                "customerId=" + getCustomerId() + "/" +
                "vehicleId=" + getVehicleId() + "/" +
                "scheduledDate=" + getScheduledDate() + "/" +
                "status=" + getStatus() + "}" ;
    }

    public static class Builder {
        private Long bookingId;
        private Long customerId;
        private Long vehicleId;
        private LocalDate scheduledDate;
        private String status;

        public Builder setBookingId(Long bookingId){
            this.bookingId = bookingId;
            return this;
        }

        public Builder setCustomerId(Long customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder setVehicleId(Long vehicleId){
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setScheduledDate(LocalDate scheduledDate){
            this.scheduledDate = scheduledDate;
            return this;
        }

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.customerId = booking.customerId;
            this.vehicleId = booking.vehicleId;
            this.scheduledDate = booking.scheduledDate;
            this.status = booking.status;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
