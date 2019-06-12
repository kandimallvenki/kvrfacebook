package gluepack;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Useridpage;
import pages.Loginpage;
import pages.Passwordpage;
import pages.Useridpage;
import pages.Passwordpage;

public class Fbgluecode 
{
public WebDriver driver;
public WebDriverWait wait;
public Scenario s;
public Properties p;
public Useridpage up;
public Passwordpage pp;
public Loginpage lp;
@Before
public void method1(Scenario s)throws Exception
 {
	this.s=s;
	FileInputStream fi=new FileInputStream("D:\\jobpurpose\\kvrfacebkbdd\\src\\test\\resources\\repository\\fb.properties");
	p=new Properties();
	p.load(fi);
 }
@Given("^launch site$")

	public void method2()
	{
	System.setProperty("webdriver.chrome.driver","D:\\batchno241\\chromedriver.exe");
	driver=new ChromeDriver();
	up=new Useridpage(driver);
	pp=new Passwordpage(driver);
	lp=new Loginpage(driver);
	driver.get(p.getProperty("Url"));
	wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(up.uid));
	driver.manage().window().maximize();
	}
@Then("^title will be \"(.*)\" for Homepage$")
	public void method3(String x)
	{
	String t=driver.getTitle();
	if(t.equals(x))
	{
	s.write("Facebook site title test passed");	
	}
	else
	{
		byte[]b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b,"Facebook title test was failed");
	}
	}
 @When("^close site$")
    public void method4()
    {
	  driver.close();
    }
 @When("^enter userid like \"(.*)\" value$")
 public void method5(String x)
    {
	  wait.until(ExpectedConditions.visibilityOf(up.uid));
	  up.filluid(x);
    }
 @When("^enter password like \"(.*)\" value$")
 public void method6(String y)
 {
	 wait.until(ExpectedConditions.visibilityOf(pp.pwd));
	  pp.fillpwd(y); 
 }
 @Then("^click login button$")
 public void method7()
 {
	wait.until(ExpectedConditions.elementToBeClickable(lp.log)); 
	lp.log.click();
	
 }
 
 @And("^validate userid output for \"(.*)\" with \"(.*)\"  and password output for \"(.*)\" with \"(.*)\" criteria$")
 public void method8(String x,String y,String z,String w) throws InterruptedException
 {
	 Thread.sleep(5000);
	 try
	 {
		  if(z.equalsIgnoreCase("valid") && y.length()==0 && pp.pwdblankerror.isDisplayed())
		   {
			 s.write("pwd blank value test passed");
		   }
		  else if(z.equals("valid") && w.equalsIgnoreCase("invalid") && pp.pwdinvaliderror.isDisplayed())
		   {
			 s.write("pwd invalid value test passed");
		   }
		  else if(x.length()==0 && w.equalsIgnoreCase("valid") && up.uidblankerror.isDisplayed())
		   {
			 s.write("uid blank value test passed");
		   }
		  else if(z.equalsIgnoreCase("invalid") && w.equalsIgnoreCase("valid") && up.uidinvaliderror.isDisplayed())
		   {
			 s.write("uid invalid value test passed");
		   }
		  else if(z.equalsIgnoreCase("valid") && w.equals("valid") && lp.log.isDisplayed())
		   {
			 s.write("valid userid and valid password test passed");
		   }
		 else
		  {
			 byte[]b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 s.embed(b,"login test was failed");
		  }
 
        
	 }
	 catch(Exception ex)
	 {
		 s.write(ex.getMessage());
	 }
driver.close();
 }

}