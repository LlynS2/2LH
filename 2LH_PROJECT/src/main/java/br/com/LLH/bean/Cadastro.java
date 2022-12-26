package br.com.LLH.bean;

import br.com.LLH.util.CriptografiaUtils;

public class Cadastro {
	
	private int    idCad;
	private String nomeUsuario;
	private String senha;
	private String email;
	private String dtNasc;
	
	private Atividades atividades;
	private ConsumoDeAlimento consumoDeAlimento;
	private IMC imc;
	
	
	public Cadastro(int idCad, String nomeUsuario, String senha, String email, String dtNasc) {

		this.idCad = idCad;
		this.nomeUsuario = nomeUsuario;
		setSenha(senha);
		this.email = email;
		this.dtNasc = dtNasc;
	}
	
	public Cadastro(String senha, String email) {

		this.senha = senha;
		this.email = email;
	}

	public Cadastro() { }

	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Atividades getAtividades() {
		return atividades;
	}

	public void setAtividades(Atividades atividades) {
		this.atividades = atividades;
	}

	public ConsumoDeAlimento getConsumoDeAlimento() {
		return consumoDeAlimento;
	}

	public void setConsumoDeAlimento(ConsumoDeAlimento consumoDeAlimento) {
		this.consumoDeAlimento = consumoDeAlimento;
	}

	public IMC getImc() {
		return imc;
	}

	public void setImc(IMC imc) {
		this.imc = imc;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try { 
			this.senha = CriptografiaUtils.criptografar(senha); 
		} catch (Exception e) { 
			e.printStackTrace(); 
			}
	}
}