package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageAtualizacaoSetor;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroSetor;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoSetor;
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
	PageInclusaoSetor    pageInclusaoGerenciaRegional    = new PageInclusaoSetor();   
	PageCadastroSetor  pageCadastrosGerenciasRegionais = new PageCadastroSetor();
	PageAtualizacaoSetor pageAtualizacaoGerenciaRegional = new PageAtualizacaoSetor();
	
	/*
	 * CRIAR TESTES PARA OBRIGATORIEDADE DOS CAMPOS
	 */
	
	/*
	 * TODO CRIAR TESTES DE EXCLUSAO DE GERENCIA REGIONAL COM SUCESSO
	 */

	@Test
	public void excluirGerenciaRegionalComSucesso(){
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.validarFrameCadastroSetor();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovoSetor();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaSetor(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.navegarParaAtualizacaoSetor();
		pageAtualizacaoGerenciaRegional.excluirGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		pageInicialSIC.navegarParaCadastroSetor();
		Log.info("Validando se gerencia nao eh exibida na listagem da pesquisa...");
		pageCadastrosGerenciasRegionais.pesquisaUnitariaSetor(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaSetorSemSucesso(dadosGerenciaRegional.get(0));
	}
	
	@Test
	public void incluirGerenciaRegionalComSucesso(){
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.validarFrameCadastroSetor();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovoSetor();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaSetor(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaSetorComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.validarFrameCadastroSetor();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovoSetor();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.validarFrameCadastroSetor();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovoSetor();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.validarFrameCadastroSetor();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovoSetor();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
	}
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosGerenciasRegionais.pesquisar_E_ValidarSetorEmMassa();
	}
}