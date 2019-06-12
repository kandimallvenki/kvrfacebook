package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Passwordpage 
{
	@FindBy(name="pass")
	public WebElement pwd;
	@FindBy(xpath="(//*[contains(text(),'The password that')])[1]")
	public WebElement pwdblankerror;
	@FindBy(xpath="(//*[contains(text(),'The password that')])[1]")
	public WebElement pwdinvaliderror;
	public Passwordpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void fillpwd(String y)
	{
		pwd.sendKeys(y);
	}
}
