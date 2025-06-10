package ui.pages.cart;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import java.util.List;

import static ui.helpers.ProductsHandler.filterWebElementByName;
import static ui.helpers.WaitHandler.waitForElementToBeInvisible;

@Getter
public class CartPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(CartPage.class);

    private final String cssToProductNameLabel = ".cart_description a";
    private final String cssToDeleteBtn = ".cart_quantity_delete";
    private final String cssToQuantityBtn = ".cart_quantity button";

    @FindBy(css = "tbody tr")
    private List<WebElement> cartTableItems;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void removeItemFromCartByName(String productName){
        WebElement cartItem = filterWebElementByName(productName, cartTableItems, cssToProductNameLabel);

        cartItem.findElement(By.cssSelector(cssToDeleteBtn)).click();
        logger.info("Item is deleted from cart");
        waitForElementToBeInvisible(driver,cartItem);
    }

    public int getQuantity(String productName){
        WebElement cartItem = filterWebElementByName(productName, cartTableItems, cssToProductNameLabel);
        return Integer.parseInt(cartItem.findElement(By.cssSelector(cssToQuantityBtn)).getText());
    }

    /*public List<WebElement> getCartTableItems(){
        return cartTableItems;
    }*/
}
