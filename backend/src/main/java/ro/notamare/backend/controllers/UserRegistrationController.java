package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend.dtos.UserDTO;
import ro.notamare.backend.services.UserRegistrationService;

@RestController
@AllArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody UserDTO userDTO) {
        return userRegistrationService.registerUser(userDTO);
    }
}
