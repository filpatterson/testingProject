package com.filpatterson.step;

import com.filpatterson.poms.ContactPage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class BasicSearchFeatureStepsDef {
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

    @Given("open Google search page")
    @Test
    public void openGoogleMainSeachPage() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        googleSearchPage = new GoogleSearchPage(driver);

        //  get to the required page
        driver.get(googleSearchPage.url);
        driver.manage().window().maximize();

        Assert.assertNotNull(googleSearchPage.mainPage);
    }

    @When("user clicks on 'Search in Google' button")
    @Test
    public void userClicksOnSearchWithoutInput() {
        googleSearchPage.clickOnSearchButton();
    }

    @Then("nothing happens and user is still on the same page")
    @Test
    public void nothingHappensOnPage() {
        Assert.assertNotNull(googleSearchPage.mainPage);
    }

    @When("user inputs search request into search box:")
    @Test
    public void userInputsSearchRequestIntoSearchBox(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(googleSearchPage.searchField);

        //  add information to review form
        googleSearchPage.performIrrelevantSearch(data);
    }

    @And("user clicks on 'Search in Google' button with inserted search request")
    @Test
    public void userClicksOnSearchInGoogleButtonWithInsertedSearchRequest() {
        Assert.assertNotNull(googleSearchPage.searchButton);
        googleSearchPage.clickOnSearchButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with results of searching request")
    @Test
    public void appearsPageWithResultsOfSearchingRequest() {
//        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
        Assert.assertNotNull(googleSearchPage.didYouMeanNotification);
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@BasicSearch")
    public void afterScenario() {
        driver.quit();
    }
}
