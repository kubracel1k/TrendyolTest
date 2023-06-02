package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;




    @FindBy(xpath = "//div[@class='i-bagg-orange hover-icon']")
    public WebElement cartIcon;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage() {
    }

    public void navigateTo(String url) {
        driver.get("https://www.trendyol.com");
    }

    public void navigateToCartPage() {
        cartIcon.click();
    }
}
