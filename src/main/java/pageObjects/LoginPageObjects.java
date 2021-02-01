package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	public WebDriver driver;

	/*Below I am creating a constructor so that I can initiate and use
	 *  object 'driver' from Test case class and in the test case classes
	 *  it is coming from base class
	It is required again similar to Base class
		*/
	
	
	public LoginPageObjects(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	
	private @FindBy(xpath = "//*[@id=\"input-login-username\"]")
	WebElement username;
	
	public WebElement username() {
		return username;
	}
//---------------------------------------------	
	private @FindBy(id = "input-login-password")
	WebElement password;
	

	public WebElement password() {
		// TODO Auto-generated method stub
		return password;
	}
	
//---------------------------------------------
	
	private @FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement submit;
		
	public WebElement submitButton() {
		// TODO Auto-generated method stub
		return submit;
	}
	/*public ViaLandingPF submit() {
		submit.click();
		ViaLandingPF lp = new ViaLandingPF(driver);
		return lp;
		
	}*/
	
	
//--------------------------------------	

		private @FindBy(xpath = "//*[@id=\"wrap\"]/header/div/div[2]/ul[2]/li[2]/a")
		WebElement adminAppswitcher;
		
		public WebElement adminAppswitcher() {
			return adminAppswitcher;
		}
	//----------------------------------------	
		
		private @FindBy(xpath = "//*[@id=\"wrap\"]/header/div/div[2]/ul[2]/li[2]/ul/li[5]/a")
		WebElement adminLogoutButton;
		
		public WebElement adinsLogoutButton() {
			return adminLogoutButton;
		}
		
		
		//----------------------------------------	
		
				@FindBy(xpath = "//*[@id=\"14598_anchor\"]")
				WebElement rootNodeName;
				
				public WebElement rootNodeName() {
					return rootNodeName;
				}
				
				
}
