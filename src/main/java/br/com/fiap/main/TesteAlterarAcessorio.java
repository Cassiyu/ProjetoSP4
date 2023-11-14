package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.dao.AcessoriosDAO;

public class TesteAlterarAcessorio {
	
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
		
		AcessoriosDAO dao = new AcessoriosDAO();
		
		Acessorios objAcs = new Acessorios();

		objAcs.setIdentifica(integer("Digite a Identificação do Acessório que deseja alterar"));
		objAcs.setTipo(text("Tipo de Acessório"));
		objAcs.setDataAquisicao(text("Data de aquisição"));
		objAcs.setValorAquisicao(decimal("Valor de aquisição"));

		System.out.println(dao.alterar(objAcs));
	}

}
