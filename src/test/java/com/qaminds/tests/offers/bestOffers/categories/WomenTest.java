package com.qaminds.tests.offers.bestOffers.categories;

import com.qaminds.tests.BaseTest;
import com.qaminds.utils.ScreenshotHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
public class WomenTest extends BaseTest {

    @Test
    public void validateTotalProducts() throws Exception {
        log.info("Test");
        log.debug("Test debug");
        throw new Exception("Fallo por que quiero!");
    }

    @Test
    public void validateOfferPrice() throws Exception {
        log.info("Test 2");
        log.debug("Test Debug");
        throw new Exception("Fallo por que quiero!");
    }
}
