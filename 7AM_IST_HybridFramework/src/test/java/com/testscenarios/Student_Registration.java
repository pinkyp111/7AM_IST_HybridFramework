package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.GenericWrappers;

public class Student_Registration extends GenericWrappers {
  @Test
  public void abc() throws Exception {
	  driver.get("https://stqatools.com/demo/index.php");
	  Thread.sleep(2000);
	  sendkeysByAnyLocator(Locators.student_name,"Rahul");
	  sendkeysByAnyLocator(Locators.student_fathername,"Narayan");
	  sendkeysByAnyLocator(Locators.student_postaladdress,"NEW DELHI");
	  sendkeysByAnyLocator(Locators.student_personaladdress,"rahulppp");
	 
	  List<WebElement> radio = driver.findElements(By.name("sex"));		  
			//same group of Radio buttons always have same 'Names', 
			//hence we need to use findElements method and store the list of Web elements.	 
			boolean bval = false;        // create a variable which will have boolean value True/False
			bval = radio.get(0).isSelected()  ; // will return True if button is selected.	 
			if(bval = true)
			{
			radio.get(0).click(); // if the first radio button is selected by default, this will select Second radio button
			}
			else
			{
			radio.get(1).click(); // if the first radio button is not selected by default, the first will be selected
			}
	  selectCustomiseOptionFromTheDropdownValues(Locators.student_city,"NEW DELHI");
	  Thread.sleep(2000);
	  selectCustomiseOptionFromTheDropdownValues(Locators.student_course,"B.TECH");
	  Thread.sleep(2000);
	  selectCustomiseOptionFromTheDropdownValues(Locators.student_district,"UP");
	  Thread.sleep(2000);
	  selectCustomiseOptionFromTheDropdownValues(Locators.student_state,"NEW DELHI");
	  Thread.sleep(3000);
	  sendkeysByAnyLocator(Locators.student_pincode,"680045");
	  sendkeysByAnyLocator(Locators.student_email,"rahulppp@gmail.com");
	  clickByAnyLocator(Locators.student_submit);
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
  
  @AfterClass
	public void afterClass() {
		System.out.println("******************* In afterClass() *******************");
	}
  @AfterTest
	public void afterTest() throws Exception {
		System.out.println("******************* In afterTest() *******************");
		//if (driver != null)
		//	driver.quit();
	}
}
