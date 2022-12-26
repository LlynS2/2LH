package br.com.LLH.factory;

import br.com.LLH.implementoDao.CadastroImplDAO;
import br.com.LLH.interfaceDao.CadastroDAO;

public class CadastroDAOFactory {

		public static CadastroDAO getCadastroDAO() {
			return new CadastroImplDAO();
		}	
}