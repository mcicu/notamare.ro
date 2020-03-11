package ro.notamare.backend.enums;

import lombok.Getter;

@Getter
public enum SessionDuration {
    ONE_HOUR("1 ora"),
    ONE_HOUR_AND_HALF("1 ora si jumatate"),
    TWO_HOURS("2 ore"),
    MORE_THAN_TWO_HOURS("Mai mult de 2 ore");

    private String value;

    SessionDuration(String value) {
        this.value = value;
    }
}
