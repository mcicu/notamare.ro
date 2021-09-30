package ro.notamare.backend.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ro.notamare.backend.entities.AbstractUser;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.enums.UserType;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final TutorRepository tutorRepository;

    public Optional<? extends AbstractUser> findByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

    public void save(AbstractUser user) {
        if (user.getUserType() == UserType.TUTOR) {
            tutorRepository.save((Tutor) user);
        }
    }
}
