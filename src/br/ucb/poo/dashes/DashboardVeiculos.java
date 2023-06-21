package br.ucb.poo.dashes;


import java.util.Scanner;

import br.ucb.poo.dao.UsuarioDAO;
import br.ucb.poo.bean.Cliente;
import br.ucb.poo.bean.Veiculo;

import br.ucb.poo.dao.VeiculoDAO;


import java.util.ArrayList;
import java.util.List;

public class DashboardVeiculos extends Dashboard {
	public String username;
	
 	public DashboardVeiculos(int stepAtual, String username) {
		System.out.println(getPresentationString());
		this.stepAtual = dashboardVeiculosLoop(stepAtual);
		
		List<Integer> listaOpcoesSaida = new ArrayList<Integer>();
		listaOpcoesSaida.add(0);
		listaOpcoesSaida.add(3);
		
		while (!listaOpcoesSaida.contains(this.stepAtual)) {
			switch (this.stepAtual) {
			case 0:
				// Sair do Programa
				this.stepAtual = 0;
				break;
			case 4:
				// Listar Veículos
				this.stepAtual = dashboardListaVeiculosLoop(this.stepAtual, username);
				break;
			case 5:
				// Inserir Veículo p/ Venda
				this.stepAtual = dashboardInsereVeiculoLoop(this.stepAtual, username);
				break;
			case 6:
				// Atualizar Infos do Veículo
				this.stepAtual = dashboardAtualizaInfosVeiculoLoop(this.stepAtual, username);
				break;
			case 7:
				// Remover Veículo da Listagem
				this.stepAtual = dashboardRemoveVeiculoLoop(this.stepAtual, username);
				break;
			case 8:
				// Sair da Sessão Atual
				this.stepAtual = 8;
				break;
			case 9:
				// Realizar Nova Operação
				this.stepAtual = dashboardVeiculosLoop(this.stepAtual);
				break;
			}
		}
	}
	
	public String getPresentationString() {
		String stringApresentacao =
				  "\n=============================================================================="
			    + "\n===             Dashboard - Veículos - AlphaMotors                         ==="
			    + "\n===  Nesta seção são disponibilizadas várias operações sobre os veículos   ==="
			    + "\n===    abaixo. Para voltar ao menu anterior, simplesmente digite Voltar.   ==="
		        + "\n==========================================================================\n";	
		
		return stringApresentacao;
	}
	
	public String telaDashboardVeiculos() {
		String telaDashboardVeiculos = 
				 "\n=========================================================================="			
			   + "\n=== Escolha uma das opções:                                            ==="
			   + "\n=== 1) Listar Todos os Veículos à Venda em Sua Carteira                ==="
			   + "\n=== 2) Inserir Veículo para Venda                                      ==="
			   + "\n=== 3) Atualizar Informações do Veículo                                ==="
			   + "\n=== 4) Remover Veículo da Listagem                                     ==="
			   + "\n=== 5) Sair da Sessão Atual                                            ==="
			   + "\n=== 0) Sair do Programa                                                ==="
			   + "\n==========================================================================\n";
				 return telaDashboardVeiculos;
	}
	
	public String telaListagemVeiculos(ArrayList<Veiculo> veiculos, String nomeCliente) {
		String telaDashboardVeiculos = 
				 "\n=========================================================================="
				+ "\n===        Dashboard - Listagem de Veículos - AlphaMotors             ==="
				+ "\n========================================================================="
				+ "\n===   Aqui estão listados todos os seus respectivos veículos,         ==="
				+ "\n=== Caro " + 
				" ".repeat((62-nomeCliente.length())/2)
				+ nomeCliente +	
				" ".repeat((62-nomeCliente.length())/2)
				+ "==="
				+ "\n==========================================================================";
		
		for(Veiculo v : veiculos) {
			
			String stringIdVeiculo = "\nID: " + v.getId();
			telaDashboardVeiculos = telaDashboardVeiculos.concat(stringIdVeiculo);
			
			String stringMarcaVeiculo = "\nMarca: " + v.getMarca();			
			telaDashboardVeiculos = telaDashboardVeiculos.concat(stringMarcaVeiculo);
			
			String stringModeloVeiculo = "\nModelo: " + v.getModelo(); 
			telaDashboardVeiculos = telaDashboardVeiculos.concat(stringModeloVeiculo);
			
			String stringAnoVeiculo = "\nAno: " + Integer.toString(v.getAno());
			telaDashboardVeiculos  = telaDashboardVeiculos.concat(stringAnoVeiculo);
			
			String stringPlacaVeiculo = "\nPlaca: " + v.getPlaca();
			telaDashboardVeiculos = telaDashboardVeiculos.concat(stringPlacaVeiculo);
			
			String stringStatusVeiculo = "\nStatus: " + v.getStatus();
			telaDashboardVeiculos = telaDashboardVeiculos.concat(stringStatusVeiculo);
			
			telaDashboardVeiculos = telaDashboardVeiculos.concat("\n==========================================================================");
		}
		
		telaDashboardVeiculos.concat("\n Aperte a tecla ENTER para voltar à tela anterir");
		return telaDashboardVeiculos;
	}
	
