package br.ucb.poo;

import java.util.ArrayList;

import java.util.Scanner;

import br.ucb.poo.bean.Veiculo;
import br.ucb.poo.dao.VeiculoDAO;
import br.ucb.poo.dashes.Dashboard;
import br.ucb.poo.dashes.DashboardLogin;
import br.ucb.poo.dashes.DashboardVeiculos;

public class Executora {
	static VeiculoDAO dao = new VeiculoDAO();
	
	public static void main(String[] args) {
		System.out.println("--- SISTEMA ALPHAMOTORS ---");
		int stepAtual = 0;
		
		Dashboard dashAtual = new Dashboard();
		dashAtual.imprimeTelaAtual();
		DashboardLogin dashLogin = new DashboardLogin(stepAtual);
		String usuario = dashLogin.getUsername();
		
		DashboardVeiculos dashVeiculos = new DashboardVeiculos(stepAtual, usuario);

		 
	}

	
}
