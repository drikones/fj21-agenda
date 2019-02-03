<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,br.com.caelum.jdbc.CRUDContato,br.com.caelum.modelo.Contato, java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos</title>
<style>
td {
	text-align: center;
	padding: 10px;
}
</style>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.CRUDContato" />
	<table colspan=5 border="1">
		<tr>
			<td>id</td>
			<td>nome</td>
			<td>email</td>
			<td>endereco</td>
			<td>dataNascimento</td>
		</tr>
		<c:forEach var="contato" items="${dao.list}" varStatus="id">
			<tr bgcolor="${id.count %2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<c:choose>
					<c:when test="${not empty contato.email}">
						<td><a href="mailto:${contato.email}">${contato.email}</a></td>
					</c:when>
					<c:otherwise>
						<td>E-mail não informado</td>
					</c:otherwise>
				</c:choose>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>