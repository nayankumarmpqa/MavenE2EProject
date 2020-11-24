package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HierarchyPageObjects {

	public WebDriver driver;

	/*
	 * Below I am creating a constructor so that I can initiate and use object
	 * 'driver' from Test case class and in the test case classes it is coming from
	 * base class It is required again similar to Base class
	 */

	public HierarchyPageObjects(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//--------------------------------------	

	private @FindBy(css = "#wrap > header > div > div.navbar-items > ul.nav.navbar-nav.navbar-right.personal > li.app-navigator.ng-scope > a") WebElement adminAppswitcher;

	public WebElement adminAppswitcher() {
		return adminAppswitcher;
	}
	// ----------------------------------------

	private @FindBy(xpath = "//*[@id=\"wrap\"]/header/div/div[2]/ul[2]/li[2]/ul/li[5]/a") WebElement adminLogoutButton;

	public WebElement adinsLogoutButton() {
		return adminLogoutButton;
	}

	// ----------------------------------------

	@FindBy(xpath = "//*[@id=\"14598_anchor\"]")
	WebElement rootNodeName;

	public WebElement rootNodeName() {
		return rootNodeName;
	}

	// ----------------------------------------

	@FindBy(xpath = "//a [contains(text(), 'Request revision')]")
	WebElement NodeRR;

	public WebElement nodeRR() {
		return NodeRR;
	}

	// ----------------------------------------

		@FindBy(xpath = "//a [contains(text(), 'Group Template')]")
		WebElement groupTemplateTab;

		public WebElement groupTemplateTab() {
			return groupTemplateTab;
		}
	// ----------------------------------------

	@FindBy(xpath = "//a [contains(text(), 'RR Course GT ')]")
	WebElement courseTyopGroup;

	public WebElement courseTyopGroup() {
		return courseTyopGroup;
	}

	// ----------------------------------------

	@FindBy(xpath = "//a [contains(text(), 'Activity Scheduler')]")
	WebElement activitySchedulerTab;

	public WebElement activitySchedulerTab() {
		return activitySchedulerTab;
	}

}
