package register;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class RegisterTests extends BaseTests {
    @Test(groups = {"smoke"})
    public void test_Registering_Customer_With_A_Valid_Email(){
        var registerPage = landingPage.clickRegister();


        registerPage.selectGender_Male();
        registerPage.setFirstName(getFirstName());
        registerPage.setLastName(getLastName());
        registerPage.setEmail(getEmail());
        registerPage.setPassword(getPassword());
        registerPage.setPasswordConfirmation(getPassword());
        var successRegister=  registerPage.clickRegisterButton();
        waitForVisibility(successRegister.getRegisterResult());
        assertTrue(successRegister.getResultText().contains("Your registration completed") ,
                "verification message is incorrect");
    }

    @Test(groups = {"Regression"})
    public void test_Registering_An_Already_Existing_Customer(){
        var registerPage = landingPage.clickRegister();
        registerPage.selectGender_Male();
        registerPage.setFirstName(getFirstName());
        registerPage.setLastName(getLastName());
        registerPage.setEmail(getEmail());
        registerPage.setPassword(getPassword());
        registerPage.setPasswordConfirmation(getPassword());
        registerPage.clickRegisterButton();
        String validationMessage = registerPage.getRegisterValidation();
        assertTrue(validationMessage.contains("The specified email already exists") ,
                "incorrect Validation");

    }

    private String getFirstName(){
        return BaseTests.property.getProperty("firstNameToRegister");
    }

    private String getLastName(){
        return BaseTests.property.getProperty("lastNameToRegister");
    }

    private String getEmail(){
        return BaseTests.property.getProperty("emailToRegister");
    }

    private String getPassword(){
        return BaseTests.property.getProperty("passwordToRegister");
    }
}
