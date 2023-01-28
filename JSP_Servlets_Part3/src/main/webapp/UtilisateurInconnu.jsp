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
	
	<p>
		<a href="/TP3_JSP_Servlets_Partie3/ServletControleur?idEcran=2">Retour à l'écran d'accueil</a>
	</p>

</body>
</html>