<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="java.util.ArrayList" %>
<%@ page import = "edu.ucam.classes.*" %>
<%@ page import = "edu.ucam.servlets.*" %>
<%@ page import = "edu.ucam.database.*" %>

<!DOCTYPE html>
<html lang="es">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Rafura - Error</title>
		
		<!-- CSS -->
		<link href="../css/reset.css" rel="stylesheet" type="text/css" />
		<link href="../css/liquid.css" rel="stylesheet" type="text/css" />
		<link href="../css/navigation_top_bar.css" rel="stylesheet" type="text/css" />
		<link href="../css/loginPopup.css" rel="stylesheet" type="text/css" />
		
	</head>

	<body>
	
		<%
			User user = (User)request.getSession().getAttribute(User.USER_PARAM);
		%>
		
		<header>
			<hgroup>
				<h1>Insercion</h1>
				<h2>Panel de insercion de datos del administrador</h2>
			</hgroup>
		</header>


		<nav id = "horizontal-top-bar">
			<ul id = "horizontal-top-bar-general">
				<li><a href="../index.jsp?<%=User.USER_PARAM%>=<%=user%>" title="">Catalogo</a></li>
				<li><a href="insertion.jsp?<%=User.USER_PARAM%>=<%=user%>" title="">Insertar</a></li>
				<li><a href="#" title="">Contacto</a></li>
			</ul>
			<ul id = "login-shoppingbasket-btn">
				<li><a href="html_jsp/login.jsp" title="">
					<%
						if (user != null){
							out.println(user.getUsername());
						}
						else{
							out.println("Login");
						}		
					%></a>
					<%if (user != null){%>
					<form action="<%= request.getContextPath()%>/Controller" method="POST">
						<input type="hidden" name="<%= Controller.PARAM_ACTION_ID %>" value="<%=ActionLogout.ACTION%>">
						<input type = "submit" value = "Salir">
					</form>
					<%}%>
					
				</li>
					
			</ul>
		</nav>

		<aside>
			
			<nav>
				<h3>Oros ejercicios</h3>
				<ul>
					<li><a href="#" title="#">Lorem ipsum</a></li>
					<li><a href="#" title="#">Dolor sit amet</a></li>
					<li><a href="#" title="#">Consectetur adipisicing</a></li>
				</ul>
			</nav>
			
			
			<article>
				<h4>Para recordar!</h4>
				<p>Tenemos una lista de todos los tags utilizables en HTML5 en la web <a href="http://www.w3schools.com/html5/html5_reference.asp" title="#">w3schools</a></p>
			
			</article>
			
			
			<article><h4>Documentaciï¿½n CSS3</h4>
				<p>En este ejercicio se ha utilizado un poco de CSS3:</p>
				<ul>
					<li>En los degradados del header y footer <a href="http://gradients.glrzad.com/" title="#">(Documentaciï¿½n)</a></li>
					<li>En las sombras del body <a href="http://www.css3.info/preview/box-shadow/" title="#">(Documentaciï¿½n)</a></li>
					<li>En el texto del header <a href="http://www.w3schools.com/css3/css3_pr_text-shadow.asp" title="#">(Documentaciï¿½n)</a></li>
				</ul>
				
			</article>
			
			<form action="<%= request.getContextPath() %>/ActionLogin" method="post" id="user">          <!-- insertar usuario -->
				<br><br>
				<input type="submit" value="Volver">
			</form>
			
		</aside>
	
	
		<section>
			<%
			if((user.getUsername()).equals("admin")){
			%>
			
			<article id = "insert-user" class = "content">
				<form action = "<%=request.getContextPath()%>/Controller" method="post" id="user">          <!-- insertar producto -->
					<h2>Insertar Usuario</h2>
					Username: 
					<input type = "text" name = "<%=User.USER_USERNAME_PARAM%>" required><br><br>
					Email: 
					<input type="text" name = "<%=User.USER_EMAIL_PARAM%>" required><br><br>
					Contrasena: 
					<input type = "text" name = "<%=User.USER_PASSWORD_PARAM%>" required><br><br>
					Biography
					<input type = "text" name = "<%=User.USER_BIOGRAPHY_PARAM%>" required><br><br>
					Address: 
					<input type = "text" name = "<%=User.USER_ADDRESS_PARAM%>" required><br><br>
					
					<input type = "hidden" name = "<%=Controller.PARAM_ACTION_ID %>" value = "<%=ActionInsertion.PARAM_INSERT%>">
					<input type = "hidden" name = "<%=ActionInsertion.PARAM_INSERT%>" value = "<%=ActionInsertion.PARAM_INSERT_USER%>"/>
					<input type = "submit" value = "Insertar"><br><br>
				</form>
			</article>
			
			
			<article id = "insert-product" class = "content">
				<form action="<%=request.getContextPath()%>/Controller" method="post" id="product">          <!-- insertar producto -->
					<h2>Insertar Producto</h2>
					Nombre
					<input type="text" name="<%=Product.PRODUCT_PARAM_NAME%>" required><br><br>
					Marca Registrada
					<input type="text" name="<%=Product.PRODUCT_TRADEMARK_PARAM%>" required><br><br>
					Modelo
					<input type="text" name="<%=Product.PRODUCT_MODEL_PARAM%>" required><br><br>
					Descripcion
					<input type="text" name="<%=Product.PRODUCT_DESCRIPTION_PARAM%>" required><br><br>
					Precio
					<input type="text" name="<%=Product.PRODUCT_PRICE_PARAM%>" required><br><br>
					
					<input type="hidden" name="<%= Controller.PARAM_ACTION_ID %>" value="<%=ActionInsertion.PARAM_INSERT%>"> 
					<input type = "hidden" name = "<%=ActionInsertion.PARAM_INSERT%>" value = "<%=ActionInsertion.PARAM_INSERT_PRODUCT%>"/>
					<input type="submit" value="Insertar"><br><br>
				</form>
			</article>
			
			
			<article id = "insert-vote" class = "content">
				<form action="<%=request.getContextPath()%>/Controller" method="post" id="vote">          <!-- insertar voto -->
					<h2>Insertar Voto</h2>
					Evaluación
					<input type="text" name="<%=Vote.VOTE_ASSESSMENT_PARAM%>" required><br><br>
					Id del Usuario
					<input type="text" name="<%=Vote.VOTE_USER_PARAM%>" required><br><br>
					Id del Producto
					<input type="text" name="<%=Vote.VOTE_PRODUCT_PARAM%>" required><br><br>
					Fecha
					<input type="date" name="<%=Vote.VOTE_DATE_PARAM%>" required><br><br>
					
					<input type="hidden" name="<%= Controller.PARAM_ACTION_ID %>" value="<%=ActionInsertion.PARAM_INSERT%>">
					<input type = "hidden" name = "<%=ActionInsertion.PARAM_INSERT%>" value = "<%=ActionInsertion.PARAM_INSERT_VOTE%>"/>
					<input type="submit" value="Insertar"><br><br>
				</form>
			</article>
		
			<article id = "insert-comment" class = "content">
				<form action="<%=request.getContextPath()%>/Controller" method="post" id="comment">          <!-- insertar comentario -->
					<h2>Insertar Comentario</h2>
					Resumen / Título: 
					<input type="text" name="<%=Comment.COMMENT_RESUME_PARAM%>" required><br><br>
					Contenido: 
					<input type="text" name="<%=Comment.COMMENT_CONTENT_PARAM%>" required><br><br>
					VotoId: 
					<input type="text" name="<%=Comment.COMMENT_VOTE_ID_PARAM%>" required><br><br>
					
					<input type="hidden" name="<%= Controller.PARAM_ACTION_ID %>" value="<%=ActionInsertion.PARAM_INSERT%>">
					<input type = "hidden" name = "<%=ActionInsertion.PARAM_INSERT%>" value = "<%=ActionInsertion.PARAM_INSERT_COMMENT%>"/>
					<input type="submit" value="Insertar"><br><br>
				</form>
			</article>
		
		<%}
		else{%>
			Usuario sin PERMISO.
		<%}%>
		</section>
		
		<footer>
			<p>Fin del ejercicio</p>
		</footer>
	</body>
</html>