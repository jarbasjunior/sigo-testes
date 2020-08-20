package br.com.cagepa.sigo.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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

import javax.imageio.ImageIO;

import org.junit.Assert;

import br.com.cagepa.sigo.setup.Property;

/**
 * Classe com m�todos de apoio, que otimizam a codifica��o das classes de
 * p�gina.
 * 
 * @author jarbas.junior
 *
 */
public abstract class Utils {

	private static boolean               isError = false;

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
	
	public static String geraSigla(int tamanhoSigla){
		Random random = new Random();
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tamanhoSigla; i++) {
			int ch = random.nextInt (letras.length);
		    sb.append (letras [ch]);
		}    
		return sb.toString();    
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
		Date data = new Date();
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
    	Calendar now = Calendar.getInstance();
        Robot robot;
		try {
			robot = new Robot();
         	BufferedImage screenShot = robot.createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
         	try {
				ImageIO.write(screenShot, "JPG", new File(Property.EVIDENCIAS_TESTE_PATH+fileName+ data.getTime()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	System.out.println(formatter.format(now.getTime()));
				
		} catch (AWTException e) {
			// TODO Auto-generated catch block
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