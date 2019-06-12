package unipro.model;

public class Amministratore {
	
	private String nomeAmministratore;
	private String cognomeAmministratore;
	private String username;
	private String password;
	
	public Amministratore() {
	
		super();
	}

	public String getNomeAmministratore() {
		return nomeAmministratore;
	}

	public void setNomeAmministratore(String nomeAmministratore) {
		this.nomeAmministratore = nomeAmministratore;
	}

	public String getCognomeAmministratore() {
		return cognomeAmministratore;
	}

	public void setCognomeAmministratore(String cognomeAmministratore) {
		this.cognomeAmministratore = cognomeAmministratore;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
