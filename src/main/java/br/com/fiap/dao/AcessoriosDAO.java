package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Acessorios;
import br.com.fiap.conexoes.ConexaoFactory;

public class AcessoriosDAO {

    private Connection minhaConexao;

    public AcessoriosDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Acessorios acessorios) throws SQLException {

        String sql = "INSERT INTO T_FIAP_ACESSORIOS (identifica_bike, tipo_acs, data_acs, valor_acs) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setInt(1, acessorios.getIdentifica());
        stmt.setString(2, acessorios.getTipo());
        stmt.setString(3, acessorios.getDataAquisicao());
        stmt.setDouble(4, acessorios.getValorAquisicao());
        stmt.executeUpdate();
        stmt.close();

        return "Acessórios cadastrados com sucesso.";
    }
    
    public String deletar(int identifica_bike) throws SQLException {

        String sql = "DELETE FROM T_FIAP_ACESSORIOS WHERE identifica_bike = ?";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setInt(1, identifica_bike);
        stmt.executeUpdate();
        stmt.close();

        return "Acessórios deletados com sucesso.";
    }
    
    public String alterar(Acessorios acessorios) throws SQLException {

        String sql = "UPDATE T_FIAP_ACESSORIOS SET tipo_acs = ?, data_acs = ?, valor_acs ? WHERE identifica_bike = ?";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setString(1, acessorios.getTipo());
        stmt.setString(2, acessorios.getDataAquisicao());
        stmt.setDouble(3, acessorios.getValorAquisicao());
        stmt.setInt(4, acessorios.getIdentifica());
        stmt.executeUpdate();
        stmt.close();

        return "Acessórios alterados com sucesso.";
    }
    
    public List<Acessorios> selecionar() throws SQLException {
    	List<Acessorios> listaAcessorios = new ArrayList<Acessorios>();
    	
    	PreparedStatement stmt = minhaConexao.prepareStatement
    			("SELECT * FROM T_FIAP_ACESSORIOS");
    	
    	ResultSet rs = stmt.executeQuery();
    	
    	while (rs.next()) {
    		Acessorios acs = new Acessorios();
    		acs.setIdentifica(rs.getInt(1));
    		acs.setTipo(rs.getString(2));
    		acs.setDataAquisicao(rs.getString(3));
    		acs.setValorAquisicao(rs.getDouble(4));
    		listaAcessorios.add(acs);
		}
    	return listaAcessorios;
    }
    
    
    
}
