<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>2LH - EDITAR ATIVIDADE</title>
	<%@ include file="Header.jsp" %>
	</head>
	
		<body id="body">
		
		<!-- NAVBAR -->		

	<div id="NavbarAtividades">
		<nav class="navbar navbar-expand-lg navbar-light" style="background-color : rgb(0, 34, 96);box-shadow: 2px 5px 5px #081c40;">
		  		<div class="container-fluid">
		  		
				    <a class="navbar-brand" href="#">
					  	<img src="Resource/Img/Imagem3.png" alt="" width="100" height="85" class="d-inline-block align-text-top">
					</a>
					
					&nbsp; &nbsp; &nbsp; &nbsp; 
				    <button style="background-color : white" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
		    
		    	<div class="collapse navbar-collapse" id="navbarNav">
				      <ul class="navbar-nav">
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="ConDeAlimentoADD.jsp"><i style="color : white"><b>Adicionar Consumo de Alimento</b></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="consumoDeAlimentoServlet?acao=listar"><i style="color : white"><b>Histórico do Consumo de  Alimentos</b></i></a>
				        </li>
				      </ul>
				      &nbsp; &nbsp; &nbsp; &nbsp; 
				      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		  				<button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
		  					<a href="consumoDeAlimentoServlet?acao=listar" style="text-decoration : none;">
		  					<b style="color : white;">Voltar</b>
		  					</a>
		  				</button>
					</div>
		    	</div>
		  	</div>
		</nav>
	</div>

<!-- NAVBAR -->	

<!-- EDIÇÃO -->
		
		<div id="general" class="container" style="padding-top : 85px">
          
          <div class="col-md-7 order-md-2" >
		
			<h1><i>Editar Alimento</i></h1>
			
			<form action="consumoDeAlimentoServlet" method="post" class="row g-3">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${conAlimentoEdit.idConAli}" name="codigo">
							
				<div class="col-md-4">
		       <label for="nomeAli" class="form-label">Nome Atividade</label>
		       <input type="text" autocomplete="off" class="form-control" id="nomeAli" name="nomeAli" value="${conAlimentoEdit.nomeAlimento}" >
		   </div>       
		
		    <div class="col-md-4 mb-3" >
		        <label for="calorias" class="form-label">Calorias</label>
		        <input type="text" autocomplete="off" class="form-control" id="calorias" name="calorias" value="${conAlimentoEdit.calorias}">
		    </div>
		    
		    <div>
		    	<button type="submit" value="Salvar" class="btn btn-primary" style="background-color : #002260; border-color : white"><b>Salvar</b></button>
				<a href="consumoDeAlimentoServlet?acao=listar" class="btn btn-danger" style="background-color : #9f9e9e; border-color : #9f9e9e;" ><b>Cancelar</b></a>
		    </div>
			</form>
			
		</div>
	</div>	
<!-- EDIÇÃO -->	
		<%@ include file="Footer.jsp" %>
	</body>
</html>