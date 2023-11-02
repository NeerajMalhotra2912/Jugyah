package com.selenium.org;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class BookVisitWithOutLoggingUser extends BaseClass {
    public static void main(String[] args) throws Exception {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            BookVisitWithOutLoggingUser baseClass = new BookVisitWithOutLoggingUser();
            baseClass.setup();
            baseClass.findNewHome();
            baseClass.selectProperty();
            baseClass.scheduleVisitViaDates();
            baseClass.selectTimeSlot();
//            baseClass.signUpForNewUser();
            baseClass.submitMobileNumberAndConfirm();
        }
        catch (Exception exception){
            System.out.println("Catch block exception : " + exception.getLocalizedMessage());
        }
        finally {
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("./WithoutLoginUserVisit.png"));
            driver.quit();
        }
    }
}
