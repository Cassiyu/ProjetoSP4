package br.com.fiap.beans;

public class Acessorios {

	// Variables
	private int identifica;
	private String tipo;
	private String dataAquisicao;
	private double valorAquisicao;

	// Overloading

	// Empty Constructor Method
	public Acessorios() {
		super();
	}

	// Full Constructor Method
	public Acessorios(int identifica, String tipo, String dataAquisicao, double valorAquisicao) {
		super();
		this.identifica = identifica;
		this.tipo = tipo;
		this.dataAquisicao = dataAquisicao;
		this.valorAquisicao = valorAquisicao;
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
	
}
