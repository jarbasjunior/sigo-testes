package br.com.huetech.calcdescontos.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.test.contato.TestPesquisaGoogleIT;
/**
 * Classe que agrupa todas as classes de teste, funcionando com uma suíte de regressão.
 * @author Jarbas
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestPesquisaGoogleIT.class,
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
