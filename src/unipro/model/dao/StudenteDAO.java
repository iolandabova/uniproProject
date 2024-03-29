package unipro.model.dao;

import java.util.List;

import unipro.model.Amministratore;
import unipro.model.Studente;
import unipro.model.dto.AppelloDTO;

public interface StudenteDAO {
	
	public boolean save(Studente s);									
	public boolean deleteByMatricola(String matricola);									
	public Studente getByMatricola(String matricola);	
	public Studente getStudentByMatricolaPassword(String matricola, String password);
	public void update(Studente s);									
	public List<Studente> getAll();
	public boolean prenotaAppello(String matricola, String idAppello);
	public boolean cancellaPrenotazioneAppello(String matricola, String idAppello);
	public List<AppelloDTO> getAppelliPrenotati(String matricola);
	public Amministratore getAdminByUsernamePassword(String username, String password);
}

