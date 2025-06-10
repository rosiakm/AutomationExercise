package ui.steps.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.helpers.ConfigLoader;
import ui.models.Address;
import ui.models.User;
import ui.pages.login.AccountInfoPage;
import ui.pages.login.AuthMode;
import ui.pages.login.LoginPage;
import ui.pages.login.RegistrationFormPage;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;
import ui.providers.AddressBuilder;
import ui.providers.UserBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    private final WebDriver driver;
    User newUser = UserBuilder.createUser();
    Address newAddress = AddressBuilder.createAddress();

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public LoginSteps openSignupLoginTab(){
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(TopMenuButtons.SIGNUP_LOGIN);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));
        return this;
    }

    @Step
    public LoginSteps selectSignupOption() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(AuthMode.SIGNUP, newUser.getName(), newUser.getEmail());
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("signupFormUrl"));
        return this;
    }

    @Step
    public LoginSteps fillInRegistrationFormAndCreateAccount() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.selectRandomTitle()
                .providePassword(newUser.getPassword())
                .selectDay()
                .selectMonth()
                .selectYear()
                .provideFirstName(newUser.getFirstName())
                .provideLastName(newUser.getLastName())
                .provideAddress(newAddress.getAddress())
                .selectCountry()
                .provideState(newAddress.getState())
                .provideCity(newAddress.getCity())
                .provideZipcode(newAddress.getZipcode())
                .provideMobileNumber(newUser.getMobileNumber());

        registrationFormPage.createAccount();
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("accountCreatedPage"));

        AccountInfoPage accountInfoPage = new AccountInfoPage(driver);
        accountInfoPage.submitAction();
        return this;
    }

    @Step
    public LoginSteps loginAsANewUser() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(TopMenuButtons.LOGOUT);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(AuthMode.LOGIN, newUser.getPassword(), newUser.getEmail());
        return this;
    }

    @Step
    public LoginSteps deleteCreatedAccount() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(TopMenuButtons.DELETE_ACCOUNT);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("deleteAccountPage"));

        AccountInfoPage accountInfoPage = new AccountInfoPage(driver);
        accountInfoPage.submitAction();
        return this;
    }

    @Step
    public void verifyAccountDeletion() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(TopMenuButtons.SIGNUP_LOGIN);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(AuthMode.LOGIN, newUser.getPassword(), newUser.getEmail());
        assertThat(loginPage.getWarningMessageText()).isEqualTo(ConfigLoader.get("warningMessage"));
    }
}
