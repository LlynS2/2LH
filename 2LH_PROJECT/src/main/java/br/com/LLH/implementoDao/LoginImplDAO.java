package br.com.LLH.implementoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.connection.ConnectionManager;

public class LoginImplDAO {
	
	 private Cadastro cadastro;
	 private Connection conexao;
	    
	    public LoginImplDAO(Cadastro usr)
	    {
	    	cadastro = usr;
	    }
	    
	        public boolean verificaUsuario(){
	        	
	        if(cadastro.getEmail()!=null && cadastro.getSenha()!=null)
	        {
	            try
	            {
	             conexao = ConnectionManager.getInstance().getConnection();
	             
	             String sql="SELECT * FROM T_CADASTRO WHERE EMAIL = ? AND SENHA = ?";       
	             
	             PreparedStatement stmt = conexao.prepareStatement(sql);
	             
	             stmt.setString(1, cadastro.getEmail());
	             stmt.setString(2, cadastro.getSenha());
	            
	             
	             ResultSet rs = stmt.executeQuery();
	             
	             if(rs.next()) //Existe o usuário no banco de dados
	             {
	                   rs.close();
	                   stmt.close();
	                   return true;
	                 
	             } // Não existe o usuário
	             rs.close();
	             stmt.close();
	             return false;
	            }
	            catch (SQLException e) 
	        {return false;}

	        }
	        return false;

	    } 
}