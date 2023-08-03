package register;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CheckoutTests extends BaseTests {
    @Test(groups = "Regression")
    public void test_terms_of_service_are_mandatory(){
        String productCategory = "Books";
        String product = "Computing and Internet";

        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getValidPassword());
        var homePage = loginPage.clickLoginButton();

        var productsPage = homePage.clickProduct(productCategory);
        productsPage.addProductToCart(product);
        waitForVisibility(productsPage.getNotification());

        var checkoutPage = productsPage.goTo_shopping_cart();
        checkoutPage.clickCheckout();
        assertTrue(checkoutPage.getTermsOfServiceWarningElement().isDisplayed(), "Element is not Displayed");
    }

    @Test(groups = "Regression")
    public void test_verify_the_mandatory_fields_in_the_billing_address(){
        String productCategory = "Books";
        String product = "Computing and Internet";

        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getValidPassword());
        var homePage = loginPage.clickLoginButton();

        var productsPage = homePage.clickProduct(productCategory);
        productsPage.addProductToCart(product);
        waitForVisibility(productsPage.getNotification());

        var shippingCartPage = productsPage.goTo_shopping_cart();
        shippingCartPage.clickTermsOfServiceCB();
        var checkOutPage =  shippingCartPage.clickCheckout();

        //click on continue
        checkOutPage.clickContinue();

        //Address validations
        String countryValidation = checkOutPage.getCountryValidationText();
        String cityValidation = checkOutPage.getCityValidationText();
        String address1Validation = checkOutPage.getAddress1ValidationText();
        String zipCodeValidation = checkOutPage.getZipCodeValidationText();
        String phoneNumberValidation = checkOutPage.getPhoneNumberValidationText();

        assertEquals(countryValidation , "Country is required.");
        assertEquals(cityValidation , "City is required");
        assertEquals(address1Validation , "Street address is required");
        assertEquals(zipCodeValidation , "Zip / postal code is required");
        assertEquals(phoneNumberValidation , "Phone is required");
    }


}
