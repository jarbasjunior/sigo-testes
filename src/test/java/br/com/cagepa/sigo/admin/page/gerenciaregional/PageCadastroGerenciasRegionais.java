package br.com.cagepa.sigo.admin.page.gerenciaregional;

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

public class PageCadastroGerenciasRegionais extends PageObjectGeneric<PageCadastroGerenciasRegionais> {

	public PageCadastroGerenciasRegionais() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "quicksearchph_top")
	WebElement clickFieldGerenciaRegional;
	
	@FindBy(id = "SC_fast_search_top")
	WebElement fieldGerenciaRegional;
	
	@FindBy(id = "SC_fast_search_submit_top")
	WebElement btLupaGerenciaRegional;
	
	@FindBy(id = "sc_btgp_btn_group_1_top")
	WebElement btExportacao;
	
	@FindBy(id = "sc_b_new_top")
	WebElement btNovaGerencia;
	
	@FindBy(id = "brec_bot")
	WebElement btIrPara;
	
	@FindBy(id = "lin1_col1")
	WebElement titleCadastroGerenciaRegional;
	
	@FindBy(id = "lin1_col2")
	WebElement textoDataConsulta;
	
	@FindBy(xpath = ".//*[@id='tit_sigo_gerencia_regional_grid__SCCS__1']/td[2]/a")
	WebElement textoSiglaTabela;
	
	@FindBy(xpath = ".//*[@id='tit_sigo_gerencia_regional_grid__SCCS__1']/td[3]/a")
	WebElement textoNomeTabela;
	
	@FindBy(xpath = "//*[@id='sc_grid_toobar_bot']/table/tbody/tr/td[1]/span")
	WebElement textoVisualizar;
	
	@FindBy(id = "id_sc_field_sigla_1")
	WebElement textoSiglaRetornoConsulta;
	
	@FindBy(id = "id_sc_field_nome_1")
	WebElement textoNomeRetornoConsulta;
	
	By msgAguarde = By.xpath("html/body/div[5]/div/span/img");
	
	/*===============================================================================================
	 * MÉTODOS DE PESQUISA E VALIDAÇÃO EM MASSA DE GERENCIAS REGIONAIS
	 */
	
	public void pesquisarValidarGerenciaRegionalEmMassa() throws Exception{
		validarFrameCadastroGerenciasRegionais();
		
		pesquisaValidacaoEmMassa(clickFieldGerenciaRegional, fieldGerenciaRegional, 
								 btLupaGerenciaRegional, msgAguarde,
								 camposDeValidacao());
		
		
		clickBotao(clickFieldGerenciaRegional);
		Utils.wait(1000);
		aguardarElementoVisivel(fieldGerenciaRegional);
		Log.info("Inserindo valor [GRES] no campo de pesquisa...");
		preencherCampo(fieldGerenciaRegional, "GRES");
		clickBotao(btLupaGerenciaRegional);
		Log.info("Aguardando retorno da pesquisa...");
	}
	
	/*
	 *  GUARDA TODOS ELEMENTOS DE VALIDAÇÃO EM UMA LISTA
	 */
		public List<WebElement> camposDeValidacao(){
			List<WebElement> elementos = new ArrayList<>();
			elementos.add(titleCadastroGerenciaRegional);
			elementos.add(textoSiglaTabela);
			elementos.add(textoNomeTabela);
			elementos.add(textoSiglaRetornoConsulta);
			elementos.add(textoNomeRetornoConsulta);
			elementos.add(textoDataConsulta);
			return elementos;
		}
	//===============================================================================================
	 
	
	/*===============================================================================================
	 * MÉTODOS DE PESQUISA E VALIDAÇÃO UNITÁRIA DE GERENCIAS REGIONAIS
	 */
	public void pesquisaUnitariaGerenciaRegional(){
		validarFrameCadastroGerenciasRegionais();
		clickBotao(clickFieldGerenciaRegional);
		Utils.wait(1000);
		aguardarElementoVisivel(fieldGerenciaRegional);
		Log.info("Inserindo valor [GRES] no campo de pesquisa...");
		preencherCampo(fieldGerenciaRegional, "GRES");
		clickBotao(btLupaGerenciaRegional);
		Log.info("Aguardando retorno da pesquisa...");
	}
	
	public void validacaoUnitariaPesquisaGerenciaRegional(){
		esperarElementoDesaparecer(msgAguarde, 15);
		Log.info("Validando nome da gerencia regional...");
		Utils.assertEquals(titleCadastroGerenciaRegional.getText(), "Cadastro de Gerências Regionais");
		Log.info("Validando data da consulta...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nome [Sigla] na tabela...");
		Utils.assertEquals(textoSiglaTabela.getText(), "Sigla");
		Log.info("Validando nome [Nome] na tabela...");
		Utils.assertEquals(textoNomeTabela.getText(), "Nome");
		Log.info("Validando sigla do retorno da consulta...");
		Utils.assertEquals(textoSiglaRetornoConsulta.getText(), "GRES");
		Log.info("Validando nome do retorno da consulta...");
		Utils.assertEquals(textoNomeRetornoConsulta.getText(), "Gerência Regional das Espinharas");
	}
	/*
	 * ===============================================================================================
	 */
	
	/*
	 * MÉTODO PARA VALIDAR CAMPOS DA FRAME DE CADASTRO DE REGIONAL
	 */
	public void validarFrameCadastroGerenciasRegionais(){
		Log.info("Alterando frame...");
		selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER);
		Log.info("Frame alterada para aba manter.");
		Log.info("Validando frame de cadastro de gerencia regional.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleCadastroGerenciaRegional.getText(), "Cadastro de Gerências Regionais");
		Log.info("Validando data...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btExportacao.getText()  , "  Exportação  ");
		Utils.assertEquals(btNovaGerencia.getText(), "Nova Gerência");
		Utils.assertEquals(btIrPara.getText()      , "Ir para");
		Log.info("Validando nomes...");
		Utils.assertEquals(textoSiglaTabela.getText(), "Sigla");
		Utils.assertEquals(textoNomeTabela.getText() , "Nome");
		Utils.assertEquals(textoVisualizar.getText() , "Visualizar");
	}
}