	public String telaListagemVeiculosVazia(String nomeCliente) {
		String telaListagemVeiculosVazio = 
				  "\n=========================================================================="
				+ "\n===        Dashboard - Listagem de Veículos - AlphaMotors              ==="
				+ "\n=========================================================================="
				+ "\n=== Caro Cliente " + nomeCliente + ", não existem veículos cadastrados ==="
				+ "\n=== em seu nome. Redirecionando-o para a tela anterior.                ==="
				+ "\n==========================================================================";
		
		return telaListagemVeiculosVazio;
	}
	
	public String telaInsercaoVeiculo(String nomeCliente) {
		String telaInsercaoVeiculo = 
				 "\n=========================================================================="
				 + "\n===               Inserção de Veículo - AlphaMotors                   ==="
				 + "\n=== Para inserir um veículo, insira os dados requisitados abaixo.     ==="
				 + "\n=== abaixo. Para voltar ao menu anterior, simplesmente digite Voltar. ==="
			     + "\n==========================================================================\n";	
		return telaInsercaoVeiculo;
	}
	
	public String telaAtualizacaoVeiculo(String nomeCliente) {
		String telaInsercaoVeiculo = 
				 "\n=========================================================================="
				 + "\n===               Atualização de Veículo - AlphaMotors                ==="
				 + "\n=== Para atualizar um veículo, insira os dados requisitados abaixo.   ==="
				 + "\n=== abaixo. Para voltar ao menu anterior, simplesmente digite Voltar. ==="
			     + "\n==========================================================================\n";	
		return telaInsercaoVeiculo;
	}
	
	public int dashboardVeiculosLoop(int stepAtual) {
		System.out.println(telaDashboardVeiculos());
		
		List<Integer> listaOpcoes = new ArrayList<Integer>();
		// Listar Veiculos
		listaOpcoes.add(1);
		// Inserir Veiculo para Venda
		listaOpcoes.add(2);
		// Atualizar Infos. do Veiculo
		listaOpcoes.add(3);
		// Remover Veículo da Listagem
		listaOpcoes.add(4);
		// Sair da Sessão Atual
		listaOpcoes.add(5);
		// Sair do Prograam
		listaOpcoes.add(0);
		
		Scanner sc = new Scanner(System.in);
		String escolha = sc.nextLine();
		int escolhaInteiro = Integer.parseInt(escolha);
		
		
		while(!listaOpcoes.contains(escolhaInteiro)) {
			System.out.println("Escolha inválida. Por favor, insira um novo valor: ");
			escolha = sc.nextLine();
			escolhaInteiro = Integer.parseInt(escolha);
		}
				
		switch (escolhaInteiro) {
			case 1:
				this.stepAtual = 4;
				return this.stepAtual;
			case 2:
				this.stepAtual = 5;
				return this.stepAtual;
			case 3:
				this.stepAtual = 6;
				return this.stepAtual;
			case 4:
				this.stepAtual = 7;
				return this.stepAtual;
			case 5:
				this.stepAtual = 8;
				return this.stepAtual;
			case 0:
				this.stepAtual = 0;
				return this.stepAtual;
		}
		return 0;
	}
	
	public int dashboardListaVeiculosLoop(int stepAtual, String username) {
		VeiculoDAO vdao = new VeiculoDAO();
		UsuarioDAO udao = new UsuarioDAO();
		
		String nomeCliente = udao.getNomeClienteFromUsername(username);
		int id_usuario = udao.getIdClienteFromUsername(username);
		
		ArrayList<Veiculo> veiculos;
		veiculos = vdao.listaVeiculosBD(id_usuario);
		
		
		if(!veiculos.isEmpty()) {
			String dashListagemVeiculosString = telaListagemVeiculos(veiculos, nomeCliente);
			System.out.println(dashListagemVeiculosString);
			System.out.println("Para voltar à tela anterior, aperte ENTER...");
			Scanner sc = new Scanner(System.in);
			String tecla = sc.nextLine();
			return 9;
		} else {
			System.out.println(telaListagemVeiculosVazia(nomeCliente));
			Scanner sc = new Scanner(System.in);
			return 9;
		}
	}
	
