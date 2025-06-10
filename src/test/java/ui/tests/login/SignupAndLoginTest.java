package ui.tests.login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.steps.login.LoginSteps;

public class SignupAndLoginTest extends BaseTest {

    @Test
    @DisplayName("Sign up and login test")
    @Tag("keyword")
    @Tag("Login")
    @Tag("Signup")
    public void signupAndLoginTest(){
        LoginSteps loginSteps = new LoginSteps(getDriver());

        loginSteps.openSignupLoginTab()
                .selectSignupOption()
                .fillInRegistrationFormAndCreateAccount()
                .loginAsANewUser()
                .deleteCreatedAccount()
                .verifyAccountDeletion();
    }
}
