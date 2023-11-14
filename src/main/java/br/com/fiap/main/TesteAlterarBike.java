package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Bike;
import br.com.fiap.dao.BikeDAO;

public class TesteAlterarBike {
	
	static String text(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int integer(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static double decimal(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BikeDAO dao1 = new BikeDAO();
		
		Bike objBike = new Bike();

		objBike.setIdentifica(integer("Digite a Identificação da Bicicleta que deseja alterar"));
		objBike.setTipo(text("Tipo de Bicicleta"));
		objBike.setMarca(text("Marca"));
		objBike.setModelo(text("Modelo"));
		objBike.setDataAquisicao(text("Data de aquisição"));
		objBike.setValorAquisicao(decimal("Valor de aquisição"));

		System.out.println(dao1.alterar(objBike));
		
	}

}
