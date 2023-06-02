package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
// instance variables
    public WebDriver driver;

    @FindBy(xpath = "//div[@class='product-button-container']//button[@class='add-to-basket']//div[@class='add-to-basket-button-text']")
    public WebElement addToCartButton;

    // constructor
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // add to cart function
    public void addToCart() {
        addToCartButton.click();
    }
}
