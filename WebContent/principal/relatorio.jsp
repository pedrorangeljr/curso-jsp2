<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

				<h2>Relatório de Usuários</h2>

				<form action="<%=request.getContextPath()%>/ServletUsuario"
					method="get" id="formUser">

					<input type="hidden" id="acaoRelatorioImprimirTipo" name="acao"
						value="imprimirRelatorioUser">

					<div class="form-row align-items-center">

						<div class="col-md-3 px-1">
							<div class="form-group">
								<label>Data Inicial</label> <input type="date"
									class="form-control" name="dataInicial" id="dataInicial"
									value="${dataInicial }">
							</div>
						</div>

						<div class="col-md-3 pl-1">
							<div class="form-group">
								<label for="exampleInputEmail1">Data Final</label> <input
									type="date" class="form-control" name="dataFinal"
									id="dataFinal" value="${dataFinal }">
							</div>
						</div>

						<div class="col-md-4 pl-1">
							<div class="form-group" style="margin-top: 25px;">
								<button type="button" onclick="imprimirHtlm();" class=" btn btn-success btn-round mb-1">Imprimir
									Relatório</button>
								<a href="<%= request.getContextPath() %>/ServletUsuario?acao=imprimirPDF" class="btn btn-success btn-round mb-1">Imprimir PDF</a>
							</div>
						</div>

					</div>

				</form>

				<br />

				<div class="col-md-12">
					<div class="card" style="margin-left: -20px;">
						<div class="card-header">
							<h4 class="card-title">Simple Table</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<div style="height: 400px; overflow: scroll;">
									<table class="table">

										<thead class=" text-primary">
											<th>ID</th>
											<th>Nome</th>
											<th>Email</th>
											<th>Perfil</th>
										</thead>


										<tbody>
											<c:forEach items="${listarUser }" var='ml'>
												<tr>
													<td><c:out value="${ml.id }"></c:out></td>
													<td><c:out value="${ml.nome }"></c:out></td>
													<td><c:out value="${ml.email }"></c:out></td>
													<td><c:out value="${ml.perfil }"></c:out></td>
												</tr>
											</c:forEach>
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- footer início -->

			<!-- footer fim -->
		</div>
	</div>
	<!--   Core JS Files   -->
	<jsp:include page="script.jsp"></jsp:include>

	<script type="text/javascript">
		function imprimirHtlm() {

			document.getElementById("acaoRelatorioImprimirTipo").value = 'imprimirRelatorioUser';

			$("#formUser").submit();

		}
		$(function() {

			$("#dataInicial")
					.datepicker(
							{
								dateFormat : 'dd/mm/yyyy',
								dayNames : [ 'Domingo', 'Segunda', 'Terça',
										'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
								dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
										'S', 'D' ],
								dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
										'Qui', 'Sex', 'Sáb', 'Dom' ],
								monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
										'Abril', 'Maio', 'Junho', 'Julho',
										'Agosto', 'Setembro', 'Outubro',
										'Novembro', 'Dezembro' ],
								monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
										'Mai', 'Jun', 'Jul', 'Ago', 'Set',
										'Out', 'Nov', 'Dez' ],
								nextText : 'Próximo',
								prevText : 'Anterior'
							});
		});

		$(function() {

			$("#dataFinal")
					.datepicker(
							{
								dateFormat : 'dd/mm/yyyy',
								dayNames : [ 'Domingo', 'Segunda', 'Terça',
										'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
								dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
										'S', 'D' ],
								dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
										'Qui', 'Sex', 'Sáb', 'Dom' ],
								monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
										'Abril', 'Maio', 'Junho', 'Julho',
										'Agosto', 'Setembro', 'Outubro',
										'Novembro', 'Dezembro' ],
								monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
										'Mai', 'Jun', 'Jul', 'Ago', 'Set',
										'Out', 'Nov', 'Dez' ],
								nextText : 'Próximo',
								prevText : 'Anterior'
							});
		});
	</script>
</body>

</html>
