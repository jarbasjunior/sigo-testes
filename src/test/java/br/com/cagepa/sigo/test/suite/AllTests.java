package br.com.cagepa.sigo.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.cagepa.sigo.common.Property;
import br.com.cagepa.sigo.common.Selenium;
import br.com.cagepa.sigo.test.TestLoginSIC_IT;
/**
 * Classe que agrupa todas as classes de teste, funcionando com uma suíte de regressão.
 * @author Jarbas
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLoginSIC_IT.class,
})

public class AllTests {
protected static WebDriver driver;
	
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Property.URL);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Selenium.resetDriver();
	}

}
