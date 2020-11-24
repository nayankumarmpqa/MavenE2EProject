package ViaAutoPack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HierarchyPageObjects;
import pageObjects.LoginPageObjects;

public class HeirarchyPageTest extends BaseClass {
	public static Logger log = LogManager.getLogger(HeirarchyPageTest.class.getName());

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
	public void validateLandingPage(String un, String pw, String role) throws IOException {

		log.info("validateLandingPage Test Started");

		// crete obbject and invom=ke methods
		LoginPageObjects lpo = new LoginPageObjects(driver);
		lpo.username().sendKeys(un);
		lpo.password().sendKeys(pw);
		lpo.submitButton().click();
		log.info("submit clicked");
		HierarchyPageObjects hpo = new HierarchyPageObjects(driver);

		System.out.println(hpo.rootNodeName().getText());
		// Assert.assertEquals(lpo.rootNodeName().getText(), "Nayan Kumar");
		Assert.assertTrue(hpo.rootNodeName().isDisplayed());
		// lpo.adminAppswitcher().click();
		// lpo.adinsLogoutButton().click();
		log.info("root node name verified");
	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many dataset
		// columns stands for how many values in once set
		// []rows[]columns

		// 1st set
		Object[][] dataset = new Object[1][3];
		dataset[0][0] = "nayan@wm.com";
		dataset[0][1] = "t3stf1rsT";
		dataset[0][2] = "admin";

		return dataset;

	}

	@AfterTest
	public void teardown() {
		System.out.println("closing the browser after @test run");

		driver.close();
		driver = null; // avoid increase of memory use
	}
}
