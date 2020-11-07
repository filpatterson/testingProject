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

    //  reference to input search field
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/form/input[1]")
    public WebElement searchInputField;

    //  reference to search button
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/form/input[2]")
    public WebElement searchButton;

    //  reference to contact form
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]")
    public WebElement contactForm;

    //  reference to contacting input name field
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]/form/div[1]/input")
    public WebElement contactingNameInputField;

    //  reference to contacting input email field
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]/form/div[2]/input")
    public WebElement contactingEmailInputField;

    //  reference to contacting input subject field
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]/form/div[3]/input")
    public WebElement contactingSubjectInputField;

    //  reference to contacting input message field
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]/form/div[4]/textarea")
    public WebElement contactingMessageInputField;

    //  reference to contacting form send button
    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div[2]/form/input")
    public WebElement contactingSendButton;

    //  reference to used driver
    public WebDriver driver;

    /**
     * constructor for page prototype
     * @param driver driver reference for web-page interaction
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
     * click on search button
     */
    public void clickOnSearchButton(){
        searchButton.click();
    }

    /**
     * click on send contacting information button
     */
    public void clickOnContactingSendButton(){
        contactingSendButton.click();
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
     * @param map map containing datatable with name, email and password
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

    /**
     * function for searching information on platform
     */
    public void inputSearchQueryInSearchField(String searchQuery) {
        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchInputField));

        searchInputField.clear();
        searchInputField.sendKeys(searchQuery);
    }

    /**
     * function for registration using name and email
     * @param map map containing datatable with name, email and password
     */
    public void inputContactingInformation(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String name = map.get("username");
        String email = map.get("email");
        String subject = map.get("subject");
        String message = map.get("message");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(contactingNameInputField));

        //  check if there are values to enter
        if(!"n/a".equals(name)){
            contactingNameInputField.clear();
            contactingNameInputField.sendKeys(name);
        }
        if(!"n/a".equals(email)){
            contactingEmailInputField.clear();
            contactingEmailInputField.sendKeys(email);
        }
        if(!"n/a".equals(subject)){
            contactingSubjectInputField.clear();
            contactingSubjectInputField.sendKeys(subject);
        }
        if(!"n/a".equals(message)){
            contactingMessageInputField.clear();
            contactingMessageInputField.sendKeys(message);
        }
    }
}
