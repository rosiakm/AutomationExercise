package ui.pages.filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import java.util.List;

import static ui.helpers.ProductsHandler.filterCategoryByText;

public class CategoryFiltersPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(CategoryFiltersPage.class);

    @FindBy(css = "a[href='#Women']")
    private WebElement womenCategoryLabel;

    @FindBy(css = "a[href='#Men']")
    private WebElement menCategoryLabel;

    @FindBy(css = "a[href='#Kids']")
    private WebElement kidsCategoryLabel;

    @FindBy(css = "#Women a")
    private List<WebElement> womenSubcategoryLabels;

    @FindBy(css = "#Men a")
    private List<WebElement> menSubcategoryLabels;

    @FindBy(css = "#Kids a")
    private List<WebElement> kidsSubcategoryLabels;

    public CategoryFiltersPage(WebDriver driver) {
        super(driver);
    }

    public void openCategoryPage(Categories category, Subcategories subcategory) {
        switch (category) {
            case WOMEN ->
                expandCategory(womenCategoryLabel, "Women", actions);
            case MEN ->
                expandCategory(menCategoryLabel,"Men", actions);
            case KIDS ->
                expandCategory(kidsCategoryLabel, "Kids", actions);
        }
        if (category.equals(Categories.WOMEN)) {
            switch (subcategory) {
                case DRESS ->
                    clickOnSubcategory(subcategory,womenSubcategoryLabels,"Women -> Dress");
                case TOPS ->
                    clickOnSubcategory(subcategory,womenSubcategoryLabels,"Women -> Tops");
                case SAREE ->
                    clickOnSubcategory(subcategory,womenSubcategoryLabels,"Women -> Saree");
            }
        } else if (category.equals(Categories.MEN)) {
            switch (subcategory) {
                case TSHIRTS ->
                    clickOnSubcategory(subcategory,menSubcategoryLabels,"Men -> T-shirts");
                case JEANS ->
                    clickOnSubcategory(subcategory,menSubcategoryLabels,"Men -> Jeans");
            }
        } else if (category.equals(Categories.KIDS)) {
            switch (subcategory) {
                case KIDSDRESS -> {
                    filterCategoryByText("DRESS", kidsSubcategoryLabels).click();
                    logger.info("Kids -> Dress subcategory is selected");
                }
                case TOPSANDSHIRTS -> {
                    filterCategoryByText("TOPS & SHIRTS", kidsSubcategoryLabels).click();
                    logger.info("Kids -> Tops & Shirts subcategory is selected");
                }
            }
        }
    }

    private void expandCategory(WebElement label, String text, Actions actions){
        label.click();
        actions.scrollByAmount(0,250).perform();
        logger.info(text.concat(" category is opened"));
    }

    private void clickOnSubcategory(Subcategories subcategory, List<WebElement> label, String text){
        filterCategoryByText(subcategory.toString(), label).click();
        logger.info(text.concat(" subcategory is selected"));
    }
}
