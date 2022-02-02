package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

public class FB_DataDriven extends GenericWrappers {

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
	public void afterMethod(ITestResult abc) throws Exception {
		System.out.println("******************* In afterMethod() *******************");
		screenshot();
		

		// To put the screenshot.PNG in a format more readable.
		// STATUS_PackageName.Classname_Methodname_Timestamp.PNG
		// Pass_com.testscenarios.FB_new_f_05Jan2022071655.PNG

		projectDir = System.getProperty("user.dir");
		screenshotPath = projectDir + "\\screenshots";
		className = abc.getTestClass().getName().trim();
		methodname = abc.getName().trim();
		if (abc.getStatus() == ITestResult.SUCCESS) {
			File mno = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(mno, new File("pass" + "_" + className + "_" + methodname + date() + ".PNG"));

		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		System.out.println("******************* In afterTest() *******************");
		if (driver != null)
			driver.quit();
	}

}
