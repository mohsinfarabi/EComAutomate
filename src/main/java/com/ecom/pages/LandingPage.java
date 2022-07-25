package com.ecom.pages;

import com.ecom.base.BasePage;
import com.ecom.utils.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends BasePage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //WebElements
    By modalWindow = By.className("modal-content");
    By modalCitySelector = By.xpath("//*[contains(text(), 'Select City')]");
    By modalAreaSelector = By.xpath("//*[contains(text(), 'Select Area')]");
    By modalConfirmButton = By.xpath("//button[normalize-space()='Confirm']");
    By modalTitle = By.xpath("//h4[@class='text-center']");



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
        waitForElementToAppear(modalWindow);
        waitForElementToAppear(modalCitySelector);
        waitForElementToAppear(modalAreaSelector);

       click(modalCitySelector);
       Actions keyDown = new Actions(driver);
       keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();


       // System.out.println(driver.findElement(modalWindow).getText());
        System.out.println(driver.findElement(modalCitySelector).getText());
        System.out.println(driver.findElement(modalCitySelector).getText());
        System.out.println(driver.findElement(modalAreaSelector).getText());

    }
}
