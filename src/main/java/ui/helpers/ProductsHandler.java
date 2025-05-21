package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.filters.Categories;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsHandler {
    static Logger logger = LoggerFactory.getLogger(ProductsHandler.class);

    public static WebElement filterWebElementByName(String itemName, List<WebElement> webElements, String css){
        WebElement element = webElements.stream().filter(item ->
                        item.findElement(By.cssSelector(css)).getText().equals(itemName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        logger.info("Item with name: {} is found!", element.findElement(By.cssSelector(css)).getText());
        return element;
    }

    public static WebElement filterCategoryByText(String categoryName, List<WebElement> categories){
        WebElement category = categories.stream().filter(item ->
                item.getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        logger.info("Category with name: {} is found!", category.getText());
        return category;
    }
}
