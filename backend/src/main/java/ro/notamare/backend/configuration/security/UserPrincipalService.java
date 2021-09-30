package ro.notamare.backend.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.notamare.backend.entities.AbstractUser;
import ro.notamare.backend.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPrincipalService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<? extends AbstractUser> user = userRepository.findByEmail(email);
        if (user.isEmpty())
            throw new UsernameNotFoundException("Utilizatorul nu a fost gasit");
        return new UserPrincipal(user.get());
    }
}
