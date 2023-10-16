package com.qaminds.pages;

import com.qaminds.utils.WaitsHelpers;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class HomePage {
    private WebDriver driver;
    public WaitsHelpers waith;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   }

    @FindBy(id = "SimpleSearchForm_SearchTerm")
    private WebElement inputSearch;

    @FindBy(css = "a.submitButton")
    private WebElement buttonSearch;
    public void InputSearch(String product){
        log.debug("first click on InputSearch in HomePage");
        inputSearch.click();
        log.debug("into product for search");
        inputSearch.sendKeys(product);
    }
    public void clickButtonSearch(){
       // return wait.until(ExpectedConditions.visibilityOf(buttonSearch)).click();
        buttonSearch.click();
        //wait.until(ExpectedConditions.visibilityOf(buttonSearch)).isDisplayed();
        waith.waitForElementByBy(By.id("SimpleSearchForm_SearchTerm"), Duration.ofSeconds(20), Duration.ofSeconds(20));
    }

  //  public void espera(){
    //     return wait.until(ExpectedConditions.visibilityOf(buttonSearch)).click();
    //}


   // public HomePage(WebDriver driver){
      //  this.driver = driver;
    //}



    /*
    private WebElement inputSearch(){
        return driver.findElement(By.id(""));
    }*/
}
