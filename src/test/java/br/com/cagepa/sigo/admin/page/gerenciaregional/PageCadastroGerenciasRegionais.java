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
import br.com.cagepa.sigo.util.XLS_Utils;

public class PageCadastroGerenciasRegionais extends
		PageObjectGeneric<PageCadastroGerenciasRegionais> {

	public PageCadastroGerenciasRegionais() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "quicksearchph_top")
	WebElement enableFieldGerenciaRegional;

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

	/*
	 * ===============================================================================================
	 *  MÉTODOS DE PESQUISA E VALIDAÇÃO EM MASSA DE GERENCIAS REGIONAIS
	 *  
	 */
	
	public void navegarParaInclusaoNovaGerenciaRegional(){
		Log.info("Navegando para tela de inclusão de nova gerencia regional...");
		clickBotao(btNovaGerencia);
	}

	public void pesquisar_E_ValidarGerenciaRegionalEmMassa() {
		
		try {
			XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		validarFrameCadastroGerenciasRegionais();

		int    linha        = 0;
		int    coluna       = 0;
		int    contador     = 1;
		String valorCelula  = null;
		int    qtdRegistros = 0;
		
		Log.info("Capturando quantidade de registros na planilha...");
		try {
			qtdRegistros = XLS_Utils.qtdRegistrosPlanilha();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int registrosRestantes  = qtdRegistros;
		Log.info("["+qtdRegistros+"] registros encontrados na planilha.");
		
		do {
			
			Log.info("Habilitando campo de pesquisa...");
			clickBotao(enableFieldGerenciaRegional);
			Utils.wait(500);
			aguardarElementoVisivel(fieldGerenciaRegional);
			Log.info("Campo para pesquisa habilitado.");
			Log.info("-------------------------------------------------------------------------------------");
			Log.info("Pesquisando e validando registro ["+contador+"/"+qtdRegistros+"]...");
			Log.info("-------------------------------------------------------------------------------------");
			try {
				valorCelula = XLS_Utils.getDadosCelula(linha, coluna);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Log.info("Inserindo valor [" + valorCelula + "]...");
			preencherCampo(fieldGerenciaRegional, valorCelula);
			clickBotao(btLupaGerenciaRegional);
			Log.info("Aguardando retorno da consulta...");
			esperarElementoDesaparecer(msgAguarde, 15);
			validarCamposDaPesquisa(camposDeValidacao(), linha, coluna); 
			linha++;
			contador++;
			registrosRestantes--;
		} while (registrosRestantes > 0);
		
		Log.info("Retornando para frame SIGO...");
		retornarFrameAnterior();
		Log.info("Retornado para frame SIGO...");
		XLS_Utils.fecharArquivoLeitura();
	}

	public void validarCamposDaPesquisa(List<WebElement> campos, int linha, int coluna) {
		String textoNomeRetornoConsulta  = null;
		String textoSiglaRetornoConsulta = null; 
		try {
			textoSiglaRetornoConsulta = XLS_Utils.getDadosCelula(linha, coluna);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			textoNomeRetornoConsulta = XLS_Utils.getDadosCelula(linha, coluna+1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Log.info("Validando retorno da consulta");
		Utils.assertEquals(campos.get(0).getText(), Property.TELA_TITULO_CADASTRO_GERENCIA_REGIONAL);
		Utils.assertEquals(campos.get(1).getText(), Property.TELA_SIGLA);
		Utils.assertEquals(campos.get(2).getText(), Property.TELA_NOME);
		Utils.assertEquals(campos.get(3).getText(), textoSiglaRetornoConsulta);
		Utils.assertEquals(campos.get(4).getText(), textoNomeRetornoConsulta);
		Utils.assertEquals(campos.get(5).getText(), Utils.getDataAtual());
	}

	/*
	 * GUARDA TODOS ELEMENTOS DE VALIDAÇÃO DO RETORNO DA CONSULTA EM UMA LISTA
	 */
	public List<WebElement> camposDeValidacao() {
		List<WebElement> elementos = new ArrayList<>();
		elementos.add(titleCadastroGerenciaRegional);
		elementos.add(textoSiglaTabela);
		elementos.add(textoNomeTabela);
		elementos.add(textoSiglaRetornoConsulta);
		elementos.add(textoNomeRetornoConsulta);
		elementos.add(textoDataConsulta);
		return elementos;
	}

	// ===============================================================================================

	/*
	 * ===============================================================================================
	 *  MÉTODOS DE PESQUISA E VALIDAÇÃO UNITÁRIA DE GERENCIAS REGIONAIS
	 *  
	 */
	public void pesquisaUnitariaGerenciaRegional() {
		validarFrameCadastroGerenciasRegionais();
		clickBotao(enableFieldGerenciaRegional);
		Utils.wait(1000);
		aguardarElementoVisivel(fieldGerenciaRegional);
		Log.info("Inserindo valor [GRES] no campo de pesquisa...");
		preencherCampo(fieldGerenciaRegional, "GRES");
		clickBotao(btLupaGerenciaRegional);
		Log.info("Aguardando retorno da pesquisa...");
	}

	public void validacaoUnitariaPesquisaGerenciaRegional() {
		esperarElementoDesaparecer(msgAguarde, 15);
		Log.info("Validando nome da gerencia regional...");
		Utils.assertEquals(titleCadastroGerenciaRegional.getText(),
				"Cadastro de Gerências Regionais");
		Log.info("Validando data da consulta...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nome [Sigla] na tabela...");
		Utils.assertEquals(textoSiglaTabela.getText(), "Sigla");
		Log.info("Validando nome [Nome] na tabela...");
		Utils.assertEquals(textoNomeTabela.getText(), "Nome");
		Log.info("Validando sigla do retorno da consulta...");
		Utils.assertEquals(textoSiglaRetornoConsulta.getText(), "GRES");
		Log.info("Validando nome do retorno da consulta...");
		Utils.assertEquals(textoNomeRetornoConsulta.getText(),
				"Gerência Regional das Espinharas");
		Log.info("Retornando para frame SIGO...");
		retornarFrameAnterior();
		Log.info("Retornado para frame SIGO...");
	}

	/*
	 * ===============================================================================================
	 * 
	 */

	/*
	 * MÉTODO PARA VALIDAR CAMPOS DA FRAME DE CADASTRO DE REGIONAL
	 */
	public void validarFrameCadastroGerenciasRegionais() {
		Log.info("Alterando frame...");
		selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER);
		clickBotao(titleCadastroGerenciaRegional);
		Log.info("Frame alterada para aba Manter Gerencia Regional.");
		Log.info("Validando frame de cadastro de Gerencia regional.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleCadastroGerenciaRegional.getText(),
				"Cadastro de Gerências Regionais");
		Log.info("Validando data...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btExportacao.getText(), "  Exportação  ");
		Utils.assertEquals(btNovaGerencia.getText(), "Nova Gerência");
		Utils.assertEquals(btIrPara.getText(), "Ir para");
		Log.info("Validando nomes...");
		Utils.assertEquals(textoSiglaTabela.getText(), "Sigla");
		Utils.assertEquals(textoNomeTabela.getText(), "Nome");
		Utils.assertEquals(textoVisualizar.getText(), "Visualizar");
	}
}
