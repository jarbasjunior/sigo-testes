package br.com.cagepa.sigo.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
* @author jarbas.junior
* Define o caminho do driver dos diferentes browsers
* Acessa as configurações definidas no config.properties e retorna a informação 
*/
public abstract class Property {

	public static final  String URL;
	public static final  String USR;
	public static final  String LOGIN;
	public static final  String PASSWORD;
	public static final  String EMAIL_USR;
	public static final  String BROWSER_NAME;
	public static        String IE64_DRIVE_PATH;
	public static        String CHROME_DRIVE_PATH;
	public static        String FIREFOX_DRIVE_PATH;
	public static        String PHANTOM_JS_DRIVE_PATH;
	
	private static final String PROPERTIES_FILE = "br/com/cagepa/sigo/config.properties";
	
	static{
		IE64_DRIVE_PATH       = new File("").getAbsolutePath() + "\\src\\test\\resources\\IEDriverServer.exe";
		CHROME_DRIVE_PATH     = new File("").getAbsolutePath() + "\\src\\test\\resources\\chromedriver.exe";
		PHANTOM_JS_DRIVE_PATH = new File("").getAbsolutePath() + "\\src\\test\\resources\\phantomjs.exe";
		FIREFOX_DRIVE_PATH    = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		URL                   = get("site.address");
		USR                   = get("usr");
		LOGIN                 = get("login");
		PASSWORD              = get("password");
		EMAIL_USR             = get("email");
		BROWSER_NAME          = get("browser.name");
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
