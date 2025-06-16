package tacos.dtos;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.domain.User;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public User toUser(PasswordEncoder passwordEncoder) {
        var user = new User();
        user.setUsername(this.username);
        user.setPassword(passwordEncoder.encode(this.password));
        user.setFullName(this.fullName);
        user.setStreet(this.street);
        user.setCity(this.city);
        user.setState(this.state);
        user.setZip(this.zip);
        user.setPhoneNumber(this.phone);
        return user;
    }
}
