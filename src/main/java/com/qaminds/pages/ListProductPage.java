package com.qaminds.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListProductPage {

    @FindBy(className = "product_listing_container")
    private WebElement containerResults;

    @FindBy(id = "PageHeading_2_-3001_5901")
    private WebElement labelProduct;

    public boolean isDisplayContainerResults(){
        return containerResults.isDisplayed();
    }

    public String isDisplayLabel(){
        return labelProduct.getText();
    }

}
