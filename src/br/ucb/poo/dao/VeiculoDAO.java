package br.ucb.poo.dao;
//IMPORT BIBLIOTECAS SQL CONECTION
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.factory.ConexaoFactory;
import br.ucb.poo.bean.Veiculo;

public class VeiculoDAO {
	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public void salvaVeiculoBD(Veiculo veiculo) {
	    String sql = "INSERT INTO veiculos(marca, modelo, placa, ano, status) VALUES(?,?,?,?,?)";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, veiculo.getMarca());
	        pstmt.setString(2, veiculo.getModelo());
	        pstmt.setString(3, veiculo.getPlaca());
	        pstmt.setInt(4, veiculo.getAno());
	        pstmt.setString(5, veiculo.getStatus());
	        pstmt.execute();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deletarVeiculoBD(int id_veiculo) {
		String sql = "DELETE FROM veiculos WHERE id_veiculo = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id_veiculo);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizaVeiculoBD(int id_veiculo, String marca, String modelo, String placa, int ano, String status) {
		String sql = "UPDATE veiculos SET marca = ?, modelo = ?, placa = ?, ano = ?, status = ? WHERE id_veiculo = ?";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, marca);
	        pstmt.setString(2, modelo);
	        pstmt.setString(3, placa);
	        pstmt.setInt(4, ano);
	        pstmt.setString(5, status);
	        pstmt.setInt(6, id_veiculo);
	        pstmt.executeUpdate();
	        pstmt.close();
	        System.out.println("Veículo atualizado com sucesso.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public boolean verificaIdVeiculo(int id_veiculo) {
	    String sql = "SELECT COUNT(*) FROM veiculos WHERE id_veiculo = ?";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, id_veiculo);
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        rs.close();
	        pstmt.close();
	        return count > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public ArrayList<Veiculo> listaVeiculosBD(){
		String sql = "SELECT id_veiculo, marca, modelo, placa, ano, status FROM veiculos";
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("id_veiculo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setStatus(rs.getString("status"));
				veiculos.add(veiculo);
			}
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return veiculos;
	}

}
