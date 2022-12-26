package br.com.LLH.interfaceDao;

import java.util.List;

import br.com.LLH.bean.IMC;
import br.com.LLH.exception.DBException;

public interface IMCDAO {
	
	void cadastrar(IMC imc) throws DBException; 
	
	void atualizar(IMC imc) throws DBException; 
	
	void remover(int idImc) throws DBException; 
	
	IMC buscar(int id); 
	
	List<IMC> listar();
}