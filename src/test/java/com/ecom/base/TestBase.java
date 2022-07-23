package com.ecom.base;

import com.ecom.utils.DriverManager;
import com.ecom.utils.Log;
import com.ecom.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.ByteArrayInputStream;

public class TestBase extends DriverManager {
    //setup and TearDown
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();

    public TestBase(){
        this.driver = super.getDriver();
    }


    @BeforeMethod(alwaysRun = true)
    public void setup(){
        //Read from Properties file and set the webdriver
        try{
            if(PropertyReader.readItem("browser").equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }else if(PropertyReader.readItem("browser").equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else{
                try{
                    throw new Exception("Browser Driver is no supported");
                }catch (Exception e){
                    Log.error("No Compatible browser found",e);
                }
            }
        }catch (Exception e){
            Log.error("Browser Launch Error",e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}
