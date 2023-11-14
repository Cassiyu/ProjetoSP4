package br.com.fiap.beans;

public class Bike {

	// Variables
	private int identifica;
	private String tipo;
	private String marca;
	private String modelo;
	private String dataAquisicao;
	private double valorAquisicao;
	private Acessorios acessorios;

	// Overloading

	// Empty Constructor Method
	public Bike() {
		super();
	}

	// Full Constructor Method
	public Bike(int identifica, String tipo, String marca, String modelo, String dataAquisicao, double valorAquisicao,
			Acessorios acessorios) {
		super();
		this.identifica = identifica;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.dataAquisicao = dataAquisicao;
		this.valorAquisicao = valorAquisicao;
		this.acessorios = acessorios;
	}


	// Getters and Setters
	public int getIdentifica() {
		return identifica;
	}

	public void setIdentifica(int identifica) {
		this.identifica = identifica;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}

	// Overriding
	public String Disponibilidade() {
		String informacao;
		if (valorAquisicao < 2000) {
			informacao = "Seguro indisponível para esse valor.";
		} else {
			informacao = "Seguro disponível para esse valor";
		}
		return informacao;
	}
}
