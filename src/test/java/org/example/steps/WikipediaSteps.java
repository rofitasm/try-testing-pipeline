package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.app.pages.WikipediaPage;

public class WikipediaSteps {

    WikipediaPage wikipediaPage;

    @Given("^the user is on the Wikipedia home page$")
    public void theUserIsOnTheWikipediaHomePage() {
        wikipediaPage.openWikipediaPage();
    }

    @When("^the user looks up the definition of \"([^\"]*)\"$")
    public void theUserLooksUpTheDefinitionOfApple() {
    }
}
