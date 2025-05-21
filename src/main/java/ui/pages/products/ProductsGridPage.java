package ui.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static ui.helpers.ProductsHandler.filterWebElementByName;
import static ui.helpers.WaitHandler.waitForElementToBeClickable;
import static ui.helpers.WaitHandler.waitForElementToBeVisible;

public class ProductsGridPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductsGridPage.class);

    private final String PRODUCT_DETAILS_BTN_CSS = ".choose a";
    private final String PRODUCT_NAME_LABEL_CSS = ".productinfo p";
    private final String ADD_TO_CART_BTN_CSS = ".productinfo a";

    @FindBy(css = ".title")
    public WebElement productsGridLabel;
    @FindBy(css = ".product-image-wrapper")
    public List<WebElement> productItems;
    @FindBy(css = ".modal-header h4")
    private WebElement cartModalHeader;
    @FindBy(css = "#search_product")
    private WebElement searchInput;
    @FindBy(css = "#submit_search")
    private WebElement searchButton;
    @FindBy(css = ".productinfo p")
    private List<WebElement> productNameLabels;

    public ProductsGridPage(WebDriver driver){
        super(driver);
    }

    public String getProductsGridName(){
        return productsGridLabel.getText();
    }

    public void addProductToCartByName(String productName){
        WebElement productItem = filterWebElementByName(productName, productItems, PRODUCT_NAME_LABEL_CSS);

        actions.scrollToElement(productItem.findElement(By.cssSelector(PRODUCT_DETAILS_BTN_CSS))).perform();
        actions.scrollByAmount(0,250).perform();

        waitForElementToBeClickable(driver,productItem.findElement(By.cssSelector(ADD_TO_CART_BTN_CSS)));
        productItem.findElement(By.cssSelector(ADD_TO_CART_BTN_CSS)).click();
        logger.info("Add to cart button is clicked");
    }

    public void openProductDetailsPageByName(String productName){
        WebElement productItem = filterWebElementByName(productName, productItems, PRODUCT_NAME_LABEL_CSS);

        actions.scrollToElement(productItem.findElement(By.cssSelector(PRODUCT_DETAILS_BTN_CSS))).perform();
        actions.scrollByAmount(0,250).perform();

        waitForElementToBeClickable(driver,productItem.findElement(By.cssSelector(ADD_TO_CART_BTN_CSS)));
        productItem.findElement(By.cssSelector(PRODUCT_DETAILS_BTN_CSS)).click();
        logger.info("View product button is clicked");
    }

    public String getCartModalHeaderConfirmationText(){
        waitForElementToBeVisible(driver, cartModalHeader);
        return cartModalHeader.getText();
    }

    public void searchProductName(String phrase){
        searchInput.clear();
        searchInput.sendKeys(phrase);
        logger.info("The phrase: ".concat(phrase).concat(" has been entered"));
        searchButton.click();
        logger.info("The search button has been clicked");
    }

    public List<String> getSearchedProductNames(){
        return productNameLabels.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
