package br.com.huetech.calcdescontos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.util.Log;

public class PageInicial extends PageObjectGeneric<PageInicial> {

	public PageInicial() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "welcome.button.contato")
	WebElement botaoContato;
	
	@FindBy(id = "index.navlink.paginainicial")
	WebElement abaPaginaInicial;
	
	@FindBy(id = "welcome.button.calculardesconto")
	WebElement botaoCalcularDesconto;
	
	public void irParaPaginaContato(){
		Log.info("Direcionando para página contato...");
		aguardarElementoVisivel(botaoContato);
		botaoContato.click();
		
		/*
		 * AO TESTAR ESSE MÉTODO EM UM NOTEBOOK COM WINDOWS 10,
		 * FOI NECESSÁRIO REPETIR A AÇÃO DE CLICAR NO BOTÃO
		 * CONTATO.
		 * 
		 * JÁ NO S.O. UBUNTU O MÉTODO FUNCIONOU NORMALMENTE
		 * APENAS COM UN CLIQUE.
		 * 
		 * POR ISSO QUE COLOQUEI ESTA OBSERVAÇÃO, CASO ALGUM
		 * TESTE ESTOURE ALGUM ERRO, SE ACONTECER FAVOR
		 * COMENTAR OU DESCOMENTAR A AÇÃO ABAIXO PARA QUE 
		 * O TESTE FUNCIONE NORMALMENTE
		 *  
		 */
		botaoContato.click();
	}
	
	public void abaPaginaInicial(){
		Log.info("Direcionando para página inicial...");
		aguardarElementoVisivel(abaPaginaInicial);
		abaPaginaInicial.click();
	}

	public void irParaCalculoDescontos(){
		Log.info("Direcionando para lista de produtos...");
		aguardarElementoVisivel(botaoCalcularDesconto);
		botaoCalcularDesconto.click();
		
		/*
		 * AO TESTAR ESSE MÉTODO EM UM NOTEBOOK COM WINDOWS 10,
		 * FOI NECESSÁRIO REPETIR A AÇÃO DE CLICAR NO BOTÃO
		 * CALCULAR DESCONTO.
		 * 
		 * JÁ NO S.O. UBUNTU O MÉTODO FUNCIONOU NORMALMENTE
		 * APENAS COM UN CLIQUE.
		 * 
		 * POR ISSO QUE COLOQUEI ESTA OBSERVAÇÃO, CASO ALGUM
		 * TESTE ESTOURE ALGUM ERRO, SE ACONTECER FAVOR
		 * COMENTAR OU DESCOMENTAR A AÇÃO ABAIXO PARA QUE 
		 * O TESTE FUNCIONE NORMALMENTE
		 *  
		 */
		
		botaoCalcularDesconto.click();
	}
}
