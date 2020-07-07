package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

    public class Auto_Register {

        static WebDriver driver;

        public static void TypeText(By by, String text) {
            driver.findElement(by).sendKeys(text);
        }

        public static void clickOnElement(By by, int time) {
            driver.findElement(by).click();
        }

        public static long timestamp() {
            return (System.currentTimeMillis());
        }

        public static String getTextFromElement(By by) {
            return driver.findElement(by).getText();
        }

        public static void selectFromDropDownByVisibleText(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);
        }

        public static void selectFromDropDownByValue(By by, String n) {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(n);
        }

        public static void selectFromDropDownByindex(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);

        }

        public static void initialiseMethod() {
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://demo.nopcommerce.com/");}


        public void registration(){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            clickOnElement(By.linkText("Register"), 10);
            //clickOnElement(By.xpath("//input[@id=\"gender-female\"]"),40);
            //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            //TypeText(By.id("FirstName"),"Shreyarthi");
            //TypeText(By.id("FirstName"),"Shreyarthi");
            //TypeText(By.xpath("//input[@name=\"LastName\"]"),"Patel");

            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            //driver.findElement(By.id("FirstName")).sendKeys("shreyarthi");
            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            //driver.findElement(By.xpath(input[@name=\"LastName\"]"),"Patel");
            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            //selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"6");
            //selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"February");
            //selectFromDropDownByindex(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1912");
            //TypeText(By.name("Email"),"Shreyarthi+"+timestamp()+"test@gmail.com");
            //TypeText(By.id("Company"),"Utsavixyz");
            //TypeText(By.id("Password"),"123456");
            //TypeText(By.id("ConfirmPassword"),"123456");
            //clickOnElement(By.id("register-button"),20);
            //String expectedText = "Your registration completed";

            //String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
            // Assert.assertEquals(actualText,expectedText);

        }
    }

