package ui.tests.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.helpers.ConfigLoader;
import ui.pages.cart.CartPage;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;
import ui.pages.products.ConfirmationModalPage;
import ui.pages.products.ProductDetailsPage;
import ui.pages.products.ProductsGridPage;
import ui.pages.products.ProductsList;

import static org.assertj.core.api.Assertions.assertThat;
import static ui.facade.ProductsFacade.*;
import static ui.facade.TopMenuFacade.openToMenuTab;

public class CartTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(CartTest.class);

    TopMenuPage topMenuPage;
    ConfirmationModalPage confirmationModalPage;

    @Test
    @Tag("ui/tests")
    public void removeItemFromCartTest(){
        topMenuPage = openToMenuTab(getDriver(), TopMenuButtons.PRODUCTS);

        ProductsGridPage productsGridPage = verifyOpenedProductsPageUrl(getDriver(), ProductsGridPage.class, ConfigLoader.get("productsTabUrl"));
        addProductToCart(productsGridPage, ProductsList.STYLISH_DRESS);

        confirmationModalPage = confirmAddedProduct(getDriver());

        addProductToCart(productsGridPage, ProductsList.BLUE_TOP);

        confirmationModalPage = confirmAddedProduct(getDriver());

        topMenuPage = openToMenuTab(getDriver(), TopMenuButtons.CART);

        CartPage cartPage = new CartPage(getDriver());
        assertThat(cartPage.getCartTableItems().size()).isEqualTo(2);
        cartPage.removeItemFromCartByName(ProductsList.BLUE_TOP.toString());
        assertThat(cartPage.getCartTableItems().size()).isEqualTo(1);
    }

    @Test
    @Tag("ui/tests")
    public void verifyProductQuantityInCartTest(){
        topMenuPage = openToMenuTab(getDriver(), TopMenuButtons.PRODUCTS);

        ProductsGridPage productsGridPage = verifyOpenedProductsPageUrl(getDriver(), ProductsGridPage.class, ConfigLoader.get("productsTabUrl"));
        productsGridPage.openProductDetailsPageByName(ProductsList.HALF_SLEEVES_TOP_SCHIFFLI_DETAILING_PINK.toString());

        ProductDetailsPage productDetailsPage = verifyOpenedProductsPageUrl(getDriver(), ProductDetailsPage.class, ConfigLoader.get("halfSleevesTopSchiffliDetailingPink"));

        productDetailsPage.setQuantity(4);
        productDetailsPage.addProductToCart();

        confirmationModalPage = confirmAddedProduct(getDriver());

        topMenuPage = openToMenuTab(getDriver(), TopMenuButtons.CART);

        CartPage cartPage = new CartPage(getDriver());
        assertThat(cartPage.getQuantity(ProductsList.HALF_SLEEVES_TOP_SCHIFFLI_DETAILING_PINK.toString())).isEqualTo(4);
    }

}
