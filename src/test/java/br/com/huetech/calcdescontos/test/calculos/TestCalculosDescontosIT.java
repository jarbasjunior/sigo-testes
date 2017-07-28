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
	 * TESTES CÁLCULOS 
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
}
