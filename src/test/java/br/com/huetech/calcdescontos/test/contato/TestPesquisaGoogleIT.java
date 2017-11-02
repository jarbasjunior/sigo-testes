package br.com.huetech.calcdescontos.test.contato;

import org.junit.Test;

import br.com.huetech.calcdescontos.page.base.PageInicialGoogle;
import br.com.huetech.calcdescontos.test.base.BaseTestCase;
import br.com.huetech.calcdescontos.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestPesquisaGoogleIT extends BaseTestCase {

	String            nomeTeste         = null;
	PageInicialGoogle pageInicialGoogle = new PageInicialGoogle();
	
	@Test
	public void pesquisaGoogle(){
		nomeTeste = "pesquisaGoogle";
		Log.msgInicioTeste(nomeTeste);
		pageInicialGoogle.pesquisaGoogle("google");
		pageInicialGoogle.verificaRetornoPesquisaGoogle("https://www.google.com.br/");
		Log.msgFimTeste(nomeTeste);
	}
	
	//TODO colocar tempo de execução do teste; 
	//TODO gravar log em arquivo.
}