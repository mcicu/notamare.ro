package ro.notamare.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.notamare.backend.entities.Tutor;

import java.util.List;

@Repository
public interface TutorRepository extends MongoRepository<Tutor, String> {

    List<Tutor> findAllByVisible(Boolean visible);
}
