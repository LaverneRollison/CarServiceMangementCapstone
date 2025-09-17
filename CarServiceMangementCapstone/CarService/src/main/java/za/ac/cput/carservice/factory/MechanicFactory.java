package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Mechanic;

public class MechanicFactory {

    private MechanicFactory() {

    }

    public static Mechanic createMechanic(Long mechanicId,String specialization, String contactInfo,String Username, String Password, String Email, String Phone, String Role ) {
        if (specialization == null || specialization.isBlank()) {
            throw new IllegalArgumentException("Specialization cannot be null or blank");
        }
        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Contact info cannot be null or blank");
        }

        return new Mechanic.Builder()
                .setcontactInfo(contactInfo)
                .setspecialization(specialization)
                .setUsername(Username)
                .setPassword(Password)
                .setEmail(Email)
                .setPhone(Phone)
                .setRole(Role)
                .build();
    }
}
