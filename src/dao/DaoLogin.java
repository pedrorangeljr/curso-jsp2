package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoLogin {
	
	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnetion();
	}

	public  boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		String sql = "select * from \"modelLogin\" where upper(email) = upper(?) and upper(senha) = upper(?) ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getEmail());
		statement.setString(2, modelLogin.getSenha());
		
		ResultSet resultado = statement.executeQuery();
		
		if(resultado.next()) {
			
			return true;
		}
		
		return false;
	}
}
