package com.qaminds.tests.home.header;

import com.qaminds.pages.HomePage;
import com.qaminds.pages.ListProductPage;
import com.qaminds.pages.Pages;
import com.qaminds.tests.BaseTest;
import com.qaminds.utils.ScreenshotHelpers;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j

public class SearchInputTest extends BaseTest {


    @Test
    public void validateSearchByButton(){
        log.info("Step 1: Navigate to coppel.com ");
        navigateTo("coppel.com");

        log.info("Step 2: Into product name to sarch");
        Pages.returnHomePage(getDriver()).InputSearch("Sillon");

        //System.out.println(ScreenshotHelpers.screenshot(getDriver()));

        log.info("Step 3: Click on ButtonSearch");
        Pages.returnHomePage(getDriver()).clickButtonSearch();

        log.info("Step validate: Validate that show ListProductPage");

        //try {
          //  Thread.sleep(1000);
        //} catch (InterruptedException e) {
            //throw new RuntimeException(e);
        //}

        assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResults())
               .as("No se encontro disponible el elemento")
               .isTrue();
    }
}
