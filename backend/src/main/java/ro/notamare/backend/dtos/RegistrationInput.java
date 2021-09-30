package ro.notamare.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import ro.notamare.backend.enums.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RegistrationInput {

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private UserType userType;
}
