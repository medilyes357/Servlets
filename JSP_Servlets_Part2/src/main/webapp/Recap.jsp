<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String texte1 = request.getParameter("texte1");
		String texte2 = request.getParameter("texte2");
		String texte3 = request.getParameter("texte3");
	
		String username = "";
		
		//Récupération du nom utilisateur à partir de l'attribut "nomUtil" de session
		username = (String)session.getAttribute("nomUtil");
		
		//Récupération du nom utilisateur à partir de l'attribut "nomUtil" de l'objet ServletContext
		//username = (String)application.getAttribute("nomUtil");
		
		//Récupération du nom utilisateur à partir du cookie envoyé par le client
		//Ce cookie qui nous avons déjà créé et envoyé au client
		/*Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("nomUtil")) username = cookie.getValue();
		}*/
	%>

	<p>Merci <%= username %>, voici un récapitulatif sur ce que vous avez saisi:</p>
	<p><%= texte1 %><p>
	<p><%= texte2 %><p>
	<p><%= texte3 %><p>

</body>
</html>