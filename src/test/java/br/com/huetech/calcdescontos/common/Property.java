package br.com.huetech.calcdescontos.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
* @author jarbas.junior
* Define o caminho do driver dos diferentes browsers
* Acessa as configura��es definidas no config.properties e retorna a informa��o 
*/
public abstract class Property {

	public static       String IE64_DRIVE_PATH;
	public static       String CHROME_DRIVE_PATH;
	public static       String FIREFOX_DRIVE_PATH;
	public static final String BROWSER_NAME;
	public static final String URL;
	public static final String LOGIN;
	public static final String PASSWORD;
	public static final String NOME;
	public static final String EMAIL;
	public static final String MENOR_QUE_18;
	public static final String ENTRE_18_E_60;
	public static final String MAIOR_QUE_60;
	public static final String INICIO_MSG;
	public static final String FIM_MSG;
	public static final String MSG_SUCESSO;
	public static final String TIPO_MSG_DUVIDA;
	public static final String TIPO_MSG_SUGESTAO;
	public static final String TIPO_MSG_RECLAMACAO;
	
	private static final String PROPERTIES_FILE = "br/com/huetech/calcdescontos/config.properties";
	
	static{
		IE64_DRIVE_PATH     = new File("").getAbsolutePath() + "\\src\\test\\resources\\IEDriverServer.exe";
		CHROME_DRIVE_PATH   = new File("").getAbsolutePath() + "\\src\\test\\resources\\chromedriver.exe";
		FIREFOX_DRIVE_PATH  = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		BROWSER_NAME        = get("browser.name");
		URL                 = get("site.address");
		LOGIN               = get("login");
		PASSWORD            = get("password");
		NOME           	    = get("nome");
		EMAIL			    = get("email");
		MENOR_QUE_18	    = get("menor.18");
		ENTRE_18_E_60	    = get("entre.18.60");
		MAIOR_QUE_60	    = get("maior.60");
		INICIO_MSG		    = get("inicio.mensagem");
		FIM_MSG			    = get("fim.mensagem");
		MSG_SUCESSO		    = get("mensagem.sucesso");
		TIPO_MSG_DUVIDA	    = get("mensagem.duvida");
		TIPO_MSG_SUGESTAO   = get("mensagem.sugestao");
		TIPO_MSG_RECLAMACAO = get("mensagem.reclamacao");
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
