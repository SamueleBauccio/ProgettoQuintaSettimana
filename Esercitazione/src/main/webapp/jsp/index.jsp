<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" import="it.epicode.controller.Controller"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body>
	<h4>
		<em> seleziona l'operazione </em>
	</h4>
	<nav>
		<ul>
			<li><a href="listaFornitori.do"> Lista Fornitori</a></li>
			<li><a href="listaProdotti.do" disabled="disabled"> ListaProdotti (disabilitato)</a></li>
		</ul>
	</nav>

</body>
</html>