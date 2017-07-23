package br.com.huetech.calcdescontos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.util.Log;

public class PageListagemProdutos extends PageObjectGeneric<PageListagemProdutos> {

	public PageListagemProdutos() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "html/body/div[@class='footer text-center']/p")
	WebElement rodape;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[1][contains(.,'1')]/../td[4]/a[@href='index.php?p=calcularDesconto&pid=1']/span")
	WebElement botaoCalcularDesconto;
	
	public void selecionaProdutoPorIdParaCalculoDesconto(String idProduto){
		Log.info("Escolhendo produto para calcular desconto...");
		aguardarElementoVisivel(botaoCalcularDesconto);
		botaoCalcularDesconto.click();
	}

}
