package br.com.LLH.factory;

import br.com.LLH.implementoDao.IMCImplDAO;
import br.com.LLH.interfaceDao.IMCDAO;

public class IMCDAOFactory {
	
	public static IMCDAO getIMCDAO() {
		return new IMCImplDAO();
	}	
}