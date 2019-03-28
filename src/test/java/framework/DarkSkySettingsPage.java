package framework;

import org.openqa.selenium.By;

public class DarkSkySettingsPage extends BasePage {

    private By accountSettings = By.xpath("//a[contains(text(),'Account Settings')]");


    public void clickAccountSettings(){
        clickOn(accountSettings);
    }
}
