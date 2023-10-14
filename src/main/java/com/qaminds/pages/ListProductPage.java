package com.qaminds.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListProductPage {

    @FindBy(className = "product_listing_container")
    private WebElement containerResults;

    public boolean isDisplayContainerResults(){
        return containerResults.isDisplayed();
    }

}
