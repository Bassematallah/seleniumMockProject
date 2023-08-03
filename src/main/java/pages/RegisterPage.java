package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");
    private By emailInput = By.name("Email");
    private By passwordInput = By.id("Password");
    private By confirmPasswordInput = By.id("ConfirmPassword");
    private By buttonRegister = By.id("register-button");
    private By validationRegister = By.className("validation-summary-errors");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGender_Male(){
        setElement(genderMale).click();
    }

    public void selectGender_Female(){
        setElement(genderFemale).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setEmail(String email){
        setElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password){
        setElement(passwordInput).sendKeys(password);
    }

    public void setPasswordConfirmation(String confirmedPassword){
        setElement(confirmPasswordInput).sendKeys(confirmedPassword);
    }
    public SuccessRegisterPage clickRegisterButton(){
        setElement(buttonRegister).click();
        return new SuccessRegisterPage(driver);
    }

    public String getRegisterValidation(){
        return setElement(validationRegister).getText();
    }
    private WebElement setElement(By by){
        return driver.findElement(by);
    }
}
