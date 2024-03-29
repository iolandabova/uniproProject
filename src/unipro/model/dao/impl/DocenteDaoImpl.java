package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import unipro.connection.DbConnection;
import unipro.model.Docente;
import unipro.model.dao.DocenteDAO;

public class DocenteDaoImpl implements DocenteDAO {
	
	private DbConnection dbConn;
	
	public DocenteDaoImpl() {
		
		dbConn=DbConnection.getDbConnection();
	}

	@Override
	public void save(Docente d) {
		
		String query ="insert into docente (iddocente, nome, cognome, sesso)" + "values(?,?,?,?)";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, d.getIdDocente());
			ps.setString(2, d.getNome());
			ps.setString(3, d.getCognome());
			ps.setString(4, d.getSesso());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		

	@Override
	public void deleteByIdDocente(String idDocente) {
		
		String query = "delete from docente where iddocente =?";
		
		try {
			
			PreparedStatement ps = dbConn.getConnection().prepareStatement(query);
			ps.setString(1, idDocente);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Docente getByIdDocente(String idDocente) {
		
		Docente d = null;
		String query="select * from docente where iddocente=?";
		try {
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
			ps.setString(1, idDocente);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				d=new Docente();
				d.setIdDocente(idDocente);
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setSesso(rs.getString("sesso"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
		

	@Override
	public void update(Docente d) {
		
		String query = "update docente set nome = ?, cognome = ?, sesso = ? where iddocente = ?";
		
		try {
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
			ps.setString(1, d.getNome());
			ps.setString(2, d.getCognome());
			ps.setString(3, d.getSesso());
			ps.setString(4, d.getIdDocente());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}

	@Override
	public List<Docente> getAll() {
		
		Docente d = null;
		ArrayList<Docente> listaDocenti = new ArrayList <Docente>();
		String query ="select * from docente";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				d = new Docente();
				d.setIdDocente(rs.getString("iddocente"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setSesso(rs.getString("sesso"));
				
				listaDocenti.add(d);
			}
			ps.close();
			
		}catch (Exception e) {
	    	 e.printStackTrace();
		}
		return listaDocenti;
	}
	
}
