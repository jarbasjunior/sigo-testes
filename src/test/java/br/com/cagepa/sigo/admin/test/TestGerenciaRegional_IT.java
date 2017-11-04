package br.com.cagepa.sigo.admin.test;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageManterGerenciaRegional;
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

	String         			   nomeTeste      		= null;
	PageInicialSIC 			   pageInicialSIC 		= new PageInicialSIC();
	PageManterGerenciaRegional pageGerenciaRegional = new PageManterGerenciaRegional();
	
	@Test
	public void pesquisarGerenciaRegionalComSucesso(){
		
		nomeTeste = "pesquisarGerenciaRegionalComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.clicarBotaoSIGO();
		pageInicialSIC.abrirDropDownCadastrosSIGO();
		pageInicialSIC.abrirAbaGerenciaRegional();
		pageGerenciaRegional.pesquisarGerenciaRegional();
		pageGerenciaRegional.validarPesquisaGerenciaRegional();
		Log.msgFimTeste(nomeTeste);
	}
}