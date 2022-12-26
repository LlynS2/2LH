package br.com.LLH.factory;

import br.com.LLH.implementoDao.ConsumoDeAlimentoImplDAO;
import br.com.LLH.interfaceDao.ConsumoDeAlimentoDAO;

public class ConsumoDeAlimentoDAOFactory {
	
	public static ConsumoDeAlimentoDAO getConsumoDeAlimentoDAO() {
		return new ConsumoDeAlimentoImplDAO();
	}	
}