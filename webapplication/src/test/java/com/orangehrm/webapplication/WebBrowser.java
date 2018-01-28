package com.orangehrm.webapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WebBrowser extends Base {

	String url="http://opensource.demo.orangehrmlive.com/";
	
	
	@Test
	public void browser()
	{
		driver.get(url);
		driver.findElement(By.id("txtUsername")).clear();
		AllFunctions.type(driver,By.id("txtUsername"),"admin");
		AllFunctions.type(driver,By.id("txtPassword"),"admin");
		driver.findElement(By.id("btnLogin")).click();
	}
}
