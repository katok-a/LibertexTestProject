package Libertex;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;


public class AgeCheckerTest {

    AgeChecker ageChecker = new AgeChecker();

    @Test
    public void testAgeCheckerPositive() {
        LocalDate givenDate = LocalDate.of(1990, 1, 1);
        Assert.assertTrue(ageChecker.checkAgeOverEighteen(givenDate));
    }

    @Test
    public void testAgeCheckerNegative() {
        LocalDate givenDate = LocalDate.of(2010, 1, 1);
        Assert.assertFalse(ageChecker.checkAgeOverEighteen(givenDate));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAgeCheckerIncorrectDate() {
        LocalDate givenDate = LocalDate.of(2023, 1, 1);
        ageChecker.checkAgeOverEighteen(givenDate);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAgeCheckerNullAge() {
        ageChecker.checkAgeOverEighteen(null);
    }
}
