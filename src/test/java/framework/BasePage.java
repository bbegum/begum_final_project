package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import stepdefinition.SharedSD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdownText(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdownIndex(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public void mouseOver(By locator) {


		WebElement element = SharedSD.getDriver().findElement(locator);
		Actions actions = new Actions(SharedSD.getDriver());
		actions.moveToElement(element).build().perform();

	}

	public void clickOnWithActions(By locator) {
		WebElement element = SharedSD.getDriver().findElement(locator);

		Actions actions = new Actions(SharedSD.getDriver());

		actions.moveToElement(element).click().build().perform();
	}

	public void clickThroughLists(By locator, String text) {
		List<WebElement> list = SharedSD.getDriver().findElements(locator);
		for (WebElement lists : list) {
			if (lists.getText().equals(text)) {
				lists.click();
			}
		}


	}

	public void scrollToView(By locator) {

		WebElement element = SharedSD.getDriver().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void changeWebelementListtoString(List<WebElement> webElements, ArrayList<String> text) {

		for (WebElement element : webElements) {
			text.add(element.getText().replaceAll("[^0-9?!\\.]", ""));
		}
	}

	public void changeStringlistoIntegerlist(ArrayList<String> text, ArrayList numbers) {

		for (String hoursNum : text) {
			numbers.add(Integer.parseInt(hoursNum));
		}


	}

	public int[] changeIntegerlisttoPrimitive(ArrayList<Integer> numbers){
		Integer[] wrapperArr = numbers.toArray(new Integer[numbers.size()]);

		int[] array = ArrayUtils.toPrimitive(wrapperArr);

		return array;
	}

	public void scrollDowntoElement(WebElement element) throws InterruptedException {

		((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);

	}

	public int[] changeStringArrtoIntArr(String[] array){

		int[] arrayInt = new int[array.length];
		for(int i = 0; i <array.length; i++){
			arrayInt[i]= Integer.parseInt(array[i].trim());
		}

		return arrayInt;

	}

	public int getSmallestValue(int[] array){

		int temp = array[0];
		for(int i =0; i<array.length; i++){
			if(temp >array[i]){
				temp = array[i];
			}
		}

		return temp;

	}

	public int getLargestValue(int[] array){

		int temp = array[0];
		for(int i =0; i<array.length; i++){
			if(temp<array[i]){
				temp=array[i];
			}
		}

		return temp;
	}

	public void waitForElementToBeClickable(By locator){
		WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}

