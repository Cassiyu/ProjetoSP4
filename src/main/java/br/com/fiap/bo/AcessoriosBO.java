package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.dao.AcessoriosDAO;

public class AcessoriosBO {

	AcessoriosDAO acsDAO;
	
	// Selecionar
	public ArrayList<Acessorios> selecionarBO() throws SQLException, ClassNotFoundException{
		acsDAO = new AcessoriosDAO();
		return (ArrayList<Acessorios>) acsDAO.selecionar();
	}
	
	// Inserir
	public void inserirBO(Acessorios acs) throws ClassNotFoundException, SQLException {
		AcessoriosDAO acsDao = new AcessoriosDAO();
		acsDao.inserir(acs);
	}
	
	// Alterar
	public void alterarBO(Acessorios acs) throws ClassNotFoundException, SQLException {
		AcessoriosDAO acsDao = new AcessoriosDAO();
		acsDao.alterar(acs);
	}
	
	// Deletar
	public void deletarBO(int identifica_bike) throws ClassNotFoundException, SQLException {
		AcessoriosDAO acsDao = new AcessoriosDAO();
		acsDao.deletar(identifica_bike);
	}
	
	
	
	
	
}
