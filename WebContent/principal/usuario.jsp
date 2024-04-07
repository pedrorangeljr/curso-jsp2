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
						method="post">

						<div class="row">
							<div class="col-md-5 pr-1">
								<div class="form-group">
									<label>ID</label> <input type="text" class="form-control"
										name="id" id="id"  placeholder="" readonly="readonly"
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
										class="form-control" placeholder="Last Name" >
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
										placeholder="City" >
								</div>
							</div>
							<div class="col-md-4 px-1">
								<div class="form-group">
									<label>Country</label> <input type="text" class="form-control"
										placeholder="Country" >
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

								<button type="submit" class="btn btn-primary btn-round">Novo</button>
								<button type="submit" class="btn btn-success btn-round">cadastrar</button>
								<button type="submit" class="btn btn-warning btn-round">Editar</button>
								<button type="button" class="btn btn-danger btn-round">Deletar</button>

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
</body>

</html>
