package com.qaminds.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @FindBy(id = "SimpleSearchForm_SearchTerm")
    private WebElement inputSearch;

    @FindBy(css = "a.submitButton")
    private WebElement buttonSearch;

    public void InputSearch(String product){

        log.debug("first click on InputSearch in Homepage");
        inputSearch.click();

        log.debug("input product name for search");
        inputSearch.sendKeys(product);

    }

    public void clickButtonSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        log.debug("Click on search button");
        buttonSearch.click();

    }


}
