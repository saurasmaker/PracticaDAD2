<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "edu.ucam.classes.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Página Adiministrador</title>
	
	<link href="../css/cadastro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<header>
		<h1>Administrador</h1>
	</header>
	<section>
		<article>
			<form action="" method="post" id="user">          <!-- insertar usuario -->
				<h2>Cadastro Usuario</h2>
				Username
				<input type="text" name="username" required><br><br>
				Email
				<input type="text" name="email" required><br><br>
				Password
				<input type="text" name="password" required><br><br>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<article>
			<form action="" method="post" id="product">          <!-- insertar producto -->
				<h2>Cadastro Producto</h2>
				Nombre
				<input type="text" name="name" required><br><br>
				Marca Registrada
				<input type="text" name="trademark" required><br><br>
				Modelo
				<input type="text" name="model" required><br><br>
				Descripcion
				<input type="text" name="description" required><br><br>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<article>
			<form action="" method="post" id="vote">          <!-- insertar voto -->
				<h2>Cadastro Voto</h2>
				Evaluación
				<input type="text" name="assessment" required><br><br>
				Id del Usuario
				<input type="text" name="userId" required><br><br>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<article>
			<form action="" method="post" id="comment">          <!-- insertar comentario -->
				<h2>Cadastro Comentario</h2>
				Contenido
				<input type="text" name="content" required><br><br>
				Data
				<input type="date" name="date" required><br><br>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
	</section>
	<footer>
	</footer>
</body>
</html>