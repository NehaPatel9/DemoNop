package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DemoNopDigital {

    static WebDriver driver;

    public static void TypeText(By by, String text, int time) {
        driver.findElement(by).sendKeys(text);//Method for finding an element and Typing text into it.
    }
    public static void clickElement(By by) {
        driver.findElement(by).click(); //Method for finding an element and click on it.
    }
    public static long timestamp() {
        return (System.currentTimeMillis()); //Method to enter a live timestamp.
    }
    public static String getTextfromElement(By by) {
        return driver.findElement(by).getText(); // Method to find element and get text from that element.
    }

    public static void selectFromDropDownByValue(By by, String text, int time ) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text); // Method to find element and select a Value from dropdown Menu.
    }

    public static void selectFromDropDownByindex(By by, String text, int time) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text); // Method to find element and select an Index from dropdown Menu.
    }

    public static void selectFromDropDownByVisibleText(By by, String n, int time) {
        Select select = new Select(driver.findElement(by)); // Method to find element and select a VisibleText from dropdown Menu
        select.selectByVisibleText(n);
    }
    @BeforeMethod // This method is avoid to write repetitive steps before every test case
    public static void Initialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\SOFT\\chromedriver.exe");// path to chrome driver
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);// allows to avoid chrome pop ups while running programme
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});//Chrome is being controlled by automated test software notification that
        driver = new ChromeDriver(options);//open chrome driver
        driver.manage().window().maximize();// Maximize the screen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //implicitlyWait
        driver.get("https://demo.nopcommerce.com/");// opens demo nop commerce URL
    }
    @Test (priority = 1)
    public static void Registration() { // Method to fill registration Forms

        clickElement(By.linkText("Register"));
        TypeText(By.xpath("//input[@id=\"FirstName\"]"), "Neha",20);
        TypeText(By.xpath("//input[@id=\"LastName\"]"), "Patel", 20);
        selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "3", 20);
        selectFromDropDownByindex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "January", 20);
        selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1912", 20);
        TypeText(By.name("Email"), "neha+" + timestamp() + "@gmail.com", 20);
        TypeText(By.id("Company"), "ABC LTD", 20);
        clickElement(By.xpath("//input[@id=\"Newsletter\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TypeText(By.xpath("//input[@name=\"Password\"]"), "My@password",20);
        TypeText(By.xpath("//input[@name=\"ConfirmPassword\"]"), "My@password", 20);
        clickElement(By.name("register-button"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedText = "Your registration completed";
        String actualText = getTextfromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualText, expectedText); // Assert to compare Actual Result with Expected Result
        if (actualText.contentEquals(expectedText)) { // Print result of Test
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
}
    @Test (priority = 2)
    public static void emailaFriend() {
        // Since to email a friend Registration to account is pre requisite Registration method is called
        Registration();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        clickElement(By.linkText("Computers"));
        clickElement(By.linkText("Desktops"));
        clickElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        clickElement(By.xpath("//input[@value=\"Email a friend\"]"));
        TypeText(By.xpath("//input[@id=\"FriendEmail\"]"), "kirebak309@go4mail.net", 20);
        TypeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "You are being invited ", 20);
        clickElement(By.xpath("//input[@name=\"send-email\"]"));

        String expectedText1 = "Your message has been sent.";
        String actualText1 = getTextfromElement(By.xpath("//div[@class=\"result\"]"));

        Assert.assertEquals(actualText1, expectedText1); // Assert to compare Actual Result with Expected Result
        if (actualText1.contentEquals(expectedText1)) {
            System.out.println(actualText1); // Print the result
        } else {
            System.out.println(expectedText1);
        }
}
        @Test (priority = 3)
        public static void AddtoCart() {
            clickElement(By.linkText("Computers")); // Click on Computers
            clickElement(By.linkText("Desktops")); // Click on Desktops

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clickElement(By.linkText("Books")); // Click on Books
            clickElement(By.linkText("Pride and Prejudice")); // Click on First Product to add to cart
            clickElement(By.xpath("//input[@id=\"add-to-cart-button-39\"]"));// click on add to cart

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            clickElement(By.linkText("Books")); // Go again on books category
            clickElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));//click on second product to add to cart
            clickElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]")); //click on second product on add to cart
            clickElement(By.linkText("Shopping cart"));// Go to shopping cart

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            String expectedText1 = "Pride and Prejudice";
            String actualText1 = getTextfromElement(By.linkText("Pride and Prejudice"));
            Assert.assertEquals(actualText1, expectedText1); // Assert to compare Actual Result with Expected Result

            if (actualText1.contentEquals(expectedText1)) {
                System.out.println(actualText1);
            } else {
                System.out.println("There is an Error");
            }
            String expectedText = "Fahrenheit 451 by Ray Bradbury";
            String actualText = getTextfromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
            Assert.assertEquals(actualText, expectedText);

            if (actualText.contentEquals(expectedText)) {
                System.out.println(actualText);
            } else {
                System.out.println("There is an Error"); }
        }
            @AfterMethod // Method to close browser
            public static void closeBrowser(){
            driver.close();
   }
}