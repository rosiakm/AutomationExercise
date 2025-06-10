package ui.tests.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ui.base.BaseTest;
import ui.dataProvider.DataProviderRunner;
import ui.facade.ProductsFacade;
import ui.pages.menu.TopMenuButtons;
import ui.steps.products.ProductSteps;

public class ProductsTest extends BaseTest {

    @ParameterizedTest(name = "{0} - phrase is verified")
    @ArgumentsSource(DataProviderRunner.class)
    @Tag("ui/tests")
    @Tag("keyword")
    @DisplayName("Search products by phrase test")
    public void searchProductsKeywordTest(String phrase){
        ProductSteps productSteps = new ProductSteps(getDriver());
        productSteps.userOpensTopMenuTab(TopMenuButtons.PRODUCTS);
        ProductsFacade.searchAndVerify(phrase, productSteps);
    }

}
