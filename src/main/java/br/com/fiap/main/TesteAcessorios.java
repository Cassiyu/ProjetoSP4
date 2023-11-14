package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.excecoes.Excecao;

public class TesteAcessorios {
		
	// Static Method
	static String text(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int integer(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static double decimal(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
		
	public static void main(String[] args) throws Excecao {
		
		List<Acessorios> listaAcessorios = new ArrayList<Acessorios>();
		
		Acessorios objAcessorios = null;
		
		do {
			try {
				objAcessorios = new Acessorios();
				objAcessorios.setIdentifica(integer("Identificação Bicicleta"));
				objAcessorios.setTipo(text("Tipo de Acessório"));
				objAcessorios.setDataAquisicao(text("Data de aquisição"));
				objAcessorios.setValorAquisicao(decimal("Valor de aquisição"));
				listaAcessorios.add(objAcessorios);
			} catch (Exception e) {
				throw new Excecao(e);
			} finally {
				System.out.println("Ok");
			}
			
		} while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro Acessório?", "Cadastro de Acessórios",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
		
		for (int i = 0; i < listaAcessorios.size(); i++) {
		    Acessorios acs = listaAcessorios.get(i);
		    
		    System.out.println(
    	            "\nAcessórios" +
    	            "\nTipo: " + acs.getTipo() +
    	            "\nData de aquisição: " + acs.getDataAquisicao() +
    	            String.format("\nValor de aquisição: R$%.2f", acs.getValorAquisicao()) +
    	            "\n"
    	            );
		}
		

	}
		

}
