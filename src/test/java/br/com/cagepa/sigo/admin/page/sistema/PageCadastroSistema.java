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

public class PageCadastroSistema extends
		PageObjectGeneric<PageCadastroSistema> {

	public PageCadastroSistema() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "quicksearchph_top")
	WebElement enableFieldSistema;

	@FindBy(id = "SC_fast_search_top")
	WebElement fieldSistema;

	@FindBy(id = "SC_fast_search_submit_top")
	WebElement btLupaSistema;

	@FindBy(id = "sc_btgp_btn_group_1_top")
	WebElement btExportacao;

	@FindBy(id = "sc_b_new_top")
	WebElement btNovoSistema;

	@FindBy(id = "brec_bot")
	WebElement btIrPara;

	@FindBy(id = "lin1_col1")
	WebElement titleCadastroSistema;

	@FindBy(id = "lin1_col2")
	WebElement textoDataConsulta;

	@FindBy(xpath = "//*[@id='tit_sigo_sistema_grid__SCCS__1']/td[2]/a")
	WebElement textoSiglaGRTabela;

	@FindBy(xpath = "//*[@id='tit_sigo_sistema_grid__SCCS__1']/td[3]/a")
	WebElement textoNomeTabela;
	
	@FindBy(xpath = "//*[@id='tit_sigo_sistema_grid__SCCS__1']/td[4]/a")
	WebElement textoNomeTipo;

	@FindBy(xpath = "//*[@id='sc_grid_toobar_bot']/table/tbody/tr/td[1]/span")
	WebElement textoVisualizar;

	@FindBy(id = "id_sc_field_sigla_1")
	WebElement textoSiglaRetornoConsulta;

	@FindBy(id = "id_sc_field_nome_1")
	WebElement textoNomeRetornoConsulta;
	
	@FindBy(id = "id_img_bedit")
	WebElement btEditarCadastroRegional;
	
	@FindBy(id = "sc_grid_body")
	WebElement msgRegistroNaoEncontrado;

	By msgAguarde = By.xpath("html/body/div[5]/div/span/img");

	/*
	 * ===============================================================================================
	 *  MÉTODOS DE PESQUISA E VALIDAÇÃO EM MASSA DE GERENCIAS REGIONAIS
	 *  
	 */
	
	public void navegarParaInclusaoNovoSistema(){
		Log.info("Navegando para tela de inclusão de novo sistema...");
		click(btNovoSistema);
		Utils.wait(2000);
	}
	
	public void navegarParaAtualizacaoGerenciaRegional(){
		Log.info("Navegando para tela de atualizacao de gerencia regional...");
		esperarElementoDesaparecer(msgAguarde, 10);
		click(btEditarCadastroRegional);
		esperarElementoDesaparecer(msgAguarde, 10);
	}

	public void pesquisar_E_ValidarGerenciaRegionalEmMassa() {
		
		try {
			XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		validarFrameCadastroSistema();

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
			click(enableFieldSistema);
			Utils.wait(500);
			aguardarElementoVisivel(fieldSistema);
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
			preencherCampo(fieldSistema, valorCelula);
			click(btLupaSistema);
			Log.info("Aguardando retorno da consulta...");
			esperarElementoDesaparecer(msgAguarde, 15);
			validarCamposDaPesquisa(camposDeValidacao(), linha, coluna); 
			linha++;
			contador++;
			registrosRestantes--;
		} while (registrosRestantes > 0);
		
		Log.info("Retornando para frame SIGO...");
		retornarFramePai();
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
		List<WebElement> elementos = new ArrayList<WebElement>();
		elementos.add(titleCadastroSistema);
		elementos.add(textoSiglaGRTabela);
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
	public void pesquisaUnitariaSistema(String sigla) {
		validarFrameCadastroSistema();
		Log.info("Habilitando o campo de pesquisa...");
		click(enableFieldSistema);
		Log.info("Campo de pesquisas habilitado.");
		Utils.wait(1000);
		aguardarElementoVisivel(fieldSistema);
		Log.info("Inserindo valor ["+sigla+"] no campo de pesquisa...");
		preencherCampo(fieldSistema, sigla);
		click(btLupaSistema);
		Log.info("Aguardando retorno da pesquisa...");
	}
	
	public void pesquisaUnitariaGerenciaRegionalSemSucesso(String sigla) {
		validarFrameCadastroSistema();
		click(enableFieldSistema);
		Utils.wait(1000);
		aguardarElementoVisivel(fieldSistema);
		Log.info("Inserindo valor ["+sigla+"] no campo de pesquisa...");
		preencherCampo(fieldSistema, sigla);
		click(btLupaSistema);
		Log.info("Aguardando retorno da pesquisa...");
	}

	public void validacaoUnitariaPesquisaGerenciaRegionalComSucesso(String sigla, String nome) {
		esperarElementoDesaparecer(msgAguarde, 15);
		Log.info("Validando nome da gerencia regional...");
		Utils.assertEquals(titleCadastroSistema.getText(),	"Cadastro de Gerências Regionais");
		Log.info("Validando data da consulta...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nome [Sigla] na tabela...");
		Utils.assertEquals(textoSiglaGRTabela.getText(), "Sigla");
		Log.info("Validando nome [Nome] na tabela...");
		Utils.assertEquals(textoNomeTabela.getText(), "Nome");
		Log.info("Validando sigla do retorno da consulta...");
		Utils.assertEquals(textoSiglaRetornoConsulta.getText(), sigla);
		Log.info("Validando nome do retorno da consulta...");
		Utils.assertEquals(textoNomeRetornoConsulta.getText(), nome);
		retornarFramePai();
	}
	
	public void validacaoUnitariaPesquisaSistemaSemSucesso(String sigla) {
		esperarElementoDesaparecer(msgAguarde, 15);
		Utils.assertEquals(titleCadastroSistema.getText(),	"Cadastro de Gerências Regionais");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando mensagem de registro nao encontrado...");
		Utils.assertEquals(msgRegistroNaoEncontrado.getText(), "Registros não encontrados");
		retornarFramePai();
	}

	/*
	 * ===============================================================================================
	 * 
	 */

	/*
	 * MÉTODO PARA VALIDAR CAMPOS DA FRAME DE CADASTRO DE REGIONAL
	 */
	public void validarFrameCadastroSistema() {
		Log.info("Alterando frame...");
		selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER_SISTEMA);
		click(titleCadastroSistema);
		Log.info("Frame alterada para aba Manter Sistema.");
		Log.info("Validando frame de cadastro de Sistema.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleCadastroSistema.getText(),"Cadastro de Sistemas");
		Log.info("Validando data...");
		Utils.assertEquals(textoDataConsulta.getText(), Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btExportacao.getText(), "  Exportação  ");
		Utils.assertEquals(btNovoSistema.getText(), "Novo Sistema");
		Utils.assertEquals(btIrPara.getText(), "Ir para");
		Log.info("Validando nomes...");
		Utils.assertEquals(textoSiglaGRTabela.getText(), "Sigla GR");
		Utils.assertEquals(textoNomeTabela.getText()   , "Nome");
		Utils.assertEquals(textoNomeTipo.getText()     , "Tipo");
		Utils.assertEquals(textoVisualizar.getText()   , "Visualizar");
	}
}
