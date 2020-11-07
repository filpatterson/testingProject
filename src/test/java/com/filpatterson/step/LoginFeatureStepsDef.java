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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginFeatureStepsDef {
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
     * Open web-shop page and show it
     */
    @Given("open web-shop page")
    public void openWebShopPage() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        contactPage = new ContactPage(driver);

        //  get to the required page
        driver.get(contactPage.url);
        driver.manage().window().maximize();
    }

    /**
     * Press authentication button on top-navigation menu
     */
    @When("press button with text 'Sign in'")
    @Test
    public void pressButtonWithText() {
        Assert.assertNotNull(contactPage.signInButton);
        contactPage.clickOnSignIn();
    }

    /**
     * Check if after pressing authentication button has appeared authentication form
     */
    @Then("appears authentication form")
    @Test
    public void appearsAuthenticationForm() {
        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(contactPage.signInPopupForm));

        //  check if form is shown on page
        Assert.assertTrue(contactPage.signInPopupForm.isDisplayed());
    }

    /**
     * Input user credentials defined in feature as data table to authentication form
     * @param dt datatable defined in feature file
     */
    @And("user logs in with name and email:")
    @Test
    public void userLogsInWithNameAndEmail(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(contactPage.signInPopupNameInputField);
        Assert.assertNotNull(contactPage.signInPopupEmailInputField);

        //  send authentication info to page
        contactPage.loginWithNameEmail(data);
    }

    /**
     * Perform sign in to the platform with already inserted credentials
     */
    @And("press button with value 'SIGN IN'")
    @Test
    public void pressButtonWithValue() {
        Assert.assertNotNull(contactPage.signInPopupSignInButton);
        contactPage.clickOnPSignInPopupSignIn();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with successful authentication")
    @Test
    public void appearsPageWithSuccessfulAuthentication() {
        //  check if there is no 404 notification on the page
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
