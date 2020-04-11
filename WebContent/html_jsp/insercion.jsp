<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*" import="edu.ucam.classes.*"
    import="edu.ucam.database" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../css/cadastro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<header>
		<h1>Insercion</h1>
	</header>
	<section>
		<%
			User user = (User)request.getSession().getAttribute(User.USER_PARAM);
			if((user.getUsername()).equals("admin")){
		%>
			<article>
				<form action="<%= request.getContextPath() %>/Insercion" method="post" id="product">          <!-- insertar producto -->
					<h2>Cadastro Producto</h2>
					Nombre
					<input type="text" name="name" required><br><br>
					Marca Registrada
					<input type="text" name="trademark" required><br><br>
					Modelo
					<input type="text" name="model" required><br><br>
					Descripcion
					<input type="text" name="description" required><br><br>
					Precio
					<input type="text" name="price" required><br><br>
					<% request.setAttribute("tipoInsercion", "2"); %>
					<input type="submit" value="Cadastrar">
				</form>
			</article>
		<%}%>
		<article>
			<form action="<%= request.getContextPath() %>/Insercion" method="post" id="vote">          <!-- insertar voto -->
				<h2>Cadastro Voto</h2>
				Evaluación
				<input type="text" name="assessment" required><br><br>
				Id del Usuario
				<input type="text" name="userId" required><br><br>
				Id del Producto
				<input type="text" name="productId" required><br><br>
				Fecha
				<input type="date" name="date" required><br><br>
				<% request.setAttribute("tipoInsercion", "3"); %>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<article>
			<form action="<%= request.getContextPath() %>/Insercion" method="post" id="comment">          <!-- insertar comentario -->
				<h2>Cadastro Comentario</h2>
				Contenido
				<input type="text" name="content" required><br><br>
				Resumo
				<input type="text" name="resume" required><br><br>
				VotoId
				<input type="text" name="vote" required><br><br>
				<% request.setAttribute("tipoInsercion", "4"); %>
				<input type="submit" value="Cadastrar">
			</form>
		</article>
		<aside>
			<form action="<%= request.getContextPath() %>/ActionLogin" method="post" id="user">          <!-- insertar usuario -->
				<br><br>
				<input type="submit" value="Volver">
			</form>
		</aside>
	</section>
</body>
</html>