package UI.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import UI.pages.base.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

import static UI.helpers.WaitHandler.waitForElementToBeClickable;
import static UI.helpers.WaitHandler.waitForElementToBeVisible;

public class ProductsGridPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductsGridPage.class);

    @FindBy(css = ".title")
    public WebElement productsGridLabel;
    @FindBy(css = ".product-image-wrapper")
    public List<WebElement> productItems;
    @FindBy(css = ".btn-success")
    private WebElement continueShoppingBtn;

    public ProductsGridPage(WebDriver driver){
        super(driver);
    }

    public String getProductsGridName(){
        return getTextFromWebElement(productsGridLabel);
    }

    public void addProductToCartByName(String productName){
        WebElement productItem = productItems.stream().filter(item ->
                item.findElement(By.cssSelector(".productinfo p")).getText().equals(productName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        logger.info("Product with name: {} is found!", productItem.findElement(By.cssSelector(".productinfo p")).getText());

        actions.scrollToElement(productItem.findElement(By.cssSelector(".choose a"))).perform();
        actions.scrollByAmount(0,100).perform();

        waitForElementToBeClickable(driver,productItem.findElement(By.cssSelector(".productinfo a")));
        click(productItem.findElement(By.cssSelector(".productinfo a")));
        logger.info("Add to cart button is clicked");
    }

    public void continueShopping(WebDriver driver){
        waitForElementToBeVisible(driver, continueShoppingBtn);
        click(continueShoppingBtn);
        logger.info("Continue shopping button is clicked");
    }
}
