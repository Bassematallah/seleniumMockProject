package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By loginButton = By.xpath("//input[@value='Log in']");
    private By validationLogin = By.className("validation-summary-errors");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "Email")
    private WebElement emailTextBox;

    public void setEmail(String email){
        setElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password){
        setElement(passwordInput).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        setElement(loginButton).click();
        return new HomePage(driver);
    }

    public String getLoginValidation(){
        return setElement(validationLogin).getText();
    }

    private WebElement setElement(By by){
        return driver.findElement(by);
    }
}
