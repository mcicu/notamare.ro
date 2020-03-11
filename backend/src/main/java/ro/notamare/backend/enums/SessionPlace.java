package ro.notamare.backend.enums;

import lombok.Getter;

@Getter
public enum SessionPlace {
    ONLINE("Online"),
    TUTOR_PLACE("La domiciliul tutorelui"),
    STUDENT_PLACE("La domiciliul studentului"),
    TUTORING_CENTRE("La centrul de meditatii");

    private final String value;

    SessionPlace(String value) {
        this.value = value;
    }
}
