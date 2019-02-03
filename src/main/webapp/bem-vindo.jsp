<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>bem-vindo</title>
</head>
<body>


	<h1>Primeira página do projeto fj21-agenda</h1>
	<%
		String mensagem = "Bem vindo!";
	%>
	<%
		out.println(mensagem);
	%>
	<br />
	<%
		String desenvolvido = "Desenvolvido por Adriano";
	%>
	<%=desenvolvido%>
	<% System.out.println("Tudo foi desenvolvido"); %>
</body>
</html>
