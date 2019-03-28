package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.*;
import org.testng.Assert;

public class DarkSkyAccountSD {
    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    private DarkSkyLoginPage darkSkyLoginPage = new DarkSkyLoginPage();
    private DarkSkySettingsPage darkSkySettingsPage = new DarkSkySettingsPage();
    private DarkSkyAccountPage darkSkyAccountPage = new DarkSkyAccountPage();
    private DarkSkyLogonPage darkSkyLogonPage = new DarkSkyLogonPage();

    @Given("^I am on Dark Sky Account Page$")
    public void gotoDarkSkyAccountPage() throws InterruptedException {
        darkSkyHomePage.clickAPIButton();
        darkSkyLogonPage.clickLogon();
        darkSkyLoginPage.enterEmail("begumnur502@gmail.com");
        darkSkyLoginPage.enterPassword("begum1234");
        darkSkyLoginPage.clickLoginButton();
        darkSkySettingsPage.clickAccountSettings();
        darkSkyAccountPage.scrolltocardinfo();

        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://darksky.net/dev/account");
    }

    @And("^I scroll down to credit card information section$")
    public void scrollDowntoCreditCard() throws InterruptedException {
        darkSkyAccountPage.scrolltocardinfo();
    }



    @When("^I enter (.+) into (cardholdername|cardnumber|securitycode|address|verifyaddress|city|state|zipcode|country|month|year) text fields on accounts screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {


        switch (textFields) {
            case "carholdername":
                darkSkyAccountPage.enterCardName(anyText);
                break;
            case "cardnumber":
                darkSkyAccountPage.enterCardIDNumber(anyText);
                break;
            case "securitycode":
                darkSkyAccountPage.enterCVSNumber(anyText);
            case "address":
                darkSkyAccountPage.enterAddress(anyText);
                break;
            case "verifyaddress":
                darkSkyAccountPage.enterConfirmAddress(anyText);
                break;
            case "city":
                darkSkyAccountPage.enterCity(anyText);
                break;
            case "state":
                darkSkyAccountPage.enterState(anyText);
                break;
            case "zipcode":
                darkSkyAccountPage.enterZipcode(anyText);
                break;
            case "country":
                darkSkyAccountPage.enterCountry(anyText);
                break;
            case "month":
                darkSkyAccountPage.selectCardMonth(anyText);
                break;
            case "year":
                darkSkyAccountPage.selectCardYear(anyText);
        }
    }

    @And("^I click on add card button$")
    public void clickAddCardButton(){
        darkSkyAccountPage.clickSubmitButton();

    }

    @Then("^I verify (.+) error message$")
    public void verifyDeclinedCard(String errorType){
        switch(errorType){
            case "carddeclined":
                Assert.assertEquals(darkSkyAccountPage.getIncorrectMessage(),"Your card was declined. Your request was in live mode, but used a known test card.");
                break;
            case "invalidcardnumber":
                Assert.assertEquals(darkSkyAccountPage.getIncorrectMessage(), "Your card number is incorrect.");
                break;
            case "invalidmonth":
                Assert.assertEquals(darkSkyAccountPage.getIncorrectMessage(), "Your card's expiration month is invalid.");


        }
    }


}
