<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.ModelLogin"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body class="">
	<div class="wrapper ">

		<!-- siderbar início -->

		<jsp:include page="sidebar.jsp"></jsp:include>

		<!-- siderbar fim -->

		<div class="main-panel">

			<!-- Navbar -->

			<jsp:include page="nav.jsp"></jsp:include>

			<!-- End Navbar -->

			<div class="content">

				<h2>Cadastro de Usuários</h2>

				<div class="card-body">

					<form action="<%=request.getContextPath()%>/ServletUsuario"
						method="post" id="formUser">

						<input type="hidden" name="acao" id="acao" value="">

						<div class="row">
							<div class="col-md-5 pr-1">
								<div class="form-group">
									<label>ID</label> <input type="text" class="form-control"
										name="id" id="id" placeholder="" readonly="readonly"
										value="${modelLogin.id }">
								</div>
							</div>
							<div class="col-md-3 px-1">
								<div class="form-group">
									<label>Nome</label> <input type="text" class="form-control"
										placeholder="nome" name="nome" id="nome" required="required"
										value="${modelLogin.nome }">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label for="exampleInputEmail1">Email</label> <input
										type="email" class="form-control" placeholder="Email"
										name="email" id="email" required="required" autocomplete="off"
										value="${modelLogin.email }">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 pr-1">
								<div class="form-group">
									<label>Senha</label> <input type="password"
										class="form-control" placeholder="senha" name="senha"
										id="senha" required="required" autocomplete="off"
										value="${modelLogin.senha }">
								</div>
							</div>
							<div class="col-md-6 pl-1">
								<div class="form-group">
									<label>Last Name</label> <input type="text"
										class="form-control" placeholder="Last Name">
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Perfil</label> <select class="form-control"
										name="perfil" id="perfil">
										<option disabled="disabled">[SELECIONE O PERFIL]</option>
										<option value="ADMIN">ADMIN</option>
										<option value="GERENTE">GERENTE</option>
										<option value="AUXILIAR-ADM">AUXILIAR-ADM</option>
										<option value="ENCARREGADO">ENCARREGADO</option>
										<option value="FRENTISTA">FRENTISTA</option>
									</select>

								</div>
							</div>
						</div>
						
						<div class="row">
						   <div class="col-md-12">
						   
						  
						    <input type="radio" class="form-group" name="sexo" id="sexo" value="MASCULINO">Masculino
						    
						    <input type="radio" class="form-group" name="sexo" id="sexo" value="FEMININO">Feminino
						    
						   
						   </div>
						 </div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Data de Nascimento</label> <input type="date"
										class="form-control" placeholder="" name="dataNascimento"
										id="dataNascimento" required="required" autocomplete="off" value="${modelLogin.dataNascimento }">

								</div>
							</div>
						</div>
							<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Renda Mensal</label> <input type="text"
									 
										class="form-control" placeholder="" name="rendaMensal"
										id="rendaMensal" required="required" autocomplete="off" value="${modelLogin.rendaMensal }">

								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>CEP</label> <input onblur="pesquisaCep();" type="text"
										class="form-control" placeholder="Cep" name="cep" id="cep"
										value="${modelLogin.cep }">
								</div>
							</div>
							<div class="col-md-4 px-1">
								<div class="form-group">
									<label>Logradouro</label> <input type="text"
										class="form-control" placeholder="Logradouro"
										name="logradouro" id="logradouro"
										value="${modelLogin.logradouro }">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>Número</label> <input type="text" class="form-control"
										placeholder="número" name="numero" id="numero"
										value="${modelLogin.numero }">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>Bairro</label> <input type="text" class="form-control"
										placeholder="bairro" name="bairro" id="bairro"
										value="${modelLogin.bairro }">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>Localidade</label> <input type="text"
										class="form-control" placeholder="localidade"
										name="localidade" id="localidade"
										value="${modelLogin.localidade }">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>UF</label> <input type="text" class="form-control"
										placeholder="uf" name="uf" id="uf" value="${modelLogin.uf }">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="update ml-auto mr-auto">

								<button type="submit" class="btn btn-primary btn-round"
									onclick="limparForm();">Novo</button>
								<button type="submit" class="btn btn-success btn-round">cadastrar</button>
								<button type="submit" class="btn btn-warning btn-round">Editar</button>
								<button type="button" class="btn btn-danger btn-round"
									onclick="deletarAjax();">Deletar</button>
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary btn-round"
									data-toggle="modal" data-target="#exampleModal">
									Pesquisar</button>

							</div>
						</div>

					</form>

				</div>

				<span>${msg }</span>
				<!-- Card Início -->

				<!-- Card Fim -->

				<!-- Card2 início -->

				<!-- Card2 Fim -->
			</div>
			<!-- footer início -->

			<!-- footer fim -->
		</div>
	</div>
	<!--   Core JS Files   -->
	<jsp:include page="script.jsp"></jsp:include>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Pesquisa de
						Usuário</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- Corpo do Modal -->

					<div class="input-group no-border">
						<input type="text" value="" class="form-control" id="nomeBusca"
							name="nomeBusca" placeholder="Nome">
						<div class="input-group-append">
							<button type="button" class="input-group-text"
								onclick="buscarUsuario();">
								<i class="nc-icon nc-zoom-split"></i>
							</button>
						</div>
					</div>

					<div class="card-body">
						<div class="table-responsive">
							<div style="height: 300px; overflow: scroll">
								<table class="table" id="tabelaResultados">
									<thead class=" text-primary">
										<th>ID</th>
										<th>Nome</th>
										<th>E-mail</th>
										<th>Ver</th>
									</thead>
									<tbody>
										<tr>
									</tbody>
								</table>
							</div>
							<spam id="totalResultados"></spam>
						</div>
					</div>


				</div>
				<div class="modal-footer">

					<button type="button" class="btn btn-secondary btn-round"
						data-dismiss="modal">fechar</button>

				</div>

			</div>
		</div>
	</div>


	<script type="text/javascript">
	
	$("#rendaMensal").maskMoney({showSymbol:true, symbol:"R$ ", decimal:",", thousands:"."});
	
	$( function() {
		  
		  $("#dataNascimento").datepicker({
			    dateFormat: 'dd/mm/yyyy',
			    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
			    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
			    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
			    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
			    nextText: 'Próximo',
			    prevText: 'Anterior'
			});
	} );
		function pesquisaCep() {

			var cep = $("#cep").val();

			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {

							//Atualiza os campos com os valores da consulta.
							$("cep").val(dados.cep);
							$("#logradouro").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#localidade").val(dados.localidade);
							$("#uf").val(dados.uf);

						} //end if.
						else {

							//CEP pesquisado não foi encontrado.
							limpa_formulário_cep();
							alert("CEP não encontrado.");
						}

					});
		}

		function verEditar(id) {

			var urlAction = document.getElementById("formUser").action;

			window.location.href = urlAction + '?acao=buscarEdidar&id=' + id;
		}

		/*Pesquisa por Ajax*/
		function buscarUsuario() {

			var nomeBusca = document.getElementById("nomeBusca").value;

			if (nomeBusca != null && nomeBusca != '' && nomeBusca.trim() != '') {

				var urlAction = document.getElementById("formUser").action;

				$
						.ajax(
								{

									method : "get",
									url : urlAction,
									data : "nomeBusca=" + nomeBusca
											+ "&acao=buscarUserAjax",
									success : function(response) {

										var json = JSON.parse(response);

										$('#tabelaResultados > tbody > tr')
												.remove();

										for (var p = 0; p < json.length; p++) {

											$('#tabelaResultados > tbody')
													.append(
															'<tr> <td>'
																	+ json[p].id
																	+ '</td> <td>'
																	+ json[p].nome
																	+ '</td> <td>'
																	+ json[p].email
																	+ '</td> <td><button onclick="verEditar('
																	+ json[p].id
																	+ ')" type="buuton" class="btn btn-warning btn-round">Ver</button></td></tr>');
										}

										document
												.getElementById('totalResultados').textContent = 'Resutados: '
												+ json.length;
									}

								}).fail(
								function(xhr, status, errorThrown) {
									alert('Erro ao usuário usuario por nome: '
											+ xhr.responseText);
								});
			}
		}
		/*Deleta por Ajax*/
		function deletarAjax() {

			if (confirm('Deseja realmente excluir os dados ?')) {

				var urlAction = document.getElementById("formUser").action;
				var id = document.getElementById("id").value;

				$.ajax({

					method : "get",
					url : urlAction,
					data : "id=" + id + "&acao=deletarAjax",
					success : function(response) {

						limparForm();
						alert(response);
					}

				}).fail(
						function(xhr, status, errorThrown) {
							alert('Erro ao deletar usuario por id: '
									+ xhr.responseText);
						});
			}

		}

		function criarDelete() {

			if (confirm('Deseja realmente excluir os dados ?')) {

				document.getElementById("formUser").method = 'get';
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formUser").submit();

			}

		}

		function limparForm() {

			var elementos = document.getElementById("formUser").elements;

			for (p = 0; p < elementos.length; p++) {

				elementos[p].value = '';
			}
		}
	</script>
</body>

</html>
