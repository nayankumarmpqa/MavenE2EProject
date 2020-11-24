package ViaAutoPack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;

public class LoginPage extends BaseClass {

	public static Logger log = LogManager.getLogger(LoginPage.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = browserInitialize();
		log.info("Browser initialized");

		driver.get(propobj.getProperty("url"));
		log.info("Navigated to URL");

		driver.manage().window().maximize();
		log.info("Maximized the brwoser");

	}

	@Test(dataProvider = "getData")
	public void validateLoginPage(String un, String pw, String role) throws IOException {

		log.info("validateLoginPage Test Started");
try
{
	
		// crete obbject and invom=ke methods
		LoginPageObjects lpo = new LoginPageObjects(driver);
		lpo.username().sendKeys(un);
		lpo.password().sendKeys(pw);
		log.info("Username/PW entered");
		lpo.submitButton().click();
		log.info("Submit clicked");
		lpo.adminAppswitcher().click();
		lpo.adinsLogoutButton().click();
		log.info("Logout successful");
}
catch(Exception e)
{
	System.out.println("Could not find the element try exception");
}

	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many dataset
		// columns stands for how many values in once set
		// []rows[]columns

		// 1st set
		Object[][] dataset = new Object[2][3];
		dataset[0][0] = "nayan@wm.com";
		dataset[0][1] = "t3stf1rsT";
		dataset[0][2] = "admin";

		// Second set

		dataset[1][0] = "sbunch@email.edu";
		dataset[1][1] = "t3stf1rsT";
		dataset[1][2] = "Faculty";

		return dataset;

	}

	@AfterTest
	public void teardown() {
		System.out.println("closing the browser after @test run");

		driver.close();
		driver = null; // avoid increase of memory use
	}
}
