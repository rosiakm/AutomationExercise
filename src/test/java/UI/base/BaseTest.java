package UI.base;

import UI.helpers.ConfigLoader;
import UI.pages.cart.CartPage;
import UI.pages.menu.ConsentModalPage;
import UI.pages.menu.TopMenuPage;
import UI.pages.products.ProductsGridPage;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class BaseTest {
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private WebDriver driver;
    public TopMenuPage topMenuPage;
    public ProductsGridPage productsGridPage;
    public CartPage cartPage;
    public ConsentModalPage consentModalPage;

    @BeforeEach
    public void setup(){
        String browser = ConfigLoader.get("browser").toUpperCase();
        logger.info("Browser set from system properties: {}", browser);
        DriverTypes type;

        try {
            type = DriverTypes.valueOf(browser);
        } catch (IllegalArgumentException e){
            System.out.println("Unsupported browser: " + browser);
            type = DriverTypes.CHROME;
        }

        driver = DriverFactory.getDriver(type);
        logger.info("Driver is started!");
        driver.manage().window().maximize();
        driver.get(ConfigLoader.get("baseUrl"));
        logger.info("Url address is opened: {}", ConfigLoader.get("baseUrl"));
    }

    @BeforeEach
    public void setPageInstance(){
        topMenuPage = new TopMenuPage(getDriver());
        productsGridPage = new ProductsGridPage(getDriver());
        cartPage = new CartPage(getDriver());
        consentModalPage = new ConsentModalPage(getDriver());
        logger.info("Page instances are raised!");
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
            logger.info("Driver is quit");
        }
    }
}
