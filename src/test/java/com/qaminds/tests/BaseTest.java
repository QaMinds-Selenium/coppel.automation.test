package com.qaminds.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import lombok.Getter;

@Slf4j
@Getter
public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
//        ChromeOptions handlingSSL = new ChromeOptions();
//        handlingSSL.setAcceptInsecureCerts(false);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-http2");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.safaridriver().setup();
//        driver = new SafariDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest(){
        getDriver().quit();
    }

    public void navigateTo(String _url){
        String url = String.format("https://%s", _url);
        getDriver().navigate().to(url);

        if(!getDriver().getCurrentUrl().contains(_url)){
            log.info("Browser could not get to the requested Webpage");
            throw new RuntimeException("Couldnt find: "+url);
        }


    }

}
