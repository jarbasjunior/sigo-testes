package br.com.huetech.calcdescontos.test.contato;

import org.junit.Test;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.pages.PageContato;
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
	PageContato pageContato = new PageContato();
	
	/**
	 * TESTES MENSAGENS TIPO DÚVIDA 
	 */

	@Test
	public void CTA001_verificaMsgTipoDuvidaIdadeMenorQue18(){
		nomeTeste = "CTA001_verificaMsgTipoDuvidaIdadeMenorQue18()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA002_verificaMsgTipoDuvidaIdadeEntre18e60(){
		nomeTeste = "CTA002_verificaMsgTipoDuvidaIdadeEntre18e60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA003_verificaMsgTipoDuvidaIdadeMaiorQue60(){
		nomeTeste = "CTA003_verificaMsgTipoDuvidaIdadeMaiorQue60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	/**
	 * TESTES MENSAGENS TIPO SUGESTÃO 
	 */
	
	@Test
	public void CTA004_verificaMsgTipoSugestaoIdadeMenorQue18(){
		nomeTeste = "CTA004_verificaMsgTipoSugestaoIdadeMenorQue18()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA005_verificaMsgTipoSugestaoIdadeEntre18e60(){
		nomeTeste = "CTA005_verificaMsgTipoSugestaoIdadeEntre18e60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA006_verificaMsgTipoSugestaoIdadeMaiorQue60(){
		nomeTeste = "CTA006_verificaMsgTipoSugestaoIdadeMaiorQue60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	/**
	 * TESTES MENSAGENS TIPO RECLAMAÇÃO 
	 */
	
	@Test
	public void CTA007_verificaMsgTipoReclamacaoIdadeMenorQue18(){
		nomeTeste = "CTA007_verificaMsgTipoReclamacaoIdadeMenorQue18()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA008_verificaMsgTipoReclamacaoIdadeEntre18e60(){
		nomeTeste = "CTA008_verificaMsgTipoReclamacaoIdadeEntre18e60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
	
	@Test
	public void CTA009_verificaMsgTipoReclamacaoIdadeMaiorQue60(){
		nomeTeste = "CTA009_verificaMsgTipoReclamacaoIdadeMaiorQue60()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.MSG_003, Property.MSG_004, nomeTeste);
	}
}
