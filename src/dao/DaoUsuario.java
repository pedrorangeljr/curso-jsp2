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

	public ModelLogin gravarUsuario(ModelLogin modelLogin) throws Exception {

		if (modelLogin.eNovo()) { // grava um novo

			String sql = "INSERT INTO modelLogin(email,senha,nome)Values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, modelLogin.getEmail());
			insert.setString(2, modelLogin.getSenha());
			insert.setString(3, modelLogin.getNome());
			insert.execute();

			connection.commit();

		} else { // Atualiza

			String sql = "UPDATE modelLogin SET nome = ?, email = ?, senha = ? WHERE id = " + modelLogin.getId()+ "";
			PreparedStatement update = connection.prepareStatement(sql);

			update.setString(1, modelLogin.getNome());
			update.setString(2, modelLogin.getEmail());
			update.setString(3, modelLogin.getSenha());
			update.executeUpdate();

			connection.commit();
		}

		return this.consultarUsuario(modelLogin.getEmail());
	}

	/* metodo consulta usuario por login */
	public ModelLogin consultarUsuario(String email) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "SELECT * FROM modelLogin WHERE upper(email) = upper('" + email + "')";
		PreparedStatement select = connection.prepareStatement(sql);

		ResultSet resultado = select.executeQuery();

		while (resultado.next()) {

			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setSenha(resultado.getString("senha"));

		}

		return modelLogin;
	}

	public boolean validarLogin(String login) throws Exception {

		String sql = "SELECT COUNT(1) > 0 AS EXISTE FROM modelLogin WHERE upper(email) = upper('" + login + "')";
		PreparedStatement validar = connection.prepareStatement(sql);

		ResultSet resultado = validar.executeQuery();

		resultado.next();

		return resultado.getBoolean("EXISTE");

	}

}
