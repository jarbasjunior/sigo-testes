package br.com.cagepa.sigo.setup;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
* @author jarbas.junior
* Define o caminho do driver dos diferentes browsers
* Acessa as IDENTIFICAÇÕES definidas no config.properties e retorna a informação 
*/
public abstract class Property {

	/*
	 * IDENTIFICAÇÕES DE ACESSO AO SISTEMA
	 */
	public static final String URL;
	public static final String USR;
	public static final String LOGIN;
	public static final String PASSWORD;
	public static final String EMAIL_USR;
	public static final String BROWSER_NAME;
	public static final String IE64_DRIVE_PATH;
	public static final String CHROME_DRIVE_PATH;
	public static final String FIREFOX_DRIVE_PATH;
	public static final String PHANTOM_JS_DRIVE_PATH;

	/*
	 * IDENTIFICAÇÕES DA PLANILHA DE DADOS
	 */
	public static final String PLANILHA_SETOR;
	public static final String PLANILHA_SISTEMA;
	public static final String PLANILHA_SERVICO;
	public static final String ARQUIVO_TESTE_XLS;
	public static final String PATH_ARQUIVO_TESTE;
	public static final String PLANILHA_GERENCIA_REGIONAL;
	public static final String PLANILHA_UNIDADE_OPERACIONAL;

	/*
	 * IDENTIFICAÇÕES DOS FRAMES DO SISTEMA
	 */
	public static final String FRAME_ID_ABA_MANTER;
	public static final String FRAME_NAME_ABA_MANTER;
	public static final String FRAME_ID_ABA_CADASTRO;
	public static final String FRAME_NAME_ABA_CADASTRO;
	
	private static final String PROPERTIES_FILE = "br/com/cagepa/sigo/config.properties";
	
	static{
		IE64_DRIVE_PATH              = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
		CHROME_DRIVE_PATH            = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\chromedriver.exe";
		PHANTOM_JS_DRIVE_PATH        = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\phantomjs.exe";
		FIREFOX_DRIVE_PATH           = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		URL                          = get("site.address");
		USR                          = get("usr");
		LOGIN                        = get("login");
		PASSWORD                     = get("password");
		EMAIL_USR                    = get("email");
		BROWSER_NAME                 = get("browser.name");
		ARQUIVO_TESTE_XLS            = get("arquivo.teste.xls");
		PATH_ARQUIVO_TESTE           = get("path.arquivo.xls");
		PLANILHA_SETOR               = get("planilha.setor");
		PLANILHA_SISTEMA             = get("planilha.sistema");
		PLANILHA_SERVICO             = get("planilha.servico");
		PLANILHA_GERENCIA_REGIONAL   = get("planilha.gerencia.regional");
		PLANILHA_UNIDADE_OPERACIONAL = get("planilha.unidade.operacional");
		FRAME_ID_ABA_MANTER          = get("frame.id.aba.manter");
		FRAME_NAME_ABA_MANTER        = get("frame.name.aba.manter");
		FRAME_ID_ABA_CADASTRO        = get("frame.id.aba.cadastro");
		FRAME_NAME_ABA_CADASTRO      = get("frame.name.aba.cadastro");
		
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
