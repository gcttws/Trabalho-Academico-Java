package br.ucb.poo.dashes;

import java.util.Scanner;

import br.ucb.poo.dao.UsuarioDAO;
import br.ucb.poo.bean.Cliente;

import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

public class DashboardLogin extends Dashboard {
	private String username;
	private String senha;
	
	public String getPresentationString() {
		 String stringApresentacao = "=========================================================================="
				   					+ "=== Seja bem-vindo à Alpha Motors!                                     ==="
				   					+ "=== Para realizar seu login ou criar um novo usuário, escolha uma das  ==="
				   					+ "=== opções especificadas abaixo. Para voltar ao menu anterior, sim-    ==="
				   					+ "plesmente digite Voltar.                   	 						  ==="
		 							+ "==========================================================================";
			return stringApresentacao;
	}
	
	public DashboardLogin(int step) {
		int stepAtual = dashboardLoginLoop(step);
		
		while (stepAtual != 3) {
			switch (stepAtual) {
				case 0:
					stepAtual = dashboardLoginLoop(stepAtual);
					break;
				case 1:
					stepAtual = dashboardRealizaLoginLoop(stepAtual);
					break;
				case 2:
					stepAtual = dashboardCriaContaLoop(stepAtual);
					break;
				case 3:
					break;
				default:
					stepAtual = dashboardLoginLoop(stepAtual);
			}
			
			if (stepAtual == 3) break;
		}
	}
	
	public String telaCriacaoConta() {
		String telaCriacaoConta =				
				  "\n=========================================================================="
				+ "\n===                 Criação de Conta - AlphaMotors                     ==="
				+ "\n=== Para criar uma conta, por favor, insira um usuário e uma senha     ==="
				+ "\n=== abaixo. Para voltar ao menu anterior, simplesmente digite Voltar.  ==="
			    + "\n==========================================================================\n";	
		return telaCriacaoConta;
	}
	
	public String telaDashboardLogin() {
		 String telaDashboardLogin = 
				      "\n=========================================================================="
					+ "\n=== Escolha uma das opções:                                            ==="
					+ "\n=== 1) Realizar Login                                                  ==="
					+ "\n=== 2) Criar uma Conta                                              ==="
					+ "\n==========================================================================\n";
		 return telaDashboardLogin;
	}
	
	public String telaDashboardRealizaLogin() {
		String telaDashboardRealizaLogin =				
				  "\n=========================================================================="
				+ "\n===                 Tela de Login - AlphaMotors                        ==="
				+ "\n=== Para realizar seu login, por favor, insira seu usuário e sua senha ==="
				+ "\n=== abaixo. Para voltar ao menu anterior, simplesmente digite Voltar.==="
			    + "\n==========================================================================\n";	
		return telaDashboardRealizaLogin;
}

	public int dashboardCriaContaLoop(int stepAtual) {
		boolean usuarioValido = false;
		
		System.out.println(telaCriacaoConta());
		System.out.println("\nInsira o usuário desejado abaixo: \n");
		
		Scanner sc = new Scanner (System.in);
		String usuario = sc.nextLine();
		
		UsuarioDAO userDao = new UsuarioDAO();
		
		String senha, nome, dataDeNascimento, telefone, email;
		
		while (!usuarioValido) {
			if (usuario.equals("Voltar")){
				return 0;
			} else {
				boolean usuarioExiste = userDao.verificaExistenciaCliente(usuario);
				
				while (usuarioExiste) {
					System.out.println("Esse usuário já existe, por favor escolha outro usuário.");
					usuario = sc.nextLine();
					usuarioExiste = userDao.verificaExistenciaCliente(usuario);
				} 
				
				System.out.println("\nInsira a senha desejada abaixo: \n");
				senha = sc.nextLine();
				
				System.out.println("\nInsira seu nome abaixo: \n");
				nome = sc.nextLine();
				
				System.out.println("\nInsira sua data de nascimento.\n");
				dataDeNascimento = sc.nextLine();
				
				System.out.println("\nInsira seu telefone abaixo.\n");
				telefone = sc.nextLine();
				
				System.out.println("\nInsira seu e-mail abaixo.\n");
				email = sc.nextLine();
				
				Cliente cliente = new Cliente(nome, usuario, senha, telefone, email, dataDeNascimento);
				
				
				userDao.salvaClienteBD(cliente);
				System.out.println("\nUsuário criado com sucesso!");
				usuarioValido = true;
		}
		
	}
		// Criou usuário com sucesso!
		return 3;
	}

	public int dashboardRealizaLoginLoop(int stepAtual) {
		boolean usuarioValido = false;
		
		System.out.println(telaDashboardRealizaLogin());
		System.out.println("\nInsira seu usuario abaixo: \n");
		
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();
		
		UsuarioDAO userDao = new UsuarioDAO();
		String senha;
		
		
		while (!usuarioValido) {		
		if (usuario.equals("Voltar")){
			return 0;
		} else {
				
				boolean clienteExiste =  userDao.verificaExistenciaCliente(usuario);
				
				if (!clienteExiste) {
					System.out.println("\nCliente não existente na base! Insira um novo usuário:\n");
					usuario = sc.nextLine();
				}
				
				System.out.println("\nInsira sua senha abaixo\n");
				senha = sc.nextLine();
				
				boolean senhaPareada = userDao.verificaSenhaCliente(usuario,  senha);
				if (senhaPareada) {
					System.out.println("Usuário logado com sucesso!");
					return 3;
				} else {
					System.out.println("Senha inválida.");
					continue;
				}
			}
		}
		
		return 0;
	}
		
	
	public int dashboardLoginLoop(int stepAtual) {
		System.out.println(telaDashboardLogin());
		List listaOpcoes = new ArrayList<Integer>();
		listaOpcoes.add(1);
		listaOpcoes.add(2);
				
		Scanner sc = new Scanner(System.in);
		int escolha = sc.nextInt();
		
		while(!listaOpcoes.contains(escolha)) {
			System.out.println("Escolha inválida. Por favor, insira um novo valor.");
			escolha = sc.nextInt();
		}
		
		if(escolha == 1) {
			this.stepAtual = 1;
			return this.stepAtual;
		} else if (escolha == 2) {
			this.stepAtual = 2;
			return this.stepAtual;
		}
		
		return 0;
	}

}
