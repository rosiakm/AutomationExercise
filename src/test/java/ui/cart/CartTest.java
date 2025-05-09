package ui.cart;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.base.Pages;
import ui.helpers.ConfigLoader;
import ui.pages.cart.CartPage;
import ui.pages.menu.ConsentModalPage;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;
import ui.pages.products.ConfirmationModalPage;
import ui.pages.products.ProductDetailsPage;
import ui.pages.products.ProductsGridPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest extends Pages {

    Logger logger = LoggerFactory.getLogger(CartTest.class);

    @BeforeEach
    public void setPages(){
        topMenuPage = new TopMenuPage(getDriver());
        productsGridPage = new ProductsGridPage(getDriver());
        cartPage = new CartPage(getDriver());
        productDetailsPage = new ProductDetailsPage(getDriver());
        confirmationModalPage = new ConfirmationModalPage(getDriver());
        logger.info("Page instances are raised!");
    }

    @Test
    @Tag("ui/cart")
    public void removeItemFromCartTest(){
        topMenuPage.openTopMenuOption(TopMenuButtons.PRODUCTS);

        String productsGridName = productsGridPage.getProductsGridName();
        assertThat(productsGridName).isEqualTo("ALL PRODUCTS");

        productsGridPage.addProductToCartByName("Stylish Dress");
        assertThat(productsGridPage.getCartModalHeaderConfirmationText()).isEqualTo("Added!");
        confirmationModalPage.continueShopping(getDriver());
        productsGridPage.addProductToCartByName("Blue Top");
        assertThat(productsGridPage.getCartModalHeaderConfirmationText()).isEqualTo("Added!");
        confirmationModalPage.continueShopping(getDriver());

        topMenuPage.openTopMenuOption(TopMenuButtons.CART);

        assertThat(cartPage.getCartTableItems().size()).isEqualTo(2);
        cartPage.removeItemFromCartByName("Blue Top");
        assertThat(cartPage.getCartTableItems().size()).isEqualTo(1);
    }

    @Test
    @Tag("ui/cart")
    public void verifyProductQuantityInCartTest(){
        topMenuPage.openTopMenuOption(TopMenuButtons.PRODUCTS);

        String productsGridName = productsGridPage.getProductsGridName();
        assertThat(productsGridName).isEqualTo("ALL PRODUCTS");

        productsGridPage.openProductDetailsPageByName("Winter Top");
        assertThat(productDetailsPage.getProductPageUrl()).isEqualTo(ConfigLoader.get("winterTopUrl"));

        productDetailsPage.setQuantity(4);
        productDetailsPage.addProductToCart();
        confirmationModalPage.continueShopping(getDriver());

        topMenuPage.openTopMenuOption(TopMenuButtons.CART);

        assertThat(cartPage.getQuantity("Winter Top")).isEqualTo(4);
    }

}
