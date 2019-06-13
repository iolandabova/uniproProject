package unipro.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import unipro.connection.DbConnection;
import unipro.model.Amministratore;
import unipro.model.Studente;
import unipro.model.dao.StudenteDAO;
import unipro.model.dto.AppelloDTO;

public class StudenteDaoImpl implements StudenteDAO {
	
	private DbConnection dbConn;
	
	public StudenteDaoImpl() {
		
		dbConn=DbConnection.getDbConnection();
	}

	@Override
	public boolean save(Studente s) {
		
		String query="insert into studente(matricola, nome, cognome, sesso, datanascita, indirizzo, citta, email, password) values (?,?,?,?,?,?,?,?,?)";
		boolean save = false;
		
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(query);
			ps.setString(1, s.getMatricola());
			ps.setString(2, s.getNome());
			ps.setString(3, s.getCognome());
			ps.setString(4, s.getSesso());
			Date d = s.getDataNascita();
			System.out.println(d);
			java.sql.Date sd = new java.sql.Date(d.getTime());
			ps.setDate(5, sd);
			ps.setString(6, s.getIndirizzo());
			ps.setString(7, s.getCitta());
			ps.setString(8, s.getEmail());
			ps.setString(9, s.getPassword());
			
			if (ps.executeUpdate() > 0)
				save = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return save;
	}

	@Override
	public boolean deleteByMatricola(String matricola) {
		
		String query="delete from studente where matricola=?";
		boolean delete = false;
	
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(query);
			ps.setString(1, matricola);
			
			if (ps.executeUpdate() > 0)
				delete = true;
			
			ps.close();
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return delete;
	}

	@Override
	public Studente getByMatricola(String matricola) {
		
		Studente s = null;
		String query="select * from studente where matricola=?";
		try {
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
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
				
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public Studente getStudentByMatricolaPassword(String matricola, String password) {
		
		Studente s = null;
		String query="select * from studente where matricola=? and password=?";
		try {
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
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
			PreparedStatement ps = dbConn.getConnection().prepareStatement(query);
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
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
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

	@Override
	public boolean prenotaAppello(String matricola, String idAppello) {
		
		String query ="insert into prenota (matricola, idappello)" + "values(?,?)";
		boolean ex=false;
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, matricola);
			ps.setString(2, idAppello);
			
			if (ps.executeUpdate() > 0)
				ex = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ex;
	}
	
	@Override
	public boolean cancellaPrenotazioneAppello(String matricola, String idAppello) {
		
		String query ="delete from prenota where matricola=? and idappello=?";
		boolean ex=false;
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, matricola);
			ps.setString(2, idAppello);
			
			if (ps.executeUpdate() > 0)
				ex = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ex;
	}

	@Override
	public List<AppelloDTO> getAppelliPrenotati(String matricola) {
		
		AppelloDTO a = null;
		ArrayList<AppelloDTO> listaAppelliPrenotati = new ArrayList <AppelloDTO>();
		String query ="select ap.idappello, es.nomeesame, ap.data, ap.aula, do.nome, do.cognome from appello ap join prenota pr on ap.idappello=pr.idappello join studente st on st.matricola=pr.matricola join esame es on es.idesame=ap.idesame join docente do on do.iddocente=ap.iddocente where st.matricola=?";
		
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(query);
			ps.setString(1, matricola);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				a = new AppelloDTO();
				a.setIdAppello(rs.getString("idappello"));
				a.setNomeEsame(rs.getString("nomeesame"));
				a.setData(rs.getDate("data"));
				a.setAula(rs.getString("aula"));
				a.setNomeDocente(rs.getString("nome"));
				a.setCognomeDocente(rs.getString("cognome"));
					
				listaAppelliPrenotati.add(a);
			}
			ps.close();
			
		}catch (Exception e) {
	    	 e.printStackTrace();
		}
		return listaAppelliPrenotati;
		
	}

	@Override
	public Amministratore getAdminByUsernamePassword(String username, String password) {
		
		Amministratore amm = null;
		String query="select * from amministratore where username=? and password=?";
		try {
			
			PreparedStatement ps=dbConn.getConnection().prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				amm = new Amministratore();
				
				amm.setUsername(username);
				amm.setPassword(password);
				amm.setNomeAmministratore(rs.getString("nomeamministratore"));
				amm.setCognomeAmministratore(rs.getString("cognomeamministratore"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amm;
	}
	
}
