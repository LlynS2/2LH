<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>2LH - IMC</title>
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
				          <a class="nav-link active" aria-current="page" href="IMCADD2.jsp"><i style="color : white"><b>Adicionar IMC</b></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="imcServlet?acao=listar"><i style="color : white"><b>Histórico do IMC</b></i></a>
				        </li>
				      </ul>
				      &nbsp; &nbsp; &nbsp; &nbsp; 
				      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
		  				<button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="button">
		  					<a href="Progresso.jsp" style="text-decoration : none;">
		  					<b style="color : white;">Voltar</b>
		  					</a>
		  				</button>
					</div>
		    	</div>
		  	</div>
		</nav>
	</div>
<!-- NAVBAR -->		

<!-- FORMULÁRIO -->
	
	<div id="general" class="container" style="padding-top : 85px">
          
          <div class="col-md-8 order-md-1" >

            <div>
                <h1><i>Adicionar IMC</i></h1>
            </div>
                        
            <c:if test="${not empty msg }"> 
            <div class="alert alert-success">${msg}</div> 
            
            </c:if> <c:if test="${not empty erro }"> 
            <div class="alert alert-danger">${erro}</div> 
            
            </c:if>          
            
            <form action="imcServlet" method="post" class="row g-3"> 
            <input type="hidden" value="cadastrar" name="acao">
            
            <!-- IDCAD -->
            <div class="col-md-6 mb-3"> 
            	<label for="email">Email</label> 
            	<input name="email" id="email" class="form-control">  
            </div>     
            <!-- IDCAD -->
            
            <div></div> 
	
			<div class="col-md-3">
		       <label for="peso" class="form-label">Peso</label>
		       <input type="text" autocomplete="off" class="form-control" id="peso" name="peso" >
		   </div>            
		
		    <div class="col-md-3 mb-3" >
		        <label for="altura" class="form-label">Altura</label>
		        <input type="text" autocomplete="off" class="form-control" id="altura" name="altura">
		    </div>
		    
		    <div></div>
		    
		    <c:if test="${not empty msgImc }"> 
            <div class="alert alert-success" style="border-color : white; color : white ; background-color : transparent">${msgImc}</div> 
            </c:if>
	
			<div>
		    	<input style="background-color : transparent; border-color : white; color: white" type="submit" value="Adicionar" class="btn btn-primary">
		    </div>
		    
		</form>
	</div>
</div>	
<!-- FORMULÁRIO -->	    
    	
	<%@ include file="Footer.jsp" %>
	</body>
</html>