package ui.tests.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ui.base.BaseTest;
import ui.pages.menu.TopMenuButtons;
import ui.steps.products.ProductSteps;

public class ProductsTest extends BaseTest {

    @ParameterizedTest(name = "{0} - phrase is verified")
    @CsvFileSource(resources = "/testData/products/productsTestData.csv")
    @Tag("ui/tests")
    @DisplayName("Search products by phrase test")
    public void searchProductsKeywordTest(String phrase){
        ProductSteps productSteps = new ProductSteps(getDriver());
        productSteps.userOpensTopMenuTab(TopMenuButtons.PRODUCTS);
        productSteps.userSearchProductByPhrase(phrase);
        productSteps.verifySearchedResults(phrase);
    }
}
