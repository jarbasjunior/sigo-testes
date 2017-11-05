package br.com.cagepa.sigo.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import br.com.cagepa.sigo.setup.Property;


public class XLS_Utils {

	private static 		 HSSFRow 	  	  linha              = null;
	private static 		 HSSFCell 	   	  celula             = null;
	private static 		 HSSFSheet 	  	  planilha           = null;
	private static 		 HSSFWorkbook 	  excelWBook         = null;
	private static       FileInputStream  arquivoEntradaXLS  = null;
	private static       FileOutputStream arquivoSaidaXLS 	 = null;
	private static final String       	  ARQUIVO_TESTE 	 = Property.ARQUIVO_TESTE_XLS;
	private static final String           PATH_ARQUIVO_TESTE = Property.PATH_ARQUIVO_TESTE;

	//Busca o caminho e abre o arquivo excel
	public static void getArquivoExcel(String nomePlanilha)throws Exception {
		
		Log.info("Buscando arquivo xls...");
		
		// Abre arquivo excel 
		try {
			arquivoEntradaXLS = new FileInputStream(PATH_ARQUIVO_TESTE + ARQUIVO_TESTE);
			excelWBook        = new HSSFWorkbook(arquivoEntradaXLS);
			Log.info("Arquivo encontrado em: ["+PATH_ARQUIVO_TESTE + ARQUIVO_TESTE+"]");
		} catch (Exception e) {
			Log.erro("["+ARQUIVO_TESTE+"] Diretorio nao encontrado!", e);
		}
		
		// Define a planilha do arqruivo que será utilizada no teste
		try {
			planilha = excelWBook.getSheet(nomePlanilha);
			Log.info("Planilha utlizada para teste -> ["+nomePlanilha+"]");
		} catch (Exception e) {
			Log.erro("["+nomePlanilha+"] Planilha não encontrada no arquivo", e);
		}
	}

	//	Fecha arquivo Excel
	public static void fecharArquivo() {
		
		Log.info("Salvando e fechando arquivo ["+ARQUIVO_TESTE+"]...");
		try {
			arquivoSaidaXLS.close();
			Log.info("Arquivo ["+ARQUIVO_TESTE+"] salvo em: ["+PATH_ARQUIVO_TESTE+"]");
		} catch (IOException e) {
			Log.erro("Problema no fechamento do arquivo ["+PATH_ARQUIVO_TESTE+ARQUIVO_TESTE);
		}
	}
	
    //Realiza a escrita nas células
	public static void setDadosCelula(String dados,  int numeroLinha, int numeroColuna) throws Exception {

		Log.info("Inserindo valor ["+dados+"] na célula ["+numeroLinha+"] ["+numeroColuna+"]");
		try{
			linha  = planilha.getRow(numeroLinha);
			if (linha == null) {
				linha = planilha.createRow(numeroLinha);
			}
			celula = linha.getCell(numeroColuna);
			if (celula == null) {
				celula = linha.createCell(numeroColuna);
				celula.setCellValue(dados);
			} else {
				celula.setCellValue(dados);	
			}
		
			Log.info("Valor ["+dados+"] inserido com sucesso");
		
		}catch(Exception e){
			Log.erro("Erro na inserção do valor ["+dados+"]", e);
		}
    }
    
    // Grava os registro no arquivo excel
    public static void gravaRegistrosExcel(int numeroRegistro, String planilha, List<String> dados) throws Exception{
    	int qtdColunas = 0;
    	
    	switch (planilha) {
		case "cliente":
			qtdColunas = 15;
			break;

		default:
			break;
		}
    	
    	for (int linha = numeroRegistro; linha == numeroRegistro; linha++) {

			for (int coluna = 0; coluna < qtdColunas; coluna++) {
				try {
					setDadosCelula(dados.get(coluna), linha, coluna);
					arquivoSaidaXLS = new FileOutputStream(PATH_ARQUIVO_TESTE + ARQUIVO_TESTE);
					excelWBook.write(arquivoSaidaXLS);
				} catch (Exception e) {
					Log.erro("Erro na inserção do valor ["+dados.get(linha)+"]", e);
				}
			}
    	}
    }
    
    //Realiza a leitura das células
    public static String getDadosCelula(int numeroLinha, int numeroColuna) throws Exception{
    	try{
    		celula = planilha.getRow(numeroLinha).getCell(numeroColuna);
    		if (celula == null) {
				return null;
			}else{
				String valorCelula = celula.getStringCellValue();
				Log.info("Valor ["+valorCelula+"] encontrado na célula ["+numeroLinha+"] ["+numeroColuna+"]");
				return valorCelula;
			}
    	}catch (Exception e){
    		Log.erro("Erro na captura da célula", e);
    		return null;
    	}
    }
    
    public static boolean isProximaLinha(int linha) throws Exception{
		
    	HSSFRow proximaLinha = planilha.getRow(linha);
    	if (proximaLinha == null) {
			return false;
		}
    	return true;
    	
    }
    
}

