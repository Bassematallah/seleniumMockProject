package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
    private WebDriver driver;
    private By logoutButton = By.linkText("Log out");
    private By accountInHeader = By.className("account");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void clickLogout(){
        setElement(logoutButton).click();
    }

    public ProductsPage clickProduct(String productName){
        driver.findElement(By.linkText(productName)).click();
        return new ProductsPage(driver);
    }

    public WebElement logoutElement(){
        return setElement(logoutButton);
    }

    public String getLoggedInAccount(){
        return setElement(accountInHeader).getText();
    }

    private WebElement setElement(By by){
        return driver.findElement(by);
    }
}
