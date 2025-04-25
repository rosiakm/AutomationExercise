package cart;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.menu.TopMenuButtons;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest extends Pages {

    SoftAssertions softly = new SoftAssertions();

    @Test
    @Tag("cart")
    public void removeItemFromCartTest(){
        consentModalPage.acceptTheAds();

        topMenuPage.openTopMenuOption(TopMenuButtons.PRODUCTS);

        String productsGridName = productsGridPage.getProductsGridName();
        softly.assertThat(productsGridName).isEqualTo("ALL PRODUCTS");

        productsGridPage.addProductToCartByName("Stylish Dress");
        productsGridPage.continueShopping(getDriver());
        productsGridPage.addProductToCartByName("Blue Top");
        productsGridPage.continueShopping(getDriver());

        topMenuPage.openTopMenuOption(TopMenuButtons.CART);

        softly.assertThat(cartPage.getCartTableItems().size()).isEqualTo(2);
        cartPage.removeItemFromCartByName("Blue Top");
        assertThat(cartPage.getCartTableItems().size()).isEqualTo(1);
    }
}
