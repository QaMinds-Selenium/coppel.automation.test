package com.qaminds.tests.home.header;

import com.qaminds.pages.HomePage;
import com.qaminds.pages.Pages;
import com.qaminds.tests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SearchInputTest extends BaseTest {




    @Test()
    public void ValidateSearchByButton(){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo("coppel.com");

        log.info("Step 2: Input product name to search");
        Pages.returnHomePage(getDriver()).InputSearch("Pantalla");

        log.info("Step 3: Click on Button Search");
        Pages.returnHomePage(getDriver()).clickButtonSearch();
//        getDriver().get("https://coppel.com/pantalla-led");


        log.info("Step 4: Validate ListProductPage is shown");
        assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResults())
                .as("Product list was not displayed")
                .isTrue();


    }

    @Test(dataProvider = "urlTest")
    public void ValidateSearchBySpecificURL(String url, String dataTest){
        log.info("Step 1: Navigate to Coppel.com");
        navigateTo(url);

        log.info("Step 2: Input product name to search");
        Pages.returnHomePage(getDriver()).InputSearch(dataTest);

        log.info("Step 3: Click on Button Search");
        Pages.returnHomePage(getDriver()).clickButtonSearch();

        log.info("Step 4: Validate ListProductPage is shown");
        assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResults())
                .as("Product list was not displayed")
                .isTrue();


    }

}
