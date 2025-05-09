package ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    static Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver getDriver(DriverTypes type){
        switch (type){
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                logger.info("Chromedriver is set!");
                return new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                logger.info("Firefoxdriver is set!");
                return new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                logger.info("Edgedriver is set!");
                return new EdgeDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                logger.info("Unsupported browser has been set! Chromedriver has been set by default!");
                return new ChromeDriver();
            }
        }
    }

    public static WebDriver getDefaultDriver(){
        return getDriver(DriverTypes.CHROME);
    }
}
