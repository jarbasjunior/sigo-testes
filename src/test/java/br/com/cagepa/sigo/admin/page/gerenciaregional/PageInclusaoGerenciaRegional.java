package br.com.cagepa.sigo.admin.page.gerenciaregional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;

public class PageInclusaoGerenciaRegional extends PageObjectGeneric<PageInclusaoGerenciaRegional> {

	public PageInclusaoGerenciaRegional() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(id = "lin1_col1")
	WebElement titleInclusaoGerenciaRegional;
	
	@FindBy(id = "lin1_col2")
	WebElement dataInclusaoGerenciaRegional;
	
	@FindBy(id = "sc_b_ins_t")
	WebElement btIncluir;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement btCancelar;
	
	@FindBy(id = "id_label_sigla")
	WebElement sigla;
	
	@FindBy(id = "id_label_nome")
	WebElement nome;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement fieldSigla;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement fieldNome;
	
	@FindBy(xpath = "//*[@id='main_table_form']/tbody/tr/td/div/table/tbody/tr[4]/td/span")
	WebElement fraseObrigatoriedade;

	public void incluirGerenciaRegionalComSucesso(){
		validarFrameInclusaoGerenciaRegional();
	}
	
	
	
	
	
	
	public void validarFrameInclusaoGerenciaRegional(){
		Log.info("Alterando frame...");
		selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER);
		Log.info("Frame alterada para aba manter.");
		Log.info("Validando frame de inclusao de gerencia regional.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleInclusaoGerenciaRegional.getText(), "Inclusão - Gerência Regional");
		Log.info("Validando data...");
		Utils.assertEquals(dataInclusaoGerenciaRegional.getText() , Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btIncluir.getText() , "Incluir");
		Utils.assertEquals(btCancelar.getText(), "Cancelar");
		Log.info("Validando nomes...");
		Utils.assertEquals(sigla.getText()               , "Sigla");
		Utils.assertEquals(nome.getText()                , "Nome");
		Utils.assertEquals(fraseObrigatoriedade.getText(), "* Campo de preenchimento obrigatório");
	}
}
