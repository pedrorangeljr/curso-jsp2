<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
  <h1>Mensagem de erro entre em contato com equipe de suporte do sistema</h1>
  <br/>
  <% 
     out.println(request.getAttribute("msg"));
  %>
</body>
</html>