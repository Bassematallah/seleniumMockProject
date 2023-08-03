package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessRegisterPage {
    WebDriver driver;
    private By registerResult = By.className("result");
    public SuccessRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResultText(){
        return driver.findElement(registerResult).getText();
    }

    public WebElement getRegisterResult(){
        return this.driver.findElement(registerResult);
    }
}
