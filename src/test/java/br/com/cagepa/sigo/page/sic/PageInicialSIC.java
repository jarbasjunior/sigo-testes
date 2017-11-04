package br.com.cagepa.sigo.page.sic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.common.Property;
import br.com.cagepa.sigo.common.Selenium;
import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;

public class PageInicialSIC extends PageObjectGeneric<PageInicialSIC> {

	public PageInicialSIC() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "lin1_col2")
	WebElement msgBoasVindas;
	
	@FindBy(id = "lin2_col2")
	WebElement emailUsr;
	
	@FindBy(xpath = "//*[@id='main_menu_table']/tbody/tr[1]/td/table/tbody/tr/td[2]/img")
	WebElement imgCagepa;
	
	public void verificaAutenticidadeUsuario(){
		Log.info("Direcionando para página inicial SIC CAGEPA...");
		aguardarElementoVisivel(imgCagepa);
		Log.info("Verificando mensagem de acesso...");
		Utils.assertEquals("Bem vindo, "+Property.USR, msgBoasVindas.getText());
		Log.info("Verificando usuário de acesso...");
		Utils.assertEquals(Property.EMAIL_USR, emailUsr.getText());
	}
}
