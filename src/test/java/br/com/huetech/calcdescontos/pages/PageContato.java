package br.com.huetech.calcdescontos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.common.Selenium;
import br.com.huetech.calcdescontos.util.Log;
import br.com.huetech.calcdescontos.util.Utils;

public class PageContato extends PageObjectGeneric<PageContato> {

	public PageContato() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "contato.button.enviarMensagem")
	WebElement botaoEnviarMsg;
	
	@FindBy(id = "nome")
	WebElement campoNome;
	
	@FindBy(id = "email")
	WebElement campoEmail;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/form/div[3]/label[@class='radio-inline']/input[@value='duvida']")
	WebElement radioDuvida;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/form/div[3]/label[@class='radio-inline']/input[@value='sugestao']")
	WebElement radioSugestao;
	
	@FindBy(xpath = "html/body/div[1]/div[2]/form/div[3]/label[@class='radio-inline']/input[@value='reclamacao']")
	WebElement radioReclamacao;
	
	@FindBy(id = "idade")
	WebElement comboIdade;
	
	@FindBy(id = "mensagem")
	WebElement campoMsg;
	
	@FindBy(xpath = ".//*[@id='success.msg']/strong")
	WebElement mensagem;
	
	/*
	 * ENVIAR MENSAGENS DO TIPO DÚVIDA
	 */
	public void enviarMsgTipoDuvidaIdadeMenorQue18(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioDuvida)+"], com idade ["+Property.MENOR_QUE_18+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioDuvida.click();
		selectElementByVisibleText(comboIdade, Property.MENOR_QUE_18);
		preencherCampo(campoMsg, Property.INICIO_MSG      +
								 Property.TIPO_MSG_DUVIDA +
								 Property.FIM_MSG         +
								 Property.MENOR_QUE_18    +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoDuvidaIdadeEntre18e60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioDuvida)+"], com idade ["+Property.ENTRE_18_E_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioDuvida.click();
		selectElementByVisibleText(comboIdade, Property.ENTRE_18_E_60);
		preencherCampo(campoMsg, Property.INICIO_MSG      +
								 Property.TIPO_MSG_DUVIDA +
								 Property.FIM_MSG         +
								 Property.ENTRE_18_E_60   +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoDuvidaIdadeMaiorQue60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioDuvida)+"], com idade ["+Property.MAIOR_QUE_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioDuvida.click();
		selectElementByVisibleText(comboIdade, Property.MAIOR_QUE_60);
		preencherCampo(campoMsg, Property.INICIO_MSG      +
								 Property.TIPO_MSG_DUVIDA +
								 Property.FIM_MSG         +
								 Property.MAIOR_QUE_60    +".");
		botaoEnviarMsg.click();
	}
	
	/*
	 * ENVIAR MENSAGENS DO TIPO SUGESTÃO
	 */
	public void enviarMsgTipoSugestaoIdadeMenorQue18(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioSugestao)+"], com idade ["+Property.MENOR_QUE_18+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioSugestao.click();
		selectElementByVisibleText(comboIdade, Property.MENOR_QUE_18);
		preencherCampo(campoMsg, Property.INICIO_MSG     	+
								 Property.TIPO_MSG_SUGESTAO +
								 Property.FIM_MSG           +
								 Property.MENOR_QUE_18      +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoSugestaoIdadeEntre18e60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioSugestao)+"], com idade ["+Property.ENTRE_18_E_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioSugestao.click();
		selectElementByVisibleText(comboIdade, Property.ENTRE_18_E_60);
		preencherCampo(campoMsg, Property.INICIO_MSG        +
								 Property.TIPO_MSG_SUGESTAO +
								 Property.FIM_MSG           +
								 Property.ENTRE_18_E_60     +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoSugestaoIdadeMaiorQue60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioSugestao)+"], com idade ["+Property.MAIOR_QUE_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioSugestao.click();
		selectElementByVisibleText(comboIdade, Property.MAIOR_QUE_60);
		preencherCampo(campoMsg, Property.INICIO_MSG        +
								 Property.TIPO_MSG_SUGESTAO +
								 Property.FIM_MSG        	+
								 Property.MAIOR_QUE_60		+".");
		botaoEnviarMsg.click();
	}
	
	/*
	 * ENVIAR MENSAGENS DO TIPO RECLAMAÇÃO
	 */
	
	public void enviarMsgTipoReclamacaoIdadeMenorQue18(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioReclamacao)+"], com idade ["+Property.MENOR_QUE_18+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioReclamacao.click();
		selectElementByVisibleText(comboIdade, Property.MENOR_QUE_18);
		preencherCampo(campoMsg, Property.INICIO_MSG     	  +
								 Property.TIPO_MSG_RECLAMACAO +
								 Property.FIM_MSG        	  +
								 Property.MENOR_QUE_18		  +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoReclamacaoIdadeEntre18e60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioReclamacao)+"], com idade ["+Property.ENTRE_18_E_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioReclamacao.click();
		selectElementByVisibleText(comboIdade, Property.ENTRE_18_E_60);
		preencherCampo(campoMsg, Property.INICIO_MSG     	  +
								 Property.TIPO_MSG_RECLAMACAO +
								 Property.FIM_MSG        	  +
								 Property.ENTRE_18_E_60		  +".");
		botaoEnviarMsg.click();
	}
	
	public void enviarMsgTipoReclamacaoIdadeMaiorQue60(){
		Log.info("Enviando mensagem do tipo ["+getValorAtributo(radioReclamacao)+"], com idade ["+Property.MAIOR_QUE_60+"]...");
		aguardarElementoVisivel(botaoEnviarMsg);
		preencherCampo(campoNome,  Property.NOME);
		preencherCampo(campoEmail, Property.EMAIL);
		radioReclamacao.click();
		selectElementByVisibleText(comboIdade, Property.MAIOR_QUE_60);
		preencherCampo(campoMsg, Property.INICIO_MSG     	  +
								 Property.TIPO_MSG_RECLAMACAO +
								 Property.FIM_MSG        	  +
								 Property.MAIOR_QUE_60		  +".");
		botaoEnviarMsg.click();
	}
	
	/*
	 * MÉTODO PARA VALIDAR RETORNO DE: 
	 * 
	 * QUALQUER TIPO DE MENSAGEM (dúvida, sugestão ou reclamação) e
	 * 
	 * QUALQUER FAIXA ETÁRIA (< 18; > 17 e < 61; > 60)
	 * 
	 */
	public void validaRetornoDaMsgEnviada(String msgSucesso, String msgFalha, String nomeTeste){
		Log.info("Validando retorno da mensagem enviada...");
		
		if (mensagem.getText().equals(msgFalha)) {
			Log.erro("Teste ["+nomeTeste+"] falhou!");
			Utils.assertFail(msgFalha);
		}
		
		Log.info("Retorno esperado....... ["+msgSucesso+"].");
		Log.info("Retorno exibido em tela ["+mensagem.getText()+"].");
		
		if (msgSucesso.equals(mensagem.getText())) {
			Log.info("Teste ["+nomeTeste+"] PASSOU o/");
		}else{
			Log.erro("Teste ["+nomeTeste+"] FALHOU :/");
			Utils.assertFail("Teste ["+nomeTeste+"] FALHOU :/");
		}
		/*
		 * 
		 * O CÓDIGO APROVA OS TESTES DE MENSAGENS.
		 */
		
		/*String retornoEsperado = tipoMsg+"-"+faixaEtaria+Property.MSG_SUCESSO;
		
		try {
			Utils.assertEquals(retornoEsperado, msgSucesso.getText());
			Log.info("Retorno esperado ["+retornoEsperado+"] exibido na tela.");
			Log.info("Função executada com sucesso.");
		} catch (Exception e) {
			Log.mensagemErro("Falha no retorno da mensagem :/");
		}*/
	}

}
