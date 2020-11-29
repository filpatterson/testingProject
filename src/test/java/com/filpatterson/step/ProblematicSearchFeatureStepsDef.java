package com.filpatterson.step;

import com.filpatterson.poms.GoogleSearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class ProblematicSearchFeatureStepsDef {
    //  driver for performing all web-actions and interaction
    static WebDriver driver = initDriver();

    //  instance of web-page prototype
    static GoogleSearchPage googleSearchPage;

    /**
     * Method for initialization of web driver that will visit the page and perform all required actions
     * @return already set up driver for Chrome
     */
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Given("open Google main search page")
    @Test
    public void openGoogleMainSearchPage() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        googleSearchPage = new GoogleSearchPage(driver);

        //  get to the required page
        driver.get(googleSearchPage.url);
        driver.manage().window().maximize();

        Assert.assertNotNull(googleSearchPage.mainPage);
    }

    @When("user inputs not existing search request into search box:")
    @Test
    public void userInputsNotExistingSearchRequestIntoSearchBox(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(googleSearchPage.searchField);
        Assert.assertNotNull(googleSearchPage.searchButton);

        //  add information to review form
        googleSearchPage.performNotExistingSearch(data);
    }

    @And("user clicks on 'Search in Google' button with inserted not existing search request")
    @Test
    public void userClicksOnSearchInGoogleButtonWithInsertedNotExistingSearchRequest() {
        googleSearchPage.clickOnSearchButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page that nothing is found")
    @Test
    public void appearsPageThatNothingIsFound() {
//        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
        Assert.assertNotNull(googleSearchPage.nothingFoundNotification);
    }

    @When("user inputs irrelevantSearchRequest into search field:")
    @Test
    public void userInputsIrrelevantSearchRequestIntoSearchField(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(googleSearchPage.secondarySearchField);
        Assert.assertNotNull(googleSearchPage.secondarySearchButton);

        //  add information to review form
        googleSearchPage.performIrrelevantSecondarySearch(data);
    }

    @And("user clicks on 'Search in Google' button with inserted irrelevant search request")
    @Test
    public void userClicksOnSearchInGoogleButtonWithInsertedIrrelevantSearchRequest() {
        googleSearchPage.clickOnSecondarySearchButton();
    }

    @Then("appears page with 'did you mean' notification")
    @Test
    public void appearsPageWithDidYouMeanNotification() {
        Assert.assertNotNull(googleSearchPage.didYouMeanNotification);
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@ProblematicSearch")
    public void afterScenario() {
        driver.quit();
    }
}
