package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.GenericWrappers;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class NewTest1 extends GenericWrappers {
  @Test
  public void f() {
	  driver.get("https://www.facebook.com");
	  driver.findElement(By.id("email")).sendKeys("Hialltest@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("myPassowrd@12");
		driver.findElement(By.name("login")).click();
  }
  @BeforeClass
  public void beforeClass() {
	  openChromeBrowser();
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
	  
  }
  

}
