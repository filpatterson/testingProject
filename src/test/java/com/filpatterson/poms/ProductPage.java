package com.filpatterson.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ProductPage {
    //  page url
    public String url = "https://loving-hermann-e2094b.netlify.app/single.html";

    //  reference to review section of product page
    @FindBy(xpath = "//*[@id='horizontalTab']/ul/li[2]")
    public WebElement reviewSection;

    //  reference to add a review form
    @FindBy(xpath = "//*[@id='horizontalTab']/div/div[2]/div/div/div[2]")
    public WebElement addingReviewForm;

    //  reference to name input field in adding review form
    @FindBy(xpath = "//*[@id='horizontalTab']/div/div[2]/div/div/div[2]/form/input[1]")
    public WebElement addingReviewNameInputField;

    //  reference to email input field in adding review form
    @FindBy(xpath = "//*[@id='horizontalTab']/div/div[2]/div/div/div[2]/form/input[2]")
    public WebElement addingReviewEmailInputField;

    //  reference to message input field in adding review form
    @FindBy(xpath = "//*[@id='horizontalTab']/div/div[2]/div/div/div[2]/form/textarea")
    public WebElement addingReviewMessageInputField;

    //  reference to review form send button
    @FindBy(xpath = "//*[@id='horizontalTab']/div/div[2]/div/div/div[2]/form/input[3]")
    public WebElement reviewFormSendButton;

    //  reference to used driver
    public WebDriver driver;

    /**
     * constructor for page prototype
     * @param driver driver reference for web-page interaction
     */
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * click on sign in button in top-navigation bar
     */
    public void clickOnReviewSectionButton(){
        reviewSection.click();
    }

    public void clickOnSendReviewButton(){
        reviewFormSendButton.click();
    }

    /**
     * function for logging in using name and email
     * @param map map containing datatable with name and email
     */
    public void inputReviewNameEmailMessage(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String name = map.get("username");
        String email = map.get("email");
        String message = map.get("message");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(addingReviewNameInputField));

        //  check if there are values to enter
        if(!"n/a".equals(name)){
            addingReviewNameInputField.clear();
            addingReviewNameInputField.sendKeys(name);
        }
        if(!"n/a".equals(email)){
            addingReviewEmailInputField.clear();
            addingReviewEmailInputField.sendKeys(email);
        }
        if(!"n/a".equals(message)){
            addingReviewMessageInputField.clear();
            addingReviewMessageInputField.sendKeys(message);
        }
    }
}
