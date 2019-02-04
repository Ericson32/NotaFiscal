package br.org.wmas.notas;

import java.util.ArrayList;
import java.util.Collection;

public class Teste {
	 private String path;

	    public Teste(String teste) {
	        this.path = path;
	    }

	    public String getPath() {
	        return path;
	    }

	    public void cd(String newPath) {
	        throw new UnsupportedOperationException("Waiting to be implemented.");
	    }

	    public static void main(String[] args) {
	        Teste teste = new Teste("/a/b/c/d");
	        teste.cd("../x");
	        System.out.println(teste.getPath());
	    }
}
