package ro.notamare.backend.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationOutput {

    private String jwt;
    private String email;
}
