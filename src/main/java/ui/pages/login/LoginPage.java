package ui.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

public class LoginPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "form p[style='color: red;']")
    private WebElement warningMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void submitUserCredentials(AuthMode mode, String param, String email){
        switch (mode){
            case SIGNUP ->
                processAuthFlow(signupNameInput,param,"signup name field",
                                signupEmailInput,email, "signup email field",
                                signupButton, "Signup button");
            case LOGIN ->
                processAuthFlow(loginEmailInput,email,"login email field",
                                loginPasswordInput,param,"login password field",
                                loginButton,"Login button");
        }
    }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    private void processAuthFlow(WebElement firstInput, String firstValue, String firstLabel,
                                 WebElement secondInput, String secondValue, String secondLabel,
                                 WebElement button, String buttonLabel){

        firstInput.clear();
        firstInput.sendKeys(firstValue);
        logger.info(firstValue.concat(" has been sent to ".concat(firstLabel)));
        secondInput.clear();
        secondInput.sendKeys(secondValue);
        logger.info(secondValue.concat(" has been sent to ".concat(secondLabel)));
        button.click();
        logger.info(buttonLabel.concat(" is clicked!"));
    }
}
