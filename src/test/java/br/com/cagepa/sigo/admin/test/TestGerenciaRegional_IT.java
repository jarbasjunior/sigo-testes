package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageAtualizacaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroGerenciaRegional;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.page.base.PageLoginSIC;
import br.com.cagepa.sigo.test.base.BaseTestCase;
import br.com.cagepa.sigo.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestGerenciaRegional_IT extends BaseTestCase {

	PageLoginSIC                    pageLoginSIC                    = new PageLoginSIC();
	PageInicialSIC 			        pageInicialSIC 				    = new PageInicialSIC();
	PageInclusaoGerenciaRegional    pageInclusaoGerenciaRegional    = new PageInclusaoGerenciaRegional();   
	PageCadastroGerenciaRegional    pageCadastrosGerenciaRegional   = new PageCadastroGerenciaRegional();
	PageAtualizacaoGerenciaRegional pageAtualizacaoGerenciaRegional = new PageAtualizacaoGerenciaRegional();
	
	
	@Test
	public void incluirGerenciaRegionalComSucesso(){
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciaRegional.validacaoUnitariaPesquisaGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		Log.info("INCLUSAO REALIZADA COM SUCESSO ! ! !");
		pageInicialSIC.sairDoSistema();
	}
	
	@Test
	public void excluirGerenciaRegionalComSucesso(){
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciaRegional.navegarParaAtualizacaoGerenciaRegional();
		pageAtualizacaoGerenciaRegional.excluirGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		Log.info("Validando se gerencia nao eh exibida na listagem da pesquisa...");
		pageCadastrosGerenciaRegional.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciaRegional.validacaoUnitariaPesquisaGerenciaRegionalSemSucesso(dadosGerenciaRegional.get(0));
		pageInicialSIC.sairDoSistema();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
		pageInicialSIC.sairDoSistema();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
		pageInicialSIC.sairDoSistema();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
		pageInicialSIC.sairDoSistema();
	}
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciaRegional.pesquisar_E_ValidarGerenciaRegionalEmMassa();
		pageInicialSIC.sairDoSistema();
	}
}