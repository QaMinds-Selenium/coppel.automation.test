package com.qaminds.tests;

import com.qaminds.utils.WebDriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Slf4j
@Getter
@Setter
public class BaseTest {

    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        log.debug("Entramos al BeforeTest para crear la instancia del navegador");

        setDriver(WebDriverConfiguration.getInstance(new ChromeDriver()).getDriver());
        getDriver().manage().window().maximize();
        try {
            WebDriverManager.chromedriver().setup();

        } catch(Exception ex) {
            log.error("Falto configurar el driver del navegador: " + ex.getMessage());
        }

    }

    @AfterTest
    public void closeBrowser() {
        getDriver().quit();
    }

    public void navigateTo(String url){
        log.info("Estamos navegando en la siguiente URL: " + url);
        getDriver().get(url);
    }
}
