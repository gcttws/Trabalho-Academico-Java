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
	
	public void salvaClienteBD(Cliente cliente) {
		String sql = "INSERT INTO usuarios(nome, username, senha, data_nasc, telefone, email, role) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,  cliente.getNome());
			pstmt.setString(2,  cliente.getUsername());
			pstmt.setString(3,  cliente.getSenha());
			Date dataNascimento = java.sql.Date.valueOf(cliente.getDataNascimento());
			pstmt.setDate(4, dataNascimento);
			pstmt.setString(5, cliente.getTelefone());
			pstmt.setString(6,  cliente.getEmail());
			pstmt.setInt(7, cliente.getRole());
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
