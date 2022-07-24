package com.ecom.tests;

import com.ecom.base.TestBase;
import com.ecom.pages.LandingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class TestSelectLocation extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for location Set")
    @Test
    public void setLocation(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openLandingPage();
        landingPage.setDeliveryLocation();
        takeScreenshot("Location Set to Test Area");
    }
}
