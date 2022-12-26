<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>2LH - HOME</title>
	<%@ include file="Header.jsp" %>
	</head>
	
	<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color : rgb(0, 34, 96);box-shadow: 2px 5px 5px rgba(0, 34, 96, 0.418);">
	  
		  <div class="container-fluid">
		    
		    <a class="navbar-brand" href="IndexAcess.jsp"><img src="Resource/Img/Imagem3.png" alt="2LH" width="100" height="85" class="d-inline-block align-text-top"></a>
			    
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
		      
		      <!-- VALIDAÇÃO DO USUÁRIO -->
			<div style="padding-right : 15px">
				<c:if test="${not empty msg }"><b style="padding-top : 5px; color : white"><i>Bora para mais um dia,<b>${msg}</b>?!</i></b></c:if>
			</div>
			<!-- VALIDAÇÃO DO USUÁRIO -->
		      
		      <button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
					<a href="IndexNoAcess.jsp" style="text-decoration : none;">
					<b style="color : white;">Sair</b>
					</a>
		  	  </button>
		    </div>
		  </div>
	</nav>
	<!-- NAVBAR -->
	
	
		<div class="container" >
	
		<!-- NOVIDADES DO APP -->
		<div  id="2LH-SOBRE">
     		<img src="Resource/Img/Novidades.png" style="padding-top: 15px;" width="230"  class = 'img-fluid'>
    	</div>
    	
			<div class="row" style="padding-top : 25px;">
			  
			  <div class="col-sm-6">
			    <div class="card" style="border: 1px solid #002260;background-color : #002260;">
			      <div class="card-body">
			        <h5 class="card-title" style="color : white " ><b><i>EXTRA!! EXTRA !!</i></b></h5>
			        <p class="card-text" style="color : white " ><i>Novos treinos foram adicionados, dê uma olhada nas <a href="Treino.jsp" style="color : white " ><b>sugestões</b></a></i></p>
			      </div>
			    </div>
			  </div>
			  
			  <div class="col-sm-6" >
			    <div class="card" style="border: 1px solid #002260;background-color : #002260;">
			      <div class="card-body">
			        <h5 class="card-title" style="color : white "><b><i>PROGRESSO!!!</i></b></h5>
			        <p class="card-text" style="color : white " ><i>Chegou o <a href="Progresso.jsp" style="color : white "><b>progresso</b></a>! Registre suas <a href="AtividadesADD.jsp" style="color : white" ><b>atividades</b></a>, <a href="IMCADD2.jsp" style="color : white "><b>IMC</b></a> e <a href="ConDeAlimentoADD.jsp" style="color : white "><b>Consumo de alimentos</b></a>.</i></p>
			      </div>
			    </div>
			  </div>
			</div>
		<!-- NOVIDADES DO APP -->	
		
		<!-- NEWS -->
		<div id="news">
				<%@ include file="News2LHAcess.jsp" %>
			</div>
		<!-- NEWS -->
	</div>

	<%@ include file="Footer.jsp" %>
	</body>
</html>