package unipro.model.dto;

import java.util.Date;

public class AppelloDTO {
	
	private String idAppello;
	private String nomeEsame;
	private Date data;
	private String aula;
	private String nomeDocente;
	private String cognomeDocente;
	
	public AppelloDTO() {
		
		super();
	}
	
	public String getIdAppello() {
		return idAppello;
	}
	public void setIdAppello(String idAppello) {
		this.idAppello = idAppello;
	}
	public String getNomeEsame() {
		return nomeEsame;
	}
	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}
	
	
	

}
