package za.ac.cput.carservice.factory;
import za.ac.cput.carservice.domain.User;

public class UserFactory {
    private UserFactory() {}

public static User createUser(
    String Username,
    String Password,
    String Email,
    String Phone,
    String Role
) {


    if (Username == null || Username.isEmpty())
        throw new IllegalArgumentException("Username is required");

    if (Password == null || Password.isEmpty())
        throw new IllegalArgumentException("Password is required");

    if (Email == null || Email.isEmpty() || !Email.contains("@"))
        throw new IllegalArgumentException("Valid email is required");

    if (Role == null || Role.isEmpty())
        throw new IllegalArgumentException("Role is required");


    return new User.Builder()
            .setUsername(Username)
            .setPassword(Password)
            .setEmail(Email)
            .setPhone(Phone)
            .setRole(Role)
            .build();
    }
}
