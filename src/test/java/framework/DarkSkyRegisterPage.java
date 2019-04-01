package framework;

import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class DarkSkyRegisterPage extends BasePage {


 private By registerButton = By.xpath("//a[@class='button filled']");
 private By emailField = By.name("email");

 public void clickRegisterButton(){
     clickOn(registerButton);
 }

 public String geterrorMessage(){

     String errorMessage = getAttribute(emailField, "validationMessage");

     return errorMessage;
 }



//    getDriver().findElement(By.xpath("//button[@type='submit']")).click();
//        Thread.sleep(4000);
//
//    String message = getDriver().findElement(By.name("email")).getAttribute("validationMessage");
//
//        System.out.println(message);



}
