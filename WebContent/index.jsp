<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="<%= request.getContextPath() %>/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="<%= request.getContextPath() %>/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Curso jsp
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="<%= request.getContextPath() %>/assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<%= request.getContextPath() %>/assets/demo/demo.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="css/stilo.css">
</head>

<body class="">
  <div class="wrapper ">
    
      <div class="content"> 
        <div class="row">
          <div class="col-md-12">
          
            <form method="post" action="ServletLogin">
            
            <input type="hidden" value="<%= request.getParameter("url") %>" name="url">
            <div class="card ">
              <div class="card-header ">
                <h5 class="card-title">Sistema Curso JSP</h5>
              </div>

              <div class="card-body ">
                <div >
                    <div class="col-md-6">
                      <div class="form-group">
                        <label>Login</label>
                        <input type="email" class="form-control"  name="email" id="email" required="required"> 
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-group">
                        <label>Senha</label>
                        <input type="password" class="form-control" name="senha" id="senha" required="required">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-success btn-round">Logar</button>
                    </div>
                    
                  </div>
                  
                 <div class="auth-option text-center pt-5">Ainda não tem conta ?   <a class="text-link" href="" >Cadastre-se</a>.</div>
            </div>
          </div>
        </div>
        
        </form>
              
        <h3>${msg }</h3>
        </div>
        </div>
     
        </div> 
  <!--   Core JS Files   -->
  <script src="<%= request.getContextPath() %>/assets/js/core/jquery.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/js/core/popper.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/js/core/bootstrap.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="<%= request.getContextPath() %>/assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="<%= request.getContextPath() %>/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="<%= request.getContextPath() %>/assets/js/paper-dashboard.min.js?v=2.0.1" type="text/javascript"></script><!-- Paper Dashboard DEMO methods, don't include it in your project! -->
  <script src="<%= request.getContextPath() %>/assets/demo/demo.js"></script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
      demo.initChartsPages();
    });
  </script>
</body>

</html>
      
    
<!--  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<center style="margin-top: 180px">
		<h1>Login</h1>

	</center>

	<div align="center" >

		<form action="ServletLogin" method="post">
		
		 <input type="hidden" value="<%= request.getParameter("url") %>" name="url"">

			<table border="1" cellpadding="5">

				<tr>
					<th>Login:</th>
					<td><input type="email" name="email" id = "email" size="45"  /></td>
				</tr>
				
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" id="senha" size="45" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Entrar" /></td>
				</tr>

			</table>

		</form>
        
        <h4>${msg }</h4>
        
	</div>

</body>

</body>
</html>
-->