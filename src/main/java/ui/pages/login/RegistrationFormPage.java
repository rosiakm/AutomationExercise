package ui.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.base.BasePage;

import java.util.List;
import java.util.Random;

public class RegistrationFormPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(RegistrationFormPage.class);

    @FindBy(css = "#id_gender1")
    private WebElement maleRadioButton;

    @FindBy(css = "id_gender2")
    private WebElement femaleRadioButton;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> genderRadioButtons;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#days")
    private WebElement daysSelect;

    @FindBy(css = "#days option")
    private List<WebElement> daysSelectOptions;

    @FindBy(css = "#months")
    private WebElement monthsSelect;

    @FindBy(css = "#months option")
    private List<WebElement> monthsSelectOptions;

    @FindBy(css = "#years")
    private WebElement yearsSelect;

    @FindBy(css = "#years option")
    private List<WebElement> yearsSelectOptions;

    @FindBy(css = "input[data-qa='first_name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-qa='last_name']")
    private WebElement lastNameInput;

    @FindBy(css = "input[data-qa='address']")
    private WebElement addressInput;

    @FindBy(css = "#country")
    private WebElement countrySelect;

    @FindBy(css = "#country option")
    private List<WebElement> countrySelectOptions;

    @FindBy(css = "input[data-qa='state']")
    private WebElement stateInput;

    @FindBy(css = "input[data-qa='city']")
    private WebElement cityInput;

    @FindBy(css = "input[data-qa='zipcode']")
    private WebElement zipcodeInput;

    @FindBy(css = "input[data-qa='mobile_number']")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountBtn;

    public RegistrationFormPage(WebDriver driver){
        super(driver);
    }

    public RegistrationFormPage selectMaleTitle(){
        maleRadioButton.click();
        logger.info("Male radio button selected");
        return this;
    }

    public RegistrationFormPage selectFemaleTitle(){
        femaleRadioButton.click();
        logger.info("Female radio button selected");
        return this;
    }

    public RegistrationFormPage selectRandomTitle(){
        Random random = new Random();
        WebElement radioBtn = genderRadioButtons.get(random.nextInt(genderRadioButtons.size()-1));
        radioBtn.click();
        logger.info(radioBtn.getText().concat(" radio button is clicked"));
        return this;
    }

    public RegistrationFormPage providePassword (String password){
        provideText(passwordInput, password);
        return this;
    }

    public RegistrationFormPage selectDay(){
        selectDateOfBirthItem(daysSelectOptions, daysSelect);
        return this;
    }

    public RegistrationFormPage selectMonth(){
        selectDateOfBirthItem(monthsSelectOptions, monthsSelect);
        return this;
    }

    public RegistrationFormPage selectYear(){
        selectDateOfBirthItem(yearsSelectOptions, yearsSelect);
        return this;
    }

    public RegistrationFormPage provideFirstName(String firstName){
        provideText(firstNameInput,firstName);
        return this;
    }

    public RegistrationFormPage provideLastName(String lastName){
        provideText(lastNameInput,lastName);
        return this;
    }

    public RegistrationFormPage provideAddress(String address){
        provideText(addressInput, address);
        return this;
    }

    public RegistrationFormPage selectCountry(){
        Random random = new Random();
        WebElement selectedCountry = countrySelectOptions.get(random.nextInt(countrySelectOptions.size()-1));
        new Select(countrySelect).selectByVisibleText(selectedCountry.getText());
        logger.info(selectedCountry.getText().concat(" - country is selected"));
        return this;
    }

    public RegistrationFormPage provideState(String state){
        provideText(stateInput, state);
        return this;
    }

    public RegistrationFormPage provideCity(String city){
        provideText(cityInput,city);
        return this;
    }

    public RegistrationFormPage provideZipcode(String zipcode){
        provideText(zipcodeInput,zipcode);
        return this;
    }

    public RegistrationFormPage provideMobileNumber(String mobileNumber){
        provideText(mobileNumberInput,mobileNumber);
        return this;
    }

    public void createAccount(){
        createAccountBtn.click();
        logger.info("Create Account button is clicked");
    }

    private void provideText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        logger.info(text.concat(" is provided"));
    }

    private void selectDateOfBirthItem(List<WebElement> options, WebElement item){
        Random random = new Random();
        options.remove(0);
        WebElement selectedItem = options.get(random.nextInt(options.size()-1));
        new Select(item).selectByVisibleText(selectedItem.getText());
        logger.info(selectedItem.getText().concat(" option is selected"));
    }
}
