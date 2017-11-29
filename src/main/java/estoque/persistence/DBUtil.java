package estoque.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	
	private Connection conn = null;
	
	public Connection getConnection(){
		try {
			String driverName = "com.mysql.jdbc.Driver";                        
			Class.forName(driverName);
			/* MUDAR PELAS INFORMACOES DO PROVEDOR DO BD*/
			//String serverName = "localhost";    
            //String mydatabase = "estoque";        
            String username = "sql10207809";              
            String password = "Up5erDyWwx";      
            /* MUDAR PELAS INFORMACOES DO PROVEDOR DO BD*/
           //String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10207809";
            conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(conn != null){
			System.out.println("Conectado com Sucesso");
		}else {
			System.out.println("Nao conectou");
		}
		return conn;
	}
	
	public void closeConnection(Connection c){
		try {
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
