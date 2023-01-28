<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisateur Inconnu</title>
</head>
<body>

	<% 	
		String username = request.getParameter("username");	
	%>

	<p>Désolé <%= username %> ! </p>
	<p>Aucun username ne correspond à celui que vous avez saisi.</p>

</body>
</html>