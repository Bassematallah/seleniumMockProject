package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    WebDriver driver;
    private By discountCodeInput = By.name("discountcouponcode");
    private By applyCouponButton = By.name("applydiscountcouponcode");

    private String discountXpath = "//td[@class='cart-total-left'][contains(.,'Discount')]/following-sibling::" +
            "td[@class='cart-total-right']/descendant::span[@class='product-price']";
    private String subTotalXpath = "//td[@class='cart-total-left'][contains(.,'Sub-Total')]/following-sibling::" +
            "td[@class='cart-total-right']/descendant::span[@class='product-price']";
    private By discountValue = By.xpath(discountXpath);
    private By subTotalValue = By.xpath(subTotalXpath);

    private By checkoutButton = By.id("checkout");

    private By termsOfServiceWarningBox = By.id("terms-of-service-warning-box");
    private By termsOfServiceCB = By.id("termsofservice");
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDiscountCode(String discountCode){
        driver.findElement(discountCodeInput).sendKeys(discountCode);
    }

    public void clickApplyCoupon(){
        driver.findElement(applyCouponButton).click();
    }

    private String getDiscountValue(){
        String positiveNumber[] = driver.findElement(discountValue).getText().split("-");
        return positiveNumber[1];
    }

    private String getSubTotalValue(){
        return driver.findElement(subTotalValue).getText();
    }

    public Double calcDiscountPercentage(){
        Double discount = Double.parseDouble(getDiscountValue());
        Double subTotal = Double.parseDouble(getSubTotalValue());
        return ((discount/subTotal)*100);
    }

    public CheckoutPage clickCheckout(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }

    public String getTermsOfServiceWarningText(){
        return driver.findElement(termsOfServiceWarningBox).getText();
    }

    public WebElement getTermsOfServiceWarningElement(){
        return driver.findElement(termsOfServiceWarningBox);
    }

    public void clickTermsOfServiceCB(){
        driver.findElement(termsOfServiceCB).click();
    }
}
