package br.com.LLH.interfaceDao;

import java.util.List;

import br.com.LLH.bean.Atividades;
import br.com.LLH.exception.DBException;

public interface AtividadesDAO {
	
	void cadastrar(Atividades atividades) throws DBException; 
	
	void atualizar(Atividades atividades) throws DBException; 
	
	void remover(int idAtiv) throws DBException; 
	
	Atividades buscar(int id); 
	
	List<Atividades> listar();
}