package br.com.cagepa.sigo.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.gerenciaregional.PageAtualizacaoSetor;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageCadastroSetor;
import br.com.cagepa.sigo.admin.page.gerenciaregional.PageInclusaoSetor;
import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.test.base.BaseTestCase;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestSetor_IT extends BaseTestCase {

	PageInicialSIC 		 pageInicialSIC		= new PageInicialSIC();
	PageInclusaoSetor    pageInclusaoSetor    = new PageInclusaoSetor();   
	PageCadastroSetor    pageCadastrosSetor   = new PageCadastroSetor();
	PageAtualizacaoSetor pageAtualizacaoSetor = new PageAtualizacaoSetor();
	
	/*
	 * CRIAR TESTES PARA OBRIGATORIEDADE DOS CAMPOS
	 */
	
	@Test
	public void incluirSetorComSucesso(){
		List<String> dadosSetor = new ArrayList<String>();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosSetor.validarFrameCadastroSetor();
		pageCadastrosSetor.navegarParaInclusaoNovoSetor();
		dadosSetor = pageInclusaoSetor.incluirGerenciaRegional();
		pageInicialSIC.navegarParaCadastroSetor();
		pageCadastrosSetor.pesquisaUnitariaSetor(dadosSetor.get(0));
		pageCadastrosSetor.validacaoUnitariaPesquisaSetorComSucesso(dadosSetor.get(0), dadosSetor.get(1));
	}
	
//	@Test
//	public void excluirGerenciaRegionalComSucesso(){
//		List<String> dadosGerenciaRegional = new ArrayList<String>();
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.validarFrameCadastroGerenciasRegionais();
//		pageCadastrosSetor.navegarParaInclusaoNovaGerenciaRegional();
//		dadosGerenciaRegional = pageInclusaoSetor.incluirGerenciaRegional();
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
//		pageCadastrosSetor.navegarParaAtualizacaoGerenciaRegional();
//		pageAtualizacaoSetor.excluirGerenciaRegionalComSucesso(dadosGerenciaRegional.get(0), dadosGerenciaRegional.get(1));
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		Log.info("Validando se gerencia nao eh exibida na listagem da pesquisa...");
//		pageCadastrosSetor.pesquisaUnitariaGerenciaRegional(dadosGerenciaRegional.get(0));
//		pageCadastrosSetor.validacaoUnitariaPesquisaGerenciaRegionalSemSucesso(dadosGerenciaRegional.get(0));
//	}
//	
//	@Test
//	public void tentarIncluirEmMassaGerenciaRegionalComSiglaInvalidaNomeExistenteSemSucesso(){
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.validarFrameCadastroGerenciasRegionais();
//		pageCadastrosSetor.navegarParaInclusaoNovaGerenciaRegional();
//		pageInclusaoSetor.tentarIncluirGerenciaRegionalComSiglaInvalidaNomeExistente_EmMassa();
//	}
//	
//	@Test
//	public void tentarIncluirEmMassaGerenciaRegionalComSiglaExistenteNomeInvalidoSemSucesso(){
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.validarFrameCadastroGerenciasRegionais();
//		pageCadastrosSetor.navegarParaInclusaoNovaGerenciaRegional();
//		pageInclusaoSetor.tentarIncluirGerenciaRegionalComSiglaExistenteNomeInvalido_EmMassa();
//	}
//	
//	@Test
//	public void tentarIncluirEmMassaGerenciaRegionalComSigla_E_Nome_ExistentesSemSucesso(){
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.validarFrameCadastroGerenciasRegionais();
//		pageCadastrosSetor.navegarParaInclusaoNovaGerenciaRegional();
//		pageInclusaoSetor.tentarIncluirGerenciaRegionalComSigla_E_NomeExistentes_EmMassa();
//	}
//	
//	@Test
//	public void pesquisarGerenciaRegionalEmMassaComSucesso() {
//		pageInicialSIC.navegarParaCadastroGerenciaRegional();
//		pageCadastrosSetor.pesquisar_E_ValidarGerenciaRegionalEmMassa();
//	}
}