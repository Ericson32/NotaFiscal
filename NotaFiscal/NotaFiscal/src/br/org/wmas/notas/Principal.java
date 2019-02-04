package br.org.wmas.notas;

public class Principal {

	public static void main(String[] args) {
		AbrirNavegador abrirNavegador = new AbrirNavegador();
		try {
			AbrirNavegador.setUp();
			abrirNavegador.logar();
			abrirNavegador.emitirNFS();
			//abrirNavegador.gerarRanfQueimados();
			//abrirNavegador.gerarDapsSeropedica();
			//abrirNavegador.gerarDapsBelfordRoxo();
			//File file = abrirNavegador.getProcessFile();
			//abrirNavegador.processNFSList(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
