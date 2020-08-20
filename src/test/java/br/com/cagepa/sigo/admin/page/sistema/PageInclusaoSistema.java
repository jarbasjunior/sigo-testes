package br.com.cagepa.sigo.admin.page.sistema;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;
import br.com.cagepa.sigo.util.XLS_Utils;

public class PageInclusaoSistema extends PageObjectGeneric<PageInclusaoSistema> {

	public PageInclusaoSistema() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(id = "lin1_col1")
	WebElement titleInclusaoSistema;
	
	@FindBy(id = "lin1_col2")
	WebElement dataInclusaoSistema;
	
	@FindBy(id = "sc_b_ins_t")
	WebElement btIncluir;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement btCancelar;
	
	@FindBy(id = "id_label_sigla")
	WebElement sigla;
	
	@FindBy(id = "id_label_nome")
	WebElement nome;
	
	@FindBy(id = "id_label_codigoid_gerencia_regional")
	WebElement gerenciaRegional;
	
	@FindBy(id = "id_label_tipo")
	WebElement tipo;
	
	@FindBy(id = "id_label_setores_responsaveis")
	WebElement setoresResponsaveis;

	@FindBy(id = "id_label_localidades_atendidas")
	WebElement localidadesAtendidas;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement fieldSigla;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement fieldNome;
	
	@FindBy(id = "id_read_off_sigla")
	WebElement enablefieldSigla;
	
	@FindBy(id = "id_read_off_nome")
	WebElement enablefieldNome;
	
	@FindBy(xpath = "//*[@id='main_table_form']/tbody/tr/td/div/table/tbody/tr[4]/td/span")
	WebElement fraseObrigatoriedade;
	
	@FindBy(id = "resposta_cadastro")
	WebElement msgFeedbackSucesso;
	
	@FindBy(id = "id_error_message_fixed")
	WebElement msgFeedbackErro;
	
	@FindBy(name = "Bmens")
	WebElement btOk;
	
	@FindBy(id = "sc_b_new_t")
	WebElement btNovo;
	
	@FindBy(xpath = ".//*[@id='id_error_display_fixed']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a")
	WebElement btFecharMsgAlerta;
	
	@FindBy(id = "id_sc_field_codigoid_gerencia_regional")
	WebElement comboGerenciaRegional;
	
	@FindBy(id = "id_sc_field_tipo")
	WebElement comboTipoAtuacao;

	@FindBy(xpath = "//*[@id='idAjaxSelect_tipo']/select/option[@value='A']")
	WebElement opcaoTipoAtuacaoAgua;
	
	@FindBy(xpath = "//*[@id='idAjaxSelect_tipo']/select/option[@value='E']")
	WebElement opcaoTipoAtuacaoEsgoto;
	
	By msgAguarde = By.xpath("//*[@id='id_div_process']/span/img");

	public List<String> incluirSistema(String gerencia){
		WebElement opcaoGerencia = Selenium.getDriver().findElement(By.xpath("//*[@id='idAjaxSelect_codigoid_gerencia_regional']/select/option[contains(.,'"+gerencia+"')]"));
		List<String> dadosSistema = new ArrayList<String>();
		String siglaSistema = Utils.geraSigla(3);
		String nomeSistema  = "Teste Sistema "+siglaSistema;
		dadosSistema.add(siglaSistema);
		dadosSistema.add(nomeSistema);
		validarFrameInclusaoGerenciaRegional();
		
		Log.info("Iniciando preenchimento de inclusão de sistema...");
		Log.info("Habilitando campo nome...");
		click(enablefieldNome);
		Log.info("Campo [Nome] habilitado.");
		aguardarElementoVisivel(fieldNome);
		Log.info("Preenchendo campo [Nome] com valor ["+nomeSistema+"]...");
		preencherCampo(fieldNome, nomeSistema);
		Log.info("Campo [Nome] preenchido.");
		Log.info("Selecionando gerência regional ["+gerencia+"]...");
		click(comboGerenciaRegional);
		Utils.wait(1000);
		aguardarElementoVisivel(opcaoGerencia);
		click(opcaoGerencia);
		Utils.wait(3000);
		click(comboTipoAtuacao);
		Utils.wait(1000);
		aguardarElementoVisivel(opcaoTipoAtuacaoAgua);
		click(opcaoTipoAtuacaoAgua);
		Utils.wait(1000);
		click(comboTipoAtuacao);
		Utils.wait(1000);
			
		Log.info("Clicando no botao incluir...");
		click(btIncluir);
		/*
		 * 
		// FALTA DESENVOLVEDOR IMPLEMENTAR ALERTA DE CONFIRMAÇÃO DE INCLUSÃO DE SISTEMA
		
		Log.info("Confirmando pop-up de inclusao...");
		confirmarAlerta();
			
		// FALTA DESENVOLVEDOR IMPLEMENTAR MENSAGEM DE FEEDBACK DE INCLUSÃO DE SISTEMA
		Log.info("Verificando inclusao da ["+nomeSistema+"]...");
		Log.info("Validando mensagem feedback de sucesso...");
		Utils.assertEquals(msgFeedbackSucesso.getText(), "Sistema cadastrada com sucesso!");
			
		Log.info("Confirmando mensagem de sucesso...");
		aguardarElementoVisivel(btOk);
		click(btOk);
		 */
		Log.info("Retornando driver para frame SIGO...");
		retornarFramePai();
		Log.info("Driver na frame SIGO...");
		Utils.wait(2000);
		return dadosSistema;
	}
	
