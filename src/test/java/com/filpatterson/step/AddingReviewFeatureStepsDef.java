package com.filpatterson.step;

import com.filpatterson.DriverCapabilities;
import com.browserstack.local.Local;
import com.filpatterson.poms.ProductPage;
import gherkin.ast.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddingReviewFeatureStepsDef {
    //  driver for performing all web-actions and interaction
//    static WebDriver driver = initDriver();
    static WebDriver driver;

    //  instance of web-page prototype
    static ProductPage productPage;

    static Local local;

    /**
     * Method for initialization of web driver that will visit the page and perform all required actions
     * @return already set up driver for Chrome
     */
//    public static WebDriver initDriver() {
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();
//    }

    /**
     * Open web-shop page and show it
     */
    @Given("open web-shop product page with review section")
    @Test
    public void openWebShopProductPageWithReviewSection() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(DriverCapabilities.URL), caps);


        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        productPage = new ProductPage(driver);

        //  get to the required page
        driver.get(productPage.url);
        driver.manage().window().maximize();

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(productPage.reviewSection));

        //  check if form is shown on page
        Assert.assertTrue(productPage.reviewSection.isDisplayed());
    }


    @When("user clicks on 'review' field")
    @Test
    public void userClicksOnReviewField() {
        productPage.clickOnReviewSectionButton();
    }

    /**
     * Input name, email and message to the review form
     * @param dt datatable defined in feature file
     */
    @And("user inputs name, email and message to review form:")
    @Test
    public void userInputsNameEmailAndMessageToReviewForm(DataTable dt) {
        //  get elements from datatable in feature file
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  check if there are fields that can be filled with data
        Assert.assertNotNull(productPage.addingReviewNameInputField);
        Assert.assertNotNull(productPage.addingReviewEmailInputField);
        Assert.assertNotNull(productPage.addingReviewMessageInputField);

        //  add information to review form
        productPage.inputReviewNameEmailMessage(data);
    }

    /**
     * send review to page
     */
    @And("press review form button with value 'SEND'")
    @Test
    public void pressButtonWithValueSEND() {
        Assert.assertNotNull(productPage.reviewFormSendButton);
        productPage.clickOnSendReviewButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears product page with attached review to it")
    @Test
    public void appearsPageWithSuccessfulReviewDelivery() {
        //  check if there is no 404 notification on the page
        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@AddingReview")
    public void afterScenario() throws Exception {
        driver.quit();
        if (local != null) local.stop();
    }
}
