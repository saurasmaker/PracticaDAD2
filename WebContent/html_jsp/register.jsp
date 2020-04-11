<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Página Adiministrador</title>
	
	<link href="../css/cadastro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<header>
		<h1>Cadastro</h1>
	</header>
	<section>
		<article>
			<form action="<%= request.getContextPath() %>/Insercion" method="post" id="user">          <!-- insertar usuario -->
				<h2>Cadastro Usuario</h2>
				Username
				<input type="text" name="username" required><br><br>
				Email
				<input type="email" name="email" required><br><br>
				Contraseña
				<input type="password" name="password" required><br><br>
				Biografía
				<input type="text" name="biografia" required><br><br>
				Direccion
				<input type="text" name="adress" required><br><br>
				<% request.setAttribute("tipoInsercion", "1"); %>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<article>
			<form action="<%= request.getContextPath() %>/ActionLogout" method="post" id="user">    
				<br><br>
				<input type="submit" value="Volver">
			</form>
		</article>
	</section>
</body>
</html>