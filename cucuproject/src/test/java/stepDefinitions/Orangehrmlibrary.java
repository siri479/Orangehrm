package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Orangehrmlibrary {
	
private static WebDriver driver;
String empid;


@Given("^i open the browser with url \"([^\"]*)\"$")
public void i_open_the_browser_with_url(String url) 

{ 
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(url);	


}
  

@Then("^i should see login page$")
public void i_should_see_login_page() 
{
	if (driver.findElement(By.id("btnLogin")).isDisplayed()) {
		
	 System.out.println("app launch sucess");
		
	}
}

@When("^i enter username as \"([^\"]*)\"$")
public void i_enter_username_as(String uname) 
{
	driver.findElement(By.id("txtUsername")).sendKeys(uname);
}

@When("^i enter password as \"([^\"]*)\"$")
public void i_enter_password_as(String pword) 

{ driver.findElement(By.id("txtPassword")).sendKeys(pword);
}

@When("^i click login$")
public void i_click_login() 
{
	driver.findElement(By.id("btnLogin")).click();
}

@Then("^i should see admin module$")
public void is_should_see_admin_module() 
{ 
	if(driver.findElement(By.linkText("Admin")).isDisplayed()) {
		
		System.out.println("Admin module displayed");
}}

@When("^i click logout$")
public void i_click_logout() 

{ 
	driver.findElement(By.id("welcome")).click();
	driver.findElement(By.linkText("Logout")).click();
}

@Then("^i close browser$")
public void i_close_browser() 
{
	driver.close();
}

@Then("^is errormessage displayed$")
public void is_errormessage_displayed()
{  
	String errmsg = driver.findElement(By.id("spanMessage")).getText();
	if (errmsg.toLowerCase().contains("invalid credentials")) 
	{ System.out.println("Err msg displayed");
		
	}
}


@When("^i goto add employee page$")
public void i_goto_add_employee_page() 
{ 
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
}

@When("^i enter firstname as \"([^\"]*)\"$")
public void i_enter_firstname_as(String fname) 
{
	driver.findElement(By.id("firstName")).sendKeys(fname);
	
}

@When("^i enter last name as \"([^\"]*)\"$")
public void i_enter_last_name_as(String lname) 
{
	driver.findElement(By.id("lastName")).sendKeys(lname);
}

@When("^click save$")
public void click_save() 
{
	empid = driver.findElement(By.id("employeeId")).getAttribute("value");
	driver.findElement(By.id("btnSave")).click();
}

@Then("^i should see registered employee in employee list$")
public void i_should_see_registered_employee_in_employee_list() 
{
	 driver.findElement(By.linkText("PIM")).click();
	 driver.findElement(By.linkText("Employee List")).click();
	 driver.findElement(By.id("empsearch_id")).sendKeys(empid);
	 driver.findElement(By.id("searchBtn")).click();
	 
	 
	 WebElement emptable = driver.findElement(By.id("resultTable"));
	 List<WebElement> rows = emptable.findElements(By.tagName("tr"));
	 boolean addemp = false;
for (int i = 1; i < rows.size(); i++) {
	
	List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
	
	if (col.get(1).getText().equalsIgnoreCase(empid)) {
		
		addemp = true;
		break;
		
	}
	}
if (addemp) {
	System.err.println("empadding test pass");
	
}else
	
{ System.err.println("empadding test fail");
	
}

}
}
	


