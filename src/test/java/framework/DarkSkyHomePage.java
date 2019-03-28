package framework;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jetty.util.ArrayUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyHomePage extends BasePage {

    private By todaysCloud = By.xpath("//a[1]//span[1]//span[1]//img[1]");
    private By todaysHighTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']");
    private By todaysLowTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']");
    private By todaysTimelineLow = By.xpath("//a[@class='day revealed']//descendant::span[@class='minTemp']");
    private By todaysTimeLineHigh = By.xpath("//a[@class='day revealed']//descendant::span[@class='maxTemp']");
    private By currentTemperature = By.xpath("//span[@class='summary swap']");
    private By timeMachineButton = By.xpath("//a[@class='button']");
    private By firstHourTimeline = By.xpath("//div[@id='timeline']//div[@class='hours']//descendant::span[@class='hour first']");
    private By apiButton = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private String dateLocatorStart = "//td[@data-day='";
    private String dateLocatorEnd = "']";
    private String currentDate = dateLocatorStart + DateUtil.getTodaysDate("d") + dateLocatorEnd;
    private WebElement todaysDate = SharedSD.getDriver().findElement(By.xpath(currentDate));
    private ArrayList<String> hours = new ArrayList<String>();
    private List<WebElement> dropdown = SharedSD.getDriver().findElements(By.xpath("//div[@class='hours']//span[@class='hour']//span"));
    private ArrayList<Integer> hoursI = new ArrayList<Integer>();
    private List<WebElement> degrees = SharedSD.getDriver().findElements(By.xpath("//div[@class='scroll-container']//div[@class='temps']"));
    private int smallestTimeLineTemp;
    private int largestTimeLineTemp;
    private WebElement element = SharedSD.getDriver().findElement(By.xpath("//a[@class='day']//span[@class='tempRange']"));
    private String tempDisplayed = getTextFromElement(currentTemperature);
    private boolean hoursIncrementedByValue = false;



    public void scrollToTimeMachine() throws InterruptedException {
        SharedSD.getDriver().manage().window().maximize();
        scrollToView(timeMachineButton);

    }

    public void clickOnTimeMachineButton() {

        clickOnWithActions(timeMachineButton);
    }

    public void clickTodaysDate() {

        todaysDate.click();


    }

    public boolean verifyTimelineHours(int incremented) {
        changeWebelementListtoString(dropdown, hours);
        changeStringlistoIntegerlist(hours, hoursI);
        changeIntegerlisttoPrimitive(hoursI);

        Integer[] arrayTemp = hoursI.toArray(new Integer[hoursI.size()]);

        int[] array = ArrayUtils.toPrimitive(arrayTemp);


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++)
                if (array[i] + incremented == array[i + 1]) {
                    hoursIncrementedByValue = true;
                    break;
                }
        }
        return hoursIncrementedByValue;


    }

    public String getfirstHourText() {
        String firstHour = getTextFromElement(firstHourTimeline);
        return firstHour;
    }

    public void scrolltoToday() throws InterruptedException {
        scrollDowntoElement(element);
        Thread.sleep(3000);

        clickOn(todaysCloud);


    }

    public String  getHighTemp() {


        String text = getTextFromElement(todaysHighTemp);
        String[] text1 = text.split(" ");
        String highTemp = text1[0];
        return highTemp;

    }

    public String getLowTemp() {


        String word = getTextFromElement(todaysLowTemp);
        String[] word1 = word.split(" ");
        String lowTemp = word1[0];
        return lowTemp;
    }

    public String getLowTimelimeTemp() {


        String templowTimeline = getTextFromElement(todaysTimelineLow);


        return templowTimeline;
    }

    public String getHighTimelineTemp(){
        String temphighTimeline = getTextFromElement(todaysTimeLineHigh);

        return temphighTimeline;
    }

    public int getcurrentDegree() {

        String[] word1 = tempDisplayed.split(" ");

        String currentTemp = word1[0];

        String[] currentTempArray = currentTemp.split("");

        String currentTempDisplayedString = currentTempArray[0] + currentTempArray[1];

        int currentTempDisplayed = Integer.parseInt(currentTempDisplayedString);

        return currentTempDisplayed;
    }

    public void changeDegreestoInteger(){

        ArrayList<String> tempsTimeLine = new ArrayList<>();
        for(WebElement temp: degrees){
            tempsTimeLine.add(temp.getText());
        }
        String[] tempsString = tempsTimeLine.get(0).split("\\u00b0");
        int[] timeLineTemp = changeStringArrtoIntArr(tempsString);
        smallestTimeLineTemp = getSmallestValue(timeLineTemp);
        largestTimeLineTemp = getLargestValue(timeLineTemp);
    }

    public int getLargestTimeLineTemp() {
        return largestTimeLineTemp;
    }

    public int getSmallestTimeLineTemp() { return smallestTimeLineTemp;


    }

    public void clickAPIButton(){
        clickOn(apiButton);
    }





}
