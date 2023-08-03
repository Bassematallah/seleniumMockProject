package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    private By buttonContinue = By.xpath("//div[@id='billing-buttons-container']/input[@title='Continue']");
    private By countryValidation = By.xpath("//span[@class='field-validation-error'][@data-valmsg-for='BillingNewAddress.CountryId']");
    private By cityValidation = By.xpath("//span[@class='field-validation-error'][@data-valmsg-for='BillingNewAddress.City']");
    private By address1Validation = By.xpath("//span[@class='field-validation-error'][@data-valmsg-for='BillingNewAddress.Address1']");
    private By zipCodeValidation = By.xpath("//span[@class='field-validation-error'][@data-valmsg-for='BillingNewAddress.ZipPostalCode']");
    private By phoneNumberValidation = By.xpath("//span[@class='field-validation-error'][@data-valmsg-for='BillingNewAddress.PhoneNumber']");
    public CheckoutPage(WebDriver driver) {
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(buttonContinue).click();
    }

    public String getCountryValidationText(){
        return driver.findElement(countryValidation).getText();
    }

    public String getCityValidationText(){
        return driver.findElement(cityValidation).getText();
    }

    public String getAddress1ValidationText(){
        return driver.findElement(address1Validation).getText();
    }

    public String getZipCodeValidationText(){
       return driver.findElement(zipCodeValidation).getText();
    }

    public String getPhoneNumberValidationText(){
        return driver.findElement(phoneNumberValidation).getText();
    }
}
