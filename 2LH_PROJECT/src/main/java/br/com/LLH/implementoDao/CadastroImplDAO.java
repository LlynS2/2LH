package br.com.LLH.implementoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.LLH.bean.Cadastro;
import br.com.LLH.connection.ConnectionManager;
import br.com.LLH.exception.DBException;
import br.com.LLH.interfaceDao.CadastroDAO;

public class CadastroImplDAO implements CadastroDAO {

	ResultSet rs = null;
	PreparedStatement stmt = null;
	private Connection conexao;

	@Override
	public void cadastrar(Cadastro cadastro) throws DBException {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO "
					   + "T_CADASTRO ("
					   + "ID_CAD, "
					   + "NM_USUARIO,"
					   + "SENHA, "
					   + "EMAIL, "
					   + "DT_NASC )"
					   + "VALUES ("
					   + "SQE_CADASTRO.NEXTVAL, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,cadastro.getNomeUsuario());
			stmt.setString(2,cadastro.getSenha());
			stmt.setString(3,cadastro.getEmail());
			stmt.setString(4,cadastro.getDtNasc());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}