package resumeautomation.naukritestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import resumeautomation.naukrihomepage.NaukriHomePage;
import utility.CommonFunctions;
import utility.GetValue;
import utility.ScreenshotsUtility;

public class ResumeUploadData {

	WebDriver driver;
	NaukriHomePage naukrihomepage;

	@BeforeTest
	public void Browser() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(GetValue.readProperty("url"));
		CommonFunctions.pageLoadTimeOut(driver, 10000);
//driver.manage().window().maximize();
		naukrihomepage = new NaukriHomePage(driver);

	}

	@Test
	public void naukri() throws IOException, InterruptedException

	{

		String display = naukrihomepage.logindisplayed.getText();
		Assert.assertEquals(display, "Login");
		System.out.println("Login Button is displayed as " + display);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(naukrihomepage.login));
		element.click();
		ScreenshotsUtility.takeScreenshot(driver,
				System.getProperty("user.dir") + "/src/main/java/screenshots/loginpage.png");
		CommonFunctions.pageLoadTimeOut(driver, 15000);// if you are calling same line of code again and again without
														// making generic functions That is called dublicay.
		naukrihomepage.loginApplication(GetValue.readProperty("username"), GetValue.readProperty("password"));
		CommonFunctions.pageLoadTimeOut(driver, 15000);
		Thread.sleep(5000);// Thread.sleep will stop the execution of the program for the given time
							// period.In this line the program will pause for 10 sec.
		boolean diplay = naukrihomepage.titleDisplay.isDisplayed();
		Assert.assertEquals(diplay, true, "Title is not displayed");
		boolean viewDisplay = naukrihomepage.viewProfileLink.isDisplayed();
		Assert.assertEquals(viewDisplay, true, "ProfileLink is not displayed");
		ScreenshotsUtility.takeScreenshot(driver,
				System.getProperty("user.dir") + "/src/main/java/screenshots/Homepage.png");
		naukrihomepage.viewProfileLink.click();
		Thread.sleep(3000);
		String verifyCvButton = naukrihomepage.verifyUpdateCv.getAttribute("value");
		Assert.assertEquals(verifyCvButton, "Update resume", "UpdateCV is not displayed");
		System.out.println("UpdateCV Text is displayed as:" + verifyCvButton);
		naukrihomepage.uploadCV.sendKeys(System.getProperty("user.dir") + "/ResumeS.docx");
		WebDriverWait waitForSuccessMsg = new WebDriverWait(driver, 10);
		WebElement successMsg = waitForSuccessMsg.until(ExpectedConditions.visibilityOf(naukrihomepage.successHeader));
		String headerMsg = successMsg.getText();
		Assert.assertEquals(headerMsg, "Success", "Success Message is not Displayed");
		String Msg = naukrihomepage.successMessage.getText();
		Assert.assertEquals(Msg, "Resume has been successfully uploaded.",
				"Resume has been successfully uploaded. is not Displayed");

		String resumeUpload = naukrihomepage.uploadedFileName.getText();
		Assert.assertEquals(resumeUpload, "ResumeS.docx", "ResumeS.docx is not Displayed");
		ScreenshotsUtility.takeScreenshot(driver,
				System.getProperty("user.dir") + "/src/main/java/screenshots/Resumeuploaded.png");
	}
//ctrl+shift+f is for formatting the code

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}
