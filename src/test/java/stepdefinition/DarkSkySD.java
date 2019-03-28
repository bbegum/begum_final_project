package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import util.DateUtil;

public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    DarkSkyWeatherPage darkSkyWeatherPage = new DarkSkyWeatherPage();
    DarkSkySettingsPage darkSkySettingsPage = new DarkSkySettingsPage();
    DarkSkyLoginPage darkSkyLoginPage = new DarkSkyLoginPage();
    DarkSkyLogonPage darkSkyLogonPage = new DarkSkyLogonPage();
    DarkSkyAccountPage darkSkyAccountPage = new DarkSkyAccountPage();


    @Given("^I am on Dark Sky Home Page$")
    public void verifyDarkSkyHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY", "This is the Wrong website");
    }

    @And("^I scroll to Time Machine Button$")
    public void scrollDown() throws InterruptedException {
        darkSkyHomePage.scrollToTimeMachine();
        Thread.sleep(2000);
    }

    @And("^I click on Time Machine Button$")
    public void clickTimeMachineButton() {
        darkSkyHomePage.clickOnTimeMachineButton();


    }

    @And("^I click on Today's Date$")
    public void clickTodaysDate() {
        darkSkyHomePage.clickTodaysDate();
    }

    @Then("^I verify Weather Date$")
    public void verifyWeatherDate() {
        Assert.assertEquals(darkSkyWeatherPage.getDate(), DateUtil.getTodaysDate("EEEEEE, MMM d'st', yyyy"), "It is not today's date");
    }

    @And("^I verify the first index is (.+)$")
    public void verifyTimeLineStart(String text) {
        Assert.assertEquals(darkSkyHomePage.getfirstHourText(), text);
    }

    @Then("^I verify timeline is displayed with (.+) hours incremented$")
    public void verifyTimelineHours(int incremented) {

        //Assert.assertTrue(darkSkyHomePage.verifyTimelineHours(incremented));

        Assert.assertTrue(darkSkyHomePage.verifyTimelineHours(incremented));
    }

    @When("^I expand todays timeline$")
    public void expandTodaysTimeline() throws InterruptedException {
        darkSkyHomePage.scrolltoToday();
        Thread.sleep(2000);
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTemperatures() throws InterruptedException {
        Assert.assertEquals(darkSkyHomePage.getLowTemp(), darkSkyHomePage.getLowTimelimeTemp(), "The degrees are not the same");
        Assert.assertEquals(darkSkyHomePage.getHighTemp(), darkSkyHomePage.getHighTimelineTemp(), "The degrees are not the same");


    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemp() {
        darkSkyHomePage.changeDegreestoInteger();

        boolean isCurrentTempCorrect = false;



        if (!(darkSkyHomePage.getcurrentDegree() < darkSkyHomePage.getSmallestTimeLineTemp() || darkSkyHomePage.getcurrentDegree() > darkSkyHomePage.getLargestTimeLineTemp())){
            isCurrentTempCorrect = true;
        }

        System.out.println("The Current Temperature is within range: " + isCurrentTempCorrect);


    }

    @When("^I click on API button$")
    public void clickAPIButton() {

        SharedSD.getDriver().findElement(By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]")).click();

    }

    @And("^I click On login button$")
    public void clickLogon(){
        darkSkyLogonPage.clickLogon();

    }

    @And("^I enter the login information$")
    public void enterlogin(){
        darkSkyLoginPage.enterEmail("begumnur502@gmail.com");
        darkSkyLoginPage.enterPassword("begum1234");
        darkSkyLoginPage.clickLoginButton();
    }

    @Then("^I click on Account Settings$")
    public void clickAccountSettings(){
        darkSkySettingsPage.clickAccountSettings();
    }

    @And("^I scroll down to card information section$")
    public void gotoCardSectrion(){
        darkSkyAccountPage.scrolltocardinfo();
    }



}






