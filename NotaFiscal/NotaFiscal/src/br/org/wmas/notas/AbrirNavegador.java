package br.org.wmas.notas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirNavegador {

	static WebDriver driver;
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void gerarRanfQueimados() throws InterruptedException{
		driver.get("http://www1.webiss.com.br/queimadosrj/Entrada/Autenticacao.aspx?ReturnUrl=%2fqueimadosrj");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_edUsuario")).sendKeys("12978281782");
		driver.findElement(By.id("dummyinput")).sendKeys("qa82m");

		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnConfirmar")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnPdf")).click();
	}

	public void gerarDapsBelfordRoxo() throws InterruptedException{
		driver.get("http://www8.receita.fazenda.gov.br/simplesnacional/aplicacoes.aspx?id=21");
		//driver.findElement(By.("caixaTexto")).sendKeys("10918228000119");
		Thread.sleep(15000);
		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnConfirmar")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnPdf")).click();
	}

	public void gerarDapsSeropedica() throws InterruptedException{
		driver.get("http://nfse.seropedica.rj.gov.br/login.php#");
		//driver.findElement(By.("caixaTexto")).sendKeys("10918228000119");
		Thread.sleep(15000);
		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnConfirmar")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolderConteudo_btnPdf")).click();
	}

	public void logar() throws InterruptedException{
		driver.get("https://notacarioca.rio.gov.br/senhaweb/login.aspx");
		driver.findElement(By.id("ctl00_cphCabMenu_tbCpfCnpj")).sendKeys("10918228000119");
		driver.findElement(By.id("ctl00_cphCabMenu_tbSenha")).sendKeys("8281901");
		Thread.sleep(15000);
		driver.findElement(By.id("ctl00_cphCabMenu_btEntrar")).click();
		driver.findElement(By.linkText("Emiss�o de NFS-e")).click();
	}

	public void refresh(){
		driver.get("https://notacarioca.rio.gov.br/contribuinte/nota.aspx");
	}

	public File getProcessFile(){

		File path = new File("C:\\Users\\admin\\Desktop");
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			File arq = files[i];
			if (!arq.isDirectory() && arq.getName().equals("notas.csv")) {
				return arq;
			}
		}
		return null;
	}

	public void processNFSList(File file){
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";

		try {
			br = new BufferedReader(new FileReader(file));
			while ((linha = br.readLine()) != null) {
				emitirNFS(/*linha.split(csvDivisor)*/);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	public void emitirNFS(/*String[] nota*/) {

		/*refresh();

		if(nota[0].contains("1")){
			driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		}
		else{
			driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		}

		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys(nota[1]);
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys(nota[2]);

		if(nota[0].contains("1")){
			driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
			driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		}
		else{
			driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		}

		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys(nota[3]);
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys(nota[4]);*/
		//driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		//driver.switchTo().alert().accept();
		//}

		/*Nova Igua�u e Rosa dos Ventos*/
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019020682");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem nas capelas:  \n"+
				" \n"+	
				"Nova Igua�u R$ 549,37 \n"+				
				"Rosa dos Ventos R$ 1.229,35 \n"+
				" \n"+	
				"M�o de Obra R$ 1.245,10 \n"+
				"Material    R$ 533,62 \n"+
				"Total       R$ 1.778,72 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("136,96");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("1.778,72");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("N Igua�u & Rosa V.");

		/*Nova Igua�u e Rosa dos Ventos Diferen�a aumento
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019020682");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018 nas capelas:  \n"+
				" \n"+	
				"Nova Igua�u \n"+				
				"Rosa dos Ventos  \n"+
				" \n"+	
				"M�o de Obra R$ 203,75 \n"+
				"Material    R$ 87,33 \n"+
				"Total       R$ 291,08 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("22,41");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("291,08");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("N Igua�u & Rosa V. Diferen�a aumento");*/

		//#######################################################################

		//Belford Roxo
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019095267");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Belford Roxo.  \n"+
				" \n"+	
				"M�o de Obra R$ 426,30 \n"+
				"Material    R$ 182,71 \n"+
				"Total       R$ 609,01 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("46,89");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("609,01");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Belford Roxo");

		//#######################################################################

		//Belford Roxo Diferen�a aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019095267");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 69,76 \n"+
				"Material    R$ 29,90 \n"+
				"Total       R$ 99,66 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("7,67");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("99,66");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Belford Roxo Diferen�a aumento");*/

		//#######################################################################
		// Queimados 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019086004");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Queimados.  \n"+
				" \n"+	
				"M�o de Obra R$ 511,79 \n"+
				"Material    R$ 219,35 \n"+
				"Total       R$ 731,14 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("56,29");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("731,14");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Queimados");

		//#######################################################################

		// Queimados Diferen�a aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019086004");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 83,74 \n"+
				"Material    R$ 35,90 \n"+
				"Total       R$ 119,64 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("9,21");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("119,64");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Queimados Diferen�a aumento");*/

		//#######################################################################
		// Vilar dos Teles 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019083170");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Vilar dos Teles.  \n"+
				" \n"+	
				"M�o de Obra R$ 224,10 \n"+
				"Material    R$ 96,05 \n"+
				"Total       R$ 320,15 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("24,65");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("320,15");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Vilar dos Teles");

		//#######################################################################

		// Vilar dos Teles Diferen�a aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019083170");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 36,68 \n"+
				"Material    R$ 15,72 \n"+
				"Total       R$ 52,40 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("4,03");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("52,40");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Vilar dos Teles Diferen�a aumento");*/

		//######################################################################

		// Itagua� 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019099416");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Itagua�.  \n"+
				" \n"+	
				"M�o de Obra R$ 806,76 \n"+
				"Material    R$ 345,76 \n"+
				"Total       R$ 1.152,52 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("88,74");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("1.152,52");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Itagua�");

		//#######################################################################

		// Itagua� Diferen�a aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019099416");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 132,02 \n"+
				"Material    R$ 56,58 \n"+
				"Total       R$ 188,60 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("14,52");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("188,60");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Itagua� Diferen�a aumento");*/

		//#######################################################################

		// Serop�dica 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019160425");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Serop�dica.  \n"+
				" \n"+	
				"M�o de Obra R$ 763,63 \n"+
				"Material    R$ 327,28 \n"+
				"Total       R$ 1.090,91 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("83,99");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("1.090,91");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Serop�dica");

		//#######################################################################


		// Serop�dica Diferen�a Aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019160425");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 124,95 \n"+
				"Material    R$ 53,55 \n"+
				"Total       R$ 178,50 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("13,74");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("178,50");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Serop�dica Diferen�a aumento");*/

		//#######################################################################

		//Angra dos Reis 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019127215");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Angra dos Reis.  \n"+
				" \n"+	
				"M�o de Obra R$ 818,41 \n"+
				"Material    R$ 350,75 \n"+
				"Total       R$ 1.169,16 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("90,02");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("1.169,16");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Angra");

		//#######################################################################

		//Angra dos Reis Diferen�a Aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019127215");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 133,92 \n"+
				"Material    R$ 57,40 \n"+
				"Total       R$ 191,32 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("14,73");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("191,32");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Angra Diren�a Aumento");*/

		//#######################################################################

		//Olinda 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019050166");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem na capela de Olinda.  \n"+
				" \n"+	
				"M�o de Obra R$ 348,69 \n"+
				"Material    R$ 149,45 \n"+
				"Total       R$ 498,14 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("38,35");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("498,14");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Olinda");

		//#######################################################################

		//Olinda Diferen�a Aumento 
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019050166");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"M�o de Obra R$ 57,06 \n"+
				"Material    R$ 24,46 \n"+
				"Total       R$ 81,52 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("6,27");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("81,52");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Olinda Diferen�a aumento");*/

		//#######################################################################

		// Caxias e Jd Leal 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019030050");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem nas capelas:  \n"+

