package br.com.LLH.factory;

import br.com.LLH.implementoDao.AtividadesImplDAO;
import br.com.LLH.interfaceDao.AtividadesDAO;

public class AtividadesDAOFactory {
	
	public static AtividadesDAO getAtividadesDAO() {
		return new AtividadesImplDAO();
	}	
}