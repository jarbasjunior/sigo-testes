package br.com.cagepa.sigo.setup;

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
	public static final  String IE64_DRIVE_PATH;
	public static final  String CHROME_DRIVE_PATH;
	public static final  String FIREFOX_DRIVE_PATH;
	public static final  String PHANTOM_JS_DRIVE_PATH;
	public static final  String FRAME_ID_ABA_MANTER;
	public static final  String FRAME_NAME_ABA_MANTER;
	public static final  String FRAME_ID_ABA_CADASTRO;
	public static final  String FRAME_NAME_ABA_CADASTRO;
	
	private static final String PROPERTIES_FILE = "br/com/cagepa/sigo/config.properties";
	
	static{
		IE64_DRIVE_PATH         = new File("").getAbsolutePath() + "\\src\\test\\resources\\IEDriverServer.exe";
		CHROME_DRIVE_PATH       = new File("").getAbsolutePath() + "\\src\\test\\resources\\chromedriver.exe";
		PHANTOM_JS_DRIVE_PATH   = new File("").getAbsolutePath() + "\\src\\test\\resources\\phantomjs.exe";
		FIREFOX_DRIVE_PATH      = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		URL                     = get("site.address");
		USR                     = get("usr");
		LOGIN                   = get("login");
		PASSWORD                = get("password");
		EMAIL_USR               = get("email");
		BROWSER_NAME            = get("browser.name");
		FRAME_ID_ABA_MANTER     = get("frame.id.aba.manter");
		FRAME_NAME_ABA_MANTER   = get("frame.name.aba.manter");
		FRAME_ID_ABA_CADASTRO   = get("frame.id.aba.cadastro");
		FRAME_NAME_ABA_CADASTRO = get("frame.name.aba.cadastro");
		
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
