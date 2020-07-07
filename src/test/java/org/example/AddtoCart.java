package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.xml.namespace.QName;
import java.util.concurrent.TimeUnit;
import javax.xml.namespace.QName;
import java.util.concurrent.TimeUnit;


public class AddtoCart {

        static WebDriver driver;
        @Test
        void DemoNop() {
            System.setProperty("webdriver.chrome.driver", "C:\\SOFT\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("https://demo.nopcommerce.com/");
            driver.findElement(By.xpath("//a[text()='Computers ']")).click();
            //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,250)");
            driver.findElement(By.xpath("//div[@class=\"item-box\"]//div[@class=\"sub-category-item\"]//div//a[@title='Show products in category Desktops']")).click();
            driver.findElement(By.linkText("Desktops")).click();
            driver.findElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//input[@id='add-to-cart-button-2']")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //driver.findElement(By.xpath("span[@class=\"cart-label\"]")).click();
            driver.findElement(By.linkText("Shopping cart")).click();
            jse.executeScript("window.scrollBy(0,250)");
            driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]")).click();
            driver.findElement(By.linkText("Electronics")).click();
            driver.findElement(By.xpath("//a[@title=\"Show products in category Cell phones\"]")).click();
            driver.findElement(By.linkText("HTC One Mini Blue")).click();
            driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-19\"]")).click();
            driver.findElement(By.linkText("Shopping cart")).click();
            String pageText = driver.findElement(By.linkText("HTC One Mini Blue")).getText();
            System.out.println(pageText);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            String pageText2 = driver.findElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC")).getText();
            System.out.println(pageText2);
            String expectedText = "Register";
            String actulText = driver.findElement(By.className("ico-register")).getText();
    }

}
