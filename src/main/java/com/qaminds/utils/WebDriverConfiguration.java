package com.qaminds.utils;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class WebDriverConfiguration {

    private WebDriver driver;

    private static WebDriverConfiguration webDriverConfiguration;

    public WebDriverConfiguration(WebDriver driver){
        setDriver(driver);
    }

    public static WebDriverConfiguration getInstance(WebDriver driver){
        if(webDriverConfiguration == null){
            webDriverConfiguration = new WebDriverConfiguration(driver);
        }
        return webDriverConfiguration;
    }
}