package PageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HotelLoginPageFactory {
	
	WebDriver driver;
	//step 1: identify elements
	@FindBy(name="userName")
	@CacheLookup             //temporarily store value
	WebElement pfname;
	
	@FindBy(how=How.NAME, using ="userPwd")
	@CacheLookup
	WebElement ppwd;
	
	@FindBy(className="btn")
	@CacheLookup
	WebElement pLogin;
	
	
	public HotelLoginPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//setters

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void setPfname(String pname) {
		pfname.sendKeys(pname)  ;
	}


	public void setPpwd(String spwd) {
		ppwd.sendKeys(spwd) ;
	}


	public void setpLogin() {
	pLogin.click();
	}
	
	
	
	


}
