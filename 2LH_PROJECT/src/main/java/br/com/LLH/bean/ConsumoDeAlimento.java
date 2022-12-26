package br.com.LLH.bean;

public class ConsumoDeAlimento {
	
	private int    idConAli;
	private String nomeAlimento;
	private String calorias;
	
	private Cadastro cadastro;
	
	public ConsumoDeAlimento(int idConAli, String nomeAlimento, String calorias) {
		
		this.idConAli = idConAli;
		this.nomeAlimento = nomeAlimento;
		this.calorias = calorias;
	}
	
	public ConsumoDeAlimento() {}

	public int getIdConAli() {
		return idConAli;
	}
	public void setIdConAli(int idConAli) {
		this.idConAli = idConAli;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	public String getCalorias() {
		return calorias;
	}
	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}