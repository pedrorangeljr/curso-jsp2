package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoUsuario {

	private static Connection connection;

	public DaoUsuario() {

		connection = SingleConnection.getConnetion();
	}

	/* Metodo para salvar usuario no banco de dados */

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

	public boolean validaLogin(String email) throws Exception {

		String sql = "SELECT COUNT(1) > 0 as existe FROM \"modelLogin\" WHERE upper(email) = upper('" + email + "')";
		PreparedStatement validar = connection.prepareStatement(sql);

		ResultSet resultado = validar.executeQuery();

		resultado.next();

		return resultado.getBoolean("existe");

	}
}
