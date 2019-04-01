package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class HotelsPackagesPage extends BasePage {

    private By originField = By.xpath("//input[@id='package-origin-hp-package']");
    private By destinationField = By.xpath("//input[@id='package-destination-hp-package']");
    private By departureDate = By.xpath("//input[@id='package-departing-hp-package']");
    private By returnDate = By.xpath("//input[@id='package-returning-hp-package']");
    private By submitButton = By.xpath("//section[contains(@class,'package-form-fields')]//button[contains(@type,'submit')]");


    public void setOriginField(String text){
        setValue(originField, text );
    }
    public void setDestinationField(String text){
        setValue(destinationField, text );
    }
    public void setDepartureDate(String text){
        setValue(departureDate, text );
    }
    public void setReturnDate(String text){
        setValue(returnDate, text );
    }
    public void clickSubmitButton(){
        clickOn(submitButton);
    }
















//    getDriver().findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys("New York, NY (JFK-John F. Kennedy Intl.)");
//    getDriver().findElement(By.xpath("//input[@id='package-destination-hp-package']")).sendKeys("  Orlando, FL (MCO-Orlando Intl.)");
//    getDriver().findElement(By.xpath("//input[@id='package-departing-hp-package']")).sendKeys("04/17/2019");
//    getDriver().findElement(By.xpath("//input[@id='package-returning-hp-package']")).sendKeys("04/30/2019");
//    getDriver().findElement(By.xpath("//section[contains(@class,'package-form-fields')]//button[contains(@type,'submit')]")).click();
//        Thread.sleep(40000);
//
//
//    WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//h1[@class='section-header-main']"))));
//
//    getDriver().findElement(By.xpath("//input[@id='star5']")).click();
//        Thread.sleep(8000);
//    List<WebElement> actualStars = getDriver().findElements(By.xpath("//li[@class='starRating secondary']//descendant::span[@title]"));
//    ArrayList<String> tempStars = new ArrayList<String>();
//
//        for (WebElement temp : actualStars) {
//        tempStars.add(temp.getAttribute("title"));
//    }
//
//    int[] arr = new int[tempStars.size()];
//         for(int i =0; i<tempStars.size(); i++){
//        arr[i] = Integer.parseInt(tempStars.get(i).replaceAll(".0", ""));
//        System.out.println(arr[i]);
//    }












}
