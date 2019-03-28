package framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.SharedSD;

public class DarkSkyAccountPage extends BasePage {

    private By cardNumber = By.xpath("//input[@placeholder='4242 4242 4242 4242']");
    private By cardName = By.xpath("//span[contains(text(),Cardholder's Name)]");
    private By monthField = By.xpath("//select[@data-stripe='exp-month']");
    private By yearField = By.xpath("//select[@data-stripe='exp-year']");
    private By cvsField = By.xpath("//input[@placeholder='123']");
    private By addressField = By.xpath("//input[@data-stripe = 'address_line1']");
    private By confirmAddressField = By.xpath("//input[@data-stripe='address_line2']");
    private By cityField = By.xpath("//input[@data-stripe='address_city']");
    private By stateField = By.xpath("//input[@data-stripe='address_state']");
    private By zipcodeField = By.xpath("//input[@data-stripe='address_zip'");
    private By countryField = By.xpath("//input[@data-stripe='address_country']");
    private By submitButton = By.xpath("//button[contains(text(),'Add Card')]");
    // private WebElement cardHolderName = SharedSD.getDriver().findElement(By.xpath("//input[@placeholder='4242 4242 4242 4242']"));
    private String incorrectMessage = SharedSD.getDriver().findElement(By.xpath("//div[@class='error']")).getText();

    public void scrolltocardinfo(){
        scrollToView(cardNumber);
    }
    public void enterCardName(String text){
        setValue(cardName, text);
    }



    public void enterCardIDNumber(String text){ setValue(cardNumber, text);}

    public void selectCardMonth(String text) {
        selectFromDropdownText(monthField, text);
    }

    public void selectCardYear(String text) {
        selectFromDropdownText(yearField, text);
    }

    public void enterCVSNumber(String text) {
        setValue(cvsField, text);

    }

    public void enterAddress(String text) {
        setValue(addressField, text);

    }

    public void enterConfirmAddress(String text) {
        setValue(confirmAddressField, text);
    }

    public void enterCity(String text) {
        setValue(cityField, text);
    }

    public void enterState(String text) {
        setValue(stateField, text);

    }

    public void enterZipcode(String text) {
        setValue(zipcodeField, text);

    }

    public void enterCountry(String text) {
        setValue(countryField, text);

    }

    public void clickSubmitButton() {
        waitForElementToBeClickable(submitButton);
        clickOn(submitButton);
    }

    public String getIncorrectMessage() {
        return incorrectMessage;
    }


}