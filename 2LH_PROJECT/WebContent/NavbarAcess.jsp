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
	
	<body>
	
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color : rgb(0, 34, 96);box-shadow: 2px 5px 5px rgba(0, 34, 96, 0.418);">
	  
	  <div class="container-fluid">
	    
	    <a class="navbar-brand" href="IndexAcess.jsp"><img src="Resource/Img/Imagem3.png" alt="" width="100" height="85" class="d-inline-block align-text-top"></a>
		    
		    <button style="background-color : white; border-color : white;"class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
	   
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      
	      	<li class="nav-item">
	          <a class="nav-link" href="IndexAcess.jsp" style="color : white"><b><i>Home</i></b></a>
	        </li>
	      
	        <li class="nav-item" >
	          <a class="nav-link active" aria-current="page" href="Progresso.jsp" style="color : white"><b><i>Progresso</i></b></a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="Treino.jsp" style="color : white"><b><i>Treino</i></b></a>
	        </li>
	
	      </ul>
	      
	      <button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
				<a href="IndexNoAcess.jsp" style="text-decoration : none;">
				<b style="color : white;">Sair</b>
				</a>
	  	  </button>
	    </div>
	  </div>
</nav>
		<%@ include file="Footer.jsp" %>
	</body>
</html>