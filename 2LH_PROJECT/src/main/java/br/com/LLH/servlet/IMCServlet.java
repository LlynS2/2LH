package br.com.LLH.servlet;

import java.io.IOException;
import java.util.List;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.bean.IMC;
import br.com.LLH.exception.DBException;
import br.com.LLH.factory.IMCDAOFactory;
import br.com.LLH.interfaceDao.IMCDAO;
import br.com.LLH.service.CalcularImcService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/imcServlet")
public class IMCServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IMCDAO imcDAO;
	private CalcularImcService calcular;
	
	
	@Override
	public void init() throws ServletException {
		
		imcDAO = IMCDAOFactory.getIMCDAO();
	}

    public IMCServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar": 
			listar(request, response);
			break;
	}
}

	/*LISTAR*/
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<IMC> lista = imcDAO.listar();
		request.setAttribute("imcs", lista);
		request.getRequestDispatcher("IMCLista.jsp").forward(request, response);
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
			case "excluir": 
				excluir(request, response); 
				break;	
		}		
	}
	
	/*EXCLUIR*/
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idIMC = Integer.parseInt(request.getParameter("codigo")); 
		
		try { 
			imcDAO.remover(idIMC);;
			request.setAttribute("msg", "IMC removido!"); 
			} catch (DBException e) { 
				e.printStackTrace(); 
				request.setAttribute("erro", "Erro ao atualizar"); 
				} 
		listar(request,response); 
		}
	
	/*CADASTRO*/

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			calcular = new CalcularImcService();
			
			float altura      = Float.parseFloat(request.getParameter("altura").replaceAll(",", "."));
			float peso        = Float.parseFloat(request.getParameter("peso").replaceAll(",", "."));
			float resultado = calcular.calcularImc(peso, altura);
			String email = request.getParameter("email");
			
			Cadastro cadastro = new Cadastro();
			cadastro.setEmail(email);
			
			IMC imc = new IMC(0,altura,peso,resultado);
			imc.setCadastro(cadastro);
			imcDAO.cadastrar(imc);
			
			String msg = calcular.resultadoIMC(peso, altura);
			
			request.setAttribute("msgImc", "Resultado do IMC = " + resultado + " - " + msg);
			request.setAttribute("msg", "IMC Adicionado ao histórico!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("IMCADD2.jsp").forward(request, response);
	}
}