package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.BaseClass;
import com.utilities.GenericWrappers;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class Assignment10_blazedemo extends GenericWrappers {
	@Test
	public void f() throws Exception {
		driver.get("https://blazedemo.com/"); // input test data
		driver.manage().window().maximize();

		// To select random DEPARTURE city
		BaseClass.randomElement = getRandomNumber(7);
		System.out.println("The Random departure city is" + " " + BaseClass.randomElement);
		if (BaseClass.randomElement == 0) {
			BaseClass.randomElement = 1;
			System.out.println("The Random from city if '0' selected is changed to" + BaseClass.randomElement);
		}
		driver.findElement(Locators.blaze_selectdeparture).click();
		///// doubt
//		driver.findElement(By.xpath("//select[@name='fromPort']/option[" + randomdepar + "]")).click();
		driver.findElement(Locators.blaze_selectdeparture_1).click();

		String departure = driver.findElement(Locators.blaze_selectdeparture_1).getAttribute("value");
		System.out.println("The selected departure city name is" + " " + departure);

		// To select random DESTINATION city
		BaseClass.randomElement = getRandomNumber(7);
		System.out.println("The Random destination city is" + " " + randomElement);

		if (BaseClass.randomElement == 0) {
			BaseClass.randomElement = 1;
			System.out.println("The Random destination city if '0' selected is changed to" + BaseClass.randomElement);
		}
		driver.findElement(Locators.blaze_selectdestination).click();
		driver.findElement(Locators.blaze_selectdestination_1).click();
		String destination = driver.findElement(Locators.blaze_selectdestination_1).getAttribute("value");
		System.out.println("The selected destination city name is" + " " + destination);
		// to click SUBMIT
		Thread.sleep(3000);
		driver.findElement(Locators.blaze_submit).click();
		Thread.sleep(3000);

		// Choose flight
		BaseClass.randomElement = getRandomNumber(5);
		driver.findElement(Locators.blaze_chooseflight).click();

		// Input Passenger data
		driver.findElement(Locators.blaze_inputname).sendKeys("Pinky"); // test data
		driver.findElement(Locators.blaze_address).sendKeys("Cave Creek Road");// test data
		driver.findElement(Locators.blaze_city).sendKeys("Phoenix");// test data
		driver.findElement(Locators.state).sendKeys("Arizona");// test data
		driver.findElement(Locators.zipcode).sendKeys("85050"); // test data
		Thread.sleep(3000);

		// Enter card details
		BaseClass.randomElement = getRandomNumber(3);
		driver.findElement(Locators.blaze_randomcard).click();
		Thread.sleep(3000);

		String selectedCard = driver.findElement(Locators.blaze_randomcard).getAttribute("value");
		System.out.println("Visa type" + " " + selectedCard);

		driver.findElement(Locators.creditcard_number).sendKeys("123456789"); // test data
		driver.findElement(Locators.creditcard_month);
		driver.findElement(Locators.creditcard_year);
		driver.findElement(Locators.creditcard_name).sendKeys("Pinky Francis"); // test data
		Thread.sleep(3000);
		driver.findElement(Locators.final_submit).click();
		Thread.sleep(3000);
		// Final submit
		
		String message = driver.findElement(Locators.final_submit1).getText();
		System.out.println("message" + message);
	}

	@BeforeClass
	public void beforeClass() {
		openChromeBrowser();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
