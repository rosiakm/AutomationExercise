package ui.actions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.base.Pages;

import java.util.List;

public class VerifySearchedProductsContainAction implements TestAction {
    Logger logger = LoggerFactory.getLogger(VerifySearchedProductsContainAction.class);
    private final Pages pages;

    public VerifySearchedProductsContainAction(Pages pages){
        this.pages = pages;
    }

    @Override
    public void execute(WebDriver driver, String... params){
        String expectedText = params[0];
        logger.info("Get the expected text: ".concat(expectedText));
        List<String> productNames = pages.getProductsGridPage().getSearchedProductNames();
        for (String name : productNames){
            if(!name.toLowerCase().contains(expectedText.toLowerCase())){
                throw new AssertionError("Product '".concat(name).concat("' does not contain the expected text: ".concat(expectedText)));
            }
        }
    }
}
