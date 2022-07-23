package com.ecom.tests;

import com.ecom.base.TestBase;
import com.ecom.pages.LandingPage;
import com.ecom.pages.LoginPage;
import com.ecom.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for true vs True")
    @Test
    public void loginToBM(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginToBM();
        takeScreenshot("Login to BM");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify logged in user")
    @Test
    public void verifyLoggedInUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginToBM();
        LandingPage landingPage = loginPage.afterLogin();

        Assert.assertEquals(landingPage.loggedInUserName(), PropertyReader.readItem("expectedusername"));

        takeScreenshot("Verify Logged in User");
    }
}
