package com.filpatterson.step;

import com.filpatterson.poms.ProductPage;
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

public class PincodeCheckFeatureStepsDef {
    //  driver for performing all web-actions and interaction
    static WebDriver driver = initDriver();

    //  instance of web-page prototype
    static ProductPage productPage;

    /**
     * Method for initialization of web driver that will visit the page and perform all required actions
     * @return already set up driver for Chrome
     */
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * open web-shop any product page and show it
     */
    @Given("open web-shop any product page")
    @Test
    public void openWebShopAnyProductPage() {
        //  init poms for the page containing prototypes of required elements
        // also send driver reference for navigating through web-page
        productPage = new ProductPage(driver);

        //  get to the required page
        driver.get(productPage.url);
        driver.manage().window().maximize();
    }

    /**
     * user inputs pincode in pincode checking input field
     */
    @When("input pincode for product")
    @Test
    public void inputPincodeForProduct() {
        Assert.assertNotNull(productPage.pincodeInputField);
        productPage.inputPincodeForChecking("12345678");
    }

    /**
     * press button for checking pincode status
     */
    @And("click on 'CHECK' button")
    @Test
    public void pressOnCheckButton() {
        Assert.assertNotNull(productPage.pincodeSendButton);
        productPage.clickOnPincodeSendButton();
    }

    /**
     * Check for non-appearance of 404 error
     */
    @Then("appears page with pincode check status")
    @Test
    public void appearsPageWithPincodeCheckStatus() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

    /**
     * hook that will be performed after finishing appended to this feature scenario
     */
    @After("@PincodeCheck")
    public void afterScenario() {
        driver.quit();
    }
}
