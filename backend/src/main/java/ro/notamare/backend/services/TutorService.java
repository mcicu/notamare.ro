package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.mappers.TutorMapper;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorDTO> getTutorList() {
        return tutorRepository.findAllByVisible(true).stream()
                .map(TutorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Tutor> findTutorById(String tutorId) {
        Optional<Tutor> optionalTutor = tutorRepository.findById(tutorId);
        if (false == optionalTutor.isPresent())
            log.error("No tutor found for tutorId = {}", tutorId);
        return optionalTutor;
    }

    public String createEmptyTutor() {
        Tutor tutor = new Tutor();
        tutorRepository.insert(tutor);
        return tutor.getId();
    }

    public TutorDTO updateTutor(String tutorId, TutorDTO tutorDTO) {
        Tutor tutor = TutorMapper.toEntity(tutorDTO);
        tutor.setId(tutorId);
        tutorRepository.save(tutor);
        return TutorMapper.toDTO(tutor);
    }
}
