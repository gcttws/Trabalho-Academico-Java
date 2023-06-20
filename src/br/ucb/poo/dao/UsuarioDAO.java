package br.ucb.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;

import java.sql.Date;

import br.ucb.poo.factory.ConexaoFactory;
import br.ucb.poo.bean.Cliente;

import br.ucb.poo.factory.ConexaoFactory;

public class UsuarioDAO {
	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public boolean verificaExistenciaCliente(String usuario) {	    
	
		String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ?";
    try {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, usuario);
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
    
    public boolean verificaSenhaCliente(String usuario, String senha) {
    	String sql = "SELECT senha FROM usuarios WHERE username = ?";
    	
    	try {
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1, usuario);
    		ResultSet rs = pstmt.executeQuery();
    		
    		if(!rs.next()) {
    			System.out.println("Não encontrou nenhum cliente com a senha especificada.");
    			return false;
    		}
    		

    		String senhaGravadaBanco = rs.getString(1);
    		
    		rs.close();
    		pstmt.close();
    		return senha.equals(senhaGravadaBanco) ? true : false;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
}
    
	public void salvaClienteBD(Cliente cliente) {
		String sql = "INSERT INTO usuarios(nome, username, senha, data_nasc, telefone, email, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,  cliente.getNome());
			pstmt.setString(2,  cliente.getUsername());
			pstmt.setString(3,  cliente.getSenha());
			Date dataNascimento = java.sql.Date.valueOf(cliente.getDataNascimento());
			pstmt.setDate(4, dataNascimento);
			pstmt.setString(5, cliente.getTelefone());
			pstmt.setString(6,  cliente.getEmail());
			pstmt.setInt(7, 2);
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarClienteBD(int id_cliente) {
		String sql = "DELETE FROM usuarios WHERE id_user = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id_cliente);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaClienteBD(int id_cliente, Cliente clienteAtualizacao) {
		
		String sql = "UPDATE usuarios SET nome = ?, username = ?, senha = ?, data_nasc = ?, telefone = ? WHERE id_cliente = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, clienteAtualizacao.getNome());
			pstmt.setString(2,  clienteAtualizacao.getUsername());
			pstmt.setString(3, clienteAtualizacao.getSenha());
			Date dataNascimento = java.sql.Date.valueOf(clienteAtualizacao.getDataNascimento());
			pstmt.setDate(4, dataNascimento);
			pstmt.setString(5, clienteAtualizacao.getTelefone());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
