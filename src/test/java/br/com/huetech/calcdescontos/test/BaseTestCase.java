package br.com.huetech.calcdescontos.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.test.calcdescontos.suite.AllTests;
public class BaseTestCase {
	
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			driver = Selenium.getDriver();
			driver.navigate().to(Property.URL);
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			Selenium.resetDriver();
		}
	}
}
