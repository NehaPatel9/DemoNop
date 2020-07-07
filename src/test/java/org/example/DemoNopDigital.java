package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.util.concurrent.TimeUnit;

public class DemoNopDigital {

    static WebDriver driver;

    public static void TypeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    public static long timestamp() {
        return (System.currentTimeMillis());
    }

    public static String getTextfromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void selectFromDropDownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectFromDropDownByindex(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectFromDropDownByVisibleText(By by, String n) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(n);
    }
    @BeforeMethod
    public static void Initialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\SOFT\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test (priority = 1)
    public static void Registration() {

        clickElement(By.linkText("Register"));
        TypeText(By.xpath("//input[@id=\"FirstName\"]"), "Neha");
        TypeText(By.xpath("//input[@id=\"LastName\"]"), "Patel");
        selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "3");
        selectFromDropDownByindex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "January");
        selectFromDropDownByindex(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1912");
        //selectFromDropDownByVisibleText(By.xpath("//select[@name=\"//DateOfBirthYear\"]"), "1912");
        TypeText(By.name("Email"), "neha+" + timestamp() + "@gmail.com");
        TypeText(By.id("Company"), "ABC LTD");
        clickElement(By.xpath("//input[@id=\"Newsletter\"]"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        TypeText(By.xpath("//input[@name=\"Password\"]"), "My@password");
        TypeText(By.xpath("//input[@name=\"ConfirmPassword\"]"), "My@password");
        clickElement(By.name("register-button"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //String expectedText = "Your registration completed";
        // String actulText = getTextfromElement(By.linkText("Your registration completed"));
        //Assert.assertEquals(actulText,expectedText);
        String expectedText = "Your registration completed";
        String actualText = getTextfromElement(By.xpath("//div[@class=\"result\"]"));
        //String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualText, expectedText);
        if (actualText.contentEquals(expectedText)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
}
    @Test (priority = 2)
    public static void Computer() {
        Registration();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        clickElement(By.linkText("Computers"));
        clickElement(By.linkText("Desktops"));
        clickElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //clickElement(By.xpath("input[@value=\"Email a friend\"]"));
        clickElement(By.xpath("//input[@value=\"Email a friend\"]"));
        TypeText(By.xpath("//input[@id=\"FriendEmail\"]"), "kirebak309@go4mail.net");
        //TypeText(By.xpath("//input[@id=\"YourEmailAddress\"]"),"nehajp999+"+timestamp()+"@gmail.com");
        TypeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "You are being invited ");
        clickElement(By.xpath("//input[@name=\"send-email\"]"));
        String expectedText1 = "Your message has been sent.";
        String actualText1 = getTextfromElement(By.xpath("//div[@class=\"result\"]"));
        //String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualText1, expectedText1);
        if (actualText1.contentEquals(expectedText1)) {
            System.out.println(actualText1);
        } else {
            System.out.println(expectedText1);
        }
}
        @Test (priority = 3)
        public static void AddtoCart() {
            clickElement(By.linkText("Computers"));
            clickElement(By.linkText("Desktops"));
            clickElement(By.xpath("// div[@class='product-item']//div[2]//div[2]//input[@class=\"button-2 product-box-add-to-cart-button\"]"));
            clickElement(By.xpath("//input[@id=\"product_attribute_3_6\"]"));
            clickElement(By.xpath("//input[@id=\"add-to-cart-button-1\"]"));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clickElement(By.linkText("Books"));
            clickElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
            clickElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]"));
            clickElement(By.linkText("Shopping cart"));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            String expectedText1 = "Build your own computer";
            String actualText1 = getTextfromElement(By.linkText("Build your own computer"));
            //String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
            Assert.assertEquals(actualText1, expectedText1);
            if (actualText1.contentEquals(expectedText1)) {
                System.out.println(actualText1);
            } else {
                System.out.println(expectedText1);
            }
            String expectedText = "Fahrenheit 451 by Ray Bradbury";
            String actualText = getTextfromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
            Assert.assertEquals(actualText, expectedText);
            if (actualText.contentEquals(expectedText)) {
                System.out.println(actualText);
            } else {
                System.out.println(expectedText);
        }
    }
}