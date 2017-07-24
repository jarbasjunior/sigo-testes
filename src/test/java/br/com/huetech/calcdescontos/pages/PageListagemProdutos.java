package br.com.huetech.calcdescontos.pages;

import org.openqa.selenium.By;
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
	
	public void selecionaProdutoPorIdParaCalculoDesconto(String idProduto){
		Log.info("Selecionando produto para cálculo de desconto...");
		WebElement botaoCalcularDesconto = Selenium.getDriver().findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[4]/a[@href='index.php?p=calcularDesconto&pid="+idProduto+"']/span"));
		botaoCalcularDesconto.click();
	}
	
}
