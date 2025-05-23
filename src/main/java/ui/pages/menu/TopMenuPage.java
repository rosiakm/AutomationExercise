package ui.pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

public class TopMenuPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(TopMenuPage.class);

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    public TopMenuPage(WebDriver driver){
        super(driver);
    }

    public void openTopMenuOption(TopMenuButtons button){
        switch (button)
        {
            case PRODUCTS -> {
                productsButton.click();
                logger.info("Products page is opened");
            }
            case CART -> {
                cartButton.click();
                logger.info("Cart page is opened");
            }
        }
    }



}
