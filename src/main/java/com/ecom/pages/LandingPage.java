package com.ecom.pages;

import com.ecom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By userNameOnLandingPage = By.cssSelector("div[class='b2c_user_profile'] div h4");

    //Page
    public String loggedInUserName(){
        waitForElementToAppear(userNameOnLandingPage);
        return driver.findElement(userNameOnLandingPage).getText();
    }
}
