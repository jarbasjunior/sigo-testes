package br.com.huetech.calcdescontos.page.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.util.Log;
import br.com.huetech.calcdescontos.util.Utils;

public class PageInicialGoogle extends PageObjectGeneric<PageInicialGoogle> {

	public PageInicialGoogle() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "lst-ib")
	WebElement fieldPesquisaGoogle;
	
	@FindBy(name = "btnK")
	WebElement btPesquisaGoogle;
	
	@FindBy(id = "resultStats")
	WebElement msgResultado;
	
	@FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div/div/div/div/div/cite")
	WebElement firstResults;
	
	public void pesquisaGoogle(String textoPesquisa){
		Log.info("Direcionando para página inicial google...");
		aguardarElementoVisivel(fieldPesquisaGoogle);
		preencherCampo(fieldPesquisaGoogle, textoPesquisa);
		btPesquisaGoogle.click();
		Log.info("Aguardando retorno da pesquisa...");
	}
	
	public void verificaRetornoPesquisaGoogle(String retornoEsperado){
		Log.info("Verificando retorno do primeiro resultado...");
		aguardarElementoVisivel(firstResults);
		Utils.assertEquals(retornoEsperado, firstResults.getText());
	}
}
