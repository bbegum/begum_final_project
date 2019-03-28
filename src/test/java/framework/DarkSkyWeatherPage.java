package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyWeatherPage extends BasePage {

    private By weatherDate = By.xpath("//div[@class='date']");
    private By hours = By.xpath("//div[@class='hours']//span[@class='hour']//span");

    public String getDate(){ return getTextFromElement(weatherDate);}

    public void verifyTimelineHours(By locator){


        ArrayList<String> hours = new ArrayList<String>();
        List<WebElement> dropdown = SharedSD.getDriver().findElements(By.xpath("//div[@class='hours']//span[@class='hour']//span"));
        ArrayList<Integer> hoursI = new ArrayList<Integer>();


        for (WebElement element : dropdown) {
            hours.add(element.getText().replaceAll("[^0-9?!\\.]",""));
        }

        for (String hoursNum : hours) {
            hoursI.add(Integer.parseInt(hoursNum));


        }



        for(int i =0; i <hoursI.size(); i++){
            for(int j =1; j<hoursI.size(); j++){
                if((hoursI.get(i) +2 == hoursI.get(j))){
                    System.out.println("ok");
                }
            }
        }

    }


}
