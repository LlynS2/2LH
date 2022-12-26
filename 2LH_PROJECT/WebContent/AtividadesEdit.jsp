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
				          <a class="nav-link active" aria-current="page" href="AtividadesADD.jsp"><i style="color : white"><b>Adicionar Atividade</b></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="atividadesServlet?acao=listar"><i style="color : white"><b>Histórico de atividades</b></i></a>
				        </li>
				      </ul>
				      &nbsp; &nbsp; &nbsp; &nbsp; 
				      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		  				<button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
		  					<a href="atividadesServlet?acao=listar" style="text-decoration : none;">
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
		
			<h1><i>Editar Atividade</i></h1>
			
			<form action="atividadesServlet" method="post" class="row g-3">
				<input type="hidden" value="editar" name="acao">
				<input type="hidden" value="${atividadeEdit.idAtiv}" name="codigo">
							
				<div class="col-md-8">
		       <label for="nomeAtiv" class="form-label">Nome Atividade</label>
		       <input type="text" autocomplete="off" class="form-control" id="nomeAtiv" name="nomeAtiv" value="${atividadeEdit.tipoDeTreino}" >
		   </div>  
		   
		   <div></div>        
		
		    <div class="col-md-4 mb-3" >
		        <label for="diaP" class="form-label">Dias Praticados</label>
		        <input type="text" autocomplete="off" class="form-control" id="diaP" name="diaP" value="${atividadeEdit.diasPraticados}">
		    </div>
		
		    <div class="col-md-4 mb-3">
		        <label for="caloriasPer" class="form-label">Calorias perdidas</label>
		        <input type="text" class="form-control" id="caloriasPer" name="caloriasPer" value="${atividadeEdit.caloriasPerdidas}" >
		    </div><br>
		    
		    <div class="col-md-8">
		        <label for="preArt">Pressão Arterial</label>
		        <input type="text" class="form-control" id="preArt" name="preArt" value="${atividadeEdit.pressaoArterial}">
		    </div>
		    
		    <div class="col-md-8">
		        <label for="nivelAtiv">Nível da atividade</label>
		        <select class="form-select" id="nivelAtiv" name="nivelAtiv" value="${atividadeEdit.nivelDeTreino }">
      				<option selected>${atividadeEdit.nivelDeTreino}</option>
      				<option>Iniciante</option>
      				<option>Intermediário</option>
      				<option>Avançado</option>
    			</select>
		    </div>
		    
		    <div>
		    	<button type="submit" value="Salvar" class="btn btn-primary" style="background-color : #002260; border-color : white"><b>Salvar</b></button>
				<a href="atividadesServlet?acao=listar" class="btn btn-danger" style="background-color : #9f9e9e; border-color : #9f9e9e;" ><b>Cancelar</b></a>
		    </div>
			</form>
			
		</div>
	</div>	
<!-- EDIÇÃO -->	
		<%@ include file="Footer.jsp" %>
	</body>
</html>