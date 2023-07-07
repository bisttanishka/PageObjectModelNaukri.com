package seleniumtopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Multiple Browser Testing
public class SslCertificateChromeAndFireFox {
static WebDriver driver;

public static void launchBrowser(String browserName) {

	if (browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOptions=new ChromeOptions();
	chromeOptions.setAcceptInsecureCerts(true);
	driver=new ChromeDriver(chromeOptions);
	driver.get("https://self-signed.badssl.com/");
 }
	if(browserName.equalsIgnoreCase("edgedriver")) {
	WebDriverManager.edgedriver().setup();
	EdgeOptions edgeOption=new EdgeOptions();
	edgeOption.setCapability("acceptInsecureCerts", true);
	driver=new EdgeDriver(edgeOption);
	driver.get("https://self-signed.badssl.com/");
	
	}
	
}
@Test (priority=1)
public void launchSSLInChrome() throws InterruptedException {
	
	launchBrowser("Chrome");

	System.out.println("Title in chromebrowser"+ driver.getTitle());
	Thread.sleep(10000);
	driver.close();
	
}
@Test (priority=2)
public void launchSSLEdge() throws InterruptedException {
	
	launchBrowser("Edgedriver");
	System.out.println("Title in edgedriver"+ driver.getTitle());
	Thread.sleep(10000);
	driver.close();
}


	

}
