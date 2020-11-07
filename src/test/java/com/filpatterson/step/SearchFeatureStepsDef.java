package com.filpatterson.step;

import com.filpatterson.poms.ContactPage;
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

public class SearchFeatureStepsDef {
    //  driver for performing all web-actions and interaction
    static WebDriver driver = initDriver();

    //  instance of web-page prototype
    static ContactPage contactPage;

    /**
     * Method for initialization of web driver that will visit the page and perform all required actions
     * @return already set up driver for Chrome
     */
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * open web-shop page and show it
     */
    @Given("open web-shop page with search field")
    @Test
    public void openWebShopPageWithSearchField() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        contactPage = new ContactPage(driver);

        //  get to the required page
        driver.get(contactPage.url);
        driver.manage().window().maximize();

        Assert.assertNotNull(contactPage.searchInputField);
    }

    /**
     * user inputs info to search for
     */
    @When("user inputs info to search")
    @Test
    public void userInputsInfoToSearch() {
        contactPage.inputSearchQueryInSearchField("clothes for men");
    }

    /**
     * press button for searching info
     */
    @And("press search button")
    @Test
    public void pressSearchButton() {
        Assert.assertNotNull(contactPage.searchButton);
        contactPage.clickOnSearchButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with results of search")
    @Test
    public void appearsPageWithResultsOfSearch() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

    /**
     * step to perform after all mentioned above
     */
    @After
    public void afterScenario() {
        driver.quit();
    }
}
