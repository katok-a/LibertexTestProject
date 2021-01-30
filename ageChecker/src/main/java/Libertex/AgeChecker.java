package Libertex;

import java.time.LocalDate;
import java.time.Period;

public class AgeChecker {
    private static final long CUT_OFF_AGE = 18;

    public boolean checkAgeOverEighteen(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) throw new IllegalArgumentException();
        return java.time.temporal.ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()) >= CUT_OFF_AGE;
    }
}
