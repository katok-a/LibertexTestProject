package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchPage {
    private SelenideElement searchLine() {
        return $(By.name("q"));
    }

    private SelenideElement searchResultsDiv() {
        return $(By.xpath("//div[@id='search']"));
    }

    private SelenideElement mainPageButton() {
        return $(By.xpath(".//*[@id='logo']"));
    }

    public void searchFor(String text) {
        searchLine().val(text).pressEnter();
    }

    public String getSearchLineTitle() {
        return searchLine().getAttribute("title");
    }

    public boolean isSearchResultsPresent() {
        return searchResultsDiv().exists();
    }

    public ElementsCollection getSearchResults(String resultContent) {
        return $$(By.partialLinkText(resultContent));
    }

    public void clickMainPageButton() {
        mainPageButton().click();
    }

}
