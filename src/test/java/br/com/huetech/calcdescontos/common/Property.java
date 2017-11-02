package br.com.huetech.calcdescontos.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
* @author jarbas.junior
* Define o caminho do driver dos diferentes browsers
* Acessa as configurações definidas no config.properties e retorna a informação 
*/
public abstract class Property {

	public static       String IE64_DRIVE_PATH;
	public static       String CHROME_DRIVE_PATH;
	public static       String FIREFOX_DRIVE_PATH;
	public static final String BROWSER_NAME;
	public static final String URL;
	public static final String LOGIN;
	public static final String PASSWORD;
	
	private static final String PROPERTIES_FILE = "br/com/huetech/calcdescontos/config.properties";
	
	static{
		IE64_DRIVE_PATH      = new File("").getAbsolutePath() + "\\src\\test\\resources\\IEDriverServer.exe";
		CHROME_DRIVE_PATH    = new File("").getAbsolutePath() + "\\src\\test\\resources\\chromedriver.exe";
		FIREFOX_DRIVE_PATH   = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		BROWSER_NAME         = get("browser.name");
		URL                  = get("site.address");
		LOGIN                = get("login");
		PASSWORD             = get("password");
	}
	
	/**
	 * Metodo para pegar o valor de alguma propriedade no arquivo de configuracao do Selenium
	 * O caminho e o nome do arquivo pode ser trocados
	 */
	private static String get(String name) {
		Properties properties = new Properties();
		String     value      = null;
		try {
			properties.load(Property.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		    value = properties.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
