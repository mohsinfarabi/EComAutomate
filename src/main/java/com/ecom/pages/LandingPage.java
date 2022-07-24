package com.ecom.pages;

import com.ecom.base.BasePage;
import com.ecom.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //WebElements
    By modalWindow = By.className("modal-body");
    By modalCitySelector = By.className("css-1s2u09g-control");
    By modalAreaSelector = By.className("");
    By modalConfirmButton = By.xpath("//button[normalize-space()='Confirm']");

    By userNameOnLandingPage = By.cssSelector("div[class='b2c_user_profile'] div h4");

    //Page
    public String loggedInUserName(){
        waitForElementToAppear(userNameOnLandingPage);
        return driver.findElement(userNameOnLandingPage).getText();
    }

    public void openLandingPage(){

        goToUrl(PropertyReader.readItem("url"));
    }
    public void setDeliveryLocation(){

    }
}
