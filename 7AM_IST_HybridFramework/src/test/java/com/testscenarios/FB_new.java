package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

public class FB_new extends GenericWrappers {

	@Test
	public void fbTest() throws Exception {
		System.out.println("******************* In fbTest() *******************");

		if (driver != null) {

			Properties prop = new Properties();
			FileInputStream fi = new FileInputStream("./src/test/resources/testdata/inputdata.properties");
			prop.load(fi);

			driver.get(prop.getProperty("Fb_Url"));
			sendkeysByAnyLocator(Locators.fb_email_editbox, prop.getProperty("Fb_email"));
			// driver.findElement(Locators.fb_email_editbox).sendKeys(prop.getProperty("Fb_email"));

			sendkeysByAnyLocator(Locators.fb_password, prop.getProperty("Fb_password"));
			// driver.findElement(Locators.fb_password).sendKeys(prop.getProperty("Fb_password"));

			clickByAnyLocator(Locators.fb_login);
			// driver.findElement(By.name("login")).click();
		}
	}
@Test
public void xyz() throws Exception {
	driver.navigate().to("https://stqatools.com/demo/index.php");
	Thread.sleep(5000);
}
	// Cross browser testing
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

	@AfterClass
	public void afterClass() {
		System.out.println("******************* In afterClass() *******************");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		System.out.println("******************* In afterMethod() *******************");
		screenshot();
	}

	@AfterTest
	public void afterTest() throws Exception {
		System.out.println("******************* In afterTest() *******************");
		if (driver != null)
			driver.quit();
	}

}
