package br.com.cagepa.sigo.admin.test;

import org.junit.Test;

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

	String         			       nomeTeste      				   = null;
	PageInicialSIC 			       pageInicialSIC 				   = new PageInicialSIC();
	PageInclusaoGerenciaRegional   pageInclusaoGerenciaRegional    = new PageInclusaoGerenciaRegional();   
	PageCadastroGerenciasRegionais pageCadastrosGerenciasRegionais = new PageCadastroGerenciasRegionais();
	
	@Test
	public void tentarIncluirGerenciaRegionalSemSucesso(){
		nomeTeste = "tentarIncluirGerenciaRegionalSemSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.incluirGerenciaRegionalEmMassa();
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosGerenciasRegionais.pesquisar_E_ValidarGerenciaRegionalEmMassa();
		Log.msgFimTeste(nomeTeste);
	}
	
//	@Test
//	public void pesquisarGerenciaRegionalComSucesso(){
//		nomeTeste = "pesquisarGerenciaRegionalComSucesso";
//		Log.msgInicioTeste(nomeTeste);
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional();
//		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaGerenciaRegional();
//		Log.msgFimTeste(nomeTeste);
//	}
//	
//	@Test
//	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
//		nomeTeste = "pesquisarGerenciaRegionalEmMassaComSucesso";
//		Log.msgInicioTeste(nomeTeste);
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosGerenciasRegionais.pesquisar_E_ValidarGerenciaRegionalEmMassa();
//		Log.msgFimTeste(nomeTeste);
//	}
}