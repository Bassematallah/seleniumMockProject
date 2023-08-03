package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LandingPage {
    private WebDriver driver;
    private By registerButton = By.className("ico-register");
    private By loginButton = By.className("ico-login");
    private By accountInHeader = By.className("account");
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickRegister(){
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickLogin(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }



    private WebElement setElement(By by){
        return driver.findElement(by);
    }
}
