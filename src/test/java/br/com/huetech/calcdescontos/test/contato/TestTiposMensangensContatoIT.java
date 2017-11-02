package br.com.huetech.calcdescontos.test.contato;

import org.junit.Test;

import br.com.huetech.calcdescontos.pages.PageInicial;
import br.com.huetech.calcdescontos.test.BaseTestCase;
import br.com.huetech.calcdescontos.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a pagina de contatos
 * @author Jarbas
 * 
 * */
public class TestTiposMensangensContatoIT extends BaseTestCase {

	String      nomeTeste   = "";
	PageInicial pageInicial = new PageInicial();
	
	/**
	 * TESTES MENSAGENS TIPO DÚVIDA - REQUISITO 003
	 */

	@Test
	public void CTA001_REQ003_verificaMsgTipoDuvidaIdadeMenorQue18(){
		nomeTeste = "CTA001_REQ003_verificaMsgTipoDuvidaIdadeMenorQue18";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA002_REQ003_verificaMsgTipoDuvidaIdadeEntre18e60(){
		nomeTeste = "CTA002_REQ003_verificaMsgTipoDuvidaIdadeEntre18e60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA003_REQ003_verificaMsgTipoDuvidaIdadeMaiorQue60(){
		nomeTeste = "CTA003_REQ003_verificaMsgTipoDuvidaIdadeMaiorQue60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	/**
	 * TESTES MENSAGENS TIPO SUGESTÃO - REQUISITO 003
	 */
	
	@Test
	public void CTA004_REQ003_verificaMsgTipoSugestaoIdadeMenorQue18(){
		nomeTeste = "CTA004_REQ003_verificaMsgTipoSugestaoIdadeMenorQue18";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA005_REQ003verificaMsgTipoSugestaoIdadeEntre18e60(){
		nomeTeste = "CTA005_REQ003verificaMsgTipoSugestaoIdadeEntre18e60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA006_REQ003_verificaMsgTipoSugestaoIdadeMaiorQue60(){
		nomeTeste = "CTA006_REQ003_verificaMsgTipoSugestaoIdadeMaiorQue60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	/**
	 * TESTES MENSAGENS TIPO RECLAMAÇÃO - REQUISITO 003 
	 */
	
	@Test
	public void CTA007_REQ003_verificaMsgTipoReclamacaoIdadeMenorQue18(){
		nomeTeste = "CTA007_REQ003_verificaMsgTipoReclamacaoIdadeMenorQue18";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA008_REQ003_verificaMsgTipoReclamacaoIdadeEntre18e60(){
		nomeTeste = "CTA008_REQ003_verificaMsgTipoReclamacaoIdadeEntre18e60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA009_REQ003_verificaMsgTipoReclamacaoIdadeMaiorQue60(){
		nomeTeste = "CTA009_REQ003_verificaMsgTipoReclamacaoIdadeMaiorQue60";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		Log.msgFimTeste(nomeTeste);
	}
}
