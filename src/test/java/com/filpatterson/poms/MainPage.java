package com.filpatterson.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class MainPage{

    @FindBy(xpath = "//*[@id='home']/div/ul/li[1]/a")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='myModal']/div/div/div[2]/div[1]/form/input")
    public WebElement signInPopupSignInButton;

    @FindBy(xpath = "//div[@id='myModal']//input[@name='Name']")
    public WebElement signInPopupNameInputField;

    @FindBy(xpath = "//div[@id='myModal']//input[@name='Email']")
    public WebElement signInPopupEmailInputField;

    @FindBy(xpath = "//*[@id='myModal']/div/div")
    public WebElement signInPopupForm;

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void clickOnSignIn(){
        signInButton.click();
    }

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
}
