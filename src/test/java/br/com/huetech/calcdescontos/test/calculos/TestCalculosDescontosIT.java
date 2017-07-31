package br.com.huetech.calcdescontos.test.calculos;

import org.junit.Test;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.pages.PageCalculaDescontoProduto;
import br.com.huetech.calcdescontos.pages.PageInicial;
import br.com.huetech.calcdescontos.pages.PageListagemProdutos;
import br.com.huetech.calcdescontos.test.BaseTestCase;
import br.com.huetech.calcdescontos.util.Log;
import br.com.huetech.calcdescontos.util.Utils;

/**
 * 
 * Classe de testes com cenários relacionados a pagina de contatos
 * @author Jarbas
 * 
 */
public class TestCalculosDescontosIT extends BaseTestCase {

	String               	   nomeTeste            	  = "";
	PageInicial			 	   pageInicial          	  = new PageInicial();
	PageListagemProdutos 	   pageListagemProdutos       = new PageListagemProdutos();
	PageCalculaDescontoProduto pageCalculaDescontoProduto = new PageCalculaDescontoProduto();
	
	/**
	 * TESTES CÁLCULO DE DESCONTO PARA CLIENTE DO TIPO A
	 */

	@Test
	public void CTA010_RN01_verificaDesconto10PorcentoQtdMenorQue100ClientesA(){
		nomeTeste = "CTA010_RN01_verificaDesconto10PorcentoQtdMenorQue100ClientesA";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_A, Utils.geraNumeroEntre1_99(), Property.DESCONTO_10_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_10_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA011_RN01_verificaDesconto5PorcentoQtdEntre100_e_999ClientesA(){
		nomeTeste = "CTA011_RN01_verificaDesconto5PorcentoQtdEntre100_e_999ClientesA";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_A, Utils.geraNumeroEntre100_999(), Property.DESCONTO_5_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_5_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA012_RN01_verificaNAODescontoParaQtdMaiorQue999ClientesA(){
		nomeTeste = "CTA012_RN01_verificaNAODescontoParaQtdMaiorQue999ClientesA";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_A, Utils.geraNumeroEntre1000_10000(), Property.SEM_DESCONTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.SEM_DESCONTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	/**
	 * TESTES CÁLCULO DE DESCONTO PARA CLIENTE DO TIPO B
	 */
	
	@Test
	public void CTA013_RN01_verificaDesconto15PorcentoQtdMenorQue100ClientesB(){
		nomeTeste = "CTA013_RN01_verificaDesconto15PorcentoQtdMenorQue100ClientesB";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_B, Utils.geraNumeroEntre1_99(), Property.DESCONTO_15_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_15_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA014_RN01_verificaDesconto10PorcentoQtdEntre100_e_999ClientesB(){
		nomeTeste = "CTA014_RN01_verificaDesconto10PorcentoQtdEntre100_e_999ClientesB";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_B, Utils.geraNumeroEntre100_999(), Property.DESCONTO_10_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_10_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA015_RN01_verificaDesconto5PorcentoQtdMaiorQue999ClientesB(){
		nomeTeste = "CTA015_RN01_verificaDesconto5PorcentoQtdMaiorQue999ClientesB";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_B, Utils.geraNumeroEntre1000_10000(), Property.DESCONTO_5_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_5_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	/**
	 * TESTES CÁLCULO DE DESCONTO PARA CLIENTE DO TIPO C
	 */
	
	@Test
	public void CTA016_RN01_verificaDesconto20PorcentoQtdMenorQue100ClientesC(){
		nomeTeste = "CTA016_RN01_verificaDesconto20PorcentoQtdMenorQue100ClientesC";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_C, Utils.geraNumeroEntre1_99(), Property.DESCONTO_20_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_20_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA017_RN01_verificaDesconto15PorcentoQtdEntre100_e_999ClientesC(){
		nomeTeste = "CTA017_RN01_verificaDesconto15PorcentoQtdEntre100_e_999ClientesC";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_C, Utils.geraNumeroEntre100_999(), Property.DESCONTO_15_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_15_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	@Test
	public void CTA018_RN01_verificaDesconto10PorcentoQtdMaiorQue999ClientesC(){
		nomeTeste = "CTA018_RN01_verificaDesconto10PorcentoQtdMaiorQue999ClientesC";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_C, Utils.geraNumeroEntre1000_10000(), Property.DESCONTO_10_PORCENTO);
		pageCalculaDescontoProduto.validaCalculoRealizado(valorProduto, Property.DESCONTO_10_PORCENTO, nomeTeste);
		Log.msgFimTeste(nomeTeste);
	}
	
	/**
	 * TESTE PARA VERIFICAR OBRIGATORIEDADE DO PREENCHIMENTO DA QUANTIDADE
	 */
	@Test
	public void CTA019_RN01_validaObrigatoriedadePreenchimentoDoCampoQuantidade(){
		nomeTeste = "CTA019_RN01_validaObrigatoriedadePreenchimentoDoCampoQuantidade";
		Log.msgInicioTeste(nomeTeste); 		
		pageInicial.abaPaginaInicial(); 		
		pageInicial.irParaCalculoDescontos(); 		
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO); 		
		pageCalculaDescontoProduto.validaObrigatoriedadeDaQuantidade(nomeTeste); 		
		Log.msgFimTeste(nomeTeste);
	}
}
