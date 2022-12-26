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
		<div id="navbar-header">
			<%@ include file="NavbarNoAcess.jsp" %>
		</div>
		
		<!--Main-->
		<div id = "main">
			  <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel" >
			    <div class="carousel-inner">
			      <div class="carousel-item active">
			        <img src="Resource/Img/EX1.png" class="d-block w-100" alt="2LH-BENF�CIOS">
			      </div>
			      <div class="carousel-item">
			        <img src="Resource/Img/EX4.png" class="d-block w-100" alt="2LH-MOTIVA��O">
			      </div>
			      <div class="carousel-item">
			        <img src="Resource/Img/EX6.png" class="d-block w-100" alt="2LH-INOVA��O">
			      </div>
			    </div>
			  </div>
		</div>
		<!--Main--> 
		
		<!--Apresenta��o-->
    	<div id="2LH-SOBRE">
     		<center> <img src="Resource/Img/EIYOU.png" style="padding-top: 15px;" width="350"  class = 'img-fluid'></center>
    	</div>
    	<div id ="text">
      		<center>
       		 	<p><i>A 2LH - Long Life ! Health � a melhor plataforma, sem retri��es de idade, para voc� melhorar sua sa�de e aprimorar seu bem estar. Trazendo dicas, treinos para diversos n�veis e at� acesso com especialistas em tempo real. Queremos dar aos nossos usu�rios a melhor experi�ncia, e um detalhe sem sair de casa!! 
        	  	� poss�vel acessar a 2LH de qualquer lugar e a qualquer hora, ficou interessado ?? <br><a href="Cadastro.jsp" style="color : #002260"><b>Fa�a seu cadastro e come�e uma grande mudan�a em sua vida.</b></a>
        		</i></p>
        		
        		<img src="Resource/Img/publi.png" width="1050"  style="padding-top: 10px;" class = 'img-fluid'>
      		</center>
    	</div>
		<!--Apresenta��o-->
		
		<!-- News -->
		<div id="news">
				<%@ include file="News2LH.jsp" %>
			</div>
		<!-- News -->	
		
		<%@ include file="Footer.jsp" %>
	</body>
</html>