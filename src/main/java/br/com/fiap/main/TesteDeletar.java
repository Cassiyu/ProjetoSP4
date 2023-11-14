package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Bike;
import br.com.fiap.dao.AcessoriosDAO;
import br.com.fiap.dao.BikeDAO;

public class TesteDeletar {
	
	static int integer(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BikeDAO dao1 = new BikeDAO();
		AcessoriosDAO dao2 = new AcessoriosDAO();

		Bike objBike = new Bike();
	
		objBike.setIdentifica(integer("Digite a identificação da Bicicleta para deletar os dados"));
		
		System.out.println(dao2.deletar(objBike.getIdentifica()));
		System.out.println(dao1.deletar(objBike.getIdentifica()));

	}

}
