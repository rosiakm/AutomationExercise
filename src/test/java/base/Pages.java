package base;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cart.CartPage;
import pages.menu.ConsentModalPage;
import pages.menu.TopMenuPage;
import pages.products.ProductsGridPage;

public class Pages extends BaseTest{
    Logger logger = LoggerFactory.getLogger(Pages.class);

    public TopMenuPage topMenuPage;
    public ProductsGridPage productsGridPage;
    public CartPage cartPage;
    public ConsentModalPage consentModalPage;

    @BeforeEach
    public void setPageInstance(){
        topMenuPage = new TopMenuPage(getDriver());
        productsGridPage = new ProductsGridPage(getDriver());
        cartPage = new CartPage(getDriver());
        consentModalPage = new ConsentModalPage(getDriver());
        logger.info("Page instances are raised!");
    }
}
