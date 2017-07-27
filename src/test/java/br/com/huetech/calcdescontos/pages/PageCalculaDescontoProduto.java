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
	
	public void validaCalculoRealizado(Double valorProduto, String desconto){
		Log.info("Validando cálculo realizado...");
		String valorComDesconto = "";
		switch (desconto) {
		case "5":
			valorComDesconto = calculaDesconto5Porcento(valorProduto);
			break;
		case "10":
			valorComDesconto = calculaDesconto10Porcento(valorProduto);
			break;
		case "15":
			valorComDesconto = calculaDesconto15Porcento(valorProduto);
			break;
		case "20":
			valorComDesconto = calculaDesconto20Porcento(valorProduto);
			break;
		}
		
		valorComDesconto = formataParaValorDaTela(valorComDesconto);
	}
	
	public String calculaDesconto5Porcento(Double valor){
		valor = valor - (valor * .05);
		return Utils.conversorDoubleString(valor);
	}
	public String calculaDesconto10Porcento(Double valor){
		valor = valor - (valor * .1);
		return Utils.conversorDoubleString(valor);
	}
	public String calculaDesconto15Porcento(Double valor){
		valor = valor - (valor * .15);
		return Utils.conversorDoubleString(valor);
	}
	public String calculaDesconto20Porcento(Double valor){
		valor = valor - (valor * .2);
		return Utils.conversorDoubleString(valor);
	}
	public String formataParaValorDaTela(String str){
		String a         	  = str.substring(2, 8).replace(",", ".");
		String b         	  = str.substring(0, 2).replace(".", ",");
		String valorFormatado = a.concat(b);
		return valorFormatado;
	}
}
