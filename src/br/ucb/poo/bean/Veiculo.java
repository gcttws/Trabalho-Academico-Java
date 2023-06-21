package br.ucb.poo.bean;

public class Veiculo {

	private int id;
	private String marca;
	private String modelo;
	private String placa;
	private int ano;
	private String status;
	private int dono;
	
	/*
	Veiculo(String marca, String modelo, String placa, int ano, String status){
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.status = status;
		
	}
	*/
	//getters and setters
	public int getDono() {
		return dono;
	}
	
	public void setDono(int dono) {
		this.dono = dono;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
	    this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	
	//metodos
	
	
	
}

