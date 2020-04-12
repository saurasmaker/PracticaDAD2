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
		<title>Rafura</title>
		
		<!-- CSS -->
		<link href="css/reset.css" rel="stylesheet" type="text/css" />
		<link href="css/liquid.css" rel="stylesheet" type="text/css" />
		<link href="css/navigation_top_bar.css" rel="stylesheet" type="text/css" />
		<link href="css/loginPopup.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
	
		<% User user = (User)request.getSession().getAttribute(User.USER_PARAM); %>
		
		<header>
			<hgroup>
				<h1>Inicio</h1>
				<h2>Inicio de la pagina web Rafura</h2>
			</hgroup>
		</header>


		<nav id = "horizontal-top-bar">
			
			<ul id = "horizontal-top-bar-general">
				<li><a href="index.jsp?<%=User.USER_PARAM%>=<%=user%>" title="">Catalogo</a></li>
				<li><a href="html_jsp/insercion.jsp?<%=User.USER_PARAM%>=<%=user%>" title="">Insertar</a></li>
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
					<li>En los degradados del header y footer <a href="http://gradients.glrzad.com/" title="#">(Documentacion)</a></li>
					<li>En las sombras del body <a href="http://www.css3.info/preview/box-shadow/" title="#">(Documentacion)</a></li>
					<li>En el texto del header <a href="http://www.w3schools.com/css3/css3_pr_text-shadow.asp" title="#">(Documentacion)</a></li>
				</ul>
				
			</article>
			
		</aside>



		<section>
		<h1>Catálogo</h1>
				
					
				<% 
				ArrayList<String> productsReferences = new ArrayList<String>();
					
				LoadDataReferences.loadProductsReferences(productsReferences, getServletContext().getRealPath("/"));
					
				for(int i = 0; i < productsReferences.size(); ++i){
					Product p = LoadDataByReference.product(productsReferences.get(i), getServletContext().getRealPath("/"));
				%>
					
				<article class="content">
				<h2><%=p.getName()%></h2>
				
				<p>
					<%=p.getDescription()%>
				</p>
				
				<p>
					- Marca: <%=p.getTrademark()%>
					<br/>
					- Modelo: <%=p.getModel()%>
					<br/>
					- Precio: <%=p.getPrice().toString()%> Euro(s)
				</p>
				
				</article>
					
				<%}%>	
					
	
		</section>

		<footer>
			<p>Fin del ejercicio</p>
		</footer>
		
		
	</body>
	
	
</html>