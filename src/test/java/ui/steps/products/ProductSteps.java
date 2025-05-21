package ui.steps.products;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;
import ui.pages.products.ProductsGridPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps {
    private final WebDriver driver;

    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open {topMenuButton} tab")
    public void userOpensTopMenuTab(TopMenuButtons topMenuButton) {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(topMenuButton);
    }

    @Step("Provide searched phrase: {phrase}, and click search button")
    public void userSearchProductByPhrase(String phrase) {
        ProductsGridPage productsGridPage = new ProductsGridPage(driver);
        productsGridPage.searchProductName(phrase);
    }

    @Step("Verify that phrase: {phrase} is included in results")
    public void verifySearchedResults(String phrase) {
        ProductsGridPage productsGridPage = new ProductsGridPage(driver);
        List<String> productNames = productsGridPage.getSearchedProductNames();
        for (String name : productNames){
            assertThat(name.toLowerCase()).contains(phrase.toLowerCase());
        }
    }
}
