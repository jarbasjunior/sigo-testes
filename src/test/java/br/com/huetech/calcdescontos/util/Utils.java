package br.com.huetech.calcdescontos.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.huetech.calcdescontos.common.Selenium;

/**
 * Classe com m�todos de apoio, que otimizam a codifica��o das classes de
 * p�gina.
 * 
 * @author jarbas.junior
 *
 */
public abstract class Utils {

	private static final WebDriver driver;
	private static final WebDriverWait wait;

	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public static void isVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void isVisible(String id) {
		isVisible(By.id(id));
	}

	public static void isLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void isLocated(String id) {
		isLocated(By.id(id));
	}

	public static void isClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void assertEquals(Object esperado, Object atual) {
		try {
			Assert.assertEquals(esperado, atual);
		} catch (Exception e) {
			assertFail("Erro encontrado: Esperado ["+esperado+"], mas retornou ["+atual+"]");
		}
	}
	
	public static void assertTrue(String message, boolean bol){
		Assert.assertTrue(message, bol);
	}
	
	public static void assertFail(String message) {
		Assert.fail(message);
	}
	
	public static String conversorDoubleString(double valor){
		DecimalFormat df=new DecimalFormat("0.00");  
		String novoValor = df.format(valor);
		return novoValor;
	}
	
	public static Double conversorStringDouble(String valor){
		String novoValor = valor.replace(",", ".");
		return Double.parseDouble(novoValor);
	} 
	
	public static String converterValoresFloatToString(Float value) {
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return nf.format(value).replace(",","");
	}
	
	
	/**
	 * M�todo para capturar screenshot
	 * @param fileName - Nome do arquivo
	 */
//	public static void takeScreenshot(String fileName){
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Date data = new Date();
//	    try {
//			FileUtils.copyFile(scrFile, new File("C:\\Users\\Jarbas\\Desktop\\"+fileName+ data.getTime()+".jpeg"),true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void calculaTempoDoTest(Date tempoInicio, Date tempoFinal) {
//		long diferencaSegundos = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000);
//		long diferencaMinutos = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60);
//		long diferencaHoras = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60 * 60);
//		Log.info("Tempo de execu��o:"+ String.format("%02d:%02d:%02d ", diferencaHoras, diferencaMinutos, diferencaSegundos));
//	}
}