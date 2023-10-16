package com.qaminds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    private static <T> T PagesFactory(WebDriver driver, Class<T> clazz){return PageFactory.initElements(driver,clazz);}

    public static HomePage returnHomePage(WebDriver driver){
        return PagesFactory(driver, HomePage.class);
    }

    public static ListProductPage returnListProductPage(WebDriver driver){return PagesFactory(driver, ListProductPage.class);}



}
