package br.com.LLH.implementoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.LLH.bean.ConsumoDeAlimento;
import br.com.LLH.connection.ConnectionManager;
import br.com.LLH.exception.DBException;
import br.com.LLH.interfaceDao.ConsumoDeAlimentoDAO;

public class ConsumoDeAlimentoImplDAO implements ConsumoDeAlimentoDAO{
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection conexao;

	@Override
	public void cadastrar(ConsumoDeAlimento consumoDeAlimento) throws DBException {	
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO "
					   + "T_CONSUMO_DE_ALIMENTOS ("
					   + "ID_CON_ALI, "
					   + "NM_ALIMENTO, "
					   + "CALORIAS_ALIMENTO, "
					   + "T_CADASTRO_ID_CAD ) "
					   + "VALUES ("
					   + "SQE_ATIVIDADES.NEXTVAL, ?, ?,( SELECT ID_CAD FROM T_CADASTRO WHERE Email = ? ))";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,consumoDeAlimento.getNomeAlimento());
			stmt.setString(2,consumoDeAlimento.getCalorias());
			stmt.setString(3,consumoDeAlimento.getCadastro().getEmail());

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
	public void atualizar(ConsumoDeAlimento consumoDeAlimento) throws DBException {
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE "
					   + "T_CONSUMO_DE_ALIMENTOS SET "
					   + "NM_ALIMENTO = ?,"
					   + "CALORIAS_ALIMENTO = ?"
					   + "WHERE ID_CON_ALI = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, consumoDeAlimento.getNomeAlimento());
			stmt.setString(2, consumoDeAlimento.getCalorias());
			stmt.setInt(3, consumoDeAlimento.getIdConAli());

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
	public void remover(int idConAli) throws DBException {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_CONSUMO_DE_ALIMENTOS WHERE ID_CON_ALI = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idConAli);
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
	public ConsumoDeAlimento buscar(int id) {
		
		ConsumoDeAlimento consumoDeAlimento = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(  "SELECT * FROM T_CONSUMO_DE_ALIMENTOS WHERE ID_CON_ALI = ?");
			stmt.setInt(1,id );
			rs = stmt.executeQuery();

			if (rs.next()){
	
				String nomeAlimento = rs.getString("NM_ALIMENTO");
				String calorias = rs.getString("CALORIAS_ALIMENTO");
				int idConAli         = rs.getInt("ID_CON_ALI");
				
				consumoDeAlimento = new ConsumoDeAlimento(idConAli,nomeAlimento,calorias);
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
		return consumoDeAlimento;
	}

	@Override
	public List<ConsumoDeAlimento> listar() {
		
		List<ConsumoDeAlimento> lista = new ArrayList<ConsumoDeAlimento>();

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONSUMO_DE_ALIMENTOS");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				int idConAli         = rs.getInt("ID_CON_ALI");
				String nomeAlimento = rs.getString("NM_ALIMENTO");
				String calorias = rs.getString("CALORIAS_ALIMENTO");
								
				ConsumoDeAlimento consumoDeAlimento = new ConsumoDeAlimento(idConAli,nomeAlimento,calorias);
				lista.add(consumoDeAlimento);
				
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