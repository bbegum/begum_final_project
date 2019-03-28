package framework;

import org.openqa.selenium.By;

public class HotelsHomePage extends BasePage {

    private By packagesFlightsButton = By.xpath("//a[contains(text(),'Packages & Flights')]");

    public void clickPackagesandFlights(){
        clickOn(packagesFlightsButton);
    }
}
