<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro 2LH</title>
		<%@ include file="Header.jsp" %>
	</head>
	
	<body id="body">
	
	<div id="general" class="container" style="padding-top : 100px">
          <!--Cadastro-->
          <div class="col-md-8 order-md-1" >
              <form action="cadastroServlet" method="post" class="row g-3">

                        <div>
                            <h1><i>Cadastre-se</i></h1>
                        </div>
                        
                        <c:if test="${not empty msg }"> <div class="alert alert-success">${msg}<a href="Login.jsp">Login</a> para entrar no app ^^</div> </c:if> 
                        <c:if test="${not empty erro }"> <div class="alert alert-danger">${erro}</div> </c:if>  

                        <div class="col-md-8">
                            <label for="nome" class="form-label">Nome de Usuário</label>
                            <input type="text" autocomplete="off" class="form-control" id="nome" name="nome" name="nome">
                        </div>
                        
                        <div></div>

                        <div class="col-md-4 mb-3" >
                            <label for="email" class="form-label">Email</label>
                            <input type="email" autocomplete="off" class="form-control" id="email" name="email">
                        </div>

                        <div class="col-md-4 mb-3">
                            <label for="senha" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha">
                        </div><br>
                        
                        <div></div>
                        
                        <div class="col-md-8">
                            <label for="dtnasc">Data de Nascimento</label>
                            <input type="date" class="form-control" id="dtnasc" name="dtnasc" placeholder="Ex.: 22/10/2000">
                        </div>

                        <div>
                        <button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="submit">
	  					<b>Cadastrar</b>
	  					</button>
                        </div>

                        <div>
                            <a id="a" href="Login.jsp" style="color : white"><b>Tenho cadastro, quero me logar!!</b></a>
                        </div>

                        </form>
                    </div>
            </div>
		<%@ include file="Footer.jsp" %>
	</body>
</html>