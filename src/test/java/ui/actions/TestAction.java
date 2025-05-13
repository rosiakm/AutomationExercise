package ui.actions;

import org.openqa.selenium.WebDriver;

public interface TestAction {
    void execute(WebDriver driver, String... params);
}