	public int dashboardInsereVeiculoLoop(int stepAtual, String username) {
		boolean veiculoValido = false;
		boolean anoValidacao, placaValidacao;

		
		VeiculoDAO vdao = new VeiculoDAO();
		UsuarioDAO udao = new UsuarioDAO();
		Veiculo veiculo = new Veiculo();
		
		String marca, modelo , placa, status;

		
		int ano;
	
		int id_usuario = udao.getIdClienteFromUsername(username);
		String nomeCliente = udao.getNomeClienteFromUsername(username);
		
		List<Integer> statusValidos = new ArrayList<Integer>();
		statusValidos.add(1);
		statusValidos.add(2);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(telaInsercaoVeiculo(nomeCliente));
		
		System.out.println("Para criar um novo veículo, são necessários 5 atributos."
				+ "Esses 5 atributos correspondem à marca, modelo, placa, ano e status do"
				+ "respectivo veículo.");
		
		System.out.println("Para começar, digite a marca do veículo. Ou, se desejar voltar,"
				+ "apenas digite 'Voltar' abaixo.");
		
		System.out.println("Marca:");
		
		marca = sc.nextLine();
		while (!veiculoValido) {
			if (marca.equals("Voltar")) {
				
				return 9;
			} else {
				System.out.println("\nInsira o modelo do veículo abaixo: ");
				modelo = sc.nextLine();
				
				placaValidacao = false;
				System.out.println("\nInsira a placa do veículo abaixo");
				placa = sc.nextLine();
				placaValidacao = validaPlaca(placa);
				
				
				while(!placaValidacao) {
					System.out.println("\n Falha na validação da placa. Por favor, insira uma placa\n"
							+ "válida: ");
					placa = sc.nextLine();
					placaValidacao = validaPlaca(placa);
				}
				
				vdao.verificaPlacaVeiculo(placa);
				anoValidacao = false;
				System.out.println("\nInsira o ano do veículo abaixo");
				ano = Integer.parseInt(sc.nextLine());
				anoValidacao = validaAno(ano);
				
				while(!anoValidacao) {
					System.out.println("\n Falha na validação do ano. Por favor, insira uma placa\n"
							+ "válida: ");
					ano = Integer.parseInt(sc.nextLine());
					anoValidacao = validaAno(ano);
				}
				
				System.out.println("\nInsira o status do veículo abaixo\n  1 - À VENDA"
						+ " ou 2 - VENDIDO')");
				
				int statusValor = Integer.parseInt(sc.nextLine());
				while(!statusValidos.contains(statusValor)) {
					System.out.println("\n Por favor, insira um status válido. Este pode ser"
							+ "\n1 - À VENDA \n ou \n 2 - VENDIDO: ");
					statusValor = Integer.parseInt(sc.nextLine());
				}
								
				if (statusValor == 1) status = "À VENDA"; else status = "VENDIDO";
				
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setPlaca(placa);
				veiculo.setAno(ano);
				veiculo.setStatus(status);
				veiculo.setDono(id_usuario);
				
				vdao.salvaVeiculoBD(veiculo, id_usuario);
				System.out.println("Veículo inserido com sucesso!");
				veiculoValido = true;
			}
		}
		
		return 9;
	}
	
