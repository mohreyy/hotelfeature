package Login;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageBean.HotelLoginPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	
	private WebDriver driver;
	private HotelLoginPageFactory objhlpg;
	@Then("^check the heading of the page$")
	public void check_the_heading_of_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver=new  FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objhlpg=new HotelLoginPageFactory(driver);                    //
		
		driver.get("file:///D:/Module%203/hotelBooking/login.html");
		
	}

	@When("^user enters valid username,valid password$")
	public void user_enters_valid_username_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objhlpg.setPfname("capgemini");
		objhlpg.setPpwd("capg1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objhlpg.setpLogin();
		driver.close();
	}

	@Then("^navigate to hotelBooking$")
	public void navigate_to_hotelBooking() throws Throwable {
	   ;
		driver.navigate().to("file:///D:/Module%203/hotelBooking/hotelbooking.html");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.close();
		
	}

	@When("^user does not enter either username or password$")
	public void user_does_not_enter_either_username_or_password() throws Throwable {
		objhlpg.setPfname("");
		Thread.sleep(1000);
		
		
	}

	@When("^clicks the login Button$")
	public void clicks_the_login_Button() throws Throwable {
		objhlpg.setpLogin();
		Thread.sleep(1000);
		
	}

	@Then("^display appropriate message$")
	public void display_appropriate_message() throws Throwable {
	   String strHeading=driver.findElement(By.xpath("")).getText();
	   assertEquals(strHeading,"please enter username");
	   
		
		
	}

	@When("^user enters incorrect username or password$")
	public void user_enters_incorrect_username_or_password() throws Throwable {
	    
		
		
	}

	@Then("^display login failed message$")
	public void display_login_failed_message() throws Throwable {
	   String alertMessage=driver.switchTo().alert().getText();
	   
	   driver.switchTo().alert();
	   System.out.println("**********"+ alertMessage);
	}
	
}
