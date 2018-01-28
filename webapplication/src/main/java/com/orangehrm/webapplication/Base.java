package com.orangehrm.webapplication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {

WebDriver driver;
public String browsername;
@Parameters(value="browsername")
@BeforeClass(alwaysRun=true)
public void browserSelect(@Optional("none") String browsername ){
this.browsername=browsername;
driver=AllFunctions.selectBrowser(browsername);
}
	
public WebDriver getDriver() {

	if (driver == null) {
		driver = AllFunctions.selectBrowser(browsername);
	}

	return driver;
}

@AfterClass
public void closeBrowser() throws InterruptedException{
	System.out.println("Browser will be closed in 3 sec");
	Thread.sleep(3000);
	driver.close();
}


}
