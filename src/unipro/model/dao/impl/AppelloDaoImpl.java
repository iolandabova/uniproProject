package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import unipro.connection.DbConnection;
import unipro.model.Appello;
import unipro.model.Docente;
import unipro.model.dao.AppelloDAO;
import unipro.model.dto.AppelloDTO;

public class AppelloDaoImpl implements AppelloDAO {
	
	private DbConnection dbConn;
	
	public AppelloDaoImpl() {
		
		dbConn=DbConnection.getDbConnection();
	}

	@Override
	public void save(Appello ap) {
		
		String query ="insert into appello (idappello, data, aula, idesame, iddocente)" + "values(?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, ap.getIdAppello());
			Date d = ap.getData();
			java.sql.Date sd = new java.sql.Date(d.getTime());
			ps.setDate(2, sd);
			ps.setString(3, ap.getAula());
			ps.setString(4, ap.getIdEsame());
			ps.setString(5, ap.getIdDocente());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteByIdAppello(String idAppello) {
		
		String query = "delete from appello where idappello =?";
		
		try {
			
			PreparedStatement ps = dbConn.getConnection().prepareStatement(query);
			ps.setString(1, idAppello);
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Appello getByIdAppello(String idAppello) {
		
		Appello a = null;
		String query="select * from appello where idAppello=?";
		try {
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
			ps.setString(1, idAppello);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a=new Appello();
				a.setIdAppello(idAppello);
				a.setData(rs.getDate("data"));
				a.setAula(rs.getString("aula"));
				a.setIdEsame(rs.getString("idesame"));
				a.setIdDocente(rs.getString("iddocente"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void update(Appello ap) {
		
		String query = "update appello set data = ?, aula = ?, idesame = ?, iddocente = ? where idappello = ?";
		
		try {
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
			Date d = ap.getData();
			java.sql.Date sd = new java.sql.Date(d.getTime());
			ps.setDate(1, sd);
			ps.setString(2, ap.getAula());
			ps.setString(3, ap.getIdEsame());
			ps.setString(4, ap.getIdDocente());
			ps.setString(5, ap.getIdAppello());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<AppelloDTO> getAllByIdEsame(String idEsame) {
		
		AppelloDTO a = null;
		ArrayList<AppelloDTO> listaAppelli = new ArrayList <AppelloDTO>();
		String query ="select * from esame es join appello ap on es.idesame=ap.idesame join docente do on do.iddocente=ap.iddocente where es.idEsame=?";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, idEsame);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				a = new AppelloDTO();
				a.setIdAppello(rs.getString("idappello"));
				a.setNomeEsame(rs.getString("nomeEsame"));
				a.setData(rs.getDate("data"));
				a.setAula(rs.getString("aula"));
				a.setNomeDocente(rs.getString("nome"));
				a.setCognomeDocente(rs.getString("cognome"));
					
				listaAppelli.add(a);
			}
			ps.close();
			
		}catch (Exception e) {
	    	 e.printStackTrace();
		}
		return listaAppelli;
	}		
		
	@Override
	public List<Appello> getAll() {
		
		Appello a = null;
		ArrayList<Appello> listaAppelli = new ArrayList <Appello>();
		String query ="select * from appello";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				a = new Appello();
				a.setIdAppello(rs.getString("idappello"));
				a.setData(rs.getDate("data"));
				a.setAula(rs.getString("aula"));
				a.setIdEsame(rs.getString("idesame"));
				a.setIdDocente(rs.getString("iddocente"));
				
				listaAppelli.add(a);
			}
			ps.close();
			
		}catch (Exception e) {
	    	 e.printStackTrace();
		}
		return listaAppelli;
	}
	
}
