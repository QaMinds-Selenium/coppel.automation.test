package com.qaminds.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
public class ScreenshotHelpers implements ITestListener {
    private final String directory;
    private WebDriver driver;

    public ScreenshotHelpers(WebDriver driver){
        this.driver = driver;
        String currentWorkingDirectory = System.getProperty("user.dir");
        this.directory = String.format("$s/src/test/resources/screenshot/$s", currentWorkingDirectory, new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("*********************** Start Test: {} *************", result.getName());
        log.error(" {}", result.getThrowable().getMessage());
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("********* Start Test: {} ***********", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       log.info("*********** Success Test: {} ***********", result.getName());
    }
}
