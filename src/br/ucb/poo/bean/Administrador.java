package br.ucb.poo.bean;

import java.util.List;

public class Administrador extends Usuario{
	private List<String> clientePermission;
	
	Administrador(String username, String senha){
		this.setUsername(username);
		this.setSenha(senha);
		this.setRole(0);
		List<String> clientePermissions = List.of("CREATE", "UPDATE","DELETE","INSERT");
		this.setClientePermission(clientePermissions);
		
	}

	public List<String> getClientePermission() {
		return clientePermission;
	}

	private void setClientePermission(List<String> clientePermission) {
		this.clientePermission = clientePermission;
	}
	
	
	
}
