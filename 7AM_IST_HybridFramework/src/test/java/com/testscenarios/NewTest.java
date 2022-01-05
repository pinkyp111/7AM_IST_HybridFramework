package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class NewTest extends Locators{
	
	RemoteWebDriver driver;
	@Test
	public void f() {
        //Inheritance example for Locators.
		driver.findElement(fb_email_editbox).sendKeys("Hialltest@gmail.com");
		
		driver.findElement(By.name("pass")).sendKeys("myPassowrd@12");
		driver.findElement(By.name("login")).click();
	}

	@BeforeClass
	public void beforeClass() {

		// System.setProperty("webdriver.chrome.driver",
		// ".\\browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMMdd_HHmmss");
		String timeStamp = df.format(d);
		System.out.println(timeStamp);
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// move the file to local folder
		FileHandler.copy(abc, new File(".\\screenshots\\testSample" + timeStamp + ".PNG"));
	}

}
