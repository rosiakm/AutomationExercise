package ui.facade;

import org.openqa.selenium.WebDriver;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;

public class TopMenuFacade {

    public static TopMenuPage openToMenuTab(WebDriver driver, TopMenuButtons button) {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.openTopMenuOption(button);
        return topMenuPage;
    }
}
