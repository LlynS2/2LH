package br.com.LLH.interfaceDao;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.exception.DBException;

public interface CadastroDAO {
	
	void cadastrar(Cadastro cadastro) throws DBException; 
}