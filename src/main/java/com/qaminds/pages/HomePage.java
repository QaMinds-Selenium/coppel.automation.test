package com.qaminds.pages;

import lombok.extern.slf4j.Slf4j;
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
    @FindBy(id = "SimpleSearchForm_SearchTerm")
    //searchFormLabel
    private WebElement inputSearch;

    @FindBy(css = "a.submitButton")
    private WebElement buttonSearch;

    @FindBy(css = "product_listing_container")
    private WebElement containerResults;

    public void InputSearch(String product){
        log.debug("click on InputSearch in HomePage");
        inputSearch.click();

        log.debug("into product for search");
        inputSearch.sendKeys(product);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickButtonSearch(){
        buttonSearch.click();
    }

    public boolean isVisibleContainerResults(){
        return wait.until(ExpectedConditions.visibilityOf(containerResults)).isDisplayed();
    }

}
