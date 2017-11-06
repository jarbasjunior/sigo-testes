package br.com.cagepa.sigo.page.base;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cagepa.sigo.setup.Property;
import br.com.cagepa.sigo.setup.Selenium;
import br.com.cagepa.sigo.util.Log;
import br.com.cagepa.sigo.util.Utils;
import br.com.cagepa.sigo.util.XLS_Utils;

public abstract class PageObjectGeneric<T> {

	private static final String URL_HUETECH = Property.URL;
	private static final int LOAD_TIMEOUT = 5;
	private String windowHandleJanelaInicial;

	public PageObjectGeneric() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	public T abrirPagina(Class<T> clazz) {
		T pagina = PageFactory.initElements(Selenium.getDriver(), clazz);
		Selenium.getDriver().navigate().to(URL_HUETECH);
		return pagina;
	}

	public void preencherCampo(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (WebDriverException e) {
			Log.erro("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
			Assert.fail("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
		}
	}
	
	public void clickBotao(WebElement element) {
		try {
			aguardarElementoVisivel(element);
			element.click();
		} catch (WebDriverException e) {
			Log.erro("Erro ao clicar no elemento ["+element+"].");
			Assert.fail("Erro ao clicar no elemento ["+element+"].");
		}
	}

	public String getValorAtributo(WebElement element) {
		try {
			return element.getAttribute("value");
		} catch (Exception e) {
			Log.erro("Erro ao buscar valor de atributo do elemento ["+element+"].");
			Assert.fail("Erro ao buscar valor de atributo do elemento ["+element+"].");
			return null;
		}
	}

	public void selectElementByVisibleText(WebElement element, String textVisible) {
		try {
			new Select(element).selectByVisibleText(textVisible);
		} catch (WebDriverException e) {
			Log.erro("["+element+"] do combobox não encontrado, valor ["+textVisible+"] não pode ser selecionado.");
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+textVisible+"] não pode ser selecionado.");
		}
	}

	public void selectElementByVisibleValue(WebElement element, String valueVisible) {
		try {
			new Select(element).selectByValue(valueVisible);
		} catch (WebDriverException e) {
			Log.erro("["+element+"] do combobox não encontrado, valor ["+valueVisible+"] não pode ser selecionado.");
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+valueVisible+"] não pode ser selecionado.");
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			Log.erro("Erro ao realizar a confirmacao do Alerta");
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
	}

	public String getAlert() {
		String alerta = "";
		try {
			Alert alert = Selenium.getDriver().switchTo().alert();
			alerta = alert.getText();
		} catch (Exception e) {
			Log.erro("Erro ao realizar a confirmacao do Alerta");
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
		return alerta;
	}

	public void aguardarElementoVisivel(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(),
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Log.erro("Tempo excedido para aguardar elemento: " + element);
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	public void aguardarElementoVisivelComTexto(WebElement element, String text) {
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(),
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.textToBePresentInElement(
					element, text));
		} catch (Exception e) {
			Log.erro("Tempo excedido para aguardar elemento: " + element);
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}
	
	public void esperarElementoDesaparecer(By elemento, int qtdSegundos){
		try {
			int segundosEspera = 0;
			while (isVisibility(elemento) || segundosEspera == qtdSegundos) {
				Utils.wait(1000);
				segundosEspera++;
				if (!isVisibility(elemento)) {
					break;
				}
			}
		} catch (Exception e) {
			Log.info("Erro");
			Assert.fail("Error!");
		}
	}

	public boolean isVisibility(WebElement elemento) {
		try {
			return elemento.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isVisibility(By locator) {
		try {
			WebElement element = Selenium.getDriver().findElement(locator);
			element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void clicarBotaoDireito(WebElement elemento) {
		Actions action = new Actions(Selenium.getDriver());
		action.contextClick(elemento).build().perform();
	}
	
	public void doubleclick(WebElement elemento) {
		Actions action = new Actions(Selenium.getDriver());
		action.doubleClick().build().perform();
	}

	public void moverCursorPara(WebElement elemento) {
		Actions action = new Actions(Selenium.getDriver());
		action.moveToElement(elemento).build().perform();
	}
	
	public boolean existText(WebElement elemento, String texto) {
		aguardarElementoVisivel(elemento);
		return elemento.getText().contains(texto);
	}

	public void voltarPagina() {
		Selenium.getDriver().navigate().back();
	}

	/**
	 * Seta para nova janela aberta
	 */
	public void alternarJanela() {
		windowHandleJanelaInicial = Selenium.getDriver().getWindowHandle();
		Set<String> windowHandles = Selenium.getDriver().getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(windowHandleJanelaInicial)) {
				Selenium.getDriver().switchTo().window(windowHandle);
			}
		}
		setWindowHandleJanelaInicial(windowHandleJanelaInicial);
	}

	public String getWindowHandleJanelaInicial() {
		return windowHandleJanelaInicial;
	}

	public void setWindowHandleJanelaInicial(String windowHandleJanelaInicial) {
		this.windowHandleJanelaInicial = windowHandleJanelaInicial;
	}

	public void confirmarAlerta() {
		Alert alert = Selenium.getDriver().switchTo().alert();
		alert.accept();
	}
	
	public void selecionarFrameID(int idFrame) {
		Selenium.getDriver().switchTo().frame(idFrame);
	}
	
	public void selecionarFrameNameOrID(String stringFrame) {
		Selenium.getDriver().switchTo().frame(stringFrame);
	}
	
	public void selecionarFrameWebElement(WebElement element) {
		Selenium.getDriver().switchTo().frame(element);
	}
	
	public void retornarFrameAnterior() {
		Selenium.getDriver().switchTo().defaultContent();
	}

	/**
	 * 
	 * @return Janela anterior
	 */
	public void retonarJanelaOriginal() {
		Selenium.getDriver().switchTo().window(getWindowHandleJanelaInicial());
	}

	public WebElement getElement(By by) {
		return Selenium.getDriver().findElement(by);
	}
	
	public void pesquisaValidacaoEmMassa(WebElement enableField, WebElement field, 
							             WebElement btLupa, By msgAguarde, //TODO ADICIONAR DEMAIS CAMPOS DE RETORNO DA PESQUISA 
							             List<WebElement> camposDeValidacao) throws Exception{
		int 	linha        = 0;
		int 	coluna       = 0;
		String  valorCelula  = null;
		int     qtdRegistros = XLS_Utils.qtdRegistrosPlanilha();
		
		do {
			Log.info("Habilitando para pesquisa...");
			clickBotao(enableField);
			Utils.wait(1000);
			aguardarElementoVisivel(field);
			Log.info("Campo para pesquisa habilitado.");
			valorCelula = XLS_Utils.getDadosCelula(linha, coluna);
			Log.info("Inserindo valor ["+valorCelula+"]...");
			preencherCampo(field, valorCelula);
			clickBotao(btLupa);
			Log.info("Aguardando retorno da consulta...");
			esperarElementoDesaparecer(msgAguarde, 15);
			validarCamposDaPesquisa(camposDeValidacao); //TODO ADICIONAR DEMAIS CAMPOS DE RETORNO DA PESQUISA
			qtdRegistros--;
			linha++;
		} while (qtdRegistros == 0);
	}
	
	public void validarCamposDaPesquisa(List<WebElement> campos){
		Log.info("Validando retorno da consulta");
		// TODO - IMPLEMENTAR MÉTODO PARA VALIDAR RETORNO DA PESQUISA
		
	}
}
	
//	public void preencherFormularioCadastro(List<WebElement> campos){
//
//		int              cont          = 1;
//		int 			 linha         = 0;
//		boolean          isRegistro    = true;
//		String     		 valorCelula   = null;
//		List<WebElement> qtdCampos     = campos;
//
//		// VERIFICA SE PLANILHA CONTÉM REGISTROS
//		try {
//			isRegistro = XLS_Utils.isProximaLinha(linha); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		aguardarElementoVisivel(botaoSalvar);
//		Log.info("Iniciando preenchimento do formulário cliente...");
//		
//		// VARRE A PLANILHA ENQUANTO HOUVER REGISTROS
//		while (isRegistro){
//    		for (int coluna = 0; coluna < qtdCampos.size(); coluna++) {
//    			try {
//    				valorCelula = ExcelUtils.getDadosCelula(linha, coluna);
//    				
//    				Log.info("Inserindo o valor ["+valorCelula+"]");
//
//    				if (coluna == (qtdCampos.size()-1)) {
//						selectElementByVisibleText(qtdCampos.get(coluna), valorCelula);
//					}else
//						preencherCampo(qtdCampos.get(coluna), valorCelula);
//    			} catch (Exception e) {
//    				Log.erro("Quantidade de registros inseridos ["+cont+"]");
//    				Log.erro("Erro no preenchimento do valor ["+valorCelula+"], do elemento["+qtdCampos.get(coluna)+"]", e);
//    			}
//    		}
//    		// SALVA O REGISTRO
//    		botaoSalvar.click();
//    		
//    		//TESTE DE FEEDBACK
//    		Utils.assertEquals("CLIENTE CADASTRADO COM SUCESSO!", msgSucesso.getText());
//    		
//    		linha++;
//    		
//    		// VERIFICA SE AINDA HÁ REGISTROS NA PRÓXIMA LINHA DA PLANILHA, SE HOUVER, ABRE NOVO FORMULÁRIO
//    		try {
//				isRegistro = ExcelUtils.isProximaLinha(linha);
//				if (isRegistro) {
//					botaoNovoCliente.click();
//					aguardarElementoVisivel(qtdCampos.get(qtdCampos.size()-1));
//				}
//			} catch (Exception e) {
//				Log.erro("Quantidade de registros inseridos ["+cont+"]");
//				e.printStackTrace();
//			} 
//    	}
//	}

