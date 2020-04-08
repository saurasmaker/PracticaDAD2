<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "edu.ucam.classes.*" %>

<!DOCTYPE html>



<html lang="es">
	
	
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Ráfura</title>
		
		<!-- CSS -->
		<link href="css/reset.css" rel="stylesheet" type="text/css" />
		<link href="css/liquid.css" rel="stylesheet" type="text/css" />
		<link href="css/navigation_top_bar.css" rel="stylesheet" type="text/css" />
		<link href="css/loginPopup.css" rel="stylesheet" type="text/css" />
		
		<!-- JAVASCRIPT -->
		<script src="js/loginPopup.js" language="javascript" type="text/javascript"></script>
		
	</head>

	<body>
	
		<%
			User user = (User)request.getSession().getAttribute(User.USER_PARAM);
		%>
		
		<header>
			<hgroup>
				<h1>Ejercicio 1 - HTML5</h1>
				<h2>Maquetaci�n sencilla con HTML5 y algo de CSS3.</h2>
			</hgroup>
		</header>


		<nav id = "horizontal-top-bar">
			<ul id = "horizontal-top-bar-general">
				<li><a href="#" title="">Inicio</a></li>
				<li><a href="#" title="">Noticias</a></li>
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
					<%
					if (user != null){
						out.println("<ul><li><a id = \"logout\" href=" + request.getContextPath() + "/ServletLogout>Salir</a></li></ul>");
					}
					%>
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
			
			
			<article><h4>Documentaci�n CSS3</h4>
				<p>En este ejercicio se ha utilizado un poco de CSS3:</p>
				<ul>
					<li>En los degradados del header y footer <a href="http://gradients.glrzad.com/" title="#">(Documentaci�n)</a></li>
					<li>En las sombras del body <a href="http://www.css3.info/preview/box-shadow/" title="#">(Documentaci�n)</a></li>
					<li>En el texto del header <a href="http://www.w3schools.com/css3/css3_pr_text-shadow.asp" title="#">(Documentaci�n)</a></li>
				</ul>
				
			</article>
			
		</aside>



		<section>
			<article class="content">	<h2>Articulo 1</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
					minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit
					in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
					deserunt mollit anim id est laborum.</p>
			</article>
			
			<article class="content">	<h2>Articulo 2</h2>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since
					the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,
					but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset
					sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</article>
		</section>

		<footer>
			<p>Fin del ejercicio</p>
		</footer>
		
		
	</body>
	
	
</html>