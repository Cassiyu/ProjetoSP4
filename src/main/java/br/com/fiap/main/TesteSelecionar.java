package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.beans.Bike;
import br.com.fiap.dao.AcessoriosDAO;
import br.com.fiap.dao.BikeDAO;

public class TesteSelecionar {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BikeDAO dao1 = new BikeDAO();
		AcessoriosDAO dao2 = new AcessoriosDAO();

		List<Bike> listaBikes = (ArrayList<Bike>) dao1.selecionar();
		
		if (listaBikes != null) {
			for (Bike bike : listaBikes) {
				System.out.println(
						"Bicicleta" +
						"\nIdentificação: " + bike.getIdentifica() +
						"\nTipo: " + bike.getTipo() +
						"\nMarca: " + bike.getMarca() +
						"\nModelo: " + bike.getModelo() +
						"\nData de aquisição: " + bike.getDataAquisicao() +
						String.format("\nValor de aquisição: R$%.2f", bike.getValorAquisicao()) +
						"\n");
			}
		}
		
		List<Acessorios> listaAcessorios = (ArrayList<Acessorios>) dao2.selecionar();
		
		if (listaAcessorios != null) {
			for (Acessorios acs : listaAcessorios) {
				System.out.println(
						"Acessório" +
						"\nIdentificação: " + acs.getIdentifica() +
						"\nTipo: " + acs.getTipo() +
						"\nData de aquisição: " + acs.getDataAquisicao() +
						String.format("\nValor de aquisição: R$%.2f", acs.getValorAquisicao()) +
						"\n");
			}
		}
	}

}
