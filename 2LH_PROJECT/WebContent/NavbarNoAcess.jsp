<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>2LH - LONG LIFE! HEALTH</title>
		<%@ include file="Header.jsp" %>
	</head>
	
	<!-- Será mostrado para os visitantes, ou para os usuários que ainda não se logaram -->
	
	<body>
			<nav style="background-color : rgb(0, 34, 96);box-shadow: 2px 5px 5px rgba(0, 34, 96, 0.418);" class="navbar navbar-light">
			
				<div class="container-fluid">
				
					<a class="navbar-brand" href="#">
	  					<img src="Resource/Img/Imagem3.png" alt="" width="100" height="85" class="d-inline-block align-text-top">
					</a>
					
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
	  				<button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
	  					<a href="Cadastro.jsp" style="text-decoration : none;">
	  						<b style="color : white;">
	  						Cadastrar | Logar
	  						</b>
	  					</a>
	  				</button>
				</div>
				
			  </div>	
			</nav>
	
		<%@ include file="Footer.jsp" %>
	</body>
</html>