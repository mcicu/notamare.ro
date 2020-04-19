package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend._security.JwtHandler;
import ro.notamare.backend.dtos.UserDTO;
import ro.notamare.backend.services.UserRegistrationService;

@RestController
@AllArgsConstructor
public class UserAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRegistrationService userRegistrationService;
    private final JwtHandler jwtHandler;

    @PostMapping(path = "/register", consumes = "application/json")
    public String register(@RequestBody UserDTO userDTO) {
        return userRegistrationService.registerUser(userDTO);
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public String login(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword())
        );

        return jwtHandler.create(userDTO.getEmail());
    }
}
