package TestRunners;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class adminlogin {
	
	
	@Test
	public void adminlogini(String br) throws MalformedURLException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		
		URL huburl = new URL("http://192.168.69.83:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(huburl, cap);
		
		driver.get("http://orangehrm.qedgetech.com");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
	}

}



