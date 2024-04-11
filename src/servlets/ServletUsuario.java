package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import model.ModelLogin;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
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
				
			}else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjax")) { // pesquisa nome  por ajax

				String nomeBusca = request.getParameter("nomeBusca");

				//daoUsuario.deletarUser(id);
				
				//response.getWriter().write("Excluido com Sucesso");
				
				System.out.println(nomeBusca);
				
			}
			
			
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

			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setSenha(senha);

			if (daoUsuario.validarLogin(modelLogin.getEmail()) && modelLogin.getId() == null) {

				msg = "Já existe usuário com o mesmo login, informe outro login";

			} else {

				if (modelLogin.eNovo()) {

					msg = "Gravado com Sucesso!";

				} else {

					msg = "Atualizado com Sucesso!";
				}

				modelLogin = daoUsuario.gravarUsuario(modelLogin);
			}

			request.setAttribute("msg", msg);
			request.setAttribute("modelLogin", modelLogin);
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
