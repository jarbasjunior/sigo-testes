package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

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
	
	/*
	 * CRIAR TESTES PARA OBRIGATORIEDADE DOS CAMPOS
	 */
	
	/*
	 * CRIAR TESTES DE EXCLUSAO DE GERENCIA REGIONAL COM SUCESSO
	 */

	@Test
	public void incluirGerenciaRegionalComSucesso(){
		nomeTeste = "incluirGerenciaRegionalComSucesso";
		Log.msgInicioTeste(nomeTeste);
		List<String> dadosGerenciaRegional = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		dadosGerenciaRegional = pageInclusaoGerenciaRegional.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
		pageCadastrosGerenciasRegionais.validacaoUnitariaPesquisaGerenciaRegional(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
		nomeTeste = "tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
		nomeTeste = "tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
		nomeTeste = "tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.validarFrameCadastroGerenciasRegionais();
		pageCadastrosGerenciasRegionais.navegarParaInclusaoNovaGerenciaRegional();
		pageInclusaoGerenciaRegional.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
		nomeTeste = "pesquisarGerenciaRegionalEmMassaComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageInicialSIC.navegarParaCadastroGerenciaRegional();
		pageCadastrosGerenciasRegionais.pesquisar_E_ValidarGerenciaRegionalEmMassa();
		Log.msgFimTeste(nomeTeste);
	}
}