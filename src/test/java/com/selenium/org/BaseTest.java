package com.selenium.org;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties properties = new Properties();

    @BeforeTest
    public void setUp() throws InterruptedException{
        if(driver != null){
            driver.get("https://dev.jugyah.com/");
            Thread.sleep(2000);
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
