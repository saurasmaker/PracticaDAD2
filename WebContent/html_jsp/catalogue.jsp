<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="java.util.ArrayList" %>
<%@ page import = "edu.ucam.classes.*" %>
<%@ page import = "edu.ucam.servlets.Controller" %>
<%@ page import = "edu.ucam.database.LoadDataReferences" %>
<%@ page import = "edu.ucam.database.LoadDataByReference" %>

<!DOCTYPE html>
<html lang="es">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Rafura - Error</title>
		
		<!-- CSS -->
		<link href="css/reset.css" rel="stylesheet" type="text/css" />
		<link href="css/liquid.css" rel="stylesheet" type="text/css" />
		<link href="css/navigation_top_bar.css" rel="stylesheet" type="text/css" />
		<link href="css/loginPopup.css" rel="stylesheet" type="text/css" />
		
	</head>

	<body>
	
		<%
			User user = (User)request.getSession().getAttribute(User.USER_PARAM);
		%>
		
		<header>
			<hgroup>
				<h1>Ejercicio 1 - HTML5</h1>
				<h2>Maquetaciï¿½n sencilla con HTML5 y algo de CSS3.</h2>
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
						out.println("<ul><li><a name=\"Controller.PARAM_ACTION_ID\" value=\"Controller.PARAM_LOGOUT_ACTION\" id = \"logout\" href=\" + request.getContextPath() + \"/Controller>Salir</a></li></ul>");
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
			
			
			<article><h4>Documentaciï¿½n CSS3</h4>
				<p>En este ejercicio se ha utilizado un poco de CSS3:</p>
				<ul>
					<li>En los degradados del header y footer <a href="http://gradients.glrzad.com/" title="#">(Documentaciï¿½n)</a></li>
					<li>En las sombras del body <a href="http://www.css3.info/preview/box-shadow/" title="#">(Documentaciï¿½n)</a></li>
					<li>En el texto del header <a href="http://www.w3schools.com/css3/css3_pr_text-shadow.asp" title="#">(Documentaciï¿½n)</a></li>
				</ul>
				
			</article>
			
		</aside>



		<section>
		<h1>Catálogo</h1>
				
					
				<% 
				ArrayList<String> productsReferences = new ArrayList<String>();
					
				LoadDataReferences.loadProductsReferences(productsReferences);
					
				for(int i = 0; i < productsReferences.size(); ++i){
					Product p = LoadDataByReference.product(productsReferences.get(i));
				%>
					
				<article class="product">
				<h2><%=p.getName()%></h2>
				<p><%=p.getDescription()%></p>
				<ul>
					<li>Marca: <%=p.getTrademark()%></li>
					<li>Modelo: <%=p.getModel()%></li>
					<li>Precio: </li>
				</ul> 
				
				</article>
					
				<%}%>	
					
	
		</section>

		<footer>
			<p>Fin del ejercicio</p>
		</footer>
		
		
	</body>


</html>