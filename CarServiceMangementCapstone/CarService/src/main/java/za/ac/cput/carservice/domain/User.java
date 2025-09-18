package za.ac.cput.carservice.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long UserId;
    protected String Username;
    protected String Password;
    protected String Email;
    protected String Phone;
    protected String Role;

    public User() {
    }

    private User(Builder builder) {
        this.UserId = builder.UserId;
        this.Username = builder.Username;
        this.Password = builder.Password;
        this.Email = builder.Email;
        this.Phone = builder.Phone;
        this.Role = builder.Role;
    }

    public long getUserId() {
        return UserId;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getRole() {
        return Role;
    }


    public static class Builder {
        private long UserId;
        private String Username;
        private String Password;
        private String Email;
        private String Phone;
        private String Role;


        public Builder setUserId(long UserId) {
            this.UserId = UserId;
            return this;
        }

        public Builder setUsername(String Username) {
            this.Username = Username;
            return this;
        }

        public Builder setPassword(String Password) {
            this.Password = Password;
            return this;
        }

        public Builder setEmail(String Email) {
            this.Email = Email;
            return this;
        }

        public Builder setPhone(String Phone) {

            this.Phone = Phone;
            return this;
        }

        public Builder setRole(String Role) {
            this.Role = Role;
            return this;
        }
        public User.Builder copy(User user) {
            this.UserId = user.UserId;
            this.Username = user.Username;
            this.Password = user.Password;
            this.Email = user.Email;
            this.Phone = user.Phone;
            this.Role = user.Role;
            return this;
        }
        public User build() {return new User(this);}
        }
    }