" \n"+	
"Caxias:  R$ 261,23 \n"+
"Jardim Leal: R$ 249,10 \n"+
" \n"+	
"M�o de Obra R$ 357,23 \n"+
"Material    R$ 153,10 \n"+
"Total       R$ 510,33 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("39,29");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("510,33");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Caxias e Jardim Leal");

		//#######################################################################

		// Caxias e Jd Leal Diferen�a aumento
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019030050");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018:  \n"+
				" \n"+	
				"Caxias \n"+
				"Jardim Leal \n"+
				" \n"+	
				"M�o de Obra R$ 58,45 \n"+
				"Material    R$ 25,05 \n"+
				"Total       R$ 83,50 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_ctrlServicos_tbAliquota")).sendKeys("2,79");
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("6,42");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("83,50");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("Caxias e Jardim Leal Diferen�a aumento");*/

		//#######################################################################

		// Capelas do RJ 
		refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019051995");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem nas capelas:  \n"+
				" \n"+	
				"Cpo Grande R$ 1.119,22 \n"+
				"Sta Margarida R$ 612,37 \n"+
				"Ilha do Governador R$ 594,31 \n"+
				"Comari R$ 871,29' \n"+
				"Jd Maravilha R$ 1.288,14 \n"+
				"Sta Cruz R$ 1.234,47 \n"+
				" \n"+	
				"M�o de Obra R$ 4.003,86 \n"+
				"Material    R$ 1.715,94 \n"+
				"Total       R$ 5.719,80 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("440,42");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("5.719,80");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Jackson");

		//#######################################################################

		// Capelas do RJ Diferan�a aumento Set/Out
		/*refresh();
		driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019051995");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual por contrato aplicado nos meses Setembro e Outubro/2018 nas capelas:  \n"+
				" \n"+		
				"Cpo Grande  \n"+
				"Sta Margarida  \n"+
				"Ilha do Governador  \n"+
				"Comari  \n"+
				"Jd Maravilha  \n"+
				" \n"+		
				"M�o de Obra R$ 513,81 \n"+
				"Material    R$ 220,21 \n"+
				"Total       R$ 734,02 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("56,52");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("734,02");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Jackson Diferen�a aumento");*/

		//#######################################################################

		// Capelas do RJ Arnaldo 
		driver.get("https://notacarioca.rio.gov.br/contribuinte/nota.aspx");
		driver.findElement(By.linkText("Emiss�o de NFS-e")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019129005");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Servi�os realizados: manuten��o de jardinagem nas capelas:  \n"+

"Jacarepagu� R$ 640,48 \n"+
"Freguesia R$ 1.263,35 \n"+
"Curicica R$ 1.124,13 \n"+
"Madureira R$ 520,58 \n"+
"Iraj� R$ 272,17 \n"+
"�gua Branca R$ 516,06 \n"+
"Realengo R$ 707,54 \n"+
"Eng Dentro R$ 749,95 \n"+
"Encantado R$ 592,88 \n"+
"Ramos R$ 367,37 \n"+

"M�o de Obra R$ 4.728,16 \n"+
"Material    R$ 2.026,35 \n"+
"Total       R$ 6.754,51 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("520,10");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("6.754,51");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Arnaldo");


		driver.get("https://notacarioca.rio.gov.br/contribuinte/nota.aspx");
		driver.findElement(By.linkText("Emiss�o de NFS-e")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019129005");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Diferen�a retroativa relativo o aumento anual aplicado nos meses Out/18 � Dez/18:  \n"+

"M�o de Obra R$  1.547,48  \n"+
"Material         R$  663,20  \n"+
"Total              R$ 2.210,68 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("170,22");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("2.210,68");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Arnaldo Diferen�a Retroativa");

		driver.get("https://notacarioca.rio.gov.br/contribuinte/nota.aspx");
		driver.findElement(By.linkText("Emiss�o de NFS-e")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_rbForaMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019129005");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Retirada de entulho oriundo de poda:  \n"+

"M�o de Obra R$ 315,52 \n"+
"Material    R$ 135,23 \n"+
"Total       R$ 450,75 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_0")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("34,70");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("450,75");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Itaguai - Extra");

		driver.get("https://notacarioca.rio.gov.br/contribuinte/nota.aspx");
		driver.findElement(By.linkText("Emiss�o de NFS-e")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_rbNoMunicipio")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbCPFCNPJTomador")).sendKeys("61012019129005");
		driver.findElement(By.id("ctl00_cphCabMenu_btAvancar")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbDiscriminacao")).sendKeys("Retirada de entulho oriundo de poda:  \n"+

"M�o de Obra R$ 141,40 \n"+
"Material    R$ 60,60 \n"+
"Total       R$ 202,00 \n"+
				"Empresa optante pelo simples nacional, ISS devido 2,79%.");

		driver.findElement(By.id("ctl00_cphCabMenu_rblISSRetido_1")).click();
		driver.findElement(By.id("ctl00_cphCabMenu_tbINSS")).sendKeys("15,55");
		driver.findElement(By.id("ctl00_cphCabMenu_tbValor")).sendKeys("202,00");
		driver.findElement(By.id("ctl00_cphCabMenu_btEmitir")).click();
		driver.switchTo().alert().accept();
		System.out.println("RJ Comari - Extra");
	}

}
