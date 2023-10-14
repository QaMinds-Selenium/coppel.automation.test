package com.qaminds.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelpers {

    private final String directory;

    public ScreenshotHelpers(){
        String currentWorkingDirectory = System.getProperty("user.dir");
        this.directory = String.format("%s/src/test/resources/screenshot/%s", currentWorkingDirectory, new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }

    public String screenshot(WebDriver driver){
        String fileName = String.format("screenshot_%s.png", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));

        File dirScreenshot = new File(directory);
        if(!dirScreenshot.exists()){
            dirScreenshot.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(dirScreenshot, fileName);

        try {
            Files.copy(screenshotFile.toPath(), newScreenshotFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newScreenshotFile.toURI().toString();
    }
}
