package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsHandler {
    static Logger logger = LoggerFactory.getLogger(ProductsHandler.class);

    public static WebElement filterProductByName(String productName, List<WebElement> products, String css){
        WebElement productItem = products.stream().filter(item ->
                        item.findElement(By.cssSelector(css)).getText().equals(productName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        logger.info("Product with name: {} is found!", productItem.findElement(By.cssSelector(css)).getText());
        return productItem;
    }
}
