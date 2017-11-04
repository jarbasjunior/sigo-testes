package br.com.cagepa.sigo.admin.page.gerenciaregional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;

public class PageManterGerenciaRegional extends PageObjectGeneric<PageManterGerenciaRegional> {

	public PageManterGerenciaRegional() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "quicksearchph_top")
	WebElement clickFieldGerenciaRegional;
	
	@FindBy(id = "SC_fast_search_top")
	WebElement fieldGerenciaRegional;
	
	@FindBy(id = "SC_fast_search_submit_top")
	WebElement btLupaGerenciaRegional;
	
	@FindBy(id = "lin1_col1")
	WebElement nomeCadastroGerenciaRegional;
	
	@FindBy(id = "lin1_col2")
	WebElement dataConsulta;
	
	@FindBy(xpath = ".//*[@id='tit_sigo_gerencia_regional_grid__SCCS__1']/td[2]/a")
	WebElement siglaTabela;
	
	@FindBy(xpath = ".//*[@id='tit_sigo_gerencia_regional_grid__SCCS__1']/td[3]/a")
	WebElement nomeTabela;
	
	@FindBy(id = "id_sc_field_sigla_1")
	WebElement siglaRetornoConsulta;
	
	@FindBy(id = "id_sc_field_nome_1")
	WebElement nomeRetornoConsulta;
	
	By msgAguarde = By.xpath("html/body/div[5]/div/span/img");
	
	public void pesquisarGerenciaRegional(){
		Log.info("Alterando frame...");
		selecionarFrameString(Property.FRAME_NAME_ABA_MANTER);
		Log.info("Frame alterada para aba manter.");
		clickBotao(clickFieldGerenciaRegional);
		Utils.wait(1000);
		aguardarElementoVisivel(fieldGerenciaRegional);
		Log.info("Inserindo valor [GRES] no campo de pesquisa...");
		preencherCampo(fieldGerenciaRegional, "GRES");
		clickBotao(btLupaGerenciaRegional);
		Log.info("Aguardando retorno da pesquisa...");
	}
	
	public void validarPesquisaGerenciaRegional(){
		esperarElementoDesaparecer(msgAguarde, 15);
		Log.info("Validando nome da gerencia regional...");
		Utils.assertEquals(nomeCadastroGerenciaRegional.getText(), "Cadastro de Gerências Regionais");
		Log.info("Validando data da consulta...");
		Utils.assertEquals(dataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nome [Sigla] na tabela...");
		Utils.assertEquals(siglaTabela.getText(), "Sigla");
		Log.info("Validando nome [Nome] na tabela...");
		Utils.assertEquals(nomeTabela.getText(), "Nome");
		Log.info("Validando sigla do retorno da consulta...");
		Utils.assertEquals(siglaRetornoConsulta.getText(), "GRES");
		Log.info("Validando nome do retorno da consulta...");
		Utils.assertEquals(nomeRetornoConsulta.getText(), "Gerência Regional das Espinharas");
	}
}
