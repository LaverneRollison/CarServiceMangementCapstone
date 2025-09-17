package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Mechanic extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechanicId;
    private String specialization;
    private String contactInfo;

    protected Mechanic(){super();}


    private Mechanic(Builder builder) {
        this.mechanicId = builder.mechanicId;
        this.specialization = builder.specialization;
        this.contactInfo = builder.contactInfo;
        this.Username = builder.Username;
        this.Password = builder.Password;
        this.Email = builder.Email;
        this.Phone = builder.Phone;
        this.Role = builder.Role;
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
public String toString() { return
        "Mechanic{"+ super.toString()+"MechanicId"+mechanicId+"Specialization"+specialization+"ContactInfo"+contactInfo+"}";
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
        private String Username;
        private String Password;
        private String Email;
        private String Phone;
        private String Role;

        public Builder mechanicId(Long mechanicId) {
            this.mechanicId = mechanicId;
            return this;
        }

        public Mechanic.Builder setspecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Mechanic.Builder setcontactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public Mechanic.Builder setUsername(String Username) {
            this.Username= Username;
            return this;
        }
        public Mechanic.Builder setPassword(String Password) {
            this.Password = Password;
            return this;
        }
        public Mechanic.Builder setEmail(String Email) {
            this.Email = Email;
            return this;
        }
        public Mechanic.Builder setPhone(String Phone) {
            this.Phone = Phone;
            return this;
        }
        public Mechanic.Builder setRole(String Role) {
            this.Role = Role;
            return this;
        }
           public Builder copy(Mechanic mechanic) {
            this.mechanicId = mechanic.mechanicId;
            this.specialization = mechanic.getSpecialization();
            this.contactInfo = mechanic.getContactInfo();
            this.Username = mechanic.getUsername();
            this.Password = mechanic.getPassword();
            this.Email = mechanic.getEmail();
            this.Phone = mechanic.getPhone();
            this.Role = mechanic.getRole();
            return this;
           }
        public Mechanic build() {

            return new Mechanic(this);
        }
    }
}
