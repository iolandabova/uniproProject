package unipro.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static DbConnection instance;
	
	private static final String driver="thin";
	private static final String user="C##progetto";
	private static final String pass="progetto";
	private static final String host="localhost";
	private static final String port="1521";
	private static final String db="XE";
	
	//attributo che contiene la connessione
	private Connection conn;
	
	//singleton quindi costruttore privato
	private DbConnection() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		String connString = String.format("jdbc:oracle:%s:%s/%s@//%s:%s/%s",driver, user, pass, host, port, db);
		//String connString="jdbc:oracle:"+driver+":"+user+"/"+pass+"@//"+host+":"+port+"/"+db;
		
		try {
			this.conn=DriverManager.getConnection(connString);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//metodo static getInstance
	public static DbConnection getConnection() {
		
		if(instance==null) {
			instance=new DbConnection();
		}
		return instance;
	}
	
	//getter di conn
	public Connection getConn() {
		return this.conn;
	}

}
