package br.com.cagepa.sigo.test.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import br.com.cagepa.sigo.setup.Browser;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.test.suite.AllTests;
import br.com.cagepa.sigo.util.Log;
public class BaseTestCase {
	
	
	protected static WebDriver driver;
	
	@Rule
	public TestName nameTest = new TestName();
	
	@Before
	public void before(){
		Log.msgInicioTeste(nameTest.getMethodName());
	}

	@After
	public void after(){
		Log.msgFimTeste(nameTest.getMethodName());
	}
	
	@BeforeClass
	public static void beforeClass(){
		if(!AllTests.isAllTestsExecution){
			Selenium.getDriver().navigate().to(Property.URL);
			if (Property.BROWSER_NAME.equals(Browser.FIREFOX)) {
				Selenium.getDriver().manage().window().maximize();
			}
		}
	}
	
	@AfterClass
	public static void afterClass(){
		if(!AllTests.isAllTestsExecution){
			Selenium.resetDriver();
		}
	}
	
}
