package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericWrappers extends BaseClass {

	public void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void openFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void openEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public static int getRandomNumber(int maxNumber) {
		Random p = new Random();
		System.out.println("maxNumber is" + " " + maxNumber);

		int randomNumber = p.nextInt(maxNumber);
		System.out.println("The Random number is" + " " + randomNumber);

		if (randomNumber == 0) {
			randomNumber = 1;
			System.out.println("Replacing Random number '0' to " + randomNumber);
		}

		return randomNumber;

	}

	public void clickByAnyLocator(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		// isDisplay
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		} else {
			System.out.println("Element is not enabled state, please check the locator*******");
		}
	}

	public void sendkeysByAnyLocator(By locator, String inputData) throws Exception {
		WebElement element = driver.findElement(locator);
		// isDisplay
		if (element.isDisplayed() && element.isDisplayed()) {
			element.clear();
			element.sendKeys(inputData);
		} else {
			System.out.println("Element is not enabled state, please check the locator*******");
		}
	}

	public static String date() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMMdd_HHmmss");
		String timeStamp = df.format(d);
		return timeStamp;
	}

	public static void screenshot() throws Exception {
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// move the file to local folder
		FileHandler.copy(abc, new File(".\\screenshots\\testSample" + date() + ".PNG"));
	}
	
	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();//5
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());
                     
					// Select  option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
}
