package framework;

import org.openqa.selenium.By;

public class MessengerLoginPage extends BasePage{

    private By errorMessage = By.id("");

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}
