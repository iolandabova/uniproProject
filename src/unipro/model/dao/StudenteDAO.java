package unipro.model.dao;

import java.util.List;

import unipro.model.Studente;

public interface StudenteDAO {
	
	public void save(Studente s);									
	public void deleteByMatricola(String matricola);									
	public Studente getByMatricola(String matricola);	
	public Studente getByMatricola(String matricola, String password);
	public void update(Studente s);									
	public List<Studente> getAll();
}

