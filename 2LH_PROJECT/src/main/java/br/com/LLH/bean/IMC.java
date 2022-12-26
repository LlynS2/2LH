package br.com.LLH.bean;

public class IMC {
	
	private int    idImc;
	private float altura;
	private float peso;
	private float resultado;
	
	private Cadastro cadastro;
	
	public IMC(int idImc, float altura, float peso, float resultado) {
		
		this.idImc = idImc;
		this.altura = altura;
		this.peso = peso;
		this.resultado = resultado;
	}
		
	public IMC(float altura, float peso) {
		super();
		this.altura = altura;
		this.peso = peso;
	}

	public IMC() {}

	public int getIdImc() {
		return idImc;
	}
	public void setIdImc(int idImc) {
		this.idImc = idImc;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getResultado() {
		return resultado;
	}
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}