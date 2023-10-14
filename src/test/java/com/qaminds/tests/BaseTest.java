package com.qaminds.tests;

import com.qaminds.utils.ScreenshotHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

@Slf4j
@Getter
public class BaseTest {

    private WebDriver driver;
    private ScreenshotHelpers screenshotHelpers;

    @BeforeSuite
    public void beforeSuite(){
        screenshotHelpers = new ScreenshotHelpers();
    }

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        getDriver().quit();
    }

    public void navigateTo(String _url){
        String url = String.format("http://%s", _url);
        getDriver().get(url);

        if(!getDriver().getCurrentUrl().contains(_url)){
            log.error(String.format("El navegador no pudo navegar a la pagina solicitada. %s", screenshotHelpers.screenshot(getDriver())));
            throw new RuntimeException("No se encontro : " + url);
        }
    }
}
