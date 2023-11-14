package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.beans.Bike;
import br.com.fiap.dao.AcessoriosDAO;
import br.com.fiap.dao.BikeDAO;

public class TesteInserir {

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
		AcessoriosDAO dao2 = new AcessoriosDAO();

		Bike objBike = new Bike();
		Acessorios objAcessorios = new Acessorios();

		objBike.setIdentifica(integer("Identificação Bicicleta"));
		objBike.setTipo(text("Tipo de Bicicleta"));
		objBike.setMarca(text("Marca"));
		objBike.setModelo(text("Modelo"));
		objBike.setDataAquisicao(text("Data de aquisição"));
		objBike.setValorAquisicao(decimal("Valor de aquisição"));
		
		objAcessorios.setIdentifica(objBike.getIdentifica());
		objAcessorios.setTipo(text("Tipo de acessório"));
		objAcessorios.setDataAquisicao(text("Data de aquisição"));
		objAcessorios.setValorAquisicao(decimal("Valor de aquisição"));

		System.out.println(dao1.inserir(objBike));
		System.out.println(dao2.inserir(objAcessorios));
	}
}