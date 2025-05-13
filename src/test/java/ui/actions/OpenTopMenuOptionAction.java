package ui.actions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.base.Pages;
import ui.pages.menu.TopMenuButtons;
import ui.pages.menu.TopMenuPage;

public class OpenTopMenuOptionAction implements TestAction {
    Logger logger = LoggerFactory.getLogger(OpenTopMenuOptionAction.class);

    private final Pages pages;

    public OpenTopMenuOptionAction(Pages pages){
        this.pages = pages;
    }

    @Override
    public void execute(WebDriver driver, String... params){
        String option = params[0];
        logger.info("Get the parameter: ".concat(option));
        TopMenuPage topMenuPage = pages.getTopMenuPage();
        topMenuPage.openTopMenuOption(TopMenuButtons.valueOf(option));
    }
}
