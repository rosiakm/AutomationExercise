package UI.pages.cart;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import UI.pages.base.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

import static UI.helpers.WaitHandler.waitForElementToBeInvisible;

@Getter
public class CartPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(CartPage.class);

    @FindBy(css = "tbody tr")
    private List<WebElement> cartTableItems;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void removeItemFromCartByName(String productName){
        WebElement cartItem = cartTableItems.stream().filter(item ->
                item.findElement(By.cssSelector(".cart_description a")).getText().equals(productName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        logger.info("Item with name: {} is found!", cartItem.findElement(By.cssSelector(".cart_description a")).getText());

        click(cartItem.findElement(By.cssSelector(".cart_quantity_delete")));
        logger.info("Item is deleted from cart");
        waitForElementToBeInvisible(driver,cartItem);
    }
}
