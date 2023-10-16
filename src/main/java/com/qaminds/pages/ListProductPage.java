package com.qaminds.pages;

import com.qaminds.utils.WaitsHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class ListProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsHelpers waith;

    @FindBy (className = "product_listing_container")
    private WebElement contarinerResults;

    public boolean isDisplayContainerResults(){

        return contarinerResults.isDisplayed();
    }
}
