package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterClass;

public class JRIAccount_creation extends GenericWrappers {
	@Test
	public void f() throws Exception {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/inputdata.properties");
		prop.load(fi);

		driver.get(prop.getProperty("JriUrl"));

		driver.findElement(Locators.jri_create_account_link).click();

		driver.findElement(Locators.jri_name).sendKeys(prop.getProperty("JriName"));

		driver.findElement(Locators.jri_mobilenumber).sendKeys(prop.getProperty("Jrimobilenumber"));

		driver.findElement(Locators.jri_email).sendKeys(prop.getProperty("Jriemail"));

		driver.findElement(Locators.jri_password).sendKeys(prop.getProperty("Jripassword"));

		driver.findElement(Locators.jri_submitbutton).click();

	}

	@BeforeClass
	public void beforeClass() {
		openChromeBrowser();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
