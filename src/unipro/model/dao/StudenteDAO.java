package unipro.model.dao;

import java.util.List;

import unipro.model.Amministratore;
import unipro.model.Studente;
import unipro.model.dto.AppelloDTO;

public interface StudenteDAO {
	
	public void save(Studente s);									
	public void deleteByMatricola(String matricola);									
	public Studente getByMatricola(String matricola);	
	public Studente getByMatricolaPassword(String matricola, String password);
	public void update(Studente s);									
	public List<Studente> getAll();
	public boolean prenotaAppello(String matricola, String idAppello);
	public boolean cancellaPrenotazioneAppello(String matricola, String idAppello);
	public List<AppelloDTO> getAppelliPrenotati(String matricola);
	public Amministratore getByUsernamePassword(String username, String password);
}

