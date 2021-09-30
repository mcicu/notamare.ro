package ro.notamare.backend.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ro.notamare.backend.entities.Tutor;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends ElasticsearchRepository<Tutor, String> {

    List<Tutor> findAllByVisible(Boolean visible);

    Optional<Tutor> findByEmail(String email);
}
