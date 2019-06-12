package gluepack;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(features= {"D:\\jobpurpose\\kvrfacebkbdd\\src\\test\\resources\\features\\fbtest.feature","D:\\jobpurpose\\kvrfacebkbdd\\src\\test\\resources\\features\\fb2.feature"},monochrome=true,plugin= {"pretty","html:target\\results231"})

	public class Runnerclass
	{
		
	}