package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Bike;
import br.com.fiap.conexoes.ConexaoFactory;

public class BikeDAO {
    
    private Connection minhaConexao;

    public BikeDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Bike bike) throws SQLException {

        String sql = "INSERT INTO T_FIAP_BIKE (identifica_bike, tipo_bike, marca_bike, modelo_bike, data_bike, valor_bike) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setInt(1, bike.getIdentifica());
        stmt.setString(2, bike.getTipo());
        stmt.setString(3, bike.getMarca());
        stmt.setString(4, bike.getModelo());
        stmt.setString(5, bike.getDataAquisicao());
        stmt.setDouble(6, bike.getValorAquisicao());
        stmt.executeUpdate();
        stmt.close();

        return "Bicicleta cadastrada com sucesso.";
    }
    
    public String deletar(int identifica_bike) throws SQLException {

        String sql = "DELETE FROM T_FIAP_BIKE WHERE identifica_bike = ?";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setInt(1, identifica_bike);
        stmt.executeUpdate();
        stmt.close();

        return "Bicicleta deletada com sucesso.";
    }
    
    public String alterar(Bike bike) throws SQLException {

        String sql = "UPDATE T_FIAP_BIKE SET tipo_bike = ?, marca_bike = ?, modelo_bike = ?, data_bike = ?, valor_bike = ? WHERE identifica_bike = ?";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        
        stmt.setString(1, bike.getTipo());
        stmt.setString(2, bike.getMarca());
        stmt.setString(3, bike.getModelo());
        stmt.setString(4, bike.getDataAquisicao());
        stmt.setDouble(5, bike.getValorAquisicao());
        stmt.setInt(6, bike.getIdentifica());
        stmt.executeUpdate();
        stmt.close();

        return "Bicicleta alterada com sucesso.";
    }
    
    public List<Bike> selecionar() throws SQLException {
    	
    	List<Bike> listaBikes = new ArrayList<Bike>();
    	
    	PreparedStatement stmt = minhaConexao.prepareStatement
    			("SELECT * FROM T_FIAP_BIKE");
    	
    	ResultSet rs = stmt.executeQuery();
    	
    	while (rs.next()) {
    		Bike bike = new Bike();
    		bike.setIdentifica(rs.getInt(1));
    		bike.setTipo(rs.getString(2));
    		bike.setMarca(rs.getString(3));
    		bike.setModelo(rs.getString(4));
    		bike.setDataAquisicao(rs.getString(5));
    		bike.setValorAquisicao(rs.getDouble(6));
    		listaBikes.add(bike);
		}
    	return listaBikes;
    	
    }
    
    
}
