package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mechanics")
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechanicId;

    @Column(nullable = false)
    private String specialization;

    @Column
    private String contactInfo;

    protected Mechanic() {
        // Required by JPA
    }

    private Mechanic(Builder builder) {
        this.mechanicId = builder.mechanicId;
        this.specialization = builder.specialization;
        this.contactInfo = builder.contactInfo;
    }

    public Long getMechanicId() { return mechanicId; }
    public String getSpecialization() { return specialization; }
    public String getContactInfo() { return contactInfo; }

    public void updateSpecialization(String newSpecialization) {
        if (newSpecialization == null || newSpecialization.isBlank()) {
            throw new IllegalArgumentException("Specialization cannot be blank");
        }
        this.specialization = newSpecialization.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(mechanicId, mechanic.mechanicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechanicId);
    }

    public static class Builder {
        private Long mechanicId;
        private String specialization;
        private String contactInfo;

        public Builder mechanicId(Long mechanicId) {
            this.mechanicId = mechanicId;
            return this;
        }

        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder contactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public Mechanic build() {
            if (specialization == null || specialization.isBlank()) {
                throw new IllegalStateException("Specialization is required");
            }
            return new Mechanic(this);
        }
    }
}
