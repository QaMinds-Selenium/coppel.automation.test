package com.qaminds.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("--------- Start Test: {} ----------", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Screenshot error: {}", ScreenshotHelpers.screenshot());
        log.error("--------- Failed Test : {} ----------", result.getName());
        log.error("{}", result.getThrowable().getMessage());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("--------- Successful Test : {} ----------", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("--------- {} Tests Failed----------", context.getFailedTests().size());
        log.info("--------- {} Tests Success----------", context.getPassedTests().size());
    }
}
