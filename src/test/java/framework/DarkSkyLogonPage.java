package framework;

import org.openqa.selenium.By;

public class DarkSkyLogonPage extends BasePage {

    private By logonButton = By.xpath("//a[contains(text(),'Log In')]");
    private By signupButton = By.xpath("//a[@class='button filled']");

    public void clickLogon() {
        clickOn(logonButton);
    }

    public void clickSignup(){
        clickOn(signupButton);
    }
}

