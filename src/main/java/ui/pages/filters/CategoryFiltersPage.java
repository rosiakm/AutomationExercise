package ui.pages.filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            case WOMEN -> {
                womenCategoryLabel.click();
                actions.scrollByAmount(0,250).perform();
                logger.info("Women category is opened");
            }
            case MEN -> {
                menCategoryLabel.click();
                actions.scrollByAmount(0,250).perform();
                logger.info("Men category is opened");
            }
            case KIDS -> {
                kidsCategoryLabel.click();
                actions.scrollByAmount(0,250).perform();
                logger.info("Kids category is opened");
            }
        }
        if (category.equals(Categories.WOMEN)) {
            switch (subcategory) {
                case DRESS -> {
                    filterCategoryByText(Subcategories.DRESS.toString(), womenSubcategoryLabels).click();
                    logger.info("Women -> Dress subcategory is selected");
                }
                case TOPS -> {
                    filterCategoryByText(Subcategories.TOPS.toString(), womenSubcategoryLabels).click();
                    logger.info("Women -> Tops subcategory is selected");
                }
                case SAREE -> {
                    filterCategoryByText(Subcategories.SAREE.toString(), womenSubcategoryLabels).click();
                    logger.info("Women -> Saree subcategory is selected");
                }
            }
        } else if (category.equals(Categories.MEN)) {
            switch (subcategory) {
                case TSHIRTS -> {
                    filterCategoryByText(Subcategories.TSHIRTS.toString(), menSubcategoryLabels).click();
                    logger.info("Men -> Tshirts subcategory is selected");
                }
                case JEANS -> {
                    filterCategoryByText(Subcategories.JEANS.toString(), menSubcategoryLabels).click();
                    logger.info("Men -> Jeans subcategory is selected");
                }
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
}
