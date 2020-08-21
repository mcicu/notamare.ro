package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.notamare.backend._security.JwtHandler;
import ro.notamare.backend._security.UserPrincipal;
import ro.notamare.backend.dtos.AuthenticationInput;
import ro.notamare.backend.dtos.AuthenticationOutput;
import ro.notamare.backend.dtos.RegistrationInput;
import ro.notamare.backend.dtos.RegistrationOutput;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.entities.User;
import ro.notamare.backend.exceptions.BusinessException;
import ro.notamare.backend.repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthManagementService {

    private final UserRepository userRepository;
    private final TutorService tutorService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtHandler jwtHandler;

    public RegistrationOutput registerUser(RegistrationInput input) {
        checkAccountDoesNotExist(input.getEmail());

        User user = new User();
        user.setEmail(input.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(input.getPassword()));
        user.setTutorId(tutorService.createEmptyTutor());
        userRepository.insert(user);

        String jwt = jwtHandler.create(input.getEmail());
        return RegistrationOutput.builder()
                .jwt(jwt)
                .email(input.getEmail())
                .build();
    }

    public AuthenticationOutput loginUser(AuthenticationInput input) {
        UserPrincipal principal = this.authenticate(input);
        Optional<Tutor> optionalTutor = tutorService.findTutorById(principal.getAuthenticatedUser().getTutorId());
        String jwt = jwtHandler.create(input.getEmail());

        return AuthenticationOutput.builder()
                .jwt(jwt)
                .email(input.getEmail())
                .name(optionalTutor.map(Tutor::getName).orElse(null))
                .build();
    }

    private UserPrincipal authenticate(AuthenticationInput input) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        return (UserPrincipal) authentication.getPrincipal();
    }

    private void checkAccountDoesNotExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new BusinessException("Exista deja un cont pentru adresa de email specificata");
        }
    }
}
