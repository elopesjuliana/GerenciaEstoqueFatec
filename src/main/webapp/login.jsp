<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Gerencia Estoque Login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" media="screen" title="no title">
    <link rel="stylesheet" href="css/vanilla.css" media="screen" title="no title">
    <script src="js/jquery.js" charset="utf-8"></script>
    <script src="js/bootstrap.min.js" charset="utf-8"></script>
</head>
<body class="background-login">
		            	<% session.invalidate(); %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5 col-md-offset-3 login-box" style="background:white;">
				<img class="center-block" width="100" src="imgs/icone-navbar.png" alt="" />
				<form action="ServletLogin" method="post">
					<div class="form-group">
						<label for="login">Login</label>
    					<input type="email" required name="login" class="form-control" id="login" placeholder="Insira seu email:">
					</div>
					<div class="form-group">
						<label for="senha">Senha:</label>
						<input type="password" required name="senha" class="form-control" id="senha" placeholder="Insira sua senha:">
						<p class="help-block">Esqueci minha senha.</p>						
					</div>
					
					<button class="btn btn-primary btn-block" type="submit">Acessar</button>
					
				</form>
				
				
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<table style="background:white;" class="table table-bordered">
				  <caption>Acessos para o sistema:</caption>	
				  <tr>
				    <th>Nome:</th>
				    <th>Email:</th>
				    <th>Senha:</th>
				  </tr>
				  <tr>
				    <td>juliana</td>
				    <td>ju@email.com</td>
 				    <td>1234</td>
				  </tr>
				  <tr>
				    <td>Teste</td>
				    <td>teste@teste.com</td>
				    <td>1234</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>


</body>
</html>