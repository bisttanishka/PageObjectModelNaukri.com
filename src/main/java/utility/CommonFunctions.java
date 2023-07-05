package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class CommonFunctions {

	public static void pageLoadTimeOut(WebDriver driver, int timeUnit) {
		driver.manage().timeouts().pageLoadTimeout(timeUnit, TimeUnit.MILLISECONDS);
	
	
	}
}
