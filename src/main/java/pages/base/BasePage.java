package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void click(WebElement element){
        element.click();
    }

    public String getTextFromWebElement(WebElement element){
        return element.getText();
    }
}
