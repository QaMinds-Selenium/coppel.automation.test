package com.qaminds.tests.offers.bestOffers.categories;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qaminds.tests.BaseTest;
import com.qaminds.utils.reporter.ReporterManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class WomenTest extends BaseTest {

    @Test
    public void validateTotalProducts() throws Exception {
        log.info("Test");
        log.debug("Test debug");
        throw new Exception("Fallo por que quiero!");
    }

    @Test
    public void validateOfferPrice(){
        log.info("Step One: Open Coppel.com");
        navigateTo("coppel.com");
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step one: Open Coppel.com", ExtentColor.BLUE));

        log.info("Step two: Get title of the Page");
        String title = "Coppel.com";
        String getTitle = getDriver().getTitle();
        ReporterManager.createLogTest().log(Status.INFO, MarkupHelper.createLabel("Step two: Get title of the Page", ExtentColor.BLUE));

        log.info("Step validate: Validate the title of the page");
        assertThat(getTitle).containsIgnoringCase(title);
        ReporterManager.createLogTest().log(Status.PASS, MarkupHelper.createLabel("Step validate: Validate the title of the page", ExtentColor.GREEN));
    }
}
