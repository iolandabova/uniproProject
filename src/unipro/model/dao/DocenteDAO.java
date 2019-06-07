package unipro.model.dao;

import java.util.List;

import unipro.model.Docente;

public interface DocenteDAO {
	
	public void save(Docente d);									
	public void deleteByIdDocente(String idDocente);									
	public Docente getByIdDocente(String idDocente);	
	public void update(Docente d);									
	public List<Docente> getAll();

}
