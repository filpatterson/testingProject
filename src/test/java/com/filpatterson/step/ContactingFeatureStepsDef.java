package com.filpatterson.step;

import com.filpatterson.poms.ContactPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

public class ContactingFeatureStepsDef {
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
    @Given("open web-shop page contact part and navigate to contact form")
    public void openWebShopPageForContacting() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        contactPage = new ContactPage(driver);

        //  get to the required page
        driver.get(contactPage.url);
        driver.manage().window().maximize();

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(contactPage.contactForm));

        //  check if form is shown on page
        Assert.assertTrue(contactPage.contactForm.isDisplayed());
    }

    /**
     * Input name, email, subject and message to the contact form
     * @param dt datatable defined in feature file
     */
    @And("user inputs name, email, subject and message:")
    @Test
    public void userInputsNameEmailSubjectAndMessage(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(contactPage.contactingNameInputField);
        Assert.assertNotNull(contactPage.contactingEmailInputField);
        Assert.assertNotNull(contactPage.contactingSubjectInputField);
        Assert.assertNotNull(contactPage.contactingMessageInputField);

        //  send contact information to contacting form
        contactPage.inputContactingInformation(data);
    }

    /**
     * send contacting information
     */
    @And("press button with value 'SEND'")
    @Test
    public void pressButtonWithValueSEND() {
        Assert.assertNotNull(contactPage.contactingSendButton);
        contactPage.clickOnContactingSendButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with notification about successful delivery")
    @Test
    public void appearsPageWithSuccessfulContactingDelivery() {
        //  check if there is no 404 notification on the page
        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@Contacting")
    public void afterScenario() {
        driver.quit();
    }
}
