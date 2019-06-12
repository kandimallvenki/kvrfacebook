package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Useridpage 
{
@FindBy(name="email")
public WebElement uid;
@FindBy(xpath="(//*[contains(text(),'The email address')])[1]")
public WebElement uidblankerror;
@FindBy(xpath="(//*[contains(text(),'The email address')])[1]")
public WebElement uidinvaliderror;

public Useridpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void filluid(String x)
{
	uid.sendKeys(x);
}

	
}
