package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;
    private By barNotificationSuccess = By.className("bar-notification");
    private By shoppingCartInHeader = By.className("ico-cart");



    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addProductToCart(String productName){
        String xp = "//h2[contains(.,'" + productName + "')]/parent::div/descendant::input[@value='Add to cart']";
        driver.findElement(By.xpath(xp)).click();
    }

    public ShoppingCartPage goTo_shopping_cart(){
        driver.findElement(shoppingCartInHeader).click();
        return new ShoppingCartPage(driver);
    }


    public WebElement getNotification(){
        return driver.findElement(barNotificationSuccess);
    }
}
