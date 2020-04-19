package ro.notamare.backend.graphqlresolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.repositories.TutorRepository;

@Component
@AllArgsConstructor
@PreAuthorize("isAuthenticated()")
public class Mutation implements GraphQLMutationResolver {

    private final TutorRepository tutorRepository;

    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor updateTutor(String id, Tutor tutor) {
        tutor.setId(id);
        return tutorRepository.save(tutor);
    }

    public Boolean deleteTutor(String id) {
        tutorRepository.deleteById(id);
        return true;
    }
}
