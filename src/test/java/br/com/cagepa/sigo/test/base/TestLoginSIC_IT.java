package br.com.cagepa.sigo.test.base;

import br.com.cagepa.sigo.admin.page.sic.PageInicialSIC;
import br.com.cagepa.sigo.page.base.PageLoginSIC;
import br.com.cagepa.sigo.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a 
 * @author Jarbas
 * 
 * */
public class TestLoginSIC_IT {

	PageLoginSIC   pageLoginSIC   = new PageLoginSIC();
	PageInicialSIC pageInicialSIC = new PageInicialSIC();
	
	public void loginSIC_ComSucesso(){
		Log.info("Realizando login no sistema SIGO...");
		pageLoginSIC.realizarLoginSIC();
		pageInicialSIC.verificaAutenticidadeUsuario();
		Log.info("Login efetuado com sucesso!");
	}
}