package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class HotelsResultsPage extends BasePage {

    private By fiveStars = By.xpath("//label[@id='star5-label']");
    private By fourStars = By.xpath("//label[@id='star4-label']");
    private By threeStars = By.xpath("//label[@id='star3-label']");
    private By actualStars = By.xpath("//li[@class='starRating secondary']//descendant::span[@title]");
    private By hotelDistance = By.xpath("//li[@class='distance secondary tabAccess']");
    private By relitaveHotels = By.xpath("preceding-sibling::li[3]/h4");
    private ArrayList<WebElement> closeHotels = new ArrayList<WebElement>();


    public void clickOnFiveStars() {
        clickOn(fiveStars);
    }

    public void clickOnFourStars() {
        clickOn(fourStars);
    }

    public void clickOnThreeStars() {
        clickOn(threeStars);
    }

    public String getStarNumbers() {
        List<WebElement> actualStars = SharedSD.getDriver().findElements(By.xpath("//li[@class='starRating secondary']//descendant::span[@title]"));
        ArrayList<Character> tempStars = new ArrayList<Character>();
        for (WebElement temp : actualStars) {
            tempStars.add(temp.getAttribute("title").charAt(0));
        }
        int[] stars = new int[tempStars.size()];
        for (int i = 0; i < tempStars.size(); i++) {
            stars[i] = Character.getNumericValue(tempStars.get(i));
        }
        if (areSame(stars)) {
            return (String.valueOf(stars[0]));
        }
        return "error";
    }

    public ArrayList getlistofHotels(int miles) {

        List<WebElement> distance = SharedSD.getDriver().findElements(hotelDistance);



        for (WebElement temp : distance) {
            String string = temp.getText().replaceAll("km from Orlando Intl\\. \\(MCO\\)", "");
            Double number = (Double.valueOf(string)) * 0.621371;
            if (number < miles) {
                List<WebElement> hotels = (temp.findElements(relitaveHotels));
                for (WebElement i : hotels) {
                    closeHotels.add(i);
                }
            }

        }

        return closeHotels;
    }


    public void verifyHotelisWithinRange(String hotel) {

        for (WebElement temp : closeHotels) {
            if (temp.getText().toLowerCase().contains(hotel)) {
                System.out.println(temp.getText());
            }
        }
    }





    }




