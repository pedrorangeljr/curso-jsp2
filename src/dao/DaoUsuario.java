package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.SingleConnection;
import model.ModelLogin;

public class DaoUsuario {

	private static Connection connection;

	public DaoUsuario() {

		connection = SingleConnection.getConnetion();
	}

	/* Metodo para salvar usuario no banco de dados */

	public ModelLogin gravarUsuario(ModelLogin modelLogin, Long userLogado) throws Exception {

		if (modelLogin.eNovo()) { // grava um novo

			String sql = "INSERT INTO modelLogin(email,senha,nome, usuario_id)Values(?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, modelLogin.getEmail());
			insert.setString(2, modelLogin.getSenha());
			insert.setString(3, modelLogin.getNome());
			insert.setLong(4, userLogado);
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

		return this.consultarUsuario(modelLogin.getEmail(), userLogado);
	}
	
	/*Consulta usuário por nome para função Ajax*/
	public List<ModelLogin> consultausuarioList(String nome, Long usuarioLogado) throws Exception {
		
		List<ModelLogin> retorno = new ArrayList<ModelLogin>();
		
		String sql = "SELECT * FROM modelLogin WHERE upper(nome) LIKE upper(?) and useradmin is false and usuario_id = ?";
		PreparedStatement consultar = connection.prepareStatement(sql);
		consultar.setString(1, "%"+ nome +"%");
		consultar.setLong(2, usuarioLogado);
		
		ResultSet resultado = consultar.executeQuery();
		
		while(resultado.next()) {
			
			ModelLogin modelLogin = new ModelLogin();
			
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setEmail(resultado.getString("email"));
			
			retorno.add(modelLogin);
		}
		
		return retorno;
	}
	
	/*
	//Metodo que lista todos os usuarios
	public List<ModelLogin> consultausuarioList() throws Exception {
		
		List<ModelLogin> retorno = new ArrayList<ModelLogin>();
		
		String sql = "SELECT * FROM modelLogin";
		PreparedStatement consultar = connection.prepareStatement(sql);
		
		ResultSet resultado = consultar.executeQuery();
		
		while(resultado.next()) {
			
			ModelLogin modelLogin = new ModelLogin();
			
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setEmail(resultado.getString("email"));
			
			retorno.add(modelLogin);
		}
		
		return retorno;
	}*/
	
	/*Metodo consulta usuário por ID*/
	public ModelLogin consultarUsuarioID(String id, Long userLogado) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "SELECT * FROM modelLogin WHERE id = ? and useradmin is false and usuario_id = ?";
		PreparedStatement select = connection.prepareStatement(sql);
		select.setLong(1, Long.parseLong(id));
		select.setLong(2, userLogado);

		ResultSet resultado = select.executeQuery();

		while (resultado.next()) {

			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setSenha(resultado.getString("senha"));

		}

		return modelLogin;
	}
	

	/* metodo consulta usuario por login */
	public ModelLogin consultarUsuario(String email, Long userLogado) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "SELECT * FROM modelLogin WHERE upper(email) = upper('" + email + "') and useradmin is false and usuario_id = " + userLogado;
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
	
	public ModelLogin consultarUsuario(String email) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "SELECT * FROM modelLogin WHERE upper(email) = upper('" + email + "') and useradmin is false";
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
	
	public ModelLogin consultarUsuarioLogado(String email) throws Exception {

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
	
	public void deletarUser(String id) throws Exception {
		
		String sql = "DELETE FROM modelLogin WHERE id = ? and useradmin is false";
		PreparedStatement delete = connection.prepareStatement(sql);
		
		delete.setLong(1, Long.parseLong(id));
		
		delete.executeUpdate();
		
		connection.commit();
	
	}

}
