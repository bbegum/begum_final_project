package stepdefinition;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import framework.HotelsPackagesPage;
import framework.HotelsResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class HotelsSD {

    private HotelsHomePage hotelsHomePage = new HotelsHomePage();
    private HotelsPackagesPage hotelsPackagesPage = new HotelsPackagesPage();
    private HotelsResultsPage hotelsResultsPage = new HotelsResultsPage();

    @Given("^I am on Hotels.com home page$")
    public void verifyHotelsPage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
    }

    @Given("^I am on default search result screen$")
    public void enterDefaultSetting() throws InterruptedException {

        hotelsHomePage.clickPackagesAndFlights();
        hotelsPackagesPage.setOriginField("New York, NY (JFK-John F. Kennedy Intl.)");
        hotelsPackagesPage.setDestinationField("  Orlando, FL (MCO-Orlando Intl.)");
        hotelsPackagesPage.setDepartureDate("04/17/2019");
        hotelsPackagesPage.setReturnDate("04/30/2019");
        hotelsPackagesPage.clickSubmitButton();
        Thread.sleep(40000);
    }

    @When("^I select property class (.+)")
    public void enterPropertyClass(String stars) throws InterruptedException {

        switch (stars) {
            case "5 stars":
                hotelsResultsPage.clickOnFiveStars();
                break;
            case "4 stars":
                hotelsResultsPage.clickOnFourStars();
                break;
            case "3 stars":
                hotelsResultsPage.clickOnThreeStars();
                break;
        }

        Thread.sleep(8000);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void verifyStars(String stars) {

        Assert.assertEquals(hotelsResultsPage.getStarNumbers() + " " + "stars", stars);
    }

    @Then("^I verify system displays all hotels within (.+) miles radius of airport$")
    public void milesWithinRadius(int miles) {
    ArrayList<WebElement> hotels = hotelsResultsPage.getlistofHotels(10);
    for(WebElement temp : hotels){
        System.out.println("This hotel is within range: " + temp.getText());
    }

    }

    @And("^I verify (.+) Hotel is within radius$")
    public void checkHiltonRadius(String hotel) {

        System.out.println("This is the " + hotel + " Hotel: " ); hotelsResultsPage.verifyHotelisWithinRange(hotel);
    }


}