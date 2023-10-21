package com.qaminds.pages;

import com.qaminds.utils.WaitsHelpers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Slf4j
public class HomePage {

    WebDriver driver;
    WaitsHelpers wait;

    public HomePage(){
        wait = new WaitsHelpers(driver);
    }

    @FindBy(id = "SimpleSearchForm_SearchTerm")
    private WebElement inputSearch;

    @FindBy(css = "a.submitButton")
    private WebElement buttonSearch;

    public void InputSearch(String product){
        log.debug("first click on InputSearch in HomePage");

        if(wait.waitForElementIsVisivility(inputSearch, 20, 2)){
            inputSearch.click();
        }

        inputSearch.click();

        log.debug("into product for search");
        inputSearch.sendKeys(product);
    }

    public void clickButtonSearch(){
        buttonSearch.click();
    }
}
