package br.ucb.poo;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.bean.Veiculo;
import br.ucb.poo.dao.VeiculoDAO;
import br.ucb.poo.dashes.Dashboard;
import br.ucb.poo.dashes.DashboardLogin;
public class Executora {
	static VeiculoDAO dao = new VeiculoDAO();
	
	public static void main(String[] args) {
		System.out.println("--- SISTEMA ALPHAMOTRS ---");
		int stepAtual = 0;
		Dashboard dashAtual = new Dashboard();
		dashAtual.imprimeTelaAtual();
		
		
		dashAtual.dashboardLoginLoop(1);
		
		
		insereVeiculo();
		//imprimirVeiculos();
		//removeVeiculo(4);
		//atualizaVeiculo(3);
		//atualizaVeiculo(4);
		imprimirVeiculos();  
	}

	//FUNCTIONS
	/*
	public static void insereVeiculo() {
		Scanner ler = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		
		System.out.println("Informe a Marca: ");
		veiculo.setMarca(ler.nextLine().toUpperCase());
		System.out.println("Informe o Modelo: ");
		veiculo.setModelo(ler.nextLine().toUpperCase());
		System.out.println("Informe a Placa: ");
		veiculo.setPlaca(ler.nextLine().toUpperCase());
		System.out.println("Informe o Ano: ");
		veiculo.setAno(ler.nextInt());
		veiculo.setStatus(true);
		ler.close();
		
		dao.salvaVeiculoBD(veiculo);
		
	}
	*/
	
	
	public static void removeVeiculo(int id_veiculo) {
		if(dao.verificaIdVeiculo(id_veiculo)) {
			dao.deletarVeiculoBD(id_veiculo);
		}else {
			System.out.println("Veículo não existe!");
		}
	}
	
	public static void atualizaVeiculo(int id_veiculo, String role) {
		int status;
		
		if(dao.verificaIdVeiculo(id_veiculo)) {
			if(role == "Administrador") {
				Scanner ler = new Scanner(System.in);
				Veiculo novoVeiculo = new Veiculo();
				
				System.out.println("Informe a Marca: ");
				novoVeiculo.setMarca(ler.nextLine().toUpperCase());
				System.out.println("Informe o Modelo: ");
				novoVeiculo.setModelo(ler.nextLine().toUpperCase());
				System.out.println("Informe a Placa: ");
				novoVeiculo.setPlaca(ler.nextLine().toUpperCase());
				System.out.println("Informe o Ano: ");
				novoVeiculo.setAno(ler.nextInt());
				System.out.println("Informe o Status \n(1)A VENDA (2)VENDIDO: ");
				status = ler.nextInt();
				while(status != 1 || status != 2) {
					System.out.println("Valor Inválido");
					System.out.println("Informe o Status \n(1)A VENDA (2)VENDIDO: ");
					status = ler.nextInt();
				}
				if(status == 1) {
					novoVeiculo.setStatus("A VENDA");
				}else {
					novoVeiculo.setStatus("VENDIDO");
				}
				
				ler.close();
				//atualizar esta funcao para atualizar no banco
				dao.atualizaVeiculoBD(id_veiculo, novoVeiculo.getMarca(), novoVeiculo.getModelo(), novoVeiculo.getPlaca(), novoVeiculo.getAno(), novoVeiculo.getStatus());
			}else {
				Scanner ler = new Scanner(System.in);
				Veiculo novoVeiculo = new Veiculo();
				
				System.out.println("Informe a Marca: ");
				novoVeiculo.setMarca(ler.nextLine().toUpperCase());
				System.out.println("Informe o Modelo: ");
				novoVeiculo.setModelo(ler.nextLine().toUpperCase());
				System.out.println("Informe a Placa: ");
				novoVeiculo.setPlaca(ler.nextLine().toUpperCase());
				System.out.println("Informe o Ano: ");
				novoVeiculo.setAno(ler.nextInt());
				
				dao.atualizaVeiculoBD(id_veiculo, novoVeiculo.getMarca(), novoVeiculo.getModelo(), novoVeiculo.getPlaca(), novoVeiculo.getAno(), novoVeiculo.getStatus());
				ler.close();
			}
		}else {
			System.out.println("Veículo não existe!");
		}
		
		
	}
	
	public static void imprimirVeiculos() {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		veiculos = dao.listaVeiculosBD();
		
		for(Veiculo v : veiculos) {
			System.out.println("ID: " + v.getId());
			System.out.println("Marca: " + v.getMarca());
			System.out.println("Modelo: " + v.getModelo());
			System.out.println("Ano: " + v.getAno());
			System.out.println("Placa: " + v.getPlaca());
			System.out.println("Status: " + v.getStatus());
		}
	}
	
	
	//FUNCTIONS TESTES
	
	public static void insereVeiculo() {
		//Scanner ler = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		
		veiculo.setMarca("BMW");
		veiculo.setModelo("320I");
		veiculo.setPlaca("BMW-0320");
		veiculo.setAno(2023);
		veiculo.setStatus("A VENDA");
		//ler.close();
		
		dao.salvaVeiculoBD(veiculo);
		
	}
}
