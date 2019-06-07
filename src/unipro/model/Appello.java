package unipro.model;

import java.util.Date;

public class Appello {
	
	private String idAppello;
	private Date data;
	private String aula;
	private String idEsame;
	private String idDocente;
	
	public Appello() {
		super();
	}

	public String getIdAppello() {
		return idAppello;
	}

	public void setIdAppello(String idAppello) {
		this.idAppello = idAppello;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date dataAppello) {
		this.data = dataAppello;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(String idEsame) {
		this.idEsame = idEsame;
	}

	public String getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(String idDocente) {
		this.idDocente = idDocente;
	}

}
