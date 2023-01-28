<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mot de passe incorrect</title>
</head>
<body>

	<% 	
		String username = request.getParameter("username");	
	%>

	<p>Désolé <%= username %> ! </p>
	<p>Le mot de passe que vous avez saisi est incorrect.</p>

</body>
</html>