package com.selenium.org;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BookVisitWithLoggingUser {

    public static WebDriver driver;
    Random random = new Random();
    int randomIntNum = random.nextInt(1000);
    int randomMobile = random.nextInt(100000000);

    String fName = "Ram" + randomIntNum;
    String lName = "kumar" + randomIntNum;
    String email =  fName + randomIntNum + lName + "@yopmail.com";
    String mobileNumber = "78"+randomMobile;

    public static void main(String[] args) throws Exception {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            BookVisitWithLoggingUser baseClass = new BookVisitWithLoggingUser();
            baseClass.setup();
            baseClass.doSignUpAndLogOut();
            baseClass.doLogin();
            baseClass.findNewHomeWithoutLogin();
            baseClass.selectProperty();
            baseClass.scheduleVisitViaDates();
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

    public void setup() throws InterruptedException{
        driver.get("https://dev.jugyah.com/");
        Thread.sleep(2000);
    }
    public void doSignUpAndLogOut() throws InterruptedException{
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Enter first name']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@placeholder='you@email.com']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Data entered is : ");
        System.out.println("First Name : "+fName +" Last Name : "+lName +" Mobile number : "+mobileNumber+" Email : "+email);
        Thread.sleep(2000);
//        enterOtpToConfirmVisit();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[3]/div[1]/p")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Log out']")).click();
        Thread.sleep(3000);
    }
    public void doLogin() throws InterruptedException{
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
//        enterOtpToConfirmVisit();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }
    public void enterOtp(){
        driver.findElement(By.xpath("//input[@id=':r2:']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id=':r3:']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id=':r4:']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id=':r5:']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@id=':r6:']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@id=':r7:']")).sendKeys("6");
    }

    public void findHome() throws InterruptedException{
        driver.findElement(By.xpath("//div[@id='react-select-2-placeholder']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//div[@id='react-select-2-placeholder']"));
        Select select = new Select(dropdown);
        select.selectByValue("Mumbai");
        Thread.sleep(3000);
        driver.quit();
    }

    public void findNewHomeWithoutLogin() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='react-select-2-placeholder']")).click();
        driver.findElement(By.xpath("//span[text()='Cities']/../../following-sibling::div//div[text()='Mumbai']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Select budget']")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[6]")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Select BHK']")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[5]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Search for properties']")).click();
        Thread.sleep(1000);
    }

    public void selectProperty() throws InterruptedException {
        Thread.sleep(1000);
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
            Thread.sleep(2000);
            if(driver.getCurrentUrl().equals("https://dev.jugyah.com/details?propertyId=64ad22783efd934d1d69fd61")){
                Thread.sleep(1000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400)", "");
                driver.findElement(By.xpath("//button[normalize-space()='Visit for free']")).click();
                Thread.sleep(2000);
            }
        }
    }

    public void scheduleVisitViaDates() throws InterruptedException{
        driver.findElement(By.xpath("//p[normalize-space()='04']")).click();
    }

    public void scheduleVisitViaCalender(){
        driver.findElement(By.xpath("//div[4]//button[1]//div[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='30']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
    }
    public void selectTimeSlot() throws InterruptedException{
        try {
//            driver.findElement(By.xpath("//p[normalize-space()='14:30 pm']")).click();
            driver.findElement(By.xpath("//p[normalize-space()='11:30 am']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Schedule Visit']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[normalize-space()='Confirm and schedule visit']")).click();
        }
        catch (Exception e){
            System.out.println("Exception occured while selecting time slot : " + e);
        }
    }
    public void submitMobileNumberAndConfirm() throws InterruptedException{
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys("7870261090");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        enterOtp();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.close();
    }

    public void enterOtpToConfirmVisit(){
        driver.findElement(By.xpath("//input[@id=':r0:']")).click();
        driver.findElement(By.xpath("//input[@id=':r0:']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id=':r1:']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id=':r2:']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id=':r3:']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@id=':r4:']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@id=':r5:']")).sendKeys("6");
    }
}
