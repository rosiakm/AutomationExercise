package ui.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

public class AccountInfoPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(AccountInfoPage.class);

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountInfoPage(WebDriver driver){
        super(driver);
    }

    public void submitAction(){
        continueButton.click();
        logger.info("Continue button is clicked");
    }
}
