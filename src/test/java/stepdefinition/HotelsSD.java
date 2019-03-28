package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;
import framework.HotelsPackagesPage;
import framework.HotelsResultsPage;
import org.junit.Assert;

public class HotelsSD {

    private HotelsHomePage hotelsHomePage = new HotelsHomePage();
    private HotelsPackagesPage hotelsPackagesPage = new HotelsPackagesPage();
    private HotelsResultsPage hotelsResultsPage = new HotelsResultsPage();

    @Given("^I am on Hotels.com home page$")
    public void verifyHotelsPage() {
        hotelsHomePage.clickPackagesandFlights();
    }



   @Given("^I am on default search result screen$")
       public void entersearchinformation(){

        hotelsPackagesPage.enterOriginLocation("New York, NY (JFK-John F. Kennedy Intl.");
        hotelsPackagesPage.enterDestinationLocation("Orlando, Florida");
        hotelsPackagesPage.enterDepartureDate("04/01/2019");
        hotelsPackagesPage.enterReturnDate("04/09/2019");
        hotelsPackagesPage.selectNumberofAdults("Adults");
        hotelsPackagesPage.selectClass("Economy/Coach");
        hotelsPackagesPage.clickSearch();


        }

    @When("^I select property class (.+)$")
    public void selectPropertyClass(String text){
        hotelsResultsPage.selectStarClass(text);


    }





}