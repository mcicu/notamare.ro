package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.notamare.backend.dtos.UserDTO;
import ro.notamare.backend.entities.User;
import ro.notamare.backend.repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String registerUser(UserDTO userDTO) {
        checkAccountDoesNotExist(userDTO.getEmail());

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.insert(user);

        return user.getEmail();
    }

    private void checkAccountDoesNotExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new RuntimeException("Exista deja un cont pentru adresa de email specificata");
        }
    }
}
