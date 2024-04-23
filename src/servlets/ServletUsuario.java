package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DaoUsuario;
import model.ModelLogin;


@WebServlet(urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends ServletGenericUtil {
	
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public ServletUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");

			if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {// deletar normal

				String id = request.getParameter("id");

				daoUsuario.deletarUser(id);
				request.setAttribute("msg", "Excluido com Sucesso");

				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarAjax")) { // deleta por ajax

				String id = request.getParameter("id");

				daoUsuario.deletarUser(id);

				response.getWriter().write("Excluido com Sucesso");

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjax")) { // pesquisa nome
																										// por ajax

				String nomeBusca = request.getParameter("nomeBusca");

				List<ModelLogin> dadosJsonUser = daoUsuario.consultausuarioList(nomeBusca, super.getUserLogado(request));

				/* Trasnforma uma lista em Json */

				ObjectMapper mapper = new ObjectMapper();

				String json = mapper.writeValueAsString(dadosJsonUser);

				response.getWriter().write(json);

			}

			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEdidar")) {

				String id = request.getParameter("id");

				ModelLogin modelLogin = daoUsuario.consultarUsuarioID(id, super.getUserLogado(request));
				
				request.setAttribute("msg", "Usuário em edição");
				request.setAttribute("modelLogin", modelLogin);
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			
				
			}
			/*
			else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarUser")) { // Lista todos
				
				List<ModelLogin> modelLogins = daoUsuario.consultausuarioList();
				
				request.setAttribute("msg", "Usuário em edição");
				request.setAttribute("modelLogin", modelLogins);
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
			}*/

			else {

				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String msg = "Operação Realizada com Sucesso!";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String perfil = request.getParameter("perfil");
			String sexo = request.getParameter("sexo");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("localidade");
			String localidade = request.getParameter("localidade");
			String uf = request.getParameter("uf");
			String dataNascimento = request.getParameter("dataNascimento");
			

			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setSenha(senha);
			modelLogin.setPerfil(perfil);
			modelLogin.setSexo(sexo);
			modelLogin.setCep(cep);
			modelLogin.setLogradouro(logradouro);
			modelLogin.setNumero(numero);
			modelLogin.setBairro(bairro);
			modelLogin.setLocalidade(localidade);
			modelLogin.setUf(uf);
			modelLogin.setDataNascimento(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento).getTime()));

			if (daoUsuario.validarLogin(modelLogin.getEmail()) && modelLogin.getId() == null) {

				msg = "Já existe usuário com o mesmo login, informe outro login";

			} else {

				if (modelLogin.eNovo()) {

					msg = "Gravado com Sucesso!";

				} else {

					msg = "Atualizado com Sucesso!";
				}

				modelLogin = daoUsuario.gravarUsuario(modelLogin, super.getUserLogado(request));
			}

			request.setAttribute("msg", msg);
			request.setAttribute("modelLogin", modelLogin);
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
