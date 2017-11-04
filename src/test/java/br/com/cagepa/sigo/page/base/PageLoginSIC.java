package br.com.cagepa.sigo.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;

public class PageLoginSIC extends PageObjectGeneric<PageLoginSIC> {

	public PageLoginSIC() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "id_sc_field_login")
	WebElement fieldUsr;
	
	@FindBy(id = "id_sc_field_pswd")
	WebElement fieldPassword;
	
	@FindBy(id = "sub_form_b")
	WebElement btLogin;
	
	@FindBy(id = "sub_form_b")
	WebElement btAlertOk;
	
	By msgAlertaLogin = By.id("div_hidden_bloco_0");
	
	public void realizarLoginSIC(){
		Log.info("Informando usuario...");
		aguardarElementoVisivel(fieldUsr);
		preencherCampo(fieldUsr, Property.LOGIN);
		Log.info("Informando senha...");
		aguardarElementoVisivel(fieldPassword);
		preencherCampo(fieldPassword, Property.PASSWORD);
		clickBotao(btLogin);
		
		if (isVisibility(msgAlertaLogin)) {
			Log.info("Confirmando alerta de login...");
			aguardarElementoVisivel(btAlertOk);
			selecionarFrameID(0);
			clickBotao(btAlertOk);
			Log.info("Login confirmado...");
		}
	}
}
