<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ include file="Header.jsp" %>
	</head>
	
	<body>
	
<!-- NAVBAR -->		

	<div id="NavbarAtividades">
		<nav class="navbar navbar-expand-lg navbar-light" style="background-color : rgb(0, 34, 96);box-shadow: 2px 5px 5px #d7d5d5;">
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
				          <a class="nav-link active" aria-current="page" href="IMCADD2.jsp"><i style="color : white"><b>Adicionar IMC</b></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="imcServlet?acao=listar"><i style="color : white"><b>Histórico do IMC</b></i></a>
				        </li>
				      </ul>
				      &nbsp; &nbsp; &nbsp; &nbsp; 
				      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		  				<button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
		  					<a href="IMCADD2.jsp" style="text-decoration : none;">
		  					<b style="color : white;">Voltar</b>
		  					</a>
		  				</button>
					</div>
		    	</div>
		  	</div>
		</nav>
	</div>

<!-- NAVBAR -->	

<!-- LISTA -->	
	
		<div class="container" style="padding-top : 35px">
			<table class="table table-striped">
			
			<h1>
			<b style="color : #002260;"><i>Histórico do IMC</i></b>
			</h1>
			
			<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
            
            </form>
			
				<tr>
					<th style="color : #002260;">Peso</th>
					<th style="color : #002260;">Altura</th>
					<th style="color : #002260;">Resultado</th>
					<th ></th>
				</tr>
				<c:forEach items="${imcs}" var="imc">
					<tr>
						<td><i>${imc.altura}</i></td>
						<td><i>${imc.peso}</i></td>
						<td><i>${imc.resultado}</i></td>
						
						<td> 
						<form action="imcServlet" method="post"> 
								<input type="hidden" name="acao" value="excluir"> 
								<input type="hidden" name="codigo" id="codigoExcluir"> 
								<button type="submit" class="btn btn-danger" style="background-color : red; border-color : red" onclick="codigoExcluir.value = ${imc.idImc}"><b>Excluir</b></button> 
						</form>
						</td>	
					</tr>
				</c:forEach>
			</table>
		</div>
<!-- LISTA -->	
		
	<%@ include file="Footer.jsp" %>
	</body>
</html>