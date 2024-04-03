package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoUsuario {
	
	private static Connection connection;
	
	public DaoUsuario() {
		
		connection = SingleConnection.getConnetion();
	}

	/*Metodo para salvar usuario no banco de dados*/
	
	public static void gravarUsuario(ModelLogin modelLogin) {
		
		try {
			
			String sql = "INSERT INTO \"modelLogin\"(email,senha,nome)Values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, modelLogin.getEmail());
			insert.setString(2, modelLogin.getSenha());
			insert.setString(3, modelLogin.getNome());
			insert.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
