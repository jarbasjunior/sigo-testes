package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroGerenciaRegional;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.sistema.PageAtualizacaoSistema;
import br.com.cagepa.sigo.admin.page.sistema.PageCadastroSistema;
import br.com.cagepa.sigo.admin.page.sistema.PageInclusaoSistema;
import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.test.base.BaseTestCase;
import br.com.cagepa.sigo.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestSistema_IT extends BaseTestCase {

	PageInicialSIC 		   		 pageInicialSIC 	      	  = new PageInicialSIC();
	PageInclusaoSistema    		 pageInclusaoSistema    	  = new PageInclusaoSistema();   
	PageCadastroSistema    		 pageCadastroSistema    	  = new PageCadastroSistema();
	PageAtualizacaoSistema 		 pageAtualizacaoSistema 	  = new PageAtualizacaoSistema();
	PageInclusaoGerenciaRegional pageInclusaoGerenciaRegional = new PageInclusaoGerenciaRegional();   
	PageCadastroGerenciaRegional pageCadastroGerenciaRegional = new PageCadastroGerenciaRegional();

	@Test
	public void incluirSistemaComSucesso(){
		/*
		 * Incluindo gerencia regional
		 */
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastroGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastroGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastroGerenciaRegional.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastroGerenciaRegional.validacaoUnitariaPesquisaGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		String nomeGerencia = dadosGerenciaRegional.get(1);
		/*
		 * Incluindo sistema
		 */
		List<String> dadosSistema = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.validarFrameCadastroSistema();
		pageCadastroSistema.navegarParaInclusaoNovoSistema();
		dadosSistema = pageInclusaoSistema.incluirSistema(nomeGerencia);
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.pesquisaUnitariaSistema(dadosSistema.get(0));
		pageCadastroSistema.validacaoUnitariaPesquisaGerenciaRegionalComSucesso(dadosSistema.get(0), dadosSistema.get(1));
	}
	
	@Test
	public void excluirSistemaComSucesso(){
		/*
		 * Incluindo gerencia regional
		 */
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroGerenciaRegional.validarFrameCadastroGerenciasRegionais();
		pageCadastroGerenciaRegional.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroGerenciaRegional.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastroGerenciaRegional.validacaoUnitariaPesquisaGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		String nomeCompletoGerencia = dadosGerenciaRegional.get(0) +" - "+ dadosGerenciaRegional.get(1);
		/*
		 * Incluindo sistema
		 */
		List<String> dadosSistema = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.validarFrameCadastroSistema();
		pageCadastroSistema.navegarParaInclusaoNovoSistema();
		dadosSistema = pageInclusaoSistema.incluirSistema(nomeCompletoGerencia);
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.pesquisaUnitariaSistema(dadosSistema.get(0));
		/*
		 * Excluindo sistema
		 */
		pageCadastroSistema.navegarParaAtualizacaoGerenciaRegional();
		pageAtualizacaoSistema.excluirSistemaComSucesso(dadosSistema.get(0), dadosSistema.get(1));
		pageInicialSIC.navegarParaCadastroSistema();
		Log.info("Validando se Sistema nao eh exibido na listagem da pesquisa...");
		pageCadastroSistema.pesquisaUnitariaSistema(dadosSistema.get(0));
		pageCadastroSistema.validacaoUnitariaPesquisaSistemaSemSucesso(dadosSistema.get(0));
	}
	
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.validarFrameCadastroSistema();
		pageCadastroSistema.navegarParaInclusaoNovoSistema();
		pageInclusaoSistema.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.validarFrameCadastroSistema();
		pageCadastroSistema.navegarParaInclusaoNovoSistema();
		pageInclusaoSistema.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.validarFrameCadastroSistema();
		pageCadastroSistema.navegarParaInclusaoNovoSistema();
		pageInclusaoSistema.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
	}
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
		pageInicialSIC.navegarParaCadastroSistema();
		pageCadastroSistema.pesquisar_E_ValidarGerenciaRegionalEmMassa();
	}
}