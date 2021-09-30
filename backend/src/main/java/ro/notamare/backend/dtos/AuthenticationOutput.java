package ro.notamare.backend.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationOutput {

    private String jwt;
    private String email;
    private String name;
}
