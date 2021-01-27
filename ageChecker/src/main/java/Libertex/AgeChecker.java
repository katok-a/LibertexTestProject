package Libertex;

import java.time.LocalDate;
import java.time.Period;

public class AgeChecker {
    private static final int CUT_OFF_AGE = 18;

    public boolean checkAgeOverEighteen(LocalDate dateOfBirth) {
        if (dateOfBirth==null) throw new IllegalArgumentException();
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if (age < 0) throw new IllegalArgumentException();
        return age > CUT_OFF_AGE;
    }
}
