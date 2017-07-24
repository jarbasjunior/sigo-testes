package br.com.huetech.calcdescontos.test.calculos;

import org.junit.Test;

import br.com.huetech.calcdescontos.common.Property;
import br.com.huetech.calcdescontos.pages.PageInicial;
import br.com.huetech.calcdescontos.pages.PageListagemProdutos;
import br.com.huetech.calcdescontos.test.BaseTestCase;
import br.com.huetech.calcdescontos.util.Log;

/**
 * 
 * Classe de testes com cenários relacionados a pagina de contatos
 * @author Jarbas
 * 
 */
public class TestCalculosDescontosIT extends BaseTestCase {

	PageInicial			 pageInicial          = new PageInicial();
	PageListagemProdutos pageListagemProdutos = new PageListagemProdutos();
	
	/**
	 * TESTES CÁLCULOS 
	 */

	@Test
	public void calculaDesconto(){
		Log.msgInicioTeste("calculaDesconto()");
		pageInicial.abaPaginaInicial();
		pageInicial.irParaCalculoDescontos();
		pageListagemProdutos.selecionaProdutoPorIdParaCalculoDesconto(Property.ID_PRODUTO);
	}
}
