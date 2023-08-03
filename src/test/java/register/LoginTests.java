package register;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class LoginTests extends BaseTests {
    @Test(groups = {"Smoke"})
    public void test_logging_in_with_a_valid_username_and_a_valid_password(){
        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getValidPassword());
        var homePage = loginPage.clickLoginButton();
        String accountInHeader = homePage.getLoggedInAccount();
        assertTrue(accountInHeader.contains(getValidMail()));


    }

    @Test(groups = {"Regression"})
    public void test_logging_in_with_a_valid_username_and_an_invalid_password(){
        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getInvalidPassword());
        loginPage.clickLoginButton();

        String validationLogin = loginPage.getLoginValidation();
        assertTrue(validationLogin.contains("Login was unsuccessful. Please correct the errors and try again.") ,
                "validation 1 is Incorrect");
        assertTrue(validationLogin.contains("The credentials provided are incorrect") ,
                "validation 2 is Incorrect");

    }

    @Test(groups = {"Regression"})
    public void test_logging_in_with_an_invalid_username(){
        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getInvalidUser());
        loginPage.setPassword(getInvalidPassword());
        loginPage.clickLoginButton();

        String validationLogin = loginPage.getLoginValidation();
        assertTrue(validationLogin.contains("Login was unsuccessful. Please correct the errors and try again.") ,
                "validation 1 is Incorrect");
        assertTrue(validationLogin.contains("The credentials provided are incorrect") ,
                "validation 2 is Incorrect");

    }

}
