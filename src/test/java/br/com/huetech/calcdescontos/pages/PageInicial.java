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
		botaoContato.click();
	}
	
	public void irParaPaginaInicial(){
		Log.info("Direcionando para página inicial...");
		aguardarElementoVisivel(abaPaginaInicial);
		abaPaginaInicial.click();
	}

	public void irParaCalculoDescontos(){
		Log.info("Direcionando para página de cálculo de descontos...");
		aguardarElementoVisivel(botaoCalcularDesconto);
		botaoCalcularDesconto.click();
	}
}
