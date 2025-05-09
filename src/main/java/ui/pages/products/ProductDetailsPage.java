package ui.pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import static ui.helpers.WaitHandler.waitForElementToBeClickable;

public class ProductDetailsPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(ProductDetailsPage.class);

    @FindBy(css = "#quantity")
    private WebElement quantityField;
    @FindBy(css = ".product-information button")
    private WebElement addToCartBtn;

    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    public void setQuantity(int quantity){
        waitForElementToBeClickable(driver,quantityField);
        quantityField.clear();
        logger.info("Quantity field has been cleared");
        quantityField.sendKeys(String.valueOf(quantity));
        logger.info("The quantity has been set as: {}", quantity);
    }

    public void addProductToCart(){
        addToCartBtn.click();
        logger.info("Add to cart button has been clicked!");
    }

    public String getProductPageUrl(){
        return driver.getCurrentUrl();
    }
}
