package servlets;

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DaoUsuario;

public class ServletGenericUtil extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	

	public Long getUserLogado(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");
		
		return daoUsuario.consultarUsuarioLogado(usuarioLogado).getId();
	}
	
}
