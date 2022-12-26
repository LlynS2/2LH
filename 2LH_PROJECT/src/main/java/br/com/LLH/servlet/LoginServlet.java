package br.com.LLH.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.implementoDao.LoginImplDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
 
        } finally {            
            out.close();
        }
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*VERIFICAR USUÁRIO*/	
		
		String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        RequestDispatcher rd = null;
        Cadastro user = new Cadastro();
       
        user.setEmail(email);
        user.setSenha(senha);
        
        LoginImplDAO uc = new LoginImplDAO(user);
        
        if(uc.verificaUsuario())
        {
            HttpSession session = request.getSession();
            session.setAttribute("USER",email);
            request.setAttribute("msg", email);
            rd = request.getRequestDispatcher("IndexAcess.jsp");
            rd.forward(request,response);
        }
        
        else
        {
            request.setAttribute("erro", "Usuário ou senha inválidos");
            rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request,response);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	@Override
	public String getServletInfo() {
	    return "Short description";
	}

}
