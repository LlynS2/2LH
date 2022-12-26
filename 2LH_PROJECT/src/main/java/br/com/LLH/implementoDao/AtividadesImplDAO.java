package br.com.LLH.implementoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.LLH.bean.Atividades;
import br.com.LLH.connection.ConnectionManager;
import br.com.LLH.exception.DBException;
import br.com.LLH.interfaceDao.AtividadesDAO;

public class AtividadesImplDAO implements AtividadesDAO {
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection conexao;

	@Override
	public void cadastrar(Atividades atividades) throws DBException {

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "INSERT INTO "
						   + "T_ATIVIDADES ("
						   + "ID_ATIV, "
						   + "TIPO_ATIV, "
						   + "DIAS_PRATICADOS, "
						   + "CALORIAS_PERDIDAS, "
						   + "PRESSAO_ARTERIAL,"
						   + "NIVEL_DA_ATIV,"
						   + "T_CADASTRO_ID_CAD ) "
						   + "VALUES ("
						   + "SQE_ATIVIDADES.NEXTVAL, ?, ?, ?, ?, ?,( SELECT ID_CAD FROM T_CADASTRO WHERE Email = ? ))";
				
				stmt = conexao.prepareStatement(sql);
				
				stmt.setString(1,atividades.getTipoDeTreino());
				stmt.setString(2,atividades.getDiasPraticados());
				stmt.setString(3,atividades.getCaloriasPerdidas());
				stmt.setString(4,atividades.getPressaoArterial());
				stmt.setString(5,atividades.getNivelDeTreino());
				stmt.setString(6,atividades.getCadastro().getEmail());
				

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
	public void atualizar(Atividades atividades) throws DBException {

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "UPDATE "
 						   + "T_ATIVIDADES SET "
						   + "TIPO_ATIV = ?, "
						   + "DIAS_PRATICADOS = ?, "
						   + "CALORIAS_PERDIDAS = ?, "
						   + "PRESSAO_ARTERIAL = ?, "
						   + "NIVEL_DA_ATIV = ? "
						   + "WHERE ID_ATIV = ?";
				
				stmt = conexao.prepareStatement(sql);
				
				stmt.setString(1, atividades.getTipoDeTreino());
				stmt.setString(2, atividades.getDiasPraticados());
				stmt.setString(3, atividades.getCaloriasPerdidas());
				stmt.setString(4, atividades.getPressaoArterial());
				stmt.setString(5, atividades.getNivelDeTreino());
				stmt.setInt(6,atividades.getIdAtiv());

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
	public void remover(int idAtiv) throws DBException {

				try {
					conexao = ConnectionManager.getInstance().getConnection();
					String sql = "DELETE FROM T_ATIVIDADES WHERE ID_ATIV = ?";
					stmt = conexao.prepareStatement(sql);
					stmt.setInt(1, idAtiv);
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
	public Atividades buscar(int id) {
		
			Atividades atividade = null;
			
			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement(  "SELECT * FROM t_atividades WHERE ID_ATIV = ?");
				stmt.setInt(1,id );
				rs = stmt.executeQuery();

				if (rs.next()){
					
					
					String tipoDeTreino = rs.getString("TIPO_ATIV");
					String diasPraticados = rs.getString("DIAS_PRATICADOS");
					String caloriasPerdidas = rs.getString("DIAS_PRATICADOS");
					String pressaoArterial = rs.getString("PRESSAO_ARTERIAL");
					String nivelDeTreino = rs.getString("NIVEL_DA_ATIV");
					int idAtiv         = rs.getInt("ID_ATIV");
					
					atividade = new Atividades(idAtiv,tipoDeTreino,diasPraticados,caloriasPerdidas,
							pressaoArterial,nivelDeTreino);
					
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
			return atividade;
		}

	@Override
	public List<Atividades> listar() {
		
			List<Atividades> lista = new ArrayList<Atividades>();

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement("SELECT * FROM T_ATIVIDADES");
				rs = stmt.executeQuery();

				while (rs.next()) {
					
					int idAtiv = rs.getInt("ID_ATIV");
					String tipoDeTreino = rs.getString("TIPO_ATIV");
					String diasPraticados = rs.getString("DIAS_PRATICADOS");
					String caloriasPerdidas = rs.getString("CALORIAS_PERDIDAS");
					String pressaoArterial = rs.getString("PRESSAO_ARTERIAL");
					String nivelDeTreino = rs.getString("NIVEL_DA_ATIV");
									
					Atividades atividade = new Atividades(idAtiv,tipoDeTreino,diasPraticados,caloriasPerdidas,
							pressaoArterial,nivelDeTreino);
					
					lista.add(atividade);
					
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