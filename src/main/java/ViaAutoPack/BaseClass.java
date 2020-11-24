package ViaAutoPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public  Properties propobj;
	public static WebDriver driver; //make diver static only if you will run test non parallel 
	
	public WebDriver browserInitialize() throws IOException {
		
				// chrome
				// Use java.util and import a properties class and create its object.
				// this class interpret
		propobj = new Properties();

				// The object is ready to scan the file and in order to tell the file location use below
				// With the help of Java FileInputStream which will actually point where my
				// file lies by providing a path as an argument for this class.
				// Right click on properties file and copy the path and paste it as an argument
				// to the FileInputStream class.

				FileInputStream propfileloc = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ViaAutoPack\\KeyValueFile.properties");
				// Now propfileloc knows where the file lies.
				// to integrate both objects and talk to each other.

				// This method expecting propfileloc object so that catch the path for
				// interpretation
				// amek sure we have added the Add throws declataiton i.e IOExc line no. 13
				propobj.load(propfileloc);
				// mvn test -Dbrowser=chrome
				
				
				// How to use the key mentioned in the properties file. use getProperty()
				// method.
				System.out.println("browser name in properties file is =" + propobj.getProperty("browser"));
				
				// String browserName = propobj.getProperty("browser"); //Use this is wanna read propobj
				System.out.println("browser name in Jenkins is =" + System.getProperty("browser"));
				
				String browserName = System.getProperty("browser");

				//if (browserName.equals("chrome")) {
			
				if (browserName.contains("chrome")) {	
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver83.exe");
					
					ChromeOptions options= new ChromeOptions();
						if (browserName.contains("headless")) {
									options.addArguments("headless");
									}
					driver = new ChromeDriver(options);
				} else if (browserName.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
					driver = new FirefoxDriver();
				} else {
					System.out.println("we have only chrome driver at my computer");
				}

				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // Managing time out
				return driver;
			}
	
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		//Above method can be called only if it has testcase name and a driver from the failing test case class
		// Arguments are coming from Listeners class
		
		
		//Using the received WebDriver driver I am taking screenshot
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		
		//Path where I wanna save the screenshots as a String 
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+" failed.png";
		// now use Java utility
		FileUtils.copyFile(src, new File(destinationFile));
		// I was getting some errors and used dependency mentioned in
		//import org.apache.commons.io.FileUtils;
		//AND http://zetcode.com/java/copyfile/
		
		

	}
}