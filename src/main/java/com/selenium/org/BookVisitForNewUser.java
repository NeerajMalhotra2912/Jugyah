package com.selenium.org;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
public class BookVisitForNewUser extends BaseClass {
    public static void main(String[] args) throws Exception {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            BookVisitForNewUser bookVisitForNewUser = new BookVisitForNewUser();
            bookVisitForNewUser.setup();
            bookVisitForNewUser.doSignUp();
            bookVisitForNewUser.findNewHome();
            bookVisitForNewUser.selectProperty();
            bookVisitForNewUser.scheduleVisitViaDates();
            bookVisitForNewUser.selectTimeSlot();
            bookVisitForNewUser.submitMobileNumberAndConfirm();
        }
        catch (Exception exception){
            System.out.println("Catch block exception : " + exception.getLocalizedMessage());
        }
        finally {
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("./NewUserVisit.png"));
            driver.quit();
        }
    }
}
