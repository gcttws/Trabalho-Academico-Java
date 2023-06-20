package br.ucb.poo.bean;

import java.util.List;

public abstract class Usuario {
	protected String nome;
	protected String username;
	protected String senha;
	private List<Role> roles;
	protected int role;

	Usuario() {

	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome() {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
