package com.qaminds.tests.home.header;

import com.qaminds.pages.HomePage;
import com.qaminds.pages.Pages;
import com.qaminds.tests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
public class SearchInputTest extends BaseTest {

    @Test
    public void validateSearchByButton(){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo("coppel.com");

        log.info("Step 2: Into product name to search");
        Pages.returnHomePage(getDriver()).InputSearch("Sillon");

        log.info("Step 3: Click on ButtonSearch");
        Pages.returnHomePage(getDriver()).clickButtonSearch();

        log.info("Step validate: Validate that is visible List Product Page");
        assertThat(Pages.returnHomePage(getDriver()).isVisibleContainerResults()).isTrue();

        log.info("step validate : Validate that show ListProductPage");
        assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResults())
                .as("No se encontro disponible el elemento.")
                .isTrue();
    }
}
