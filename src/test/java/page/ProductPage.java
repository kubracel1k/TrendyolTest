package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    public WebDriver driver;
    public By addToCartButton = By.xpath("//div[@class='product-button-container']//button[@class='add-to-basket']//div[@class='add-to-basket-button-text']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}
