package br.com.cagepa.sigo.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cagepa.sigo.setup.Selenium;

/**
 * Classe com m�todos de apoio, que otimizam a codifica��o das classes de
 * p�gina.
 * 
 * @author jarbas.junior
 *
 */
public abstract class Utils {

	private static final   WebDriverWait wait;
	private static final   WebDriver     driver;
	private static boolean               isError = false;

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
	
	public static void assertEquals(Object atual, Object esperado) {
		try {
			isError = !esperado.toString().equals(atual.toString());
			Assert.assertEquals(esperado, atual);
		} catch (Exception e) {
			assertFail("Erro encontrado: Esperado ["+esperado+"], mas retornou ["+atual+"]");
		}finally{
			if (isError) {
				Log.erro("E R R O "+"/"+"|"+""+"\\");
				Log.erro("Esperado..: ["+esperado+"]");
				Log.erro("Encontrado: ["+atual+"]");
				Log.erro("R E P R O V A D O = :/");
			}else{
				Log.info("Resultado esperado..: ["+esperado+"]");
				Log.info("Resultado encontrado: ["+atual+"]"); 
			}
		}
	}
	
	public static void assertTrue(String message, boolean bol){
		Assert.assertTrue(message, bol);
	}
	
	public static void assertFail(String message) {
		Assert.fail(message);
	}
	
	public static String conversorDoubleString(double valor){
		DecimalFormat df = new DecimalFormat("#,###.00");  
		String novoValor = df.format(valor);
		return novoValor;
	}
	
	public static Double conversorStringDouble(String valorString){
		String valorDouble = valorString.replace(",", "");
		return Double.valueOf(valorDouble);
	} 
	
	public static String converterValoresFloatToString(Float value) {
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return nf.format(value).replace(",","");
	}
	
	public static int geraNumeroEntreIntervalo(int min, int max){
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public static String geraNumeroEntre1_99(){
		return converteInteiroParaString(geraNumeroEntreIntervalo(1, 99));
	}
	
	public static String geraNumeroEntre100_999(){
		return converteInteiroParaString(geraNumeroEntreIntervalo(100, 999));
	}
	
	public static String geraNumeroEntre1000_10000(){
		return converteInteiroParaString(geraNumeroEntreIntervalo(1000, 10000));
	}
	
	public static String converteInteiroParaString(int numero){
		return Integer.toString(numero);
	}
	
	public static int converteStringParaInt(String str){
		return Integer.parseInt(str);
	}
	
	public static void takeScreenshot(String fileName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date data = new Date();
	    try {
			FileUtils.copyFile(scrFile, 
					new File("C:\\Users\\Jarbas Junior\\Git-jarbas\\sigo-testes\\evidencias\\"+fileName+ data.getTime()+".jpeg"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getAnoAnterior() {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
			Calendar calendar = new GregorianCalendar();
			Date d1 = new Date();
			calendar.setTime(d1);
			calendar.add(Calendar.DATE, -600);
			Date d2 = calendar.getTime();
			return formatDate.format(d2);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getDataAtual() {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = new GregorianCalendar();
			Date data = new Date();
			calendar.setTime(data);
			return formatDate.format(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getAno(int qtdAnosAtras) {
		int dias = qtdAnosAtras * 365;
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
			Calendar calendar = new GregorianCalendar();
			Date d1 = new Date();
			calendar.setTime(d1);
			calendar.add(Calendar.DATE, -dias);
			Date d2 = calendar.getTime();
			return formatDate.format(d2);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void calculaTempoDoTest(Date tempoInicio, Date tempoFinal) {
		long diferencaHoras    = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60 * 60);
		long diferencaMinutos  = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000 * 60);
		long diferencaSegundos = (tempoFinal.getTime() - tempoInicio.getTime()) / (1000);
		Log.info("Tempo de execucao:"+ String.format("%02d:%02d:%02d ", diferencaHoras, diferencaMinutos, diferencaSegundos));
	}
}