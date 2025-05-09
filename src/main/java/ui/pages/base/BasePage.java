package ui.pages.base;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

@Data
public class BasePage {
    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }
}