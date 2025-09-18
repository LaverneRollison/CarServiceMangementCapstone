package za.ac.cput.carservice.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("MECHANIC")

public class Mechanic extends User{


    private String specialization;
    private String contactInfo;

    protected Mechanic(){super();}


    private Mechanic(Builder builder) {
       this.UserId = builder.UserId;
        this.specialization = builder.specialization;
        this.contactInfo = builder.contactInfo;
        this.Username = builder.Username;
        this.Password = builder.Password;
        this.Email = builder.Email;
        this.Phone = builder.Phone;
        this.Role = builder.Role;
    }


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
        "Mechanic{"+ super.toString()+"Specialization"+specialization+"ContactInfo"+contactInfo+"}";
}


    public static class Builder {
        private Long UserId;
        private String specialization;
        private String contactInfo;
        private String Username;
        private String Password;
        private String Email;
        private String Phone;
        private String Role;


        public Mechanic.Builder UserId(Long UserId) {
            this.UserId = UserId;
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
           this.UserId = mechanic.UserId;
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
