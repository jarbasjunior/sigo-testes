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
	
	@FindBy(id = "lin2_col2")
	WebElement emailUsr;
	
	@FindBy(xpath = "//*[@id='main_menu_table']/tbody/tr[1]/td/table/tbody/tr/td[2]/img")
	WebElement imgCagepa;
	
	@FindBy(id = "item_21")
	WebElement btSigo;
	
	@FindBy(css = "#item_5")
	WebElement dropDownCadastros;
	
	@FindBy(id = "item_1")
	WebElement btGerenciaRegional;
	
	@FindBy(id = "item_2")
	WebElement btSetor;
	
	public void navegarParaCadastroGerenciaRegional() {
		abrirCruds();
		abrirAbaGerenciaRegional();
	}
	public void navegarParaCadastroSetor() {
		abrirCruds();
		abrirAbaSetor();
	}
	public void abrirAbaGerenciaRegional(){
		Log.info("Clicando no botao gerencia regional...");
		moverCursorPara(btGerenciaRegional);
		clickBotao(btGerenciaRegional);
	}
	public void abrirAbaSetor(){
		Log.info("Clicando no botao setor...");
		moverCursorPara(btSetor);
		clickBotao(btSetor);
	}
	
	public void verificaAutenticidadeUsuario(){
		Log.info("Direcionando para pagina inicial SIC CAGEPA...");
		aguardarElementoVisivel(imgCagepa);
		Log.info("Verificando mensagem de acesso...");
		Utils.assertEquals("Bem vindo, "+Property.USR, msgBoasVindas.getText());
		Log.info("Verificando usuário de acesso...");
		Utils.assertEquals(Property.EMAIL_USR, emailUsr.getText());
	}
	
	public void abrirCruds(){
		clicarBotaoSIGO();
		abrirDropDownCadastrosSIGO();
	}
	public void clicarBotaoSIGO(){
		Log.info("Clicando no botao SIGO...");
		aguardarElementoVisivel(btSigo);
		clickBotao(btSigo);
	}
	public void abrirDropDownCadastrosSIGO(){
		Log.info("Alterando frame...");
		selecionarFrameNameOrID(Property.FRAME_ID_ABA_CADASTRO);
		Log.info("Frame alterada para aba cadastros.");
		Log.info("Abrindo dropdown cadastros...");
		moverCursorPara(dropDownCadastros);
	}
}
