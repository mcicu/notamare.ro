package ro.notamare.backend.enums;

import lombok.Getter;

@Getter
public enum StudentLevel {

    PRIMARY_SCHOOL("Clasele I-IV"),
    MIDDLE_SCHOOL("Clasele V-VIII"),
    HIGH_SCHOOL("Liceu"),
    FACULTY("Facultate");

    private final String value;

    StudentLevel(String value) {
        this.value = value;
    }


}
