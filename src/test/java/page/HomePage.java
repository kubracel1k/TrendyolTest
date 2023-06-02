package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public WebDriver driver;
    public By searchBox = By.className("V8wbcUhU");
    public By searchButton = By.className("cyrzo7gC");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = "link-text")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement emailKutusu;

    @FindBy(id="login-password-input")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement loginButonu;

    @FindBy(linkText = "Favorilerim")
    public WebElement basariliGirisElementi;
    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void navigateToCartPage() {
        WebElement cartIcon = driver.findElement(By.xpath("//div[@class='icon-container']"));
        cartIcon.click();
    }



}

