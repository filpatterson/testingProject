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

public class RegistrationFeatureStepsDef {
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
    @Given("open web-shop page for registration")
    @Test
    public void openWebShopPageForRegistration() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        contactPage = new ContactPage(driver);

        //  get to the required page
        driver.get(contactPage.url);
        driver.manage().window().maximize();
    }

    /**
     * Press registration button on top-navigation menu
     */
    @When("press button with text 'Sign up'")
    @Test
    public void pressButtonWithTextSignUp() {
        Assert.assertNotNull(contactPage.signUpButton);
        contactPage.clickOnSignUp();
    }

    /**
     * Check if after pressing registration button has appeared registration form
     */
    @Then("appears registration form")
    @Test
    public void appearsAuthenticationForm() {
        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(contactPage.signUpPopupForm));

        //  check if form is shown on page
        Assert.assertTrue(contactPage.signUpPopupForm.isDisplayed());
    }

    /**
     * Input user credentials defined in feature as data table to registration form
     * @param dt datatable defined in feature file
     */
    @And("user inputs name, email, password and confirms password:")
    @Test
    public void userInputsNameEmailPasswordAndConfirmsPassword(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(contactPage.signUpPopupNameInputField);
        Assert.assertNotNull(contactPage.signUpPopupEmailInputField);
        Assert.assertNotNull(contactPage.signUpPopupPasswordInputField);
        Assert.assertNotNull(contactPage.signUpPopupConfirmPasswordInputField);

        //  send registration info to form
        contactPage.registrateWithNameEmailPassword(data);
    }

    /**
     * Perform registration to the platform with already inserted credentials
     */
    @And("press button with value 'SIGN UP'")
    @Test
    public void pressButtonWithValueSIGNUP() {
        Assert.assertNotNull(contactPage.signInPopupSignInButton);
        contactPage.clickOnSignUpPopupSignUp();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with successful registration")
    @Test
    public void appearsPageWithSuccessfulRegistration() {
        //  check if there is no 404 notification on the page
        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@Registration")
    public void afterScenario() {
        driver.quit();
    }
}
