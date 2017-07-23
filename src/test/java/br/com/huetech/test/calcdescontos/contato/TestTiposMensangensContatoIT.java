package br.com.huetech.test.calcdescontos.contato;

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
	public void verificaMsgTipoDuvidaIdadeMenorQue18(){
		Log.msgInicioTeste("verificaMsgTipoDuvidaIdadeMenorQue18()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.MENOR_QUE_18);
	}
	
	@Test
	public void verificaMsgTipoDuvidaIdadeEntre18e60(){
		Log.msgInicioTeste("verificaMsgTipoDuvidaIdadeEntre18e60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void verificaMsgTipoDuvidaIdadeMaiorQue60(){
		Log.msgInicioTeste("verificaMsgTipoDuvidaIdadeMaiorQue60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoDuvidaIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_DUVIDA, Property.MAIOR_QUE_60);
	}
	
	/**
	 * TESTES MENSAGENS TIPO SUGESTÃO 
	 */
	
	@Test
	public void verificaMsgTipoSugestaoIdadeMenorQue18(){
		Log.msgInicioTeste("verificaMsgTipoSugestaoIdadeMenorQue18()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.MENOR_QUE_18);
	}
	
	@Test
	public void verificaMsgTipoSugestaoIdadeEntre18e60(){
		Log.msgInicioTeste("verificaMsgTipoSugestaoIdadeEntre18e60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void verificaMsgTipoSugestaoIdadeMaiorQue60(){
		Log.msgInicioTeste("verificaMsgTipoSugestaoIdadeMaiorQue60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoSugestaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_SUGESTAO, Property.MAIOR_QUE_60);
	}
	
	/**
	 * TESTES MENSAGENS TIPO RECLAMAÇÃO 
	 */
	
	@Test
	public void verificaMsgTipoReclamacaoIdadeMenorQue18(){
		Log.msgInicioTeste("verificaMsgTipoReclamacaoIdadeMenorQue18()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMenorQue18();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.MENOR_QUE_18);
	}
	
	@Test
	public void verificaMsgTipoReclamacaoIdadeEntre18e60(){
		Log.msgInicioTeste("verificaMsgTipoReclamacaoIdadeEntre18e60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeEntre18e60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.ENTRE_18_E_60);
	}
	
	@Test
	public void verificaMsgTipoReclamacaoIdadeMaiorQue60(){
		Log.msgInicioTeste("verificaMsgTipoReclamacaoIdadeMaiorQue60()");
		pageInicial.irParaPaginaInicial();
		pageInicial.irParaPaginaContato();
		pageContato.enviarMsgTipoReclamacaoIdadeMaiorQue60();
		pageContato.validaRetornoDaMsgEnviada(Property.TIPO_MSG_RECLAMACAO, Property.MAIOR_QUE_60);
	}
}
