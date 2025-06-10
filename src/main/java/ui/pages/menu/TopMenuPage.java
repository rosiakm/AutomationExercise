package ui.pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import static ui.helpers.WaitHandler.waitForElementToBeClickable;

public class TopMenuPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(TopMenuPage.class);

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(css = "a[href='/login']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    public TopMenuPage(WebDriver driver){
        super(driver);
    }

    public void openTopMenuOption(TopMenuButtons button){
        switch (button)
        {
            case PRODUCTS -> {
                waitForElementToBeClickable(driver,productsButton);
                productsButton.click();
                logger.info("Products page is opened");
            }
            case CART -> {
                waitForElementToBeClickable(driver,cartButton);
                cartButton.click();
                logger.info("Cart page is opened");
            }
            case SIGNUP_LOGIN -> {
                waitForElementToBeClickable(driver,loginButton);
                loginButton.click();
                logger.info("Signup/Login page is opened ");
            }
            case LOGOUT -> {
                waitForElementToBeClickable(driver,logoutButton);
                logoutButton.click();
                logger.info("User is logout");
            }
            case DELETE_ACCOUNT -> {
                waitForElementToBeClickable(driver,deleteAccountButton);
                deleteAccountButton.click();
                logger.info("Delete account page is opened");
            }
        }
    }



}
