package ui.actions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.base.Pages;
import ui.pages.products.ProductsGridPage;

public class SearchProductByNameAction implements TestAction {
    Logger logger = LoggerFactory.getLogger(SearchProductByNameAction.class);

    private final Pages pages;

    public SearchProductByNameAction(Pages pages){
        this.pages = pages;
    }

    @Override
    public void execute(WebDriver driver, String... params){
        String searchPhrase = params[0];
        logger.info("Get the searched phrase: ".concat(searchPhrase));
        ProductsGridPage productsGridPage = pages.getProductsGridPage();
        productsGridPage.searchProductName(searchPhrase);
    }
}
