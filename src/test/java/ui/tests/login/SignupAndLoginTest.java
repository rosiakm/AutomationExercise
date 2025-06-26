package ui.tests.login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.models.Address;
import ui.models.User;
import ui.pages.login.AuthMode;
import ui.pages.menu.TopMenuButtons;
import ui.providers.AddressBuilder;
import ui.providers.UserBuilder;
import ui.steps.login.LoginSteps;

public class SignupAndLoginTest extends BaseTest {

    @Test
    @DisplayName("Sign up and login test")
    @Tag("keyword")
    @Tag("Login")
    @Tag("Signup")
    public void signupAndLoginTest(){
        User newUser = UserBuilder.createUser();
        LoginSteps loginSteps = new LoginSteps(getDriver());

        loginSteps.openSignupLoginTab(TopMenuButtons.SIGNUP_LOGIN)
                .selectSignupOption(AuthMode.SIGNUP, newUser)
                .fillInRegistrationFormAndCreateAccount(newUser)
                .loginAsANewUser(AuthMode.LOGIN, newUser)
                .deleteCreatedAccount(TopMenuButtons.DELETE_ACCOUNT)
                .verifyAccountDeletion(TopMenuButtons.SIGNUP_LOGIN,AuthMode.LOGIN,newUser);
    }
}
