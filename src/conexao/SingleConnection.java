package conexao;

/*Classe de conexão com banco de dados*/

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/cursojsp?autoReconnect=true";
	private static String user = "admin";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				
				Class.forName("com.mysql.cj.jdbc.Driver"); // carrega o Driver do banco
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();// mostra qualquer erro no momento da conexão com banco de dados
		}
	}

	public static Connection getConnetion() {
		
		return connection;
	}
}
