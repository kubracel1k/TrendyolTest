package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;


import java.util.ArrayList;
import java.util.List;

public class AddToCartTest extends BasePage {
    public WebDriver driver;
    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com");

    }

    @Test
    public void testAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement acceptButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptButton.click();
        Thread.sleep(2000);
        homePage.searchProduct("Elbise");
        JavascriptExecutor scr = (JavascriptExecutor) driver;
        scr.executeScript("window.scrollBy(0,250)");
        WebElement boslukTikla = driver.findElement(By.cssSelector("body"));
        boslukTikla.click();

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='p-card-chldrn-cntnr card-border']"));

        int counter = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (counter == 3) {
                break;
            }
            WebElement product = productList.get(i);
            String productUrl = product.findElement(By.cssSelector("a")).getAttribute("href");
            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.open()");
            Thread.sleep(1000);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            Thread.sleep(1000);
            driver.switchTo().window(tabs.get(1));
            driver.get(productUrl);
            ProductDetailPage productPage = new ProductDetailPage(driver);
            Thread.sleep(1000);
            WebElement bosluk = driver.findElement(By.cssSelector("body"));
            bosluk.click();
            productPage.addToCart();
            Thread.sleep(1000);
            driver.close(); // close product detail page
            driver.switchTo().window(tabs.get(0)); // switch back to home page
            counter++;
        }

        JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0,-250)");
        homePage.navigateToCartPage();
        int cartCount = cartPage.getCartCount();
        Assert.assertEquals(cartCount, 3, "Cart count is not as expected");
        driver.close();
    }
}



