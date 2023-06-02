package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    public WebDriver driver;
    public By cartCount = By.xpath("//div[@class='basket-item-count-container visible']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartCount() {
        String count = driver.findElement(cartCount).getText();
        return Integer.parseInt(count);
    }


}
