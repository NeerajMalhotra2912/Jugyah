package com.selenium.org;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {
    public static WebDriver driver ;

    @Test
    public void testSignUpUser() throws InterruptedException {
        BookVisitForNewUser bookVisitForNewUser = new BookVisitForNewUser();
        bookVisitForNewUser.setup();
        bookVisitForNewUser.doSignUp();
        bookVisitForNewUser.findNewHomeWithoutLogin();
        bookVisitForNewUser.selectProperty();
        bookVisitForNewUser.scheduleVisitViaDates();
        bookVisitForNewUser.selectTimeSlot();
        bookVisitForNewUser.submitMobileNumberAndConfirm();
    }

    @Test
    public void testWithoutLogInUser() throws InterruptedException {
        BookVisitWithOutLoggingUser baseClass = new BookVisitWithOutLoggingUser();
        baseClass.setup();
        baseClass.findNewHomeWithoutLogin();
        baseClass.selectProperty();
        baseClass.scheduleVisitViaDates();
        baseClass.selectTimeSlot();
        baseClass.submitMobileNumberAndConfirm();
    }

    @Test
    public void testAlreadyLoggedInUser() throws InterruptedException {
        BookVisitWithLoggingUser bookVisitWithLoggingUser = new BookVisitWithLoggingUser();
        bookVisitWithLoggingUser.setup();
        bookVisitWithLoggingUser.doLogin();
        bookVisitWithLoggingUser.findNewHomeWithoutLogin();
        bookVisitWithLoggingUser.selectProperty();
        bookVisitWithLoggingUser.scheduleVisitViaDates();
        bookVisitWithLoggingUser.selectTimeSlot();
        bookVisitWithLoggingUser.submitMobileNumberAndConfirm();
    }

}
