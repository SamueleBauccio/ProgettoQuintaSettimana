<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.epicode.controller.Controller"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci il Fornitore</title>
</head>
<body>
	<form method="post" action="aggiungiFornitore.do">
	<label>Inserisci il codice</label>
		<input type="number" name="codiceFornitore">
	<label>Inserisci il nome</label>	
		<input type="text" name="nomeFornitore"><br>
	<label>Inserisci l' indirizzo</label>	
		<input type="text" name="indirizzo">
	<label>Inserisci la citta</label>	
		<input type="text" name="citta">
	<input type="submit" value="inserisci fornitore">
	</form>
</body>
</html>