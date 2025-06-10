package ui.facade;

import org.openqa.selenium.WebDriver;
import ui.pages.base.BasePage;
import ui.pages.products.ConfirmationModalPage;
import ui.pages.products.ProductsGridPage;
import ui.pages.products.ProductsList;
import ui.steps.products.ProductSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsFacade {

    public static void searchAndVerify(String phrase, ProductSteps productSteps) {
        productSteps.userSearchProductByPhrase(phrase);
        productSteps.verifySearchedResults(phrase);
    }

    public static <T extends BasePage> T verifyOpenedProductsPageUrl(WebDriver driver, Class<T> pageClass, String expectedUrl) {
        try{
            T pageInstance = pageClass.getConstructor(WebDriver.class).newInstance(driver);
            assertThat(pageInstance.getUrl()).isEqualTo(expectedUrl);
            return pageInstance;
        } catch (Exception e){
            throw new RuntimeException("Failed to instantiate page object", e);
        }
    }

    public static void addProductToCart(ProductsGridPage productsGridPage, ProductsList productName) {
        productsGridPage.addProductToCartByName(productName.toString());
        assertThat(productsGridPage.getCartModalHeaderConfirmationText()).isEqualTo("Added!");
    }

    public static ConfirmationModalPage confirmAddedProduct(WebDriver driver) {
        ConfirmationModalPage confirmationModalPage = new ConfirmationModalPage(driver);
        confirmationModalPage.continueShopping(driver);
        return confirmationModalPage;
    }
}
