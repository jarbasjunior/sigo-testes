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

	PageInicial pageInicial = new PageInicial();
	PageContato pageContato = new PageContato();
	
	/**
	 * TESTES MENSAGENS TIPO DÚVIDA 
	 */

	@Test
	public void CTA001_verificaMsgTipoDuvidaIdadeMenorQue18(){
		Log.msgInicioTeste("CTA001_verificaMsgTipoDuvidaIdadeMenorQue18()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.MENOR_QUE_18);
	}
	
	@Test
	public void CTA002_verificaMsgTipoDuvidaIdadeEntre18e60(){
		Log.msgInicioTeste("CTA002_verificaMsgTipoDuvidaIdadeEntre18e60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void CTA003_verificaMsgTipoDuvidaIdadeMaiorQue60(){
		Log.msgInicioTeste("CTA003_verificaMsgTipoDuvidaIdadeMaiorQue60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.MAIOR_QUE_60);
	}
	
	/**
	 * TESTES MENSAGENS TIPO SUGESTÃO 
	 */
	
	@Test
	public void CTA004_verificaMsgTipoSugestaoIdadeMenorQue18(){
		Log.msgInicioTeste("CTA004_verificaMsgTipoSugestaoIdadeMenorQue18()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.MENOR_QUE_18);
	}
	
	@Test
	public void CTA005_verificaMsgTipoSugestaoIdadeEntre18e60(){
		Log.msgInicioTeste("CTA005_verificaMsgTipoSugestaoIdadeEntre18e60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void CTA006_verificaMsgTipoSugestaoIdadeMaiorQue60(){
		Log.msgInicioTeste("CTA006_verificaMsgTipoSugestaoIdadeMaiorQue60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.MAIOR_QUE_60);
	}
	
	/**
	 * TESTES MENSAGENS TIPO RECLAMAÇÃO 
	 */
	
	@Test
	public void CTA007_verificaMsgTipoReclamacaoIdadeMenorQue18(){
		Log.msgInicioTeste("CTA007_verificaMsgTipoReclamacaoIdadeMenorQue18()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.MENOR_QUE_18);
	}
	
	@Test
	public void CTA008_verificaMsgTipoReclamacaoIdadeEntre18e60(){
		Log.msgInicioTeste("CTA008_verificaMsgTipoReclamacaoIdadeEntre18e60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void CTA009_verificaMsgTipoReclamacaoIdadeMaiorQue60(){
		Log.msgInicioTeste("CTA009_verificaMsgTipoReclamacaoIdadeMaiorQue60()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.MAIOR_QUE_60);
	}
}
