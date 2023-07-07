package seleniumtopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		//To run the Test in headless mode we will use chrome option class. it's is till selenium 3 versions but
		//in selenium 4 we will use diff approach. Generally we use in jenkins pipeline.
		ChromeOptions options=new ChromeOptions();
		//Only the below line 21 we need to added for selenium4 for headless browser. but it support selenium3.
		//options.addArguments("--headless=new");
		
		// To open browser in incognite:
		
		options.addArguments("--incognito");
	   
		
		//options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		//We need to pass the option object of ChromeOptions.to the chromedriver instance 
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
		
	@Test
	public void verifyGoogle() {
	System.out.println(driver.getTitle());
	}
	@AfterTest
	public void closeBrowser() {
	driver.close();

}
}
