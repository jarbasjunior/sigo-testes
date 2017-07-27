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
	public void CTA010_RN01_verificaDesconto10QtdMenorQue100ClientesA(){
		nomeTeste = "CTA010_RN01_verificaDesconto10QtdMenorQue100ClientesA()";
		Log.msgInicioTeste(nomeTeste);
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
		Double valorProduto = pageCalculaDescontoProduto.calcularDesconto(Property.TIPO_CLIENTE_A, Utils.geraNumeroEntre1_99());
		Log.msgFimTeste(nomeTeste);
	}
}
