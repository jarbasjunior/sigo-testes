package br.com.cagepa.sigo.admin.page.sic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;

public class PageInicialSIC extends PageObjectGeneric<PageInicialSIC> {

	public PageInicialSIC() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "lin1_col2")
	WebElement msgBoasVindas;
	
	@FindBy(xpath = "//*[@id='lin1_col1']/span")
	WebElement janelaConsultaSigo;
	
	@FindBy(id = "main_table_grid")
	WebElement gridJanelaConsultaSigo;
	
	@FindBy(id = "lin2_col2")
	WebElement emailUsr;
	
	@FindBy(xpath = "//*[@id='main_menu_table']/tbody/tr[1]/td/table/tbody/tr/td[2]/img")
	WebElement imgCagepa;
	
	@FindBy(id = "item_21")
	WebElement btSigo;
	
	@FindBy(id = "aba_td_item_21")
	WebElement abaSigo;
	
	@FindBy(xpath = "//*[@id='item_5']/span")
	WebElement dropDownCadastros;
	
	@FindBy(xpath = "//*[@id='item_7']/span")
	WebElement controleOcorrencias;
	
	@FindBy(id = "item_1")
	WebElement btGerenciaRegional;
	
	@FindBy(id = "item_2")
	WebElement btSetor;
	
	@FindBy(id = "item_6")
	WebElement btSistema;
	
	@FindBy(xpath = "//*[@id='item_9']/span/img")
	WebElement btOpcoes;
	
	@FindBy(xpath = "//*[@id='item_3']/img")
	WebElement btSair;
	
	public void navegarParaCadastroGerenciaRegional() {
		abrirCruds();
		abrirAbaGerenciaRegional();
	}
	
	public void navegarParaCadastroSistema() {
		abrirCruds();
		abrirAbaSistema();
	}
	public void navegarParaCadastroSetor() {
		abrirCruds();
		abrirAbaSetor();
	}
	public void abrirAbaGerenciaRegional(){
		Log.info("Clicando no botao gerencia regional...");
		aguardarElementoVisivel(btGerenciaRegional);
		moverCursorPara(btGerenciaRegional);
		aguardarElementoVisivel(btGerenciaRegional);
		waitAndClick(btGerenciaRegional);
	}
	public void abrirAbaSetor(){
		Log.info("Clicando no botao setor...");
		aguardarElementoVisivel(btSetor);
		moverCursorPara(btSetor);
		click(btSetor);
	}
	public void abrirAbaSistema(){
		Log.info("Clicando no botao sistema...");
		aguardarElementoVisivel(btSistema);
		moverCursorPara(btSistema);
		click(btSistema);
	}
	
	public void verificaAutenticidadeUsuario(){
		Log.info("Direcionando para pagina inicial SIC CAGEPA...");
		aguardarElementoVisivel(msgBoasVindas);
		Log.info("Verificando mensagem de acesso...");
		Utils.assertEquals("Bem vindo, "+Property.USR, msgBoasVindas.getText());
		Log.info("Verificando usuário de acesso...");
		Utils.assertEquals(Property.EMAIL_USR, emailUsr.getText());
	}
	
	public void abrirCruds(){
		clicarBotaoSIGO();
		aguardarJanelaConsultaAparecer();
		abrirDropDownCadastrosSIGO();
	}
	
	public void clicarBotaoSIGO(){
		Log.info("Clicando no botao SIGO...");
		aguardarElementoVisivel(btSigo);
		waitAndClick(btSigo);
		Log.info("Aguardando aba SIGO aparecer...");
		aguardarElementoVisivel(abaSigo);
		Log.info("Aba SIGO visível");
	}
	
	public void abrirDropDownCadastrosSIGO(){
		Log.info("Selecionando frame cadastro...");
		selecionarFrameNameOrID(Property.FRAME_ID_ABA_MANTER_CADASTRO);
		Log.info("Frame alterada para aba cadastros.");
		aguardarElementoVisivel(controleOcorrencias);
		Log.info("Abrindo dropdown cadastros...");
		aguardarElementoVisivel(dropDownCadastros);
		Log.info("Dropdown cadastros aberto...");
		moverCursorPara(dropDownCadastros);
	}
	
	public void aguardarJanelaConsultaAparecer(){
		Log.info("Alterando frame para aba cadastros...");
		selecionarFrameNameOrID(Property.FRAME_ID_ABA_MANTER_CADASTRO);
		Log.info("Frame alterada para aba cadastros.");
		aguardarElementoVisivel(controleOcorrencias);
		Log.info("Alternando para frame inicial...");
		aguardarElementoVisivel(dropDownCadastros);
		selecionarFrameNameOrID(Property.FRAME_NAME_ABA_INICIAL);
		Log.info("Alternando para frame da janela Consulta - sigo...");
		aguardarElementoVisivel(gridJanelaConsultaSigo);
		aguardarElementoVisivel(janelaConsultaSigo);
		aguardarElementoVisivel(gridJanelaConsultaSigo);
		aguardarElementoVisivel(janelaConsultaSigo);
		Log.info("Janela ["+janelaConsultaSigo.getText()+"] exibida");
		retornarFramePai();
		aguardarElementoVisivel(btSigo);
	}
	
	public void sairDoSistema() {
		retornarFramePai();
		Log.info("Aguardando botão opções...");
		aguardarElementoVisivel(btOpcoes);
		moverCursorPara(btOpcoes);
		aguardarElementoVisivel(btSair);
		moverCursorPara(btSair);
		Log.info("Saindo do sistema SIC...");
		waitAndClick(btSair);
	}
}
