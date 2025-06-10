package ui.pages.base;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Data
public class BasePage {
    public WebDriver driver;
    public Actions actions;
    public Select select;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}