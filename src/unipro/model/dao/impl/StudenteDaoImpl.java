package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		String query="insert into studente(matricola, nome, cognome, sesso, datanascita, indirizzo, citta, email, password) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, s.getMatricola());
			ps.setString(2, s.getNome());
			ps.setString(3, s.getCognome());
			ps.setString(4, s.getSesso());
			Date d = s.getDataNascita();
			java.sql.Date sd = new java.sql.Date(d.getTime());
			ps.setDate(5, sd);
			ps.setString(6, s.getIndirizzo());
			ps.setString(7, s.getCitta());
			ps.setString(8, s.getEmail());
			ps.setString(9, s.getPassword());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByMatricola(String matricola) {
		
		String query="delete from studente where matricola=?";
	
		try {
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, matricola);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
				e.printStackTrace();
		}

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
	public Studente getByMatricola(String matricola, String password) {
		
		Studente s = null;
		String query="select * from studente where matricola=? and password=?";
		try {
			
			PreparedStatement ps=dbConn.getConn().prepareStatement(query);
			ps.setString(1, matricola);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s=new Studente();
				s.setMatricola(matricola);
				s.setPassword(password);
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setSesso(rs.getString("sesso"));
				s.setDataNascita(rs.getDate("datanascita"));
				s.setIndirizzo(rs.getString("indirizzo"));
				s.setCitta(rs.getString("citta"));
				s.setEmail(rs.getString("email"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void update(Studente s) {
		
		String query="update studente set nome=?, cognome=?, sesso=?, datanascita=?, indirizzo=?, citta=?, email=?, password=? where matricola=?";
		
		try {
			PreparedStatement ps = dbConn.getConn().prepareStatement(query);
			ps.setString(1, s.getNome());
			ps.setString(2, s.getCognome());
			ps.setString(3, s.getSesso());
			Date d = s.getDataNascita();
			java.sql.Date sd = new java.sql.Date(d.getTime());
			ps.setDate(4, sd);
			ps.setString(5, s.getIndirizzo());
			ps.setString(6, s.getCitta());
			ps.setString(7, s.getEmail());
			ps.setString(8, s.getPassword());
			ps.setString(9, s.getMatricola());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Studente> getAll() {
		
		ArrayList<Studente> listaStudenti=new ArrayList<Studente>();
		Studente s = null;
		String query="select * from studente";
		
		try {
			
			PreparedStatement ps=dbConn.getConn().prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				s=new Studente();
				s.setMatricola(rs.getString("matricola"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setSesso(rs.getString("sesso"));
				s.setDataNascita(rs.getDate("datanascita"));
				s.setIndirizzo(rs.getString("indirizzo"));
				s.setCitta(rs.getString("citta"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				
				listaStudenti.add(s);
			}
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaStudenti;
	}
	
}
