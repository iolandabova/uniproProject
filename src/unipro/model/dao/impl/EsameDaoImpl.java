package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unipro.connection.DbConnection;
import unipro.model.Esame;
import unipro.model.dao.EsameDAO;

public class EsameDaoImpl implements EsameDAO{

	private DbConnection dbConn;
	
	public EsameDaoImpl() {
		
		dbConn=DbConnection.getConnection();
	}
	
	@Override
	public void save(Esame es) {
		
		String query= "insert into esame(idesame,nomeesame,cfu) values (?,?,?)";
		
		try {
			
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, es.getIdEsame());
			ps.setString(2, es.getNomeEsame());
			ps.setInt(3, es.getCfu());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByIdEsame(String idEsame) {
		
		String query = "delete from esame where idesame = ?";
		try {
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, idEsame);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Esame getByIdEsame(String idEsame) {
		
		Esame es = null;
		String query="select * from esame where idesame=?";
		try {
			
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, idEsame);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				es=new Esame();
				es.setIdEsame(idEsame);
				es.setNomeEsame(rs.getString("nomeesame"));
				es.setCfu(rs.getInt("cfu"));
		}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return es;
					
	}

	@Override
	public void update(Esame es) {
		
		String query="update esame set nomeesame=?, cfu=? where idesame=?";
		
		try {
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, es.getIdEsame());
			ps.setString(2, es.getNomeEsame());
			ps.setInt(3, es.getCfu());
		
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Esame> getAll() {
	
		ArrayList<Esame> listaEsami=new ArrayList<Esame>();
		Esame es = null;
		String query="select * from esame";
		try {
			PreparedStatement ps=dbConn.getConn().prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				es=new Esame();
				es.setIdEsame(rs.getString("idesame"));
				es.setNomeEsame(rs.getString("nomeesame"));
				es.setCfu(rs.getInt("cfu"));
			
				listaEsami.add(es);
		}
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEsami;
	}
		
	

}
