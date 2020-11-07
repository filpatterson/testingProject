package com.filpatterson.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

//  prototype of contact page containing references and data useful for testing purposes
public class ContactPage {
    //  page url
    public String url = "https://loving-hermann-e2094b.netlify.app/contact.html";

    //  reference to sign in button in top-navigation bar
    @FindBy(xpath = "//*[@id='home']/div/ul/li[1]/a")
    public WebElement signInButton;

    //  reference to sign up button in top-navigation bar
    @FindBy(xpath = "//*[@id='home']/div/ul/li[2]/a")
    public WebElement signUpButton;

    //  reference to sign in button in authentication form
    @FindBy(xpath = "//*[@id='myModal']/div/div/div[2]/div[1]/form/input")
    public WebElement signInPopupSignInButton;

    //  reference to sign up button in registration form
    @FindBy(xpath = "//*[@id='myModal2']/div/div/div[2]/div[1]/form/input")
    public WebElement signUpPopupSignUpButton;

    //  reference to input name field in authentication form
    @FindBy(xpath = "//div[@id='myModal']//input[@name='Name']")
    public WebElement signInPopupNameInputField;

    //  reference to input email field in authentication form
    @FindBy(xpath = "//div[@id='myModal']//input[@name='Email']")
    public WebElement signInPopupEmailInputField;

    //  reference to input name field in registration form
    @FindBy(xpath = "//div[@id='myModal2']//input[@name='Name']")
    public WebElement signUpPopupNameInputField;

    //  reference to input email field in registration form
    @FindBy(xpath = "//div[@id='myModal2']//input[@name='Email']")
    public WebElement signUpPopupEmailInputField;

    //  reference to input password field in registration form
    @FindBy(xpath = "//div[@id='myModal2']//input[@name='password']")
    public WebElement signUpPopupPasswordInputField;

    //  reference to input confirm password field in registration form
    @FindBy(xpath = "//div[@id='myModal2']//input[@name='Confirm Password']")
    public WebElement signUpPopupConfirmPasswordInputField;

    //  reference to popup authentication form
    @FindBy(xpath = "//*[@id='myModal']/div/div")
    public WebElement signInPopupForm;

    //  reference to popup registration form
    @FindBy(xpath = "//*[@id='myModal2']/div/div")
    public WebElement signUpPopupForm;

    //  reference to used driver
    public WebDriver driver;

    /**
     * constructor for page prototype
     * @param driver
     */
    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * click on sign in button in top-navigation bar
     */
    public void clickOnSignIn(){
        signInButton.click();
    }

    /**
     * click on sign in button in authentication form
     */
    public void clickOnPSignInPopupSignIn(){
        signInPopupSignInButton.click();
    }

    /**
     * click on sign up button in top-navigation bar
     */
    public void clickOnSignUp(){
        signUpButton.click();
    }

    /**
     * click on sign up button in registration form
     */
    public void clickOnSignUpPopupSignUp(){
        signUpPopupSignUpButton.click();
    }

    /**
     * function for logging in using name and email
     * @param map map containing datatable with name and email
     */
    public void loginWithNameEmail(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String name = map.get("username");
        String email = map.get("email");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(signInPopupNameInputField));

        //  check if there are values to enter
        if(!"n/a".equals(name)){
            signInPopupNameInputField.clear();
            signInPopupNameInputField.sendKeys(name);
        }
        if(!"n/a".equals(email)){
            signInPopupEmailInputField.clear();
            signInPopupEmailInputField.sendKeys(email);
        }
    }

    /**
     * function for registration using name and email
     * @param map map containing datatable with name and email
     */
    public void registrateWithNameEmailPassword(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String name = map.get("username");
        String email = map.get("email");
        String password = map.get("password");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(signUpPopupNameInputField));

        //  check if there are values to enter
        if(!"n/a".equals(name)){
            signUpPopupNameInputField.clear();
            signUpPopupNameInputField.sendKeys(name);
        }
        if(!"n/a".equals(email)){
            signUpPopupEmailInputField.clear();
            signUpPopupEmailInputField.sendKeys(email);
        }
        if(!"n/a".equals(password)){
            signUpPopupPasswordInputField.clear();
            signUpPopupPasswordInputField.sendKeys(password);
            signUpPopupConfirmPasswordInputField.clear();
            signUpPopupConfirmPasswordInputField.sendKeys(password);
        }
    }
}
