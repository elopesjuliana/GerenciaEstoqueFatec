package estoque.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.model.Funcionario;
import estoque.model.Produto;
import estoque.model.Requisicao;

public class RequisicaoDAOImpl implements IRequisicaoDAO {

	private Connection con = null;
	
	public RequisicaoDAOImpl() {
		con = new DBUtil().getConnection();	
	}
	
	@Override
	public void geraRequisicao(Requisicao req) throws SQLException {
		String sql = "CALL inserirRequisicao(?,?,?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, req.getFunc().getCodigo());
		ps.setInt(2,req.getProd().getCodigo());
		ps.setInt(3,req.getQtd_requisicao());
		ps.execute();
		ps.close();
	}


	@Override
	public List<Requisicao> listaRequisicao() throws SQLException {
		String sql = "CALL consultaRequisicao();";
		List<Requisicao> listaRequisicao = new ArrayList<Requisicao>();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Requisicao req = new Requisicao();
			Funcionario func = new Funcionario();
			Produto prod = new Produto();
			req.setCodigo_requisicao((rs.getInt("codigo_requisicao")));
			func.setNome((rs.getString("nome_funcionario")));
			prod.setNome((rs.getString("nome_produto")));
			req.setFunc(func);
			req.setProd(prod);
			req.setQtd_requisicao((rs.getInt("qtd_requisicao")));
			req.setData_requisicao((rs.getDate("data_requisicao")));
			req.setStatus((rs.getString("status_requisicao")));
			listaRequisicao.add(req);
		}
		rs.close();
		ps.close();		
		return listaRequisicao;
	}

	@Override
	public void baixaRequisicao(int codigo) throws SQLException {
		String sql = "UPDATE requisicao SET status_requisicao='B' WHERE codigo_requisicao=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, codigo);
		ps.execute();
		ps.close();
	}

	@Override
	public void estornaRequisicao(int codigo) throws SQLException {
		String sql = "UPDATE requisicao SET status_requisicao='P' WHERE codigo_requisicao=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, codigo);
		ps.execute();
		ps.close();
	}

	@Override
	public List<Requisicao> listaSaidaCaixa() throws SQLException {
		String sql = "CALL consultaSaidaCaixa();";
		List<Requisicao> listaRequisicao = new ArrayList<Requisicao>();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Requisicao req = new Requisicao();
			Funcionario func = new Funcionario();
			Produto prod = new Produto();
			prod.setCodigo((rs.getInt("codigo_produto")));
			prod.setNome((rs.getString("nome_produto")));
			prod.setPreco((rs.getDouble("valor_caixa")));
			req.setFunc(func);
			req.setProd(prod);
			req.setQtd_requisicao((rs.getInt("qtd_requisicao")));
			listaRequisicao.add(req);
		}
		rs.close();
		ps.close();		
		System.out.println(listaRequisicao);
		return listaRequisicao;
	}

	@Override
	public void cancelaRequisicao(int codigo) throws SQLException {
		String sql = "CALL excluirRequisicao(?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, codigo);
		ps.execute();
		ps.close();
	}

}
