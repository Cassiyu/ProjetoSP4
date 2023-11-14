package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Bike;
import br.com.fiap.dao.BikeDAO;

public class BikeBO {
	
	BikeDAO bikeDAO;
	
	// Selecionar
	public ArrayList<Bike> selecionarBO() throws SQLException, ClassNotFoundException{
		bikeDAO = new BikeDAO();
		return (ArrayList<Bike>) bikeDAO.selecionar();
	}
	
	// Inserir
	public void inserirBO(Bike bike) throws ClassNotFoundException, SQLException {
		BikeDAO bikeDao = new BikeDAO();
		bikeDao.inserir(bike);
	}
	
	// Alterar
	public void alterarBO(Bike bike) throws ClassNotFoundException, SQLException {
		BikeDAO bikeDao = new BikeDAO();
		bikeDao.alterar(bike);
	}
	
	// Deletar
	public void deletarBO(int identifica_bike) throws ClassNotFoundException, SQLException {
		BikeDAO bikeDao = new BikeDAO();
		bikeDao.deletar(identifica_bike);
	}

}
