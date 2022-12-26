package br.com.LLH.implementoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.LLH.bean.IMC;
import br.com.LLH.connection.ConnectionManager;
import br.com.LLH.exception.DBException;
import br.com.LLH.interfaceDao.IMCDAO;

public class IMCImplDAO implements IMCDAO {
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection conexao;

	@Override
	public void cadastrar(IMC imc) throws DBException {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO "
					   + "T_IMC ("
					   + "ID_IMC, "
					   + "ALTURA, "
					   + "PESO, "
					   + "RESULTADO, "
					   + "T_CADASTRO_ID_CAD ) "
					   + "VALUES ("
					   + "SQE_IMC.NEXTVAL, ?, ?, ?,(  SELECT ID_CAD FROM T_CADASTRO WHERE Email = ? ))";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setFloat(1,imc.getAltura());
			stmt.setFloat(2,imc.getPeso());
			stmt.setFloat(3,imc.getResultado());
			stmt.setString(4,imc.getCadastro().getEmail());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao adicionar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

	@Override
	public void atualizar(IMC imc) throws DBException {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE "
					   + "T_IMC  SET "
					   + "ALTURA = ?, "
					   + "PESO = ?, "
					   + "RESULTADO = ?"
					   + "WHERE ID_IMC = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setFloat(1,imc.getAltura());
			stmt.setFloat(2,imc.getPeso());
			stmt.setFloat(3,imc.getResultado());
			stmt.setInt(4,imc.getIdImc());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

	@Override
	public void remover(int idImc) throws DBException {
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_IMC WHERE ID_IMC = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idImc);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public IMC buscar(int id) {
		
		IMC imc = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(  "SELECT * FROM T_IMC WHERE ID_IMC = ?");
			stmt.setInt(1,id );
			rs = stmt.executeQuery();

			if (rs.next()){
				
				float altura = rs.getFloat("ALTURA");
				float peso = rs.getFloat("PESO");
				float resultado = rs.getFloat("RESULTADO");
				int idImc         = rs.getInt("ID_IMC");
				
				imc = new IMC(idImc,altura,peso,resultado);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imc;
	}

	@Override
	public List<IMC> listar() {
		
		List<IMC> lista = new ArrayList<IMC>();

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_IMC ");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				int idImc         = rs.getInt("ID_IMC");
				float altura = rs.getFloat("ALTURA");
				float peso = rs.getFloat("PESO");
				float resultado = rs.getFloat("RESULTADO");
								
				IMC imc = new IMC(idImc,altura,peso,resultado);
				lista.add(imc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}