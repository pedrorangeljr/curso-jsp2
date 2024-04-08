<%@ page import="java.sql.*"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-lg-3 col-md-6 col-sm-6">
		<div class="card card-stats">
			<div class="card-body ">
				<div class="row">
					<div class="col-5 col-md-4">
						<div class="icon-big text-center icon-warning">
							<i class="nc-icon nc-single-02 text-warning"></i>
						</div>
					</div>
					<div class="col-7 col-md-8">
						<div class="numbers">
							<p class="card-category">Usuários Cadastrados</p>
							<p class="card-title">

								<%
								Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojsp?autoReconnect=true", "admin",
										"admin");
								Statement statement = connection.createStatement();

								ResultSet resultset = statement.executeQuery("select count(id) from modelLogin");

								while (resultset.next()) {

									out.println(resultset.getString(1));
								}
								%>
							
							<p>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer ">
				<hr>
				<div class="stats">
					<i class="fa fa-refresh"></i> Update Now
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6">
		<div class="card card-stats">
			<div class="card-body ">
				<div class="row">
					<div class="col-5 col-md-4">
						<div class="icon-big text-center icon-warning">
							<i class="nc-icon nc-money-coins text-success"></i>
						</div>
					</div>
					<div class="col-7 col-md-8">
						<div class="numbers">
							<p class="card-category">Revenue</p>
							<p class="card-title">$ 1,345
							<p>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer ">
				<hr>
				<div class="stats">
					<i class="fa fa-calendar-o"></i> Last day
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6">
		<div class="card card-stats">
			<div class="card-body ">
				<div class="row">
					<div class="col-5 col-md-4">
						<div class="icon-big text-center icon-warning">
							<i class="nc-icon nc-vector text-danger"></i>
						</div>
					</div>
					<div class="col-7 col-md-8">
						<div class="numbers">
							<p class="card-category">Errors</p>
							<p class="card-title">23
							<p>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer ">
				<hr>
				<div class="stats">
					<i class="fa fa-clock-o"></i> In the last hour
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6 col-sm-6">
		<div class="card card-stats">
			<div class="card-body ">
				<div class="row">
					<div class="col-5 col-md-4">
						<div class="icon-big text-center icon-warning">
							<i class="nc-icon nc-favourite-28 text-primary"></i>
						</div>
					</div>
					<div class="col-7 col-md-8">
						<div class="numbers">
							<p class="card-category">Followers</p>
							<p class="card-title">+45K
							<p>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer ">
				<hr>
				<div class="stats">
					<i class="fa fa-refresh"></i> Update now
				</div>
			</div>
		</div>
	</div>
</div>