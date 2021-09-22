package org.example.app.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

//@DefaultUrl("https://en.wikipedia.org/")
public class WikipediaPage extends PageObject {

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElementFacade searchInput;

    public void openWikipediaPage() {
        openAt("https://en.wikipedia.org/");
    }

    public void inputSearchValue(String string) {
        searchInput.waitUntilVisible().typeAndEnter(string);
    }
}
