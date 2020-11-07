package com.filpatterson.step;


import com.filpatterson.poms.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginFeatureStepsDef {
    static WebDriver driver = initDriver();
    static String currentUrl;
    static MainPage mp;

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
        mp = new MainPage(driver);

        //  get to the required page
        driver.get("https://loving-hermann-e2094b.netlify.app/contact.html");
        driver.manage().window().maximize();
        currentUrl = driver.getCurrentUrl();
    }

    /**
     * Press authentication button on top-navigation menu
     */
    @When("press button with text 'Sign in'")
    public void pressButtonWithText() {
        mp.clickOnSignIn();
    }

    /**
     * Check if after pressing authentication button has appeared authentication form
     */
    @Then("appears authentication form")
    public void appearsAuthenticationForm() {
        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(mp.signInPopupForm));

        //  show if form is displayed on page
        System.out.println("form is shown? " + mp.signInPopupForm.isDisplayed());
    }

    /**
     * Input user credentials defined in feature as data table to authentication form
     * @param dt
     */
    @And("user logs in with name and email:")
    public void userLogsInWithNameAndEmail(DataTable dt) {
        List<Map<String, String>> ListOfMaps = dt.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        mp.loginWithNameEmail(data);
    }

    /**
     * Perform sign in to the platform with already inserted credentials
     * @throws Throwable
     */
    @And("press button with value 'SIGN IN'")
    public void pressButtonWithValue() throws Throwable {
        mp.signInPopupSignInButton.click();
    }

    @Then("appears page with successful authentication")
    public void appearsPageWithSuccessfulAuthentication() {
        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Page Not Found"));

        System.out.println(driver.getTitle());
        System.out.println(driver.findElements(By.xpath("//*[text()='404']")).size());
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
