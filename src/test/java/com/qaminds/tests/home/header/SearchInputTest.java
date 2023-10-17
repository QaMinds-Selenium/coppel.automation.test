package com.qaminds.tests.home.header;

import com.qaminds.pages.Pages;
import com.qaminds.tests.BaseTest;
import com.qaminds.utils.WebDriverConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SearchInputTest extends BaseTest {

    @Test(groups = "Desktop")
    public void validateSearchByButton(){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo("coppel.com");

        log.info("Step 2: Into product name to search");
        Pages.returnHomePage(getDriver()).InputSearch("Sillon");

        log.info("Step 3: Click on ButtonSearch");
        Pages.returnHomePage(getDriver()).clickButtonSearch();

        log.info("Step validate: Validate that show ListProductPage");
        assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResults())
                .as("No se encontro disponible el elemento.")
                .isTrue();
    }

    @DataProvider(name = "TestData")
    public Object[][] DataProviderTest(){
     return new Object[][]{
             {"coppel.com/equipos-celulares", "celulares"},
             {"coppel.com/pantallas-led", "pantallas"}
     };
    }

    @Test(dataProvider = "TestData", groups = "Desktop")
    public void validateSearchBySpesificURL(String url, String dataTest){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo(url);

        log.info("Step validate: Validate that show ListProductPage");
        assertThat(Pages.returnListProductPage(getDriver()).isDisplayLabel())
                .as("No se encontro disponible el elemento.")
                .containsIgnoringCase(dataTest);
    }
}
