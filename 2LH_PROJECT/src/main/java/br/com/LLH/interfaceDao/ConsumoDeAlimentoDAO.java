package br.com.LLH.interfaceDao;

import java.util.List;

import br.com.LLH.bean.ConsumoDeAlimento;
import br.com.LLH.exception.DBException;

public interface ConsumoDeAlimentoDAO {
	
	void cadastrar(ConsumoDeAlimento consumoDeAlimento) throws DBException; 
	
	void atualizar(ConsumoDeAlimento consumoDeAlimento) throws DBException; 
	
	void remover(int idConAli) throws DBException; 
	
	ConsumoDeAlimento buscar(int id); 
	
	List<ConsumoDeAlimento> listar();

}
