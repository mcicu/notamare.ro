package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TutorService {

    private final TutorRepository tutorRepository;

    public Optional<Tutor> findTutorById(String tutorId) {
        Optional<Tutor> optionalTutor = tutorRepository.findById(tutorId);
        if (false == optionalTutor.isPresent())
            log.error("No tutor found for tutorId = {}", tutorId);
        return optionalTutor;
    }
}
