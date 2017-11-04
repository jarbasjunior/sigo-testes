package br.com.cagepa.sigo.test.suite;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.cagepa.sigo.common.Property;
import br.com.cagepa.sigo.common.Selenium;
import br.com.cagepa.sigo.test.TestLoginSIC_IT;
import br.com.cagepa.sigo.util.Utils;
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
	public static Date    inicio = null;
	public static Date    fim    = null;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		inicio = Calendar.getInstance().getTime();
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Property.URL);
		TestLoginSIC_IT testLogin =  new TestLoginSIC_IT();
		testLogin.loginSIC_ComSucesso();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Selenium.resetDriver();
		fim = Calendar.getInstance().getTime();
		Utils.calculaTempoDoTest(inicio, fim);
	}

}