	public void tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa(){
		validarFrameInclusaoGerenciaRegional();
		
		try {
			XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int    linha         = 0;
		int    coluna        = 0;
		int    contador      = 1;
		String nomeGerencia  = null;
		String siglaGerencia = null;
		int    qtdRegistros  = 0;
		
		Log.info("Capturando quantidade de registros na planilha...");
		try {
			qtdRegistros = XLS_Utils.qtdRegistrosPlanilha();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int registrosRestantes  = qtdRegistros;
		Log.info("["+qtdRegistros+"] registros encontrados na planilha.");
		
		do {
			
			try {
				siglaGerencia = XLS_Utils.getDadosCelula(linha, coluna);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				nomeGerencia = XLS_Utils.getDadosCelula(linha, coluna+1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Inclusao de registro ["+contador+"/"+qtdRegistros+"]...");
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Iniciando preenchimento de inclusão de gerência regional...");
			
			Log.info("Habilitando campo sigla...");
			click(enablefieldSigla);
			Log.info("Campo sigla habilitado.");
			aguardarElementoVisivel(fieldSigla);
			Log.info("Preenchendo campo sigla com valor ["+siglaGerencia+"]...");
			preencherCampo(fieldSigla, siglaGerencia);
			Log.info("Campo [Sigla] preenchido.");
			
			Log.info("Habilitando campo nome...");
			click(enablefieldNome);
			Log.info("Campo [Nome] habilitado.");
			aguardarElementoVisivel(fieldNome);
			Log.info("Preenchendo campo [Nome] com valor ["+nomeGerencia+"]...");
			preencherCampo(fieldNome, nomeGerencia);
			Log.info("Campo [Nome] preenchido.");
			
			Log.info("Clicando no botao incluir...");
			click(btIncluir);
			
			Log.info("Confirmando pop-up de inclusao...");
			confirmarAlerta();
			
			Log.info("Verificando tentativa de inclusao de gerencia regional ja existente...");
			Log.info("Validando mensagem de feedback de critica na sigla e no nome da gerencia regional ja existente...");
			Utils.assertEquals(msgFeedbackErro.getText(), "Erro na inclusão - O registro já existe: Sigla\nErro na inclusão - O registro já existe: Nome");
			
			Log.info("Fechando mensagem de alerta...");
			click(btFecharMsgAlerta);
			
			linha++;
			contador++;
			registrosRestantes--;
			
		} while (registrosRestantes > 0);
		retornarFramePai();
	}
	
	public void tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa(){
		validarFrameInclusaoGerenciaRegional();
		
		try {
			XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int    linha         = 0;
		int    coluna        = 0;
		int    contador      = 1;
		String siglaGerencia = null;
		int    qtdRegistros  = 0;
		
		Log.info("Capturando quantidade de registros na planilha...");
		try {
			qtdRegistros = XLS_Utils.qtdRegistrosPlanilha();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int registrosRestantes  = qtdRegistros;
		Log.info("["+qtdRegistros+"] registros encontrados na planilha.");
		
		do {
			
			try {
				siglaGerencia = XLS_Utils.getDadosCelula(linha, coluna);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Inclusao de registro ["+contador+"/"+qtdRegistros+"]...");
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Iniciando preenchimento de inclusão de gerência regional...");
			
			Log.info("Habilitando campo sigla...");
			click(enablefieldSigla);
			Log.info("Campo sigla habilitado.");
			aguardarElementoVisivel(fieldSigla);
			Log.info("Preenchendo campo sigla com valor ["+siglaGerencia+"]...");
			preencherCampo(fieldSigla, siglaGerencia);
			Log.info("Campo [Sigla] preenchido.");
			
			Log.info("Habilitando campo nome...");
			click(enablefieldNome);
			Log.info("Campo [Nome] habilitado.");
			aguardarElementoVisivel(fieldNome);
			Log.info("Preenchendo campo [Nome] com valor [I N V A L I D O]...");
			preencherCampo(fieldNome, "I N V A L I D O");
			Log.info("Campo [Nome] preenchido.");
			
			Log.info("Clicando no botao incluir...");
			click(btIncluir);
			
			Log.info("Confirmando pop-up de inclusao...");
			confirmarAlerta();
			
			Log.info("Verificando tentativa de inclusao de gerencia regional ja existente...");
			Log.info("Validando mensagem de feedback de critica na SIGLA da gerencia regional ja existente...");
			Utils.assertEquals(msgFeedbackErro.getText(), "Erro na inclusão - O registro já existe: Sigla");
			
			Log.info("Fechando mensagem de alerta...");
			click(btFecharMsgAlerta);
			
			linha++;
			contador++;
			registrosRestantes--;
			
		} while (registrosRestantes > 0);
		retornarFramePai();
	}
	
	public void tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa(){
		validarFrameInclusaoGerenciaRegional();
		
		try {
			XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int    linha         = 0;
		int    coluna        = 0;
		int    contador      = 1;
		String nomeGerencia = null;
		int    qtdRegistros  = 0;
		
		Log.info("Capturando quantidade de registros na planilha...");
		try {
			qtdRegistros = XLS_Utils.qtdRegistrosPlanilha();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int registrosRestantes  = qtdRegistros;
		Log.info("["+qtdRegistros+"] registros encontrados na planilha.");
		
		do {
			
			try {
				nomeGerencia = XLS_Utils.getDadosCelula(linha, coluna+1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Inclusao de registro ["+contador+"/"+qtdRegistros+"]...");
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Iniciando preenchimento de inclusão de gerência regional...");
			
			Log.info("Habilitando campo sigla...");
			click(enablefieldSigla);
			Log.info("Campo sigla habilitado.");
			aguardarElementoVisivel(fieldSigla);
			Log.info("Preenchendo campo sigla com valor [INVA]...");
			preencherCampo(fieldSigla, "[INVA]");
			Log.info("Campo [Sigla] preenchido.");
			
			Log.info("Habilitando campo nome...");
			click(enablefieldNome);
			Log.info("Campo [Nome] habilitado.");
			aguardarElementoVisivel(fieldNome);
			Log.info("Preenchendo campo [Nome] com valor ["+nomeGerencia+"]...");
			preencherCampo(fieldNome, nomeGerencia);
			Log.info("Campo [Nome] preenchido.");
			
			Log.info("Clicando no botao incluir...");
			click(btIncluir);
			
			Log.info("Confirmando pop-up de inclusao...");
			confirmarAlerta();
			
			Log.info("Verificando tentativa de inclusao de gerencia regional ja existente...");
			Log.info("Validando mensagem de feedback de critica no NOME da gerencia regional ja existente...");
			Utils.assertEquals(msgFeedbackErro.getText(), "Erro na inclusão - O registro já existe: Nome");
			
			Log.info("Fechando mensagem de alerta...");
			click(btFecharMsgAlerta);
			
			linha++;
			contador++;
			registrosRestantes--;
			
		} while (registrosRestantes > 0);
		retornarFramePai();
	}
		
	public void validarFrameInclusaoGerenciaRegional(){
		By frameGerenciaRegional = By.name(Property.FRAME_NAME_ABA_MANTER_GERENCIA_REGIONAL);
		if (isVisibility(frameGerenciaRegional)) {
			Log.info("Alterando frame...");
			selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER_GERENCIA_REGIONAL);
			Log.info("Frame alterada para aba manter.");
		}
		Log.info("Validando frame de inclusao de sistema.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleInclusaoSistema.getText(), "Inclusão - Sistema");
		Log.info("Validando data...");
		Utils.assertEquals(dataInclusaoSistema.getText() , Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btIncluir.getText() , "Incluir");
		Utils.assertEquals(btCancelar.getText(), "Cancelar");
		Log.info("Validando nomes...");
		Utils.assertEquals(nome.getText()                , "Nome");
		Utils.assertEquals(gerenciaRegional.getText()    , "Gerência Regional");
		Utils.assertEquals(tipo.getText()                , "Tipo");
		Utils.assertEquals(setoresResponsaveis.getText() , "Setores Responsáveis");
		Utils.assertEquals(localidadesAtendidas.getText(), "Localidades Atendidas");
	}
}
