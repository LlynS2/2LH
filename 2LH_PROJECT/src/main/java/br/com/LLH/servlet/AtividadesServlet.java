package br.com.LLH.servlet;

import java.io.IOException;
import java.util.List;

import br.com.LLH.bean.Atividades;
import br.com.LLH.bean.Cadastro;
import br.com.LLH.exception.DBException;
import br.com.LLH.factory.AtividadesDAOFactory;
import br.com.LLH.interfaceDao.AtividadesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/atividadesServlet")
public class AtividadesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AtividadesDAO ativDAO;
	
	@Override
	public void init() throws ServletException {
		
		ativDAO = AtividadesDAOFactory.getAtividadesDAO();
	}

    public AtividadesServlet() {}

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
		Atividades atividade = ativDAO.buscar(id); 
		request.setAttribute("atividadeEdit", atividade); 
		request.getRequestDispatcher("AtividadesEdit.jsp").forward(request, response);
	}	

	/*LISTAR*/
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividades> lista = ativDAO.listar();
		request.setAttribute("atividades", lista);
		request.getRequestDispatcher("AtividadesLista.jsp").forward(request, response);
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------*/

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
		
		int idAtiv = Integer.parseInt(request.getParameter("codigo")); 
		
		try { 
			ativDAO.remover(idAtiv);
			request.setAttribute("msg", "Atividade removida!"); 
			} catch (DBException e) { 
				e.printStackTrace(); 
				request.setAttribute("erro", "Erro ao atualizar"); 
				} 
		listar(request,response); 
		}
	
	/*EDITAR*/
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int idAtiv = Integer.parseInt(request.getParameter("codigo"));
			
			String tipoDeTreino     = request.getParameter("nomeAtiv");
			String diasPraticados   = request.getParameter("diaP");
			String caloriasPerdidas = request.getParameter("caloriasPer");
			String pressaoArterial  = request.getParameter("preArt");
			String nivelDeTreino    = request.getParameter("nivelAtiv");
			
			Atividades atividades = new Atividades(idAtiv,tipoDeTreino,diasPraticados,caloriasPerdidas,pressaoArterial,nivelDeTreino);
			ativDAO.atualizar(atividades);

			request.setAttribute("msg", "Atividade atualizada!");
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
			
			String tipoDeTreino     = request.getParameter("nomeAtiv");
			String diasPraticados   = request.getParameter("diaP");
			String caloriasPerdidas = request.getParameter("caloriasPer");
			String pressaoArterial  = request.getParameter("preArt");
			String nivelDeTreino    = request.getParameter("nivelAtiv");
			
			String email = request.getParameter("email");
			
			Cadastro cadastro = new Cadastro();
			cadastro.setEmail(email);
			
			Atividades atividades = new Atividades(0,tipoDeTreino,diasPraticados,caloriasPerdidas,pressaoArterial,nivelDeTreino);
			atividades.setCadastro(cadastro);
			ativDAO.cadastrar(atividades);
			
			
			
			request.setAttribute("msg", "Atividade Adicionada ao histórico!!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("AtividadesADD.jsp").forward(request, response);
	}

}