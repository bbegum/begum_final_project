package framework;

import org.openqa.selenium.By;

public class DarkSkyLoginPage extends BasePage {


    private By emailfield = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public void enterEmail(String text){
        setValue(emailfield, text);

    }

    public void enterPassword(String text){
        setValue(passwordField, text);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }


}
