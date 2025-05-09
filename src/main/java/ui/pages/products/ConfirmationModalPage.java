package ui.pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import static ui.helpers.WaitHandler.waitForElementToBeVisible;

public class ConfirmationModalPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ConfirmationModalPage.class);

    @FindBy(css = ".btn-success")
    private WebElement continueShoppingBtn;

    public ConfirmationModalPage(WebDriver driver){
        super(driver);
    }

    public void continueShopping(WebDriver driver){
        waitForElementToBeVisible(driver, continueShoppingBtn);
        continueShoppingBtn.click();
        logger.info("Continue shopping button is clicked");
    }
}
