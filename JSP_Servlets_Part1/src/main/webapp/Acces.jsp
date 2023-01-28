<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accès</title>
</head>
<body>

	<% 	
		String username = request.getParameter("username");	
	%>

	<p>Merci <%= username %> ! </p>
	<p>Vous êtes la bienvenue dans votre espace.</p>

</body>
</html>