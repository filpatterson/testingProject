package com.filpatterson.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class GoogleSearchPage {
    //  page url
    public String url = "https://www.google.co.in";

    //  reference to sign in button in top-navigation bar
    @FindBy(xpath = "//*[@id='gsr']")
    public WebElement mainPage;

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[2]/button/div/span")
    public WebElement secondarySearchButton;

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[2]/div/div[2]/input")
    public WebElement secondarySearchField;

    //  controllr
    @FindBy(xpath = "//*[@id='taw']/div[2]/div/p/span[1]")
    public WebElement didYouMeanNotification;

    @FindBy(xpath = "//*[@id='topstuff']/div/div/p[1]")
    public WebElement nothingFoundNotification;

    @FindBy(xpath = "//*[@id='taw']/div[2]/div/p/a")
    public WebElement didYouMeanOffer;

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[2]/div/div[2]/input")
    public WebElement activeSearchField;

    @FindBy(xpath = "//*[@id='result-stats']")
    public WebElement resultAmount;

    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div")
    public WebElement firstResultOnPage;

    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div")
    public WebElement firstResultWithAnotherLanguage;

    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div[1]/div")
    public WebElement calculatorInterface;

    @FindBy(xpath = "//*[@id='rso']/div[2]/div/div/div")
    public WebElement firstResultOnRequestForTranslator;

    //  reference to used driver
    public WebDriver driver;

    /**
     * constructor for page prototype
     * @param driver driver reference for web-page interaction
     */
    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnSecondarySearchButton() {
        secondarySearchButton.click();
    }

    public void clickOnDidYouMeanOffer() {
        didYouMeanOffer.click();
    }

    public void performIrrelevantSearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("irrelevantSearchRequest");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            searchField.clear();
            searchField.sendKeys(searchRequest);
        }
    }

    public void performIrrelevantSecondarySearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("irrelevantSearchRequest");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(secondarySearchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            secondarySearchField.clear();
            secondarySearchField.sendKeys(searchRequest);
        }
    }

    public void performNotExistingSearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("notExistingRequest");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            searchField.clear();
            searchField.sendKeys(searchRequest);
        }
    }

    public void performRelevantSearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("relevantSearch");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            searchField.clear();
            searchField.sendKeys(searchRequest);
        }
    }

    public void performCalculatorSearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("calculator");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            searchField.clear();
            searchField.sendKeys(searchRequest);
        }
    }

    public void performGoogleTranslateSearch(Map<String, String> map) {
        //  get user credentials required to enter to the login page
        String searchRequest = map.get("googleTranslate");

        //  wait until form will display fields for entering credentials
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        //  check if there are values to enter
        if(!"n/a".equals(searchRequest)){
            searchField.clear();
            searchField.sendKeys(searchRequest);
        }
    }
}
