package framework;

import org.openqa.selenium.By;

public class DarkSkyLogonPage extends BasePage {

    private By logonButton = By.xpath("//a[contains(text(),'Log In')]");

    public void clickLogon() {
        clickOn(logonButton);


    }
}

