package ui.tests.filters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ui.base.BaseTest;
import ui.pages.filters.Categories;
import ui.pages.filters.Subcategories;
import ui.steps.filters.FiltersSteps;

public class CategoryFiltersTest extends BaseTest {

    @ParameterizedTest(name = "{2} is verified")
    @CsvFileSource(resources = "/testData/filters/filtersTestData")
    @Tag("ui/tests")
    @DisplayName("Opening categories test")
    public void openCategoryFilterTest(Categories category, Subcategories subcategory, String title){
        FiltersSteps filtersSteps = new FiltersSteps(getDriver());
        filtersSteps.openCategoryPage(category, subcategory);
        filtersSteps.verifyOpenedCategoryTitle(title);
    }
}
