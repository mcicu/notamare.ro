package ro.notamare.backend.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class AuthenticationInput {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
