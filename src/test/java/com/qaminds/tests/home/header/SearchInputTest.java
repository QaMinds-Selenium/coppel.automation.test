package com.qaminds.tests.home.header;

import com.qaminds.tests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Slf4j
public class SearchInputTest extends BaseTest {
    @DataProvider(name = "TestData")
    public Object[][] testData(){
        return new Object[][]{
                {"https://www.coppel.com/pantallas-led", "Pantallas"},
                {"https://www.coppel.com/equipos-celulares","Celulares"},
        };
    }
    @Test(dataProvider = "TestData")
    public void validateSearchBySpesificURL(String url, String testData){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo(url);
    }
}
