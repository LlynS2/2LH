<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>2LH - LOGIN</title>
		<%@ include file="Header.jsp" %>
	</head>
	
	<body id="body">
	
	<div id="general" class="container" style="padding-top : 100px">
                    <div class="col-md-8 order-md-1"  class="row g-3">
                    
		<div>
           <h1>Login</h1>
        </div>
		
        <form action="loginServlet" method="post">
	         <div class="col-md-6 ">
	         	<label for="email" class="form-label">Email</label>
	            <input type="text" class="form-control"  id="email" name="email"/><br>
	            
	            <label for="senha" class="form-label"> Senha</label>
	            <input type="password" class="form-control"  id="senha" name="senha"/><br>
	            <div style="padding-bottom : 25px">
	            <button style="background-color : transparent; border-color : white;" class="btn btn-primary me-md-2" type="submit" name="btLogar">Logar</button>
	        	</div>
	         </div>   
        </form>

        <c:if test="${not empty erro }"> <div class="alert alert-danger">${erro}</div> </c:if>  
        
    </div>
 </div>    
		<%@ include file="Footer.jsp" %>
	</body>
</html>