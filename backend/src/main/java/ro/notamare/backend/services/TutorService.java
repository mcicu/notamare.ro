package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public Optional<TutorDTO> getTutor(String id) {
        return tutorRepository.findById(id)
                .map(TutorMapper::toDTO);
    }

    public List<TutorDTO> getTutors() {
        return tutorRepository.findAll().stream()
                .map(TutorMapper::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    public String createTutor(TutorDTO tutorDTO) {
        Tutor tutor = TutorMapper.toEntity(tutorDTO);
        return tutorRepository.insert(tutor).getId();
    }
}
