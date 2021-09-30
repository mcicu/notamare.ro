package ro.notamare.backend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import ro.notamare.backend.enums.UserType;

@Getter
@Setter
public abstract class AbstractUser {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String registrationToken;
    private boolean enabled = false;
    private UserType userType;

    public AbstractUser(UserType userType) {
        this.userType = userType;
    }

}
