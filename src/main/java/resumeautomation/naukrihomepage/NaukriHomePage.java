package resumeautomation.naukrihomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriHomePage {

	
	@FindBy(xpath = "//a[text()=\"Login\"]")
    public WebElement logindisplayed;
	
	
	@FindBy(xpath = "//a[@id=\"login_Layer\"]")
    public WebElement login;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter your active Email ID / Username\"]")
    public WebElement enterUsername;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter your password\"]")
    public WebElement enterPassword;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[@title=\"Tanishka Bist\"]")
	public WebElement titleDisplay;
	
	@FindBy(xpath = "//a[normalize-space(text())=\"View\"]")
	public WebElement viewProfileLink;
	
	@FindBy(xpath = "//input[@value=\"Update resume\"]")
	public WebElement verifyUpdateCv;
	
	@FindBy(xpath = "//input[@id=\"attachCV\"]")
	public WebElement uploadCV;
	
	@FindBy(xpath = "//p[text()=\"Success\"]")
	public WebElement successHeader;
	
	@FindBy(xpath = "//p[text()=\"Resume has been successfully uploaded.\"]")
	public WebElement successMessage;
	
	@FindBy(xpath = "//div[text()=\"ResumeS.docx\"] ")
	public WebElement uploadedFileName;
	
	
public NaukriHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void loginApplication(String userName, String password)
{

	this.enterUsername.sendKeys(userName);
	this.enterPassword.sendKeys(password);
	this.loginButton.click();
}
}

