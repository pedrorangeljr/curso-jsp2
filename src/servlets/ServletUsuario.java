package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DaoUsuario;
import model.ModelLogin;

@WebServlet(urlPatterns = { "/ServletUsuario" })
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

				List<ModelLogin> dadosJsonUser = daoUsuario.consultausuarioList(nomeBusca,
						super.getUserLogado(request));

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

			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("imprimirRelatorioUser")) {

				String dataInicial = request.getParameter("dataInicial");
				String dataFinal = request.getParameter("dataFinal");

				if (dataInicial == null || dataInicial.isEmpty() && dataFinal == null || dataFinal.isEmpty()) {

					request.setAttribute("listarUser", daoUsuario.consultausuarioListRel(super.getUserLogado(request)));

				} else {

					request.setAttribute("listarUser",
							daoUsuario.consultausuarioListRel(super.getUserLogado(request), dataInicial, dataFinal));
				}

				request.setAttribute("dataInicial", dataInicial);
				request.setAttribute("dataFinal", dataFinal);
				request.getRequestDispatcher("principal/relatorio.jsp").forward(request, response);

			}
			/* Imprimir relatório em PDF */
			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("imprimirPDF")) {

				String dataInicial = request.getParameter("dataInicial");
				String dataFinal = request.getParameter("dataFinal");

				// List<ModelLogin> modelLogin =
				// daoUsuario.consultausuarioListRel(super.getUserLogado(request));

				if (dataInicial == null || dataInicial.isEmpty() && dataFinal == null || dataFinal.isEmpty()) {

					Document documento = new Document();

					response.setContentType("apllication/pdf");

					response.addHeader("Content-Disposition", "inline; filename=" + "usuarios.pdf");

					// Cria o documento
					PdfWriter.getInstance(documento, response.getOutputStream());

					// Abre o documento -> gera o conteudo
					documento.open();
					documento.add(new Paragraph("Lista de usuários"));
					documento.add(new Paragraph(" ")); // quebra uma linha no PDF

					PdfPTable tabela = new PdfPTable(3);
					PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
					PdfPCell col2 = new PdfPCell(new Paragraph("Email"));
					PdfPCell col3 = new PdfPCell(new Paragraph("Perfil"));

					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);

					List<ModelLogin> modelLogin = daoUsuario.consultausuarioListRel(super.getUserLogado(request));

					for (int i = 0; i < modelLogin.size(); i++) {

						tabela.addCell(modelLogin.get(i).getNome());
						tabela.addCell(modelLogin.get(i).getEmail());
						tabela.addCell(modelLogin.get(i).getPerfil());
					}

					documento.add(tabela);
					documento.close();

					documento.close();
					

				} else {

					Document documento = new Document();

					response.setContentType("apllication/pdf");

					response.addHeader("Content-Disposition", "inline; filename=" + "usuarios.pdf");

					// Cria o documento
					PdfWriter.getInstance(documento, response.getOutputStream());

					// Abre o documento -> gera o conteudo
					documento.open();
					documento.add(new Paragraph("Lista de usuários"));
					documento.add(new Paragraph(" ")); // quebra uma linha no PDF

					PdfPTable tabela = new PdfPTable(3);
					PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
					PdfPCell col2 = new PdfPCell(new Paragraph("Email"));
					PdfPCell col3 = new PdfPCell(new Paragraph("Perfil"));

					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);

					List<ModelLogin> modelLogin = daoUsuario.consultausuarioListRel(super.getUserLogado(request),dataInicial, dataFinal);

					for (int i = 0; i < modelLogin.size(); i++) {

						tabela.addCell(modelLogin.get(i).getNome());
						tabela.addCell(modelLogin.get(i).getEmail());
						tabela.addCell(modelLogin.get(i).getPerfil());
					}

					documento.add(tabela);
					documento.close();

					documento.close();
				}

			}
			/*
			 * else if(acao != null && !acao.isEmpty() &&
			 * acao.equalsIgnoreCase("listarUser")) { // Lista todos
			 * 
			 * List<ModelLogin> modelLogins = daoUsuario.consultausuarioList();
			 * 
			 * request.setAttribute("msg", "Usuário em edição");
			 * request.setAttribute("modelLogin", modelLogins);
			 * request.getRequestDispatcher("/principal/usuario.jsp").forward(request,
			 * response); }
			 */

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
			String rendaMensal = request.getParameter("rendaMensal");

			rendaMensal = rendaMensal.replaceAll("\\,", "").replaceAll("R$ ", "");

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
			modelLogin.setRendaMensal(Double.valueOf(rendaMensal));

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
