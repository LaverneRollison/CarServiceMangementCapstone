package za.ac.cput.carservice.factory;

import za.ac.cput.carservice.domain.Mechanic;

public class MechanicFactory {

    private MechanicFactory() {

    }

    public static Mechanic createMechanic(String specialization, String contactInfo) {
        if (specialization == null || specialization.isBlank()) {
            throw new IllegalArgumentException("Specialization cannot be null or blank");
        }
        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Contact info cannot be null or blank");
        }

        return new Mechanic.Builder()
                .specialization(specialization.trim())
                .contactInfo(contactInfo.trim())
                .build();
    }
}
