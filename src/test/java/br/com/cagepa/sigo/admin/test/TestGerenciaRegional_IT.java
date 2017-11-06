package br.com.cagepa.sigo.admin.test;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroGerenciasRegionais;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoGerenciaRegional;
import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.test.base.BaseTestCase;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.XLS_Utils;

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
	
	/*@Test
	public void incluirGerenciaRegionalComSucesso(){
		nomeTeste = "incluirGerenciaRegionalComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageInclusaoGerenciaRegional.incluirGerenciaRegionalComSucesso();
		Log.msgFimTeste(nomeTeste);
	}*/
	
	/*@Test
	public void pesquisarGerenciaRegionalComSucesso(){
		nomeTeste = "pesquisarGerenciaRegionalComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional();
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaGerenciaRegional();
		Log.msgFimTeste(nomeTeste);
	}*/
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() throws Exception{
		nomeTeste = "pesquisarGerenciaRegionalComSucesso";
		Log.msgInicioTeste(nomeTeste);
		XLS_Utils.getArquivoExcel(Property.PLANILHA_GERENCIA_REGIONAL);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisarValidarGerenciaRegionalEmMassa();
		XLS_Utils.fecharArquivo();
		Log.msgFimTeste(nomeTeste);
	}
}