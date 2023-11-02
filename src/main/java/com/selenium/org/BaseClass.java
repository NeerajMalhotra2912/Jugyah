package com.selenium.org;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BaseClass {

    public static WebDriver driver;
    Random random = new Random();
    int randomIntNum = random.nextInt(1000);
    int randomMobile = random.nextInt(100000000);

    String fName = "Ram" + randomIntNum;
    String lName = "kumar" + randomIntNum;
    String email =  fName + randomIntNum + lName + "@yopmail.com";
    String mobileNumber = "78"+randomMobile;

    public void setup() throws InterruptedException{
        driver.get("https://dev.jugyah.com/");
        Thread.sleep(2000);
        System.out.println("Welcome to Jugyah.com");
    }
    public void doSignUp() throws InterruptedException{
        Random random = new Random();
        int randomIntNum = random.nextInt(1000);
        int randomMobile = random.nextInt(100000000);

        String fName = "Ram" + randomIntNum;
        String lName = "kumar" + randomIntNum;
        String email =  fName + randomIntNum + lName + "@yopmail.com";
        String mobileNumber = "78"+randomMobile;

        System.out.println("Sign Up started");
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter first name']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@placeholder='you@email.com']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Data entered is : ");
        System.out.println("First Name : "+fName +" Last Name : "+lName +" Mobile number : "+mobileNumber+" Email : "+email);
        Thread.sleep(3000);
//        enterOtpToConfirmVisit();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        System.out.println("Sign Up completed successfully");
    }
    public void findNewHome() throws InterruptedException {
        System.out.println("Search home begins");
        driver.findElement(By.xpath("//div[@id='react-select-2-placeholder']")).click();
        driver.findElement(By.xpath("//span[text()='Cities']/../../following-sibling::div//div[text()='Mumbai']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Select budget']")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[6]")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Select BHK']")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[5]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Search for properties']")).click();
        Thread.sleep(2000);
        System.out.println("Clicked on search for properties");
    }
    public void selectProperty() throws InterruptedException {
        System.out.println("Selecting the desired property");
        Thread.sleep(2000);
        String homePageUrl = driver.getCurrentUrl();
        String homePageTitle = driver.getTitle();
        String homePageWindowHandle = driver.getWindowHandle();
        System.out.println("PageUrl : " + homePageUrl + " PageTitle : "+ homePageTitle + " Window handle :" +homePageWindowHandle);
        driver.findElement(By.xpath("//div[contains(@class,'MuiBox-root css-n9rvzs')]//div[2]//button[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//img[1]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()){
            String windowNew = itr.next();
            driver.switchTo().window(windowNew);
            Thread.sleep(3000);
            if(driver.getCurrentUrl().equals("https://dev.jugyah.com/details?propertyId=64ad22783efd934d1d69fd61")){
                Thread.sleep(2000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400)", "");
                driver.findElement(By.xpath("//button[normalize-space()='Visit for free']")).click();
                Thread.sleep(2000);
            }
        }
        System.out.println("Selected the property");
    }

    public void scheduleVisitViaDates() throws InterruptedException{
        driver.findElement(By.xpath("//p[normalize-space()='05']")).click();
        System.out.println("Date selected successfully");
    }

    public void scheduleVisitViaCalender(){
        driver.findElement(By.xpath("//div[4]//button[1]//div[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='7']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        System.out.println("Calender date selected successfully");
    }
    public void selectTimeSlot() throws InterruptedException{
        driver.findElement(By.xpath("//p[normalize-space()='13:30 pm']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Schedule Visit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Confirm and schedule visit']")).click();
        Thread.sleep(1000);
        System.out.println("Time slot booked successfully");
    }
    public void submitMobileNumberAndConfirm() throws InterruptedException{
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys("7816708077");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        enterOtp();
//        enterOtpToConfirmVisit();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.close();
        System.out.println("Visit booked successfully");
    }

    public void enterOtpToConfirmVisit(){
        driver.findElement(By.xpath("//input[@id=':r0:']")).click();
        driver.findElement(By.xpath("//input[@id=':r0:']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id=':r1:']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id=':r2:']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id=':r3:']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@id=':r4:']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@id=':r5:']")).sendKeys("6");
        System.out.println("Otp enterd successfully");
    }
    public void signUpForNewUser() throws InterruptedException{
        Random random = new Random();
        int randomIntNum = random.nextInt(1000);
        int randomMobile = random.nextInt(100000000);

        String fName = "Ram" + randomIntNum;
        String lName = "kumar" + randomIntNum;
        String email =  fName + randomIntNum + lName + "@yopmail.com";
        String mobileNumber = "78"+randomMobile;

        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter first name']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@placeholder='you@email.com']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Data entered is : ");
        System.out.println("First Name : "+fName +" Last Name : "+lName +" Mobile number : "+mobileNumber+" Email : "+email);
        Thread.sleep(2000);
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        System.out.println("Sign up completed");
    }
    public void enterOtp() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=':r2:']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id=':r3:']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id=':r4:']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id=':r5:']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@id=':r6:']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@id=':r7:']")).sendKeys("6");
        System.out.println("Otp entered successfully");
    }
    public void doSignUpAndLogOut() throws InterruptedException{
        System.out.println("Sign up started");
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter first name']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@placeholder='you@email.com']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Data entered is : ");
        System.out.println("First Name : "+fName +" Last Name : "+lName +" Mobile number : "+mobileNumber+" Email : "+email);
        Thread.sleep(3000);
//        enterOtpToConfirmVisit();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        System.out.println("Sign up completed successfully");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[3]/div[1]/p")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Log out']")).click();
        Thread.sleep(3000);
        System.out.println("Logged out successfully");
    }
    public void doLogin() throws InterruptedException{
        System.out.println("Login started");
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
//        enterOtpToConfirmVisit();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        System.out.println("Logged in successfully");
    }
}
