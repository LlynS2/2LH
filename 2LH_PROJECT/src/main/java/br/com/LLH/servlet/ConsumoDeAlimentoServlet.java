package br.com.LLH.servlet;

import java.io.IOException;
import java.util.List;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.bean.ConsumoDeAlimento;
import br.com.LLH.exception.DBException;
import br.com.LLH.factory.ConsumoDeAlimentoDAOFactory;
import br.com.LLH.interfaceDao.ConsumoDeAlimentoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/consumoDeAlimentoServlet")
public class ConsumoDeAlimentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ConsumoDeAlimentoDAO conAliDAO;
	
	@Override
	public void init() throws ServletException {
		
		conAliDAO = ConsumoDeAlimentoDAOFactory.getConsumoDeAlimentoDAO();
	}

   
    public ConsumoDeAlimentoServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar": 
			listar(request, response);
			break;
		case "abrir-form-edicao" :
			abrirFormEdicao(request, response);
			break;
		}
			
	}

	/*ABRIR FORMULÁRIO DE EDIÇÃO*/
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("codigo")); 
		ConsumoDeAlimento conAlimento = conAliDAO.buscar(id); 
		request.setAttribute("conAlimentoEdit", conAlimento); 
		request.getRequestDispatcher("ConDeAlimentoEdit.jsp").forward(request, response);
	}	

	/*LISTAR*/
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ConsumoDeAlimento> lista = conAliDAO.listar();
		request.setAttribute("conAlimentos", lista);
		request.getRequestDispatcher("ConDeAlimentoLista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String acao = request.getParameter("acao");
		
		switch (acao) {
			case "cadastrar":
				cadastrar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;	
			case "excluir": 
				excluir(request, response); 
				break;	
		}		
	}
	
	/*EXCLUIR*/
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idConAli = Integer.parseInt(request.getParameter("codigo")); 
		
		try { 
			conAliDAO.remover(idConAli);
			request.setAttribute("msg", "Consumo removido!"); 
			} catch (DBException e) { 
				e.printStackTrace(); 
				request.setAttribute("erro", "Erro ao atualizar"); 
				} 
		listar(request,response); 
		}
	
	/*EDITAR*/
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int idConAli = Integer.parseInt(request.getParameter("codigo"));
			
			String nomeAlimento  = request.getParameter("nomeAli");
			String calorias      = request.getParameter("calorias");
			
			
			ConsumoDeAlimento conAlimento = new ConsumoDeAlimento (idConAli,nomeAlimento,calorias);
			conAliDAO.atualizar(conAlimento);

			request.setAttribute("msg", "Consumo de Alimento atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}
	
	/*CADASTRO*/

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String nomeAlimento  = request.getParameter("nomeAli");
			String calorias      = request.getParameter("calorias");
			
			String email = request.getParameter("email");
			
			Cadastro cadastro = new Cadastro();
			cadastro.setEmail(email);
			
			ConsumoDeAlimento conAlimento = new ConsumoDeAlimento (0,nomeAlimento,calorias);
			conAlimento.setCadastro(cadastro);
			conAliDAO.cadastrar(conAlimento);
			
			request.setAttribute("msg", "Alimento Adicionado ao histórico!!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ConDeAlimentoADD.jsp").forward(request, response);
	}
		
}


