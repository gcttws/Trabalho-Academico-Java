package br.ucb.poo.dashes;

import java.util.Scanner;
public class DashboardLogin extends Dashboard {
	private String username;
	private String senha;
	
	public String getPresentationString() {
		 String stringApresentacao = "=========================================================================="
				   					+ "=== Seja bem-vindo à Alpha Motors!                                     ==="
				   					+ "=== Para realizar seu login ou criar um novo usuário, escolha uma das  ==="
				   					+ "=== opções especificadas abaixo.	 							          ==="
		 							+ "==========================================================================";
			return stringApresentacao;
	}
	
	public String telaDashboardLogin() {
		 String telaDashboardLogin = 
				      "=========================================================================="
					+ "=== Escolha uma das opções:                                            ==="
					+ "=== 1) Realizar Login                                                  ==="
					+ "=== 2) Criar uma Conta         	 							          ==="
					+ "==========================================================================";
		 return telaDashboardLogin;
	}
	
	public void dashboardLoginLoop(int stepAtual) {
		
		do {
			System.out.println(this.telaDashboardLogin());
			Scanner sc = new Scanner(System.in);
			int escolha = sc.nextInt();
			
			while(escolha != 1 || escolha != 2) {
				System.out.println("Escolha inválida. Por favor, insira um novo valor.");
				escolha = sc.nextInt();
			}
			
			this.stepAtual = 1;	
		} while (this.stepAtual != 0);		
	}
}
