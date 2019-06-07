package unipro.model.dao;

import java.util.List;

import unipro.model.Esame;

public interface EsameDAO {
	
	public void save(Esame es);									
	public void deleteByIdEsame(String idEsame);									
	public Esame getByIdEsame(String idEsame);	
	public void update(Esame es);									
	public List<Esame> getAll();

}
