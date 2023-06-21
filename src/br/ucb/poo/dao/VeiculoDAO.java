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
import br.ucb.poo.bean.Usuario;

public class VeiculoDAO {
	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public void salvaVeiculoBD(Veiculo veiculo, Integer idUsuario) {
	    String sql = "INSERT INTO veiculos(marca, modelo, placa, ano, status, id_user) VALUES(?,?,?,?,?,?)";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, veiculo.getMarca());
	        pstmt.setString(2, veiculo.getModelo());
	        pstmt.setString(3, veiculo.getPlaca());
	        pstmt.setInt(4, veiculo.getAno());
	        pstmt.setString(5, veiculo.getStatus());
	        pstmt.setInt(6, idUsuario);
	        pstmt.execute();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deletarVeiculoBD(String placa) {
		String sql = "DELETE FROM veiculos WHERE placa = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, placa);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizaVeiculoBD(int id_veiculo, String marca, String modelo, 
			String placa, int ano, String status, Integer idUsuario) {
			String sql = "UPDATE veiculos SET marca = ?, modelo = ?, "
				+ "placa = ?, ano = ?, status = ?, id_user = ? WHERE placa = ?";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, marca);
	        pstmt.setString(2, modelo);
	        pstmt.setString(3, placa);
	        pstmt.setInt(4, ano);
	        pstmt.setString(5, status);
	        pstmt.setInt(6,  idUsuario);
	        pstmt.setString(7,  placa);
	        pstmt.executeUpdate();
	        pstmt.close();
	        System.out.println("Veículo atualizado com sucesso.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public boolean verificaPlacaVeiculo(String placa) {
		String sql = "SELECT COUNT(*) FROM veiculos where placa = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,  placa);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			return count > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verificaIdVeiculo(int id_veiculo) {
	    String sql = "SELECT COUNT(*) FROM veiculos WHERE id_veiculo = ?;";
	    
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
	
	public ArrayList<Veiculo> listaVeiculosBD(int id_usuario){
		String sql = "SELECT id_veiculo, marca, modelo, placa, ano, status FROM veiculos WHERE id_user = ?;";
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id_usuario);
			
			ResultSet rs = pstmt.executeQuery();
			
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
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return veiculos;
	}
	
	public boolean verificaPosseVeiculo(String placa, int id_username) {
		String sql = "SELECT COUNT(*) FROM veiculos where placa = ? and id_user = ?;";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,  placa);
			pstmt.setInt(2, id_username);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			return count > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int capturaIdVeiculoFromPlaca(String placa) {
	    String sql = "SELECT id_veiculo FROM veiculos WHERE placa = ?;";
	    
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, placa);
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int id_veiculo = rs.getInt(1);
	        rs.close();
	        pstmt.close();
	        return id_veiculo;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

}
