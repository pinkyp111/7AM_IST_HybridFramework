package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

public class Applevacations extends GenericWrappers {
  @Test
  public void f() throws Exception {
	    
 if (driver != null) {

		
driver.get("https://www.applevacations.com/");
driver.findElement(By.xpath("//input[@id='orgAC_value']")).sendKeys("Chi");
//driver.findElement(By.xpath("//a[@class='block-buttontext']")).click();
	
  }
}
  
  
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