package za.ac.cput.carservice.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int Userid;
    protected String Username;
    protected String Password;
    protected String Email;
    protected String Phone;
    protected String Role;

    public User() {
    }

    private User(Builder builder) {
        this.Userid = builder.Userid;
        this.Username = builder.Username;
        this.Password = builder.Password;
        this.Email = builder.Email;
        this.Phone = builder.Phone;
        this.Role = builder.Role;
    }

    public int getUserid() {
        return Userid;
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
        private int Userid;
        private String Username;
        private String Password;
        private String Email;
        private String Phone;
        private String Role;


        public Builder setUserid(int Userid) {
            this.Userid = Userid;
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
            this.Userid = user.Userid;
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
