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
	
	/*
	 * IDENTIFICAÇÕES DE DADOS EM COMUM DAS TELAS DE CADASTRO
	 */
	public static final String TELA_NOME;
	public static final String TELA_SIGLA;
	public static final String TELA_ATUACAO;
	public static final String TELA_SIGLA_GR;
	public static final String TELA_VISUALIZAR;
	public static final String TELA_BT_IR_PARA;
	public static final String TELA_BT_INCLUIR;
	public static final String TELA_BT_CANCELAR;
	public static final String TELA_TIPO_UNIDADE;
	public static final String TELA_BT_EXPORTACAO;
	public static final String TELA_ESTADO_OPERACIONAL;
	public static final String TELA_MSG_OBRIGATORIEDADE;
	public static final String TELA_BT_FILTRO_GERENCIA_SISTEMA;
	/*
	 * IDENTIFICAÇÕES DE DADOS EM COMUM DAS TELAS DE INCLUSÃO
	 */
	public static final String TELA_INCLUSAO_AREA;
	public static final String TELA_INCLUSAO_TIPO;
	public static final String TELA_INCLUSAO_SISTEMA;
	public static final String TELA_INCLUSAO_ENDERECO;
	public static final String TELA_INCLUSAO_LATITUDE;
	public static final String TELA_INCLUSAO_DESCRICAO;
	public static final String TELA_INCLUSAO_LONGITUDE;
	public static final String TELA_INCLUSAO_COTA_TERRENO;
	public static final String TELA_INCLUSAO_INICIO_OPERACAO;
	public static final String TELA_INCLUSAO_AREA_ATENDIMENTO;
	public static final String TELA_INCLUSAO_GERENCIA_REGIONAL;
	public static final String TELA_INCLUSAO_SISTEMAS_ATENDIDOS;
	public static final String TELA_INCLUSAO_SETORES_RESPONSAVEIS;
	public static final String TELA_INCLUSAO_TIPOS_UNIDADE_OPERACIONAL;
	/*
	 * IDENTIFICAÇÕES DE DADOS TELA - GERÊNCIA REGIONAL
	 */
	public static final String TELA_BT_NOVA_GERENCIA_REGIONAL;
	public static final String TELA_TITULO_CADASTRO_GERENCIA_REGIONAL;
	public static final String TELA_TITULO_INCLUSAO_GERENCIA_REGIONAL;
	/*
	 * IDENTIFICAÇÕES DE DADOS TELA - SETOR
	 */
	public static final String TELA_BT_NOVO_SETOR;
	public static final String TELA_TITULO_CADASTRO_SETOR;
	public static final String TELA_TITULO_INCLUSAO_SETOR;
	/*
	 * IDENTIFICAÇÕES DE DADOS TELA - SISTEMA
	 */
	public static final String TELA_BT_NOVO_SISTEMA;
	public static final String TELA_TITULO_CADASTRO_SISTEMA;
	public static final String TELA_TITULO_INCLUSAO_SISTEMA;
	/*
	 * IDENTIFICAÇÕES DE DADOS TELA - UNIDADE OPERACIONAL
	 */
	public static final String TELA_BT_NOVA_UNIDADE_OPERACIONAL;
	public static final String TELA_TITULO_CADASTRO_UNIDADE_OPERACIONAL;
	public static final String TELA_TITULO_INCLUSAO_UNIDADE_OPERACIONAL;
	/*
	 * IDENTIFICAÇÕES DE DADOS TELA - SERVIÇO
	 */
	public static final String TELA_BT_NOVO_SERVICO;
	public static final String TELA_TITULO_CADASTRO_SERVICO;
	public static final String TELA_TITULO_INCLUSAO_SERVICO;
	
	private static final String PROPERTIES_FILE = "br/com/cagepa/sigo/config.properties";
	
	static{
		
		IE64_DRIVE_PATH                          = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
		CHROME_DRIVE_PATH                        = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\chromedriver.exe";
		PHANTOM_JS_DRIVE_PATH                    = new File("").getAbsolutePath() + "\\src\\test\\resources\\drivers\\phantomjs.exe";
		FIREFOX_DRIVE_PATH                       = new File("").getAbsolutePath() + "%PROGRAMFILES%\\Mozilla Firefox\\firefox.exe";
		URL                                      = get("site.address");
		USR                                      = get("usr");
		LOGIN                                    = get("login");
		PASSWORD                                 = get("password");
		EMAIL_USR                                = get("email");
		BROWSER_NAME                             = get("browser.name");
		ARQUIVO_TESTE_XLS                        = get("arquivo.teste.xls");
		PATH_ARQUIVO_TESTE                       = get("path.arquivo.xls");
		PLANILHA_SETOR                           = get("planilha.setor");
		PLANILHA_SISTEMA                         = get("planilha.sistema");
		PLANILHA_SERVICO                         = get("planilha.servico");
		PLANILHA_GERENCIA_REGIONAL               = get("planilha.gerencia.regional");
		PLANILHA_UNIDADE_OPERACIONAL             = get("planilha.unidade.operacional");
		FRAME_ID_ABA_MANTER                      = get("frame.id.aba.manter");
		FRAME_NAME_ABA_MANTER                    = get("frame.name.aba.manter");
		FRAME_ID_ABA_CADASTRO                    = get("frame.id.aba.cadastro");
		FRAME_NAME_ABA_CADASTRO                  = get("frame.name.aba.cadastro");
		TELA_NOME                                = get("tela.nome");
		TELA_SIGLA                               = get("tela.sigla");
		TELA_ATUACAO                             = get("tela.atuacao");
		TELA_SIGLA_GR                            = get("tela.sigla.gr");
		TELA_VISUALIZAR                          = get("tela.visualizar");
		TELA_BT_IR_PARA                          = get("tela.bt.irpara");
		TELA_BT_INCLUIR                          = get("tela.bt.incluir");
		TELA_BT_CANCELAR                         = get("tela.bt.cancelar");
		TELA_TIPO_UNIDADE                        = get("tela.tipo.unidade");
		TELA_BT_EXPORTACAO                       = get("tela.bt.exportacao");
		TELA_ESTADO_OPERACIONAL                  = get("tela.estado.operacional");
		TELA_MSG_OBRIGATORIEDADE                 = get("tela.msg.obrigatoriedade"); 
		TELA_BT_FILTRO_GERENCIA_SISTEMA          = get("tela.bt.filtro.gerencia.sistema");
		TELA_INCLUSAO_AREA                       = get("tela.inclusao.area");
		TELA_INCLUSAO_TIPO                       = get("tela.inclusao.tipo");
		TELA_INCLUSAO_SISTEMA                    = get("tela.inclusao.sistema");
		TELA_INCLUSAO_ENDERECO                   = get("tela.inclusao.endereco");
		TELA_INCLUSAO_LATITUDE                   = get("tela.inclusao.latitude");
		TELA_INCLUSAO_DESCRICAO                  = get("tela.inclusao.descricao");
		TELA_INCLUSAO_LONGITUDE                  = get("tela.inclusao.longitude");
		TELA_INCLUSAO_COTA_TERRENO               = get("tela.inclusao.cota.terreno");
		TELA_INCLUSAO_INICIO_OPERACAO            = get("tela.inclusao.inicio.operacao");
		TELA_INCLUSAO_AREA_ATENDIMENTO           = get("tela.inclusao.area.atendimento");
		TELA_INCLUSAO_GERENCIA_REGIONAL          = get("tela.inclusao.gerencia.regional");
		TELA_INCLUSAO_SISTEMAS_ATENDIDOS         = get("tela.inclusao.sistemas.atendidos");
		TELA_INCLUSAO_SETORES_RESPONSAVEIS       = get("tela.inclusao.setores.responsaveis");
		TELA_INCLUSAO_TIPOS_UNIDADE_OPERACIONAL  = get("tela.inclusao.tipos.unidade.operacional");
		TELA_BT_NOVA_GERENCIA_REGIONAL           = get("tela.bt.nova.gerencia.regional");
		TELA_TITULO_CADASTRO_GERENCIA_REGIONAL   = get("tela.titulo.cadastro.gerencia.regional");
		TELA_TITULO_INCLUSAO_GERENCIA_REGIONAL   = get("tela.titulo.inclusao.gerencia.regional");
		TELA_BT_NOVO_SETOR                       = get("tela.bt.novo.setor");
		TELA_TITULO_CADASTRO_SETOR               = get("tela.titulo.cadastro.setor");
		TELA_TITULO_INCLUSAO_SETOR               = get("tela.titulo.inclusao.setor");
		TELA_BT_NOVO_SISTEMA                     = get("tela.bt.novo.sistema");
		TELA_TITULO_CADASTRO_SISTEMA             = get("tela.titulo.cadastro.sistema");
		TELA_TITULO_INCLUSAO_SISTEMA             = get("tela.titulo.inclusao.sistema");
		TELA_BT_NOVA_UNIDADE_OPERACIONAL         = get("tela.bt.nova.unidade.operacional");
		TELA_TITULO_CADASTRO_UNIDADE_OPERACIONAL = get("tela.titulo.cadastro.unidade.operacional");
		TELA_TITULO_INCLUSAO_UNIDADE_OPERACIONAL = get("tela.titulo.inclusao.unidade.operacional");
		TELA_BT_NOVO_SERVICO                     = get("tela.bt.novo.servico");
		TELA_TITULO_CADASTRO_SERVICO             = get("tela.titulo.cadastro.servico");
		TELA_TITULO_INCLUSAO_SERVICO             = get("tela.titulo.inclusao.servico");
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
