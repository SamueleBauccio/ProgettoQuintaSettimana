<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.epicode.controller.Controller"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Fornitori</title>
</head>
<body>
	<p>Lista di fornitori</p>
	<table>
		<tr>
			<th>Codice Fornitore</th>
			<th>Nome</th>
			<th>Indirizzo</th>
			<th>Citta</th>
			<th></th>
		</tr>
		<c:forEach var="fornitore" items="${CHIAVE_LISTA_FORNITORI}">
			<tr>
				<td>${fornitore.codiceFornitore}</td>
				<td>${fornitore.nomeFornitore}</td>
				<td>${fornitore.indirizzo}</td>
				<td>${fornitore.citta}</td>
				<td>
					<form method="post" action="cancellaFornitore.do">
						<input type="hidden" name="id" value="${fornitore.codiceFornitore }">
						<input type="submit" value="elimina">
					</form>
				</td>
			</tr>
			<br>
		</c:forEach>
	</table>
	<hr>
	<a href="formInserimentoFornitore.do"> Inserisci un nuovo fornitore</a>
</body>
</html>