package Libertex;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;


public class AgeCheckerTest {
    AgeChecker ageChecker = new AgeChecker();

    @DataProvider
    public Object[][] checkAgeDP() {
        return new Object[][]{
                {LocalDate.now().minusYears(17).minusMonths(11).minusDays(27), false},
                {LocalDate.of(2020, 1, 1), false},
                {LocalDate.now().minusYears(18).minusDays(1), true},
                {LocalDate.of(2000, 1, 1), true}

        };
    }

    @Test(dataProvider = "checkAgeDP")
    public void testBirthDates(LocalDate birthDate, boolean expectedResult) {
        Assert.assertEquals(ageChecker.checkAgeOverEighteen(birthDate), expectedResult);
    }

    @DataProvider
    public Object[] exceptionsDP() {
        return new Object[]{
                LocalDate.now().plusDays(1),
                LocalDate.of(2050, 1, 1),
                null};
    }

    @Test(dataProvider = "exceptionsDP", expectedExceptions = IllegalArgumentException.class)
    public void testAgeCheckerIncorrectDate(LocalDate birthDate) {
        ageChecker.checkAgeOverEighteen(birthDate);
    }
}
