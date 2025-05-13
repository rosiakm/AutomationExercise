package ui.base;

import lombok.Getter;
import lombok.Setter;
import ui.pages.cart.CartPage;
import ui.pages.menu.TopMenuPage;
import ui.pages.products.ConfirmationModalPage;
import ui.pages.products.ProductDetailsPage;
import ui.pages.products.ProductsGridPage;

@Getter
@Setter
public class Pages extends BaseTest{
    public TopMenuPage topMenuPage;
    public ProductsGridPage productsGridPage;
    public CartPage cartPage;
    public ProductDetailsPage productDetailsPage;
    public ConfirmationModalPage confirmationModalPage;
}
