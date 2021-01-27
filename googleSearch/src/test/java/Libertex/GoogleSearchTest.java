package Libertex;

import pageObjects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


public class GoogleSearchTest {

    private WebDriver driver;
    private final static String GOOGLE_URL = "https://www.google.com/";
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @BeforeTest
    public void driverInit() {
        WebDriverManager.chromedriver().setup();
        // Un-comment next line for headless mode.
        //Configuration.headless = true;
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)
    public void searchTestPositive() {
        String searchRequest = "Libertex";
        open(GOOGLE_URL);
        googleSearchPage.searchFor(searchRequest);
        Assert.assertFalse(googleSearchPage.getSearchResults(searchRequest).isEmpty());
    }

    @Test(priority = 1)
    public void searchTestNegative() {
        //This request suppose to return empty Google search result.
        String searchRequest = "lsdkjfsldkfjsldfjlsdkfjlsdkfjpwj'peofjweofjwsdfsdfs";
        open(GOOGLE_URL);
        googleSearchPage.searchFor(searchRequest);
        Assert.assertTrue(googleSearchPage.getSearchResults(searchRequest).isEmpty());
    }

    @Test(priority = 2)
    public void searchLinePopUpTest() {
        String expected_popup = "Поиск";
        open(GOOGLE_URL);
        //In all Google search pages I've checked (.by, .de, com.hk) popup text at SearchLine is equal to its 'title' attribute.
        Assert.assertEquals(expected_popup, googleSearchPage.getSearchLineTitle());
    }

    @Test(priority = 3)
    public void mainPageButtonTest() {
        this.searchTestPositive();
        googleSearchPage.clickMainPageButton();
        Assert.assertFalse(googleSearchPage.isSearchResultsPresent());
    }
}
