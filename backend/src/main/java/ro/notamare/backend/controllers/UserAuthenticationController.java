package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend.dtos.AuthenticationInput;
import ro.notamare.backend.dtos.AuthenticationOutput;
import ro.notamare.backend.dtos.RegistrationInput;
import ro.notamare.backend.services.AuthManagementService;

@RestController
@AllArgsConstructor
public class UserAuthenticationController {

    private final AuthManagementService authManagementService;

    @PostMapping(path = "/register", consumes = "application/json")
    public String register(@RequestBody RegistrationInput registrationInput) {
        return authManagementService.registerUser(registrationInput);
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public AuthenticationOutput login(@RequestBody AuthenticationInput input) {
        return authManagementService.loginUser(input);
    }
}
