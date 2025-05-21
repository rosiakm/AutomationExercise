package ui.steps.filters;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.pages.filters.Categories;
import ui.pages.filters.CategoryFiltersPage;
import ui.pages.filters.Subcategories;
import ui.pages.products.ProductsGridPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FiltersSteps {
    private final WebDriver driver;

    public FiltersSteps(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open {category) -> {subcategory} page")
    public void openCategoryPage(Categories category, Subcategories subcategory) {
        CategoryFiltersPage categoryFiltersPage = new CategoryFiltersPage(driver);
        categoryFiltersPage.openCategoryPage(category, subcategory);
    }

    @Step("Verify that opened category title is: {title}")
    public void verifyOpenedCategoryTitle(String title) {
        ProductsGridPage productsGridPage = new ProductsGridPage(driver);
        assertThat(productsGridPage.getProductsGridName()).isEqualTo(title);
    }
}
