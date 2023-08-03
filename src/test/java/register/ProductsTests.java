package register;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class ProductsTests extends BaseTests {
    @Test(groups = "Smoke")
    public void test_product_added_successfully_to_cart_after_login(){
        String productCategory = "Books";
        String product = "Computing and Internet";

        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getInvalidPassword());
        var homePage = loginPage.clickLoginButton();

        var productsPage = homePage.clickProduct(productCategory);
        productsPage.addProductToCart(product);
        waitForVisibility(productsPage.getNotification());
        assertTrue(productsPage.getNotification().getText().contains("The product has been added to your"),
                "incorrect validation 1");
        assertTrue(productsPage.getNotification().getText().contains("shopping cart"),
                "incorrect validation 2");
    }

    @Test(groups = "Regression")
    public void test_Add_discount_code_AutomationDiscount2_and_verify_that_it_gives_20_percent_discount(){
        String productCategory = "Books";
        String product = "Computing and Internet";
        String discountCode = "AutomationDiscount2";

        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getValidPassword());
        var homePage = loginPage.clickLoginButton();

        var productsPage = homePage.clickProduct(productCategory);
        productsPage.addProductToCart(product);
        waitForVisibility(productsPage.getNotification());

        var checkoutPage = productsPage.goTo_shopping_cart();
        checkoutPage.setDiscountCode(discountCode);
        checkoutPage.clickApplyCoupon();

        var percentage = checkoutPage.calcDiscountPercentage();
        assertEquals(percentage , 20);
    }

}
