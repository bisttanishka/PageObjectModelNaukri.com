package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtility {

	public static void takeScreenshot(WebDriver driver,String destinationPath) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFilePath=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFilePath, new File (destinationPath));
	}
}
