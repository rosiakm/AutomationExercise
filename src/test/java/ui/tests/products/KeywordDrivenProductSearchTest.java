package ui.tests.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.actions.KeywordEngine;
import ui.base.BaseTest;
import ui.base.Pages;
import ui.pages.menu.TopMenuPage;
import ui.pages.products.ProductsGridPage;

import java.io.IOException;

import static ui.helpers.CsvHandler.readCsv;

public class KeywordDrivenProductSearchTest extends BaseTest {

    private Pages pages;
    private KeywordEngine engine;

    @BeforeEach
    public void setupKdt(){
        pages = new Pages();
        pages.setTopMenuPage(new TopMenuPage(getDriver()));
        pages.setProductsGridPage(new ProductsGridPage(getDriver()));
        engine = new KeywordEngine(pages);
    }

    @Test
    public void searchProductTest() throws IOException {
        String[][] steps = readCsv("src/main/resources/search_test.csv");
        engine.execute(getDriver(), steps);
    }
}
