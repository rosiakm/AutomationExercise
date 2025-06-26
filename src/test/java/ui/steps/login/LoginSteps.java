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

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    private final WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public LoginSteps openSignupLoginTab(TopMenuButtons tab){
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(tab);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));
        return this;
    }

    @Step
    public LoginSteps selectSignupOption(AuthMode mode, User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(mode, user.getName(), user.getEmail());
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("signupFormUrl"));
        return this;
    }

    @Step
    public LoginSteps fillInRegistrationFormAndCreateAccount(User user) {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.selectRandomTitle()
                .providePassword(user.getPassword())
                .selectDay()
                .selectMonth()
                .selectYear()
                .provideFirstName(user.getFirstName())
                .provideLastName(user.getLastName())
                .provideAddress(user.getAddress().getAddress())
                .selectCountry()
                .provideState(user.getAddress().getState())
                .provideCity(user.getAddress().getCity())
                .provideZipcode(user.getAddress().getZipcode())
                .provideMobileNumber(user.getMobileNumber())
                .createAccount();

        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("accountCreatedPage"));

        AccountInfoPage accountInfoPage = new AccountInfoPage(driver);
        accountInfoPage.submitAction();
        return this;
    }

    @Step
    public LoginSteps loginAsANewUser(AuthMode mode, User user) {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(TopMenuButtons.LOGOUT);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(mode, user.getPassword(), user.getEmail());
        return this;
    }

    @Step
    public LoginSteps deleteCreatedAccount(TopMenuButtons tab) {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(tab);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("deleteAccountPage"));

        AccountInfoPage accountInfoPage = new AccountInfoPage(driver);
        accountInfoPage.submitAction();
        return this;
    }

    @Step
    public void verifyAccountDeletion(TopMenuButtons tab, AuthMode mode, User user) {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(tab);
        assertThat(driver.getCurrentUrl()).isEqualTo(ConfigLoader.get("loginTabUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitUserCredentials(mode, user.getPassword(), user.getEmail());
        assertThat(loginPage.getWarningMessageText()).isEqualTo(ConfigLoader.get("warningMessage"));
    }
}
