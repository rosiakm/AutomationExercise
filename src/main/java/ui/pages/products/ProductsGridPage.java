package ui.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import java.util.List;

import static ui.helpers.ProductsHandler.filterProductByName;
import static ui.helpers.WaitHandler.waitForElementToBeClickable;
import static ui.helpers.WaitHandler.waitForElementToBeVisible;

public class ProductsGridPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductsGridPage.class);

    private final String cssToOpenProductDetailsBtn = ".choose a";
    private final String cssToProductNameLabel = ".productinfo p";
    private final String cssToAddToCartBtn = ".productinfo a";

    @FindBy(css = ".title")
    public WebElement productsGridLabel;
    @FindBy(css = ".product-image-wrapper")
    public List<WebElement> productItems;
    @FindBy(css = ".modal-header h4")
    private WebElement cartModalHeader;

    public ProductsGridPage(WebDriver driver){
        super(driver);
    }

    public String getProductsGridName(){
        return productsGridLabel.getText();
    }

    public void addProductToCartByName(String productName){
        WebElement productItem = filterProductByName(productName, productItems, cssToProductNameLabel);

        actions.scrollToElement(productItem.findElement(By.cssSelector(cssToOpenProductDetailsBtn))).perform();
        actions.scrollByAmount(0,250).perform();

        waitForElementToBeClickable(driver,productItem.findElement(By.cssSelector(cssToAddToCartBtn)));
        productItem.findElement(By.cssSelector(cssToAddToCartBtn)).click();
        logger.info("Add to cart button is clicked");
    }

    public void openProductDetailsPageByName(String productName){
        WebElement productItem = filterProductByName(productName, productItems, cssToProductNameLabel);

        actions.scrollToElement(productItem.findElement(By.cssSelector(cssToOpenProductDetailsBtn))).perform();
        actions.scrollByAmount(0,250).perform();

        waitForElementToBeClickable(driver,productItem.findElement(By.cssSelector(cssToAddToCartBtn)));
        productItem.findElement(By.cssSelector(cssToOpenProductDetailsBtn)).click();
        logger.info("View product button is clicked");
    }

    public String getCartModalHeaderConfirmationText(){
        waitForElementToBeVisible(driver, cartModalHeader);
        return cartModalHeader.getText();
    }
}
