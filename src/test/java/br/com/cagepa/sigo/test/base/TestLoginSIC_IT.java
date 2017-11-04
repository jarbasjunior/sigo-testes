package br.com.cagepa.sigo.test.base;

import org.junit.Test;

import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.page.base.PageLoginSIC;
import br.com.cagepa.sigo.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestLoginSIC_IT extends BaseTestCase {

	String         nomeTeste      = null;
	PageLoginSIC   pageLoginSIC   = new PageLoginSIC();
	PageInicialSIC pageInicialSIC = new PageInicialSIC();
	
	@Test
	public void loginSIC_ComSucesso(){
		nomeTeste = "loginSIC_ComSucesso";
		Log.msgInicioTeste(nomeTeste);
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		Log.msgFimTeste(nomeTeste);
	}
}