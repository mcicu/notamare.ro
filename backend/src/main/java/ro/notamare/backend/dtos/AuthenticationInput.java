package ro.notamare.backend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AuthenticationInput {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
