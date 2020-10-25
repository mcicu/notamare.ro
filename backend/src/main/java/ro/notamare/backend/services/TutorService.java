package ro.notamare.backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.mappers.TutorMapper;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public Optional<TutorDTO> findTutorById(String tutorId) {
        Optional<TutorDTO> optionalTutorDTO = tutorRepository.findById(tutorId).map(TutorMapper::toDTO);
        if (false == optionalTutorDTO.isPresent())
            log.error("No tutor found for tutorId = {}", tutorId);
        return optionalTutorDTO;
    }

    public String createEmptyTutor() {
        Tutor tutor = new Tutor();
        tutorRepository.save(tutor);
        return tutor.getId();
    }

    public TutorDTO updateTutor(String tutorId, TutorDTO tutorDTO) {
        Tutor tutor = TutorMapper.toEntity(tutorDTO);
        tutor.setId(tutorId);
        tutorRepository.save(tutor);
        return TutorMapper.toDTO(tutor);
    }

    //TODO score result items
    public List<TutorDTO> searchTutors(String query) {
        QueryBuilder searchQuery = QueryBuilders.multiMatchQuery(query, "description", "location", "sessionPreferences.subjects")
                .fuzziness(Fuzziness.AUTO);
        Iterable<Tutor> resultIterable = tutorRepository.search(searchQuery);

        return StreamSupport.stream(resultIterable.spliterator(), false)
                .map(TutorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
