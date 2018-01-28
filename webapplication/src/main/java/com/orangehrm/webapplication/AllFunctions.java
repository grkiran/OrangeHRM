package com.orangehrm.webapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class AllFunctions {

public static WebDriver selectBrowser(String browser) {
	WebDriver driver=null;
	String browsername;
	Properties pro;
		
		if(browser.equalsIgnoreCase("none")){
		pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("detail.properties")));
		} catch (Exception e) {
			throw new Error("Config.pro not found");
		} finally {
		} 
		browsername= pro.getProperty("browser");
		System.out.println(browsername);
		}
		else
		{
			browsername=browser;
		}
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resource/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "ff":
			System.setProperty("webdriver.gecko.driver", "src/test/resource/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/test/resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("pls check browser name");
			break;
		}
		return driver;
}

public static void type(WebDriver driver,By by,String data){
	driver.findElement(by).sendKeys(data);
	driver.findElement(by).click();
	//AllFunctions.type(driver,By.id("txtUsername"),"admin");
}
}

