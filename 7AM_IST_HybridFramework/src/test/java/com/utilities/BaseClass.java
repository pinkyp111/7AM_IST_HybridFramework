package com.utilities;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	// Here we use the concept of INHERITANCE.
	//RemoteWebDriver class is assigned to BaseClass file and is extended to FB_new class file.
	//Here BaseClass is the parent and FB_new is the child.
	
	// Whatever we define inside utilities can be accessible by any project
	public static RemoteWebDriver driver;
	public static int randomElement;
	public static String timeStamp;
	
}
