package com.selenium.org;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BookVisitWithLoggingUser extends BaseClass {
    public static void main(String[] args) throws Exception {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            BookVisitWithLoggingUser baseClass = new BookVisitWithLoggingUser();
            baseClass.setup();
            baseClass.doSignUpAndLogOut();
            baseClass.doLogin();
            baseClass.findNewHome();
            baseClass.selectProperty();
            baseClass.scheduleVisitViaCalender();
            baseClass.selectTimeSlot();
            baseClass.submitMobileNumberAndConfirm();
        }
        catch (Exception exception){
            System.out.println("Catch block exception : " + exception.getLocalizedMessage());
        }
        finally {
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("./LoggedInUserVisit.png"));
            driver.quit();
        }
    }
}
