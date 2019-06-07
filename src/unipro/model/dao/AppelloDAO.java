package unipro.model.dao;

import java.util.List;

import unipro.model.Appello;

public interface AppelloDAO {
	
	public void save(Appello ap);									
	public void deleteByIdAppello(String idAppello);									
	public Appello getByIdAppello(String idAppello);	
	public void update(Appello ap);									
	public List<Appello> getAll();

}
