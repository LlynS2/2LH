<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>2LH - PROGRESSO</title>
		<%@ include file="Header.jsp" %>
	</head>
	
	<body>
		<div id="navbar-header">
			<%@ include file="NavbarAcess.jsp" %>
		</div>
		
		<div class="container" style="padding-top : 30px">
		
		<div id="img-fundo" style="position : absolute; padding-left : 600px; padding-top : 60px">
			<img src="Resource/Img/TreinoFundo3.jpg" class="img-fluid rounded-start" alt="Atividades">
		</div>
			
			<div class="card mb-3" style="max-width: 540px;">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <img src="Resource/Img/Treino1.jpg" style="padding-top : 20px"class="img-fluid rounded-start" alt="Atividades">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title"><b style="color : #002260 "><i>Atividades</i></b></h5>
				        <p class="card-text"><i>Fique ligado em sua rotina, registre suas atividades para melhorar seu desempenho. Você consegue!!</i></p>
				        <a href="AtividadesADD.jsp" class="btn btn-primary">Ir para Atividades</a>
				      </div>
				    </div>
				  </div>
			</div>
			
			<div class="card mb-3" style="max-width: 540px;">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <img src="Resource/Img/alimento1.png" style="padding-top : 20px"class="img-fluid rounded-start" alt="Atividades">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title"><b style="color : #002260 "><i>Consumo de Alimentos</i></b></h5>
				        <p class="card-text"><i>Tenha o controle da sua dieta, registre os alimentos consumidos no seu dia. Organização é tudo!!</i></p>
				        <a href="ConDeAlimentoADD.jsp" class="btn btn-primary">Ir para Consumo de Alimentos</a>
				      </div>
				    </div>
				  </div>
			</div>
			
			<div class="card mb-3" style="max-width: 540px;">
				  <div class="row g-0">
				    <div class="col-md-4" style="padding-top : 30px; padding-left : 20px">
				      <img src="Resource/Img/IMC2.png" width="125" height="125" class="img-fluid rounded-start" alt="Atividades">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title"><b style="color : #002260 "><i>IMC</i></b></h5>
				        <p class="card-text"><i>Atualize seu progresso, calcule e registre seu IMC. Qualquer mudança, mesmo pequena, já é uma grande conquista!!</i></p>
				        <a href="IMCADD2.jsp" class="btn btn-primary">Ir para IMC</a>
				      </div>
				    </div>
				  </div>
			</div>
			
		</div>
		
		<style>
		.card{
			border: 1px solid #002260;
		}
		
		.btn-primary{
			background-color: #002260;
    		border-color: #002260;
		}
		</style>
		
		
		<%@ include file="Footer.jsp" %>
	</body>
</html>