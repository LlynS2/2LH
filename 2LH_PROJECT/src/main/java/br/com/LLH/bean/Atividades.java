package br.com.LLH.bean;

public class Atividades {
	
	private int    idAtiv;
	private String tipoDeTreino;
	private String diasPraticados;
	private String caloriasPerdidas;
	private String pressaoArterial;
	private String nivelDeTreino;
	
	private Cadastro cadastro;
	
	public Atividades(int idAtiv, String tipoDeTreino, String diasPraticados, String caloriasPerdidas,
			String pressaoArterial, String nivelDeTreino) {
		
		this.idAtiv = idAtiv;
		this.tipoDeTreino = tipoDeTreino;
		this.diasPraticados = diasPraticados;
		this.caloriasPerdidas = caloriasPerdidas;
		this.pressaoArterial = pressaoArterial;
		this.nivelDeTreino = nivelDeTreino;
	}

	public Atividades() {}

	public int getIdAtiv() {
		return idAtiv;
	}

	public void setIdAtiv(int idAtiv) {
		this.idAtiv = idAtiv;
	}

	public String getTipoDeTreino() {
		return tipoDeTreino;
	}

	public void setTipoDeTreino(String tipoDeTreino) {
		this.tipoDeTreino = tipoDeTreino;
	}

	public String getDiasPraticados() {
		return diasPraticados;
	}

	public void setDiasPraticados(String diasPraticados) {
		this.diasPraticados = diasPraticados;
	}

	public String getCaloriasPerdidas() {
		return caloriasPerdidas;
	}

	public void setCaloriasPerdidas(String caloriasPerdidas) {
		this.caloriasPerdidas = caloriasPerdidas;
	}

	public String getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public String getNivelDeTreino() {
		return nivelDeTreino;
	}

	public void setNivelDeTreino(String nivelDeTreino) {
		this.nivelDeTreino = nivelDeTreino;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}