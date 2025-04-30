package UI.pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import UI.pages.base.BasePage;

public class ConsentModalPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ConsentModalPage.class);

    @FindBy(css = "button[aria-label='Consent'] .fc-button-label")
    private WebElement consentButton;

    public ConsentModalPage(WebDriver driver){
        super(driver);
    }

    public void acceptTheAds(){
        click(consentButton);
        logger.info("Consent modal window is closed");
    }
}
