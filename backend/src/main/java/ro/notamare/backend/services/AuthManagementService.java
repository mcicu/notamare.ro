package ro.notamare.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.notamare.backend.configuration.security.JwtHandler;
import ro.notamare.backend.configuration.security.UserPrincipal;
import ro.notamare.backend.dtos.AuthenticationInput;
import ro.notamare.backend.dtos.AuthenticationOutput;
import ro.notamare.backend.dtos.RegistrationInput;
import ro.notamare.backend.dtos.RegistrationOutput;
import ro.notamare.backend.entities.AbstractUser;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.enums.UserType;
import ro.notamare.backend.exceptions.BusinessException;
import ro.notamare.backend.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthManagementService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtHandler jwtHandler;

    public RegistrationOutput registerUser(RegistrationInput input) {
        checkAccountDoesNotExist(input.getEmail());

        AbstractUser user = generateUserEntity(input);
        userRepository.save(user);

        String jwt = jwtHandler.create(user);
        return RegistrationOutput.builder()
                .jwt(jwt)
                .email(input.getEmail())
                .build();
    }

    public AuthenticationOutput loginUser(AuthenticationInput input) {
        UserPrincipal principal = this.authenticate(input);
        AbstractUser user = principal.getAuthenticatedUser();
        String jwt = jwtHandler.create(user);

        return AuthenticationOutput.builder()
                .jwt(jwt)
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    private UserPrincipal authenticate(AuthenticationInput input) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        return (UserPrincipal) authentication.getPrincipal();
    }

    private void checkAccountDoesNotExist(String email) {
        Optional<? extends AbstractUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new BusinessException("Exista deja un cont pentru adresa de email specificata");
        }
    }

    private AbstractUser generateUserEntity(RegistrationInput input) {
        if (input.getUserType() == UserType.TUTOR) {
            Tutor user = new Tutor();
            user.setName(input.getName());
            user.setEmail(input.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(input.getPassword()));
            return user;
        }

        throw new RuntimeException("User Type not implemented");
    }
}
