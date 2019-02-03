<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="caelum"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contato</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<form action="adicionaContato" method="POST">
		Nome: <input type="text" name="nome" /><br />
	    E-mail: <input type="text" name="email" /><br />
	    Endereço: <input type="text" name="endereco" /><br />
	    Data Nascimento: <caelum:campoData id="dataNascimento"/><br />
	    <input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>