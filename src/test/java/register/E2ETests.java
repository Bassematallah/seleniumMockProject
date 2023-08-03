package register;
import base.BaseTests;
import org.testng.annotations.Test;

public class E2ETests extends BaseTests {
    @Test
    public void E2E_Scenario(){
        var loginPage = landingPage.clickLogin();
        loginPage.setEmail(getValidMail());
        loginPage.setPassword(getValidPassword());
        var homePage = loginPage.clickLoginButton();


    }
}
