package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageAtualizacaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroGerenciasRegionais;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.test.base.BaseTestCase;
import br.com.cagepa.sigo.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestGerenciaRegional_IT extends BaseTestCase {

	PageInicialSIC 			        pageInicialSIC 				    = new PageInicialSIC();
	PageInclusaoGerenciaRegional    pageInclusaoGerenciaRegional    = new PageInclusaoGerenciaRegional();   
	PageCadastroGerenciasRegionais  pageCadastrosGerenciasRegionais = new PageCadastroGerenciasRegionais();
	PageAtualizacaoGerenciaRegional pageAtualizacaoGerenciaRegional = new PageAtualizacaoGerenciaRegional();
	
	/*
	 * CRIAR TESTES PARA OBRIGATORIEDADE DOS CAMPOS
	 */
	
	/*
	 * TODO CRIAR TESTES DE EXCLUSAO DE GERENCIA REGIONAL COM SUCESSO
	 */

	@Test
	public void excluirGerenciaRegionalComSucesso(){
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.navegarParaAtualizacaoGerenciaRegional();
		pageAtualizacaoGerenciaRegional.excluirGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		Log.info("Validando se gerencia nao eh exibida na listagem da pesquisa...");
		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaGerenciaRegionalSemSucesso(dadosGerenciaRegional.get(0));
	}
	
	@Test
	public void incluirGerenciaRegionalComSucesso(){
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
	}
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisar_E_ValidarGerenciaRegionalEmMassa();
	}
}