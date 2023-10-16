package com.qaminds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListProductPage {

//    private WebDriver driver;
//    private WebDriverWait wait;
//    public ListProductPage(WebDriver driver){
//        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//    }
    @FindBy(className = "product_listing_container")
    private WebElement containerResults;


    public boolean isDisplayContainerResults(){
//    wait.until(ExpectedConditions.visibilityOf(containerResults));
    return containerResults.isDisplayed();
    }

}