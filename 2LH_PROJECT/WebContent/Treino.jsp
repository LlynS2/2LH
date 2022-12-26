<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>2LH - TREINO</title>
		<%@ include file="Header.jsp" %>
	</head>
		
	<body>
		<%@ include file="NavbarAcess.jsp" %>
		
		<div id="sugestoes">
     		<center> <img src="Resource/Img/Sugestao1.png" style="padding-top: 15px;" width="550"  class = 'img-fluid'></center>
    	</div>
		
		
		<div id="videos-list">
			<%@ include file="Videos.jsp" %>
		</div>

		<%@ include file="Footer.jsp" %>
	</body>
</html>