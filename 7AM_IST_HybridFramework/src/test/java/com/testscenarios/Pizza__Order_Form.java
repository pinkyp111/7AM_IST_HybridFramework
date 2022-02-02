package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

public class Pizza__Order_Form extends GenericWrappers {
	@Test
	public void pizzaorder() throws Exception {

		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/inputdata.properties");
		prop.load(fi);

		driver.get(prop.getProperty("Pizza_url"));
		clickByAnyLocator(Locators.pizza1_dropdown_opt2);
		clickByAnyLocator(Locators.toppings1_dropdown_opt7);
		clickByAnyLocator(Locators.toppings2_dropdown_opt4);
		sendkeysByAnyLocator(Locators.quantity_input, "2");

		sendkeysByAnyLocator(Locators.name_input, "Pinky");
		sendkeysByAnyLocator(Locators.email_input, "pinky@gmail.com");
		sendkeysByAnyLocator(Locators.phone_input, "9929928222");
		selectRadioButtonByLocator(Locators.payment_radio_input);

		clickByAnyLocator(Locators.pizza_placeOrder_button);
		Thread.sleep(1000);
		String actualPopupText = driver.findElement(Locators.pizza_successOrder_dialog).getText();
		String expectedPopupText = "Thank you for your order! TOTAL: 13.5 Small 6 Slices - no toppings";
		String failedExpectedPopupText = "Thank you for your order! TOTAL: 13.5 Small 6 Slices - no toppings***";

		testHardAsserts(prop, actualPopupText, expectedPopupText, failedExpectedPopupText);
//		testSoftAsserts(prop, actualPopupText, expectedPopupText, failedExpectedPopupText);

	}
	
	private static void testHardAsserts(Properties prop, String actualPopupText, String expectedPopupText, String failedExpectedPopupText) {
		
		String expectedUrl = prop.getProperty("Pizza_url");
		String actualUrl = driver.getCurrentUrl();
		System.out.println("expectedUrl=" + expectedUrl + "\nActual url=" + actualUrl);

		Assert.assertEquals(actualUrl, expectedUrl, "check1:Actual page url is not the same as expected");
		System.out.println("Hard Assert-1 executed");

		Assert.assertEquals(actualPopupText, failedExpectedPopupText,
				"check2:Actual popup text does not match expected popup text"); // this assert will fail
		System.out.println("Hard Assert-2 executed");

		Assert.assertEquals(actualPopupText, expectedPopupText,
				"check3:Actual popup text does not match expected popup text");
		System.out.println("Hard Assert-3 executed");

	}

	private static void testSoftAsserts(Properties prop, String actualPopupText, String expectedPopupText, String failedExpectedPopupText) {
		// soft assert
		SoftAssert sa = new SoftAssert();
		String expectedUrl = prop.getProperty("Pizza_url");
		String actualUrl = driver.getCurrentUrl();
		System.out.println("expectedUrl=" + expectedUrl + "\nActual url=" + actualUrl);

		sa.assertEquals(actualUrl, expectedUrl, "check1:Actual page url is not the same as expected");
		System.out.println("Soft Assert-1 executed");

		sa.assertEquals(actualPopupText, failedExpectedPopupText,
				"check2:Actual popup text does not match expected popup text"); // this assert will fail
		System.out.println("Soft Assert-2 executed");

		sa.assertEquals(actualPopupText, expectedPopupText,
				"check3:Actual popup text does not match expected popup text");
		System.out.println("Soft Assert-3 executed");

		sa.assertAll();
	}

//Cross browser testing
	@Parameters("browsername")

	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsername) {
		System.out.println("******************* In beforeClass() *******************");
		if (browsername.equalsIgnoreCase("chrome")) {
			openChromeBrowser();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			openFirefoxBrowser();
		} else if (browsername.equalsIgnoreCase("edge")) {
			openEdgeBrowser();
		} else {
			System.out.println("Type valid browsername");
		}

	}

}
