package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.base.Pages;

import java.util.HashMap;
import java.util.Map;

public class KeywordEngine {

    private final Map<String, TestAction> actions = new HashMap<>();

    public KeywordEngine(Pages pages){
        actions.put("openTopMenuOption", new OpenTopMenuOptionAction(pages));
        actions.put("searchProductByName", new SearchProductByNameAction(pages));
        actions.put("verifySearchedProductsContain", new VerifySearchedProductsContainAction(pages));
    }

    public void execute(WebDriver driver, String[][] steps){
        for(String[] step : steps){
            String keyword = step[0];
            String[] params = new String[step.length - 1];
            System.arraycopy(step, 1, params, 0, params.length);

            TestAction action = actions.get(keyword);
            if (action == null){
                throw new IllegalArgumentException("No action found for keyword: ".concat(keyword));
            }

            action.execute(driver,params);
        }
    }
}
