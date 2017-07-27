package br.com.huetech.calcdescontos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.util.Log;
import br.com.huetech.calcdescontos.util.Utils;

public class PageCalculaDescontoProduto extends PageObjectGeneric<PageCalculaDescontoProduto> {

	public PageCalculaDescontoProduto() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "tipoCliente")
	WebElement comboTipoCliente;
	
	@FindBy(id = "quantidade")
	WebElement campoQuantidade;
	
	@FindBy(id = "calculardesconto.button.calcular")
	WebElement botaoCalcularDesconto;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/div/p[4]")
	WebElement valorProduto;
	
	
	public Double calcularDesconto(String tipoCliente, String qtd){
		aguardarElementoVisivel(botaoCalcularDesconto);
		Double vlproduto = Utils.conversorStringDouble(valorProduto.getText().substring(23));
		Log.info("Selecionando cliente do tipo ["+tipoCliente+"]...");
		selectElementByVisibleText(comboTipoCliente, tipoCliente);
		Log.info("Informando quantidade ["+qtd+"]...");
		preencherCampo(campoQuantidade, qtd);
		Log.info("Calculando desconto...");
		botaoCalcularDesconto.click();
		return vlproduto;
	}
	
	public void validaCalculoRealizado(){
		Log.info("Validando cálculo realizado...");
	}
}
