package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import unipro.connection.DbConnection;
import unipro.model.Studente;
import unipro.model.dao.StudenteDAO;

public class StudenteDaoImpl implements StudenteDAO {
	
	private DbConnection dbConn;
	
	public StudenteDaoImpl() {
		
		dbConn=DbConnection.getConnection();
	}

	@Override
	public void save(Studente s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByMatricola(String matricola) {
		// TODO Auto-generated method stub

	}

	@Override
	public Studente getByMatricola(String matricola) {
		
		Studente s = null;
		String query="select * from studente where matricola=?";
		try {
			
			PreparedStatement ps=dbConn.getConn().prepareStatement(query);
			ps.setString(1, matricola);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s=new Studente();
				s.setMatricola(matricola);
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setSesso(rs.getString("sesso"));
				s.setDataNascita(rs.getDate("datanascita"));
				s.setIndirizzo(rs.getString("indirizzo"));
				s.setCitta(rs.getString("citta"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				
//				Date newDate = rs.getDate("datanascita");
//				s.setDataNascita(newDate);
				
//				java.sql.Date dataGrezza = rs.getDate("datanascita");
//				long nsec = dataGrezza.getTime();
//				Date dataRaffinata = new Date(nsec);
//				s.setDataNascita(dataRaffinata);	
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void update(Studente s) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Studente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