	public int dashboardAtualizaInfosVeiculoLoop(int stepAtual, String username) {
		boolean veiculoValido = false;
		boolean placaValidacao = false;
		boolean anoValidacao = false;
		boolean usuarioPossuiVeiculo;
		
		List<Integer> statusValidos = new ArrayList<Integer>();
		statusValidos.add(1);
		statusValidos.add(2);
		
		VeiculoDAO vdao = new VeiculoDAO();
		UsuarioDAO udao = new UsuarioDAO();
		
		String marca, modelo ,placa, status;
		
		int ano, statusValor;
	
		int id_usuario = udao.getIdClienteFromUsername(username);
		String nomeCliente = udao.getNomeClienteFromUsername(username);

		System.out.println(telaAtualizacaoVeiculo(nomeCliente));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nInsira a placa do veículo o qual deseja alterar: ");
		
		placa = sc.nextLine();
		placaValidacao = validaPlaca(placa);
		
		while(!placaValidacao) {
			System.out.println("\n Falha na validação da placa. Por favor, insira uma placa\n"
					+ "válida: ");
			placa = sc.nextLine();
			placaValidacao = validaPlaca(placa);
		}
		
		while(!veiculoValido) {
			if (placa.equals("Voltar")) {
				return 9;
			}
			
			usuarioPossuiVeiculo = vdao.verificaPosseVeiculo(placa, id_usuario);
			
			while (!usuarioPossuiVeiculo) {
				System.out.println("Você não é proprietário do veículo o qual deseja alterar"
						+ "os respectivos dados. Por favor, insira novamente a placa do "
						+ "veículo o qual deseja alterar:");
				placa = sc.nextLine();
				placaValidacao = validaPlaca(placa);
				
				while(!placaValidacao) {
					System.out.println("\n Falha na validação da placa. Por favor, insira uma placa\n"
							+ "válida: ");
					placa = sc.nextLine();
					placaValidacao = validaPlaca(placa);
				}
				usuarioPossuiVeiculo = vdao.verificaPosseVeiculo(placa, id_usuario);
			}
			
			System.out.println("\nInsira a marca do veículo: ");
			marca = sc.nextLine();
			
			System.out.println("\nInsira o modelo do veículo: ");
			modelo = sc.nextLine();
			
			System.out.println("\nInsira o ano do veículo: ");
			ano = Integer.parseInt(sc.nextLine());
			anoValidacao = validaAno(ano);
			while(!anoValidacao) {
				System.out.println("\n Falha na validação do ano. Por favor, insira um ano\n"
						+ "válido: ");
				ano = Integer.parseInt(sc.nextLine());
				anoValidacao = validaAno(ano);
			}
			
			System.out.println("\nInsira o status do veículo: ");
			statusValor = Integer.parseInt(sc.nextLine());
			
			while(!statusValidos.contains(statusValor)) {
				System.out.println("\n Por favor, insira um status válido. Este pode ser"
						+ "\n1 - À VENDA \n ou \n 2 - VENDIDO: ");
				statusValor = Integer.parseInt(sc.nextLine());
			}
			
			if (statusValor == 1) status = "À VENDA"; else status = "VENDIDO";	
			
			int id_veiculo = vdao.capturaIdVeiculoFromPlaca(placa);
			
			vdao.atualizaVeiculoBD(id_veiculo, marca, modelo, placa, ano, status, id_usuario);
			
			System.out.println("Veículo atualizado com sucesso!");
			veiculoValido = true;
		}
		return 9;
	}
	
	public int dashboardRemoveVeiculoLoop(int stepAtual, String username) {
		boolean placaValidacao = false;
		boolean usuarioPossuiVeiculo = false;
		int id_usuario;
		String placa;
		
		VeiculoDAO vdao = new VeiculoDAO();
		UsuarioDAO udao = new UsuarioDAO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nInsira o código da placa do carro o qual deseja deletar: ");
		
		placa = sc.nextLine();
		placaValidacao = validaPlaca(placa);
		
		id_usuario = udao.getIdClienteFromUsername(username);
		
		usuarioPossuiVeiculo = vdao.verificaPosseVeiculo(placa, id_usuario);
		
		while (!usuarioPossuiVeiculo) {
			System.out.println("Você não é proprietário do veículo o qual deseja remover."
					+ " Por favor, insira novamente a placa do "
					+ "veículo o qual deseja remover:");
			placa = sc.nextLine();
			placaValidacao = validaPlaca(placa);
			
			while(!placaValidacao) {
				System.out.println("\n Falha na validação da placa. Por favor, insira uma placa\n"
						+ "válida: ");
				placa = sc.nextLine();
				placaValidacao = validaPlaca(placa);
			}
			usuarioPossuiVeiculo = vdao.verificaPosseVeiculo(placa, id_usuario);
		}
		
		
		vdao.deletarVeiculoBD(placa);
		System.out.println("Removeu registro do veículo com sucesso!");
		
		return 9;			
	}
	
	public boolean validaPlaca(String placa) {
		return placa.matches("([A-Z0-9]{3})-([0-9]{1}[A-Z]{1}[0-9]{2})");
	}
	
	public boolean validaAno(int ano) {
		 return Integer.toString(ano).matches("([0-9]{4})");
	}
	
}
