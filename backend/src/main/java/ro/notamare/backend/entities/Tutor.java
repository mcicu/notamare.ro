package ro.notamare.backend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import ro.notamare.backend.enums.SessionDuration;
import ro.notamare.backend.enums.SessionPlace;
import ro.notamare.backend.enums.StudentLevel;
import ro.notamare.backend.enums.UserType;

import java.util.LinkedList;
import java.util.List;

@Document(indexName = "tutors")
@Getter
@Setter
public class Tutor extends AbstractUser {

    private String image;
    private String phoneNumber;
    private String description;
    private String location;
    private boolean visible = false;
    private SessionPreferences sessionPreferences = new SessionPreferences();

    public Tutor() {
        super(UserType.TUTOR);
    }

    @Getter
    @Setter
    public static class SessionPreferences {
        private Double price = 100d;
        private SessionDuration duration = SessionDuration.TWO_HOURS;
        private List<String> subjects = new LinkedList<>();
        private List<StudentLevel> studentLevels = new LinkedList<>();
        private List<SessionPlace> places = new LinkedList<>();
    }
}
