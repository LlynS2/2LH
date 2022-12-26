package br.com.LLH.servlet;

import java.io.IOException;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.exception.DBException;
import br.com.LLH.factory.CadastroDAOFactory;
import br.com.LLH.interfaceDao.CadastroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CadastroDAO cadDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		cadDAO = CadastroDAOFactory.getCadastroDAO();
	}

    public CadastroServlet() {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	/*CADASTRO*/
		
		try{
				
			String nomeUsuario = request.getParameter("nome");
			String senha = request.getParameter("senha");
			String email = request.getParameter("email");
			String dtNasc = request.getParameter("dtnasc");
			
			Cadastro cadCadastro = new Cadastro(0,nomeUsuario,senha,email,dtNasc);
			cadDAO.cadastrar(cadCadastro);
			
			request.setAttribute("msg", "Cadastro Concluído! Se direcione ao ");
			
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
	}
}