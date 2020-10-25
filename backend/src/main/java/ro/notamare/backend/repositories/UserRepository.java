package ro.notamare.backend.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ro.notamare.backend.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    Optional<User> findByEmail(String username);

}
