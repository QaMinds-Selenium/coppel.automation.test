package com.qaminds.pages;

import com.qaminds.utils.WaitsHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pages {
    private WebDriver driver;
    public WaitsHelpers waith;
    private WebDriverWait wait;
    public Pages(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));   }

    private static  <T> T PagesFactory(WebDriver driver, Class<T> clazz){
        return PageFactory.initElements(driver, clazz);
    }
    public static HomePage returnHomePage(WebDriver driver){

        return PagesFactory(driver, HomePage.class);
    }

    public static ListProductPage returnListProductPage(WebDriver driver){
        return PagesFactory(driver, ListProductPage.class);
    }

}
