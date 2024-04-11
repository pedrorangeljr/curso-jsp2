<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
									<label>Address</label> <input type="text" class="form-control"
										placeholder="Home Address">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>City</label> <input type="text" class="form-control"
										placeholder="City">
								</div>
							</div>
							<div class="col-md-4 px-1">
								<div class="form-group">
									<label>Country</label> <input type="text" class="form-control"
										placeholder="Country">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>Postal Code</label> <input type="number"
										class="form-control" placeholder="ZIP Code">
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
						<input type="text" value="" class="form-control" id="nomeBusca" name="nomeBusca"
							placeholder="Nome">
						<div class="input-group-append">
							<button type="button" class="input-group-text"
								onclick="buscarUsuario();">
								<i class="nc-icon nc-zoom-split"></i>
							</button>
						</div>
					</div>

					<div class="card-body">
						<div class="table-responsive">
							<table class="table">
								<thead class=" text-primary">
									<th>ID</th>
									<th>Nome</th>
									<th>E-mail</th>
									<th>Ver</th>
								</thead>
								<tbody>
									<tr>
										<td>Dakota Rice</td>
										<td>Niger</td>
										<td>Oud-Turnhout</td>
										<td class="text-right">$36,738</td>
								</tbody>
							</table>
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
	
	     /*Pesquisa por Ajax*/
		function buscarUsuario() {
            
			var nomeBusca = document.getElementById("nomeBusca").value;
			
			if(nomeBusca != null && nomeBusca != '' && nomeBusca.trim() != '') {
				
				var urlAction = document.getElementById("formUser").action;
				
				$.ajax({

					method : "get",
					url : urlAction,
					data : "nomeBusca=" + nomeBusca + "&acao=buscarUserAjax",
					success : function(response) {

						
						
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
