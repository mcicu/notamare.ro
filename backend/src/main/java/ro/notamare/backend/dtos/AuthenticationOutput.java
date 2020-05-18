package ro.notamare.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationOutput {

    private String jwt;
    private String email;
    private String name;
}
