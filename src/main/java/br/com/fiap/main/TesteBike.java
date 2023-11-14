package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Bike;
import br.com.fiap.excecoes.Excecao;

public class TesteBike {
	
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
	// Amount
	static double calcularValorTotal(List<Bike> listaBike) {
	    double valorTotal = 0.0;

	    for (Bike bike : listaBike) {
	        valorTotal += bike.getValorAquisicao();
	    }
	    return valorTotal;
	}
	
	public static void main(String[] args) throws Excecao {

		// Instance Array List
		List<Bike> listaBike = new ArrayList<Bike>();
		

		Bike objBike = null;
		

		do {
			try {
				objBike = new Bike();
				objBike.setIdentifica(integer("Identificação"));
				objBike.setTipo(text("Tipo"));
				objBike.setMarca(text("Marca"));
				objBike.setModelo(text("Modelo"));
				objBike.setDataAquisicao(text("Data de aquisição"));
				objBike.setValorAquisicao(decimal("Valor de aquisição"));
				listaBike.add(objBike);

			} catch (Exception e) {
				throw new Excecao(e);
			} finally {
				System.out.println("Ok");
			}

		} while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra Bicicleta?", "Cadastro de Bicicletas",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
		
		for (int i = 0; i < listaBike.size(); i++) {
		    Bike bike = listaBike.get(i);
		    
		    System.out.println(
		    		"Bicicleta " + (i + 1)+
		    		"\nIdentificação: " + bike.getIdentifica() +
    	            "\nTipo: " + bike.getTipo() +
		    		"\nMarca: " + bike.getMarca() +
    	            "\nModelo: " + bike.getModelo() +
    	            "\nData de aquisição: " + bike.getDataAquisicao() +
    	            String.format("\nValor de aquisição: R$%.2f", bike.getValorAquisicao()) +
    	            "\n" +
    	            "\nSeguro" +
    	            "\nDisponibilidade: " + bike.Disponibilidade() +
    	            "\n"
    	            );
		}
		double valorTotal = calcularValorTotal(listaBike);
	    System.out.printf("Valor Total das Bicicletas Cadastradas: R$%.2f", valorTotal);
	}
}
