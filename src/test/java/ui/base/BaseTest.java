package ui.base;

import ui.helpers.ConfigLoader;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.menu.ConsentModalPage;

@Getter
public class BaseTest{
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private WebDriver driver;
    public ConsentModalPage consentModalPage;

    @BeforeEach
    public void setup(){
        String browser = ConfigLoader.get("browser").toUpperCase();
        logger.info("Browser set from system properties: {}", browser);
        DriverTypes type;

        try {
            type = DriverTypes.valueOf(browser);
        } catch (IllegalArgumentException e){
            logger.info("Unsupported browser: {}", browser);
            type = DriverTypes.CHROME;
        }

        driver = DriverFactory.getDriver(type);
        logger.info("Driver is started!");
        driver.manage().window().maximize();
        driver.get(ConfigLoader.get("baseUrl"));
        logger.info("Url address is opened: {}", ConfigLoader.get("baseUrl"));
    }

    @BeforeEach
    public void acceptTheAds(){
        consentModalPage = new ConsentModalPage(driver);
        consentModalPage.acceptTheAds();
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
            logger.info("Driver is quit");
        }
    }
}
