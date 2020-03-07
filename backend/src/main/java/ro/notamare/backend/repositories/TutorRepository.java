package ro.notamare.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.notamare.backend.entities.Tutor;

@Repository
public interface TutorRepository extends MongoRepository<Tutor, String> {
}
