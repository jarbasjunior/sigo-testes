package br.com.huetech.test.calcdescontos.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.common.Selenium;
/**
 * Classe que agrupa todas as classes de teste, funcionando com uma su�te de regress�o.
 * @author jcan
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})

public class AllTests {
protected static WebDriver driver;
	
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.navigate().to(Property.URL);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		driver.quit();
	}

}
