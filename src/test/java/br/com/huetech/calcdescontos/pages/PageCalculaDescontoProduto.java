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
	
	@FindBy(id = "html/body/div[1]/div[2]/div/p[4]/strong")
	WebElement valorProduto;
	
	
	public int calcularDesconto(String tipoCliente, String qtd){
		aguardarElementoVisivel(botaoCalcularDesconto);
		int vlproduto = Utils.converteStringParaInt(valorProduto.getAttribute("strong")); // CORRIGIR
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
