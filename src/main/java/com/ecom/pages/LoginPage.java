package com.ecom.pages;

import com.ecom.base.BasePage;
import com.ecom.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //WebElements
    By emailAddress = By.id("email");
    By password = By.id("password");
    By login = By.cssSelector("button[type='submit']");

    //Page Actions
    public void OpenLoginPage(){
        goToUrl(PropertyReader.readItem("url"));
    }
    public void loginToBM(){
        writeText(emailAddress,PropertyReader.readItem("email"));
        writeText(password,PropertyReader.readItem("password"));
        click(login);
    }

    public LandingPage afterLogin(){
        return new LandingPage(driver);
    }


}
