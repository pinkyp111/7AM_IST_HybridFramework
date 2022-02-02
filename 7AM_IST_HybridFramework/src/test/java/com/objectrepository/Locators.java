package com.objectrepository;

import org.openqa.selenium.By;

import com.utilities.BaseClass;

public class Locators extends BaseClass {

	public static final By fb_email_editbox = By.id("email");
	public static final By fb_login = By.name("login");
	public static final By fb_password = By.name("pass");

	public static final By jri_create_account_link = By.id("signup-link9");
	public static final By jri_name = By.id("signup_name");
	public static final By jri_mobilenumber = By.id("signup_mobileno");
	public static final By jri_email = By.id("signup_email");
	public static final By jri_password = By.id("signup_password");
	public static final By jri_checkbox = By.id("//*[@id=\\\"checkbox\\");
	public static final By jri_submitbutton = By.id("imgbtnSubmit");

	public static final By blaze_selectdeparture = By.xpath("//select[@name='fromPort']");
	public static final By blaze_selectdeparture_1 = By
			.xpath("//select[@name='fromPort']/option[" + randomElement + "]");
	public static final By blaze_selectdestination = By.xpath("//select[@name='toPort']");
	public static final By blaze_selectdestination_1 = By
			.xpath("//select[@name='toPort']/option[" + randomElement + "]");
	public static final By blaze_submit = By.xpath("//input[@type='submit']");
	public static final By blaze_chooseflight = By.xpath("//tr[" + randomElement + "]/td[1]/input[@type='submit']");
	public static final By blaze_inputname = By.xpath("//input[@id='inputName']");
	public static final By blaze_address = By.xpath("//input[@id='address']");
	public static final By blaze_city = By.xpath("//input[@name='city']");
	public static final By state = By.xpath("//input[@id='state']");
	public static final By zipcode = By.xpath("//input[@name='zipCode']");
	public static final By blaze_randomcard = By.xpath("//select[@name='cardType']/option[" + randomElement + "]");
	public static final By creditcard_number = By.xpath("//input[@id='creditCardNumber']");
	public static final By creditcard_month = By.xpath("//input[@id='creditCardMonth']");
	public static final By creditcard_year = By.xpath("//input[@id='creditCardYear']");
	public static final By creditcard_name = By.xpath("//input[@id='nameOnCard']");
	public static final By final_submit = By.xpath("//input[@type='submit']");
	public static final By final_submit1 = By.xpath("/html/body/div[2]/div/h1");
	
	public static final By student_name=By.xpath("//input[@id='studentname']");
	public static final By student_fathername=By.id("fathername");
	public static final By student_postaladdress=By.id("paddress");
	public static final By student_personaladdress=By.id("personaladdress");
	public static final By student_city =  By.name("City");
	public static final By student_course =  By.name("Course");
	public static final By student_district =  By.name("District");
	public static final By student_state =  By.name("State");
	public static final By student_pincode =  By.id("pincode");
	public static final By student_email =  By.id("emailid");
	public static final By student_submit=By.xpath("//input[@value='Submit Form']");
	
	// pizza page
	public static final By pizza1_dropdown_opt2 = By.xpath("//*[@id='pizza1Pizza']/option[2]"); 
	public static final By toppings1_dropdown_opt7 = By.xpath("//*[@id='pizza1']/select[2]/option[7]");
	public static final By toppings2_dropdown_opt4 = By.xpath("//*[@id='pizza1']/select[3]/option[4]");
	public static final By quantity_input = By.xpath("//*[@id='pizza1Qty']");
	//*[@id="name"]
	public static final By name_input = By.xpath("//*[@id='name']");
	public static final By email_input = By.xpath("//*[@id='email']");
	public static final By phone_input = By.xpath("//*[@id='phone']");
	public static final By payment_radio_input = By.xpath("//*[@name='payment']");
	public static final By pizza_placeOrder_button = By.xpath("//*[@id='placeOrder']");
	public static final By pizza_successOrder_dialog = By.xpath("//*[@id='dialog']/p");




}