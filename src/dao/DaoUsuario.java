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

			String sql = "INSERT INTO modelLogin(email,senha,nome,usuario_id,perfil,sexo,cep,logradouro,bairro,"
					+ "localidade,uf,numero, dataNascimento, rendaMensal)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, modelLogin.getEmail());
			insert.setString(2, modelLogin.getSenha());
			insert.setString(3, modelLogin.getNome());
			insert.setLong(4, userLogado);
			insert.setString(5, modelLogin.getPerfil());
			insert.setString(6, modelLogin.getSexo());
			insert.setString(7, modelLogin.getCep());
			insert.setString(8, modelLogin.getLogradouro());
			insert.setString(9, modelLogin.getBairro());
			insert.setString(10, modelLogin.getLocalidade());
			insert.setString(11, modelLogin.getUf());
			insert.setString(12, modelLogin.getNumero());
			insert.setDate(13, modelLogin.getDataNascimento());
			insert.setDouble(14, modelLogin.getRendaMensal());
			insert.execute();

			connection.commit();

		} else { // Atualiza

			String sql = "UPDATE modelLogin SET nome = ?, email = ?, senha = ?, perfil = ?, cep = ?, logradouro = ?,"
					+ "bairro = ?, localidade = ?, uf = ?, numero = ?, dataNascimento = ?, rendaMensal = ? WHERE id = " + modelLogin.getId()+ "";
			PreparedStatement update = connection.prepareStatement(sql);

			update.setString(1, modelLogin.getNome());
			update.setString(2, modelLogin.getEmail());
			update.setString(3, modelLogin.getSenha());
			update.setString(4, modelLogin.getPerfil());
			update.setString(5, modelLogin.getCep());
			update.setString(6, modelLogin.getLogradouro());
			update.setString(7, modelLogin.getBairro());
			update.setString(8, modelLogin.getLocalidade());
			update.setString(9, modelLogin.getUf());
			update.setString(10, modelLogin.getNumero());
			update.setDate(11, modelLogin.getDataNascimento());
			update.setDouble(12, modelLogin.getRendaMensal());
			
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
			modelLogin.setPerfil(resultado.getString("perfil"));
			modelLogin.setDataNascimento(resultado.getDate("dataNascimento"));
			modelLogin.setRendaMensal(resultado.getDouble("rendaMensal"));
			
			retorno.add(modelLogin);
		}
		
		return retorno;
	}
	
	
	//Metodo que lista todos os usuarios
	public List<ModelLogin> consultausuarioListRel(Long userLogado) throws Exception {
		
		List<ModelLogin> retorno = new ArrayList<ModelLogin>();
		
		String sql = "select * from modelLogin where useradmin is false and usuario_id = " + userLogado;
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
	}
	
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
			modelLogin.setPerfil(resultado.getString("perfil"));
			
			modelLogin.setCep(resultado.getString("cep"));
			modelLogin.setLogradouro(resultado.getString("logradouro"));
			modelLogin.setBairro(resultado.getString("bairro"));
			modelLogin.setLocalidade(resultado.getString("localidade"));
			modelLogin.setUf(resultado.getString("uf"));
			modelLogin.setNumero(resultado.getString("numero"));

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
			modelLogin.setPerfil(resultado.getString("perfil"));
			
			modelLogin.setCep(resultado.getString("cep"));
			modelLogin.setLogradouro(resultado.getString("logradouro"));
			modelLogin.setBairro(resultado.getString("bairro"));
			modelLogin.setLocalidade(resultado.getString("localidade"));
			modelLogin.setUf(resultado.getString("uf"));
			modelLogin.setNumero(resultado.getString("numero"));

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
			modelLogin.setPerfil(resultado.getString("perfil"));
			
			modelLogin.setCep(resultado.getString("cep"));
			modelLogin.setLogradouro(resultado.getString("logradouro"));
			modelLogin.setBairro(resultado.getString("bairro"));
			modelLogin.setLocalidade(resultado.getString("localidade"));
			modelLogin.setUf(resultado.getString("uf"));
			modelLogin.setNumero(resultado.getString("numero"));

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
			modelLogin.setPerfil(resultado.getString("perfil"));
			
			modelLogin.setCep(resultado.getString("cep"));
			modelLogin.setLogradouro(resultado.getString("logradouro"));
			modelLogin.setBairro(resultado.getString("bairro"));
			modelLogin.setLocalidade(resultado.getString("localidade"));
			modelLogin.setUf(resultado.getString("uf"));
			modelLogin.setNumero(resultado.getString("numero"));

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
