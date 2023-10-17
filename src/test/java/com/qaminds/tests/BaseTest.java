package com.qaminds.tests;

import com.qaminds.utils.ScreenshotHelpers;
import com.qaminds.utils.TestListener;
import com.qaminds.utils.WebDriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Slf4j
@Setter
@Getter
@Listeners(TestListener.class)
public class BaseTest{

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(Method method){
        WebDriverManager.chromedriver().setup();
        setDriver(WebDriverConfiguration.getInstance(new ChromeDriver()).getDriver());
        getDriver().manage().deleteAllCookies();
        new ScreenshotHelpers(getDriver());
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult){
        log.info("Close browser");
        getDriver().quit();
    }

    public void navigateTo(String _url){
        String url = String.format("http://%s", _url);
        getDriver().get(url);

        if(!getDriver().getCurrentUrl().contains(_url)){
            log.error(String.format("El navegador no pudo navegar a la pagina solicitada."));
            throw new RuntimeException("No se encontro : " + url);
        }
    }
}
