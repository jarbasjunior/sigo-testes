package br.com.cagepa.sigo.admin.page.setor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.cagepa.sigo.page.base.PageObjectGeneric;
import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;

public class PageAtualizacaoSetor extends PageObjectGeneric<PageAtualizacaoSetor> {

	public PageAtualizacaoSetor() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(id = "lin1_col1")
	WebElement titleAtualizacaoGerenciaRegional;
	
	@FindBy(id = "lin1_col2")
	WebElement dataAtualizacaoGerenciaRegional;
	
	@FindBy(id = "sc_b_new_t")
	WebElement btNovo;
	
	@FindBy(id = "sc_b_upd_t")
	WebElement btSalvar;
	
	@FindBy(id = "sc_b_del_t")
	WebElement btExcluir;
	
	@FindBy(id = "id_label_sigla")
	WebElement textSigla;
	
	@FindBy(id = "id_label_nome")
	WebElement textNome;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement fieldSigla;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement fieldNome;
	
	
	public void excluirGerenciaRegionalComSucesso(String sigla, String nome){
		validarFrameInclusaoGerenciaRegional();
		Log.info("Validando campos que serao excluidos...");
		Utils.assertEquals(fieldSigla.getAttribute("value") , sigla);
		Utils.assertEquals(fieldNome.getAttribute("value") , nome);
		Log.info("Excluindo gerencia regional ["+nome+"]...");
		click(btExcluir);
		Log.info("Confirmando exclusao...");
		confirmarAlerta();
		retornarFramePai();
	}
	
	public void validarFrameInclusaoGerenciaRegional(){
		By frameGerenciaRegional = By.name(Property.FRAME_NAME_ABA_MANTER_GERENCIA_REGIONAL);
		if (isVisibility(frameGerenciaRegional)) {
			Log.info("Alterando frame...");
			selecionarFrameNameOrID(Property.FRAME_NAME_ABA_MANTER_GERENCIA_REGIONAL);
			Log.info("Frame alterada para aba manter.");
		}
		Log.info("Validando frame de atualizacao de gerencia regional.");
		Log.info("Validando titulo...");
		Utils.assertEquals(titleAtualizacaoGerenciaRegional.getText(), "Atualização - Gerência Regional");
		Log.info("Validando data...");
		Utils.assertEquals(dataAtualizacaoGerenciaRegional.getText() , Utils.getDataAtual());
		Log.info("Validando nomes de botoes...");
		Utils.assertEquals(btNovo.getText() , "Novo");
		Utils.assertEquals(btSalvar.getText(), "Salvar");
		Utils.assertEquals(btExcluir.getText(), "Excluir");
		Log.info("Validando nomes...");
		Utils.assertEquals(textSigla.getText()               , "Sigla");
		Utils.assertEquals(textNome.getText()                , "Nome");
	}
}
