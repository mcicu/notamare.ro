package ro.notamare.backend.graphqlresolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.List;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final TutorRepository tutorRepository;

    public List<Tutor> tutors() {
        return tutorRepository.findAll();
    }
}
