<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "edu.ucam.classes.*" %>
<%@ page import = "edu.ucam.database.*" %>
<%@ page import = "java.util.ArrayList" %>
    
<!doctype html>
<html lang="es">
    
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
        <title>RAFAURA</title>
    </head>
    
    <body style = "background-color: lightgray; ">
        <div class = "general container" style = "background-color: white; padding:0;">

			<%			
			if((User)request.getSession().getAttribute(User.USER_PARAM) == null)
				request.getRequestDispatcher("/GoTo?GO_TO=/src/access_denied.jsp").forward(request, response);
			
			else if(!((User)request.getSession().getAttribute(User.USER_PARAM)).getUsername().equals("admin"))
				request.getRequestDispatcher("/GoTo?GO_TO=/src/access_denied.jsp").forward(request, response);
			%>


        	<jsp:include page="/src/header.jsp"></jsp:include>


			<div class = "row" style = "padding-top: 15px; padding-left: 30px ; padding-right: 30px; height: 100%; ">
	
				<div class = "col-12">
					<h3 class = "display-2 text-center">Administrar</h3>
					<hr width = "75%"/>
					<br/>
				</div>
				
				<!-- USUARIOS -->
				<div class = "col-12">
					<h3 class = "display-3">Usuarios</h3>
					<hr width = "25%" align = "left"/>
					<br/>
				</div>
				
				<div class = "col-lg-4 col-md-6 col-sm-12">
					<form class = "form-group" action = "<%=request.getContextPath()%>/AddUser" method = "post">
				
						<label for="input-username">Nombre usuario: </label>
						<p><input id = "input-username" type = "text" class="form-control" placeholder = "Introduce el nombre del usuario..." name = "<%=User.USER_USERNAME_PARAM%>" required></p>
						
						<label for="input-email">Correo electrónico: </label>
						<p><input id = "input-email" type = "email" class="form-control" placeholder = "Introduce el correo electrónico del usuario..." name = "<%=User.USER_EMAIL_PARAM %>" required></p>
						
						<label for="input-pass">Contraseña: </label>
						<p><input id = "input-pass" type = "text" class="form-control" placeholder = "Introduce la contraseña del usuario..." name = "<%=User.USER_PASSWORD_PARAM %>" required></p>
						
						<label for="input-address">Dirección: </label>
						<p><input id = "input-address" type = "text" class="form-control" placeholder = "Introduce la dirección del usuario..." name = "<%=User.USER_ADDRESS_PARAM %>" required></p>
							
						<p><input id = "input-send" type = "submit" class="btn btn-primary" value = "Añadir"></p>
					
					</form>
				</div>
				
				<div class = "col-lg-8 col-md-6 col-sm-12">
					<div class = "table-responsive" style = " max-height: 400px !important; overflow: auto;">
					<table class="table table-striped">
  						<thead class = "thead-dark">
    						<tr>
      							<th scope="col">ID</th>
      							<th scope="col">Nombre de Usuario</th>
      							<th scope="col">Correo electrónico</th>
      							<th scope="col">Dirección</th>
      							<th scope="col">Biografía</th>
      							<th scope="col">Contraseña</th>
      							<th scope="col">Remove</th>
    						</tr>
  						</thead>
  						
  						<tbody>				
  						
  						<% 
  						
  						ArrayList<String> usersReferences = new ArrayList<String>();
  						
  						LoadDataReferences.loadUsersReferences(usersReferences);
  									
  						for(int i = 0; i < usersReferences.size(); ++i){
  							User u = LoadDataByReference.user(usersReferences.get(i));
  							
  						%>
    						<tr>
      							<th scope="row"><%=u.getId() %></th>
      							<td><%=u.getUsername() %></td>
      							<td><%=u.getEmail() %></td>
      							<td><%=u.getAddress() %></td>
      							<td><%=u.getBiography() %></td>
      							<td><%=u.getPassword() %></td>
      							<td><form action = "<%=request.getContextPath()%>/RemoveUser" method = "POST"><input type = "hidden" name = "<%=User.USER_ID_PARAM %>" value = "<%=u.getId()%>"><button type = "submit" class="btn btn-danger">Remove</button></form></td>
      							
    						</tr>	
    					<%}%>
  						</tbody>
					</table>
					</div>				

				</div>
				
				
				
				
				
				<!-- PRODUCTOS -->
				<div class = "col-12">
					<h3 class = "display-3">Productos</h3>
					<hr width = "25%" align = "left"/>
					<br/>
				</div>
				
				<div class = "col-lg-4 col-md-6 col-sm-12">
					<form class = "form-group" enctype="multipart/form-data" action = "<%=request.getContextPath()%>/AddProduct" method = "POST">
						<input id = "input-id" type = "hidden" class="form-control" placeholder = "Introduce el ID del producto..." name = "<%=Product.PRODUCT_ID_PARAM%>">
						
						<label for="input-name">Nombre: </label>
						<p><input id = "input-name" type = "text" class="form-control" placeholder = "Introduce el nombre del producto..." name = "<%=Product.PRODUCT_PARAM_NAME%>" required></p>
						
						<label for="input-trademark">Marca: </label>
						<p><input id = "input-trademark" type = "text" class="form-control" placeholder = "Introduce la marca del producto..." name = "<%=Product.PRODUCT_TRADEMARK_PARAM %>" required></p>
						
						<label for="input-model">Modelo: </label>
						<p><input id = "input-model" type = "text" class="form-control" placeholder = "Introduce el modelo del producto..." name = "<%=Product.PRODUCT_MODEL_PARAM %>" required></p>
						
						<label for="input-price">Precio: </label>
						<p><input id = "input-price" type = "number" class="form-control" step="0.01" placeholder = "Introduce el precio del producto formato (n,xy)..." name = "<%=Product.PRODUCT_PRICE_PARAM %>" required></p>
						
						<label for="input-img">Imagen: </label>
						<p><input id = "input-img" type = "file" accept = "image/*" class="form-control" name = "<%=Product.PRODUCT_IMG_PARAM %>"  required></p>

						<label for="input-description">Descripción: </label>
						<p><textarea id = "input-description" class="form-control" placeholder = "Introduce la descripción del producto..." name = "<%=Product.PRODUCT_DESCRIPTION_PARAM %>" required></textarea></p>
						
						<p><input id = "input-send" type = "submit" class="btn btn-primary" value = "Enviar"></p>
					
					</form>
				</div>
				
				<div class = "col-lg-8 col-md-6 col-sm-12">
					<div class = "table-responsive" style = " max-height: 550px !important; overflow: auto;">
					<table class="table table-striped">
  						<thead class = "thead-dark">
    						<tr>
      							<th scope="col">ID</th>
      							<th scope="col">Nombre</th>
      							<th scope="col">Marca</th>
      							<th scope="col">Modelo</th>
      							<th scope="col">Precio (Euros)</th>
      							<th scope="col">Ruta imagen</th>
      							<th scope="col">Remove</th>
    						</tr>
  						</thead>
  						<tbody>
  						
  						<% 
  						
  						ArrayList<String> productsReferences = new ArrayList<String>();
  						
  						LoadDataReferences.loadProductsReferences(productsReferences);
  									
  						for(int i = 0; i < productsReferences.size(); ++i){
  							Product p = LoadDataByReference.product(productsReferences.get(i));
  						%>
    						<tr>
      							<th scope="row"><%=p.getId() %></th>
      							<td><%=p.getName() %></td>
      							<td><%=p.getTrademark() %></td>
      							<td><%=p.getModel() %></td>
      							<td><%=p.getPrice().toString()%></td>
      							<td><%=p.getImg_path() %></td>
      							<td><form action = "<%=request.getContextPath()%>/RemoveProduct" method = "POST"><input type = "hidden" name = "<%=Product.PRODUCT_ID_PARAM %>" value = "<%=p.getId()%>"><button type = "submit" class="btn btn-danger">Remove</button></form></td>
    						</tr>	
    					<%}%>
  						</tbody>
					</table>
					</div>				

				</div>
				
				
				
				
				
				
				
				<!-- VOTOS -->
				<div class = "col-12">
					<h3 class = "display-3">Votos</h3>
					<hr width = "25%" align = "left"/>
					<br/>
				</div>
				
				<div class = "col-lg-4 col-md-6 col-sm-12">
					<form class = "form-group" action = "<%=request.getContextPath()%>/AddVote" method = "post">
						
						<input id = "input-id" type = "hidden" class="form-control" placeholder = "Introduce el ID del producto..." name = "<%=Vote.VOTE_ID_PARAM%>">
						
						<label for="select-user-id">ID Usuario</label>
    					<p><select class="form-control" id="select-user-id" name = "<%=Vote.VOTE_USER_PARAM %>" required>
      						<%
      						for(String id: usersReferences){
      							User u_vote = LoadDataByReference.user(id);
      							if(u_vote!=null){
      						%>
      						<option value = "<%=id %>"><%=id %> (<%=u_vote.getUsername() %>)</option>
							<%}} %>
    					</select></p>
    					
						<label for="select-product-id">ID Producto</label>
    					<p><select class="form-control" id="select-product-id" name = "<%=Vote.VOTE_PRODUCT_PARAM %>" required>
      						<%
      						for(String id: productsReferences){
      							Product p_vote = LoadDataByReference.product(id);
      							if(p_vote != null){
      						%>
      						<option value = "<%=id %>"><%=id %> (<%=p_vote.getName() %>)</option>
							<%}}%>
    					</select></p>
			
						<label for="input-model">Puntuación: </label>
						<p><input id = "input-model" type = "number" max = "5" min = "1" class="form-control" placeholder = "Introduce el modelo del producto..." name = "<%=Vote.VOTE_ASSESSMENT_PARAM %>" required></p>
						
						<label for="input-price">Fecha: </label>
						<p><input id = "input-price" type = "date" class="form-control" step="0.01" name = "<%=Vote.VOTE_DATE_PARAM %>" required></p>

						<p><input id = "input-send" type = "submit" class="btn btn-primary" value = "Enviar"></p>
					
					</form>
				</div>
				
				<div class = "col-lg-8 col-md-6 col-sm-12">
					<div class = "table-responsive" style = " max-height: 400px !important; overflow: auto;">
					<table class="table table-striped">
  						<thead class = "thead-dark">
    						<tr>
      							<th scope="col">ID</th>
      							<th scope="col">ID_USUARIO</th>
      							<th scope="col">ID_PRODUCTO</th>
      							<th scope="col">Puntuación</th>
      							<th scope="col">Fecha</th>
      							<th scope="col">Remove</th>
    						</tr>
  						</thead>
  						<tbody>
  						
  						<% 
  						
  						ArrayList<String> votesReferences = new ArrayList<String>();
  						
  						LoadDataReferences.loadVotesReferences(votesReferences);
  									
  						for(int i = 0; i < votesReferences.size(); ++i){
  							Vote v = LoadDataByReference.vote(votesReferences.get(i));
  							if(v != null){
  						%>
    						<tr>
      							<th scope="row"><%=v.getId() %></th>
      							<td><%=v.getUserId() %></td>
      							<td><%=v.getProductId() %></td>
      							<td><%=v.getAssessment() %></td>
      							<td><%=v.getDate().toString()%></td>
      							<td><form action = "<%=request.getContextPath()%>/RemoveVote" method = "POST"><input type = "hidden" name = "<%=Vote.VOTE_ID_PARAM %>" value = "<%=v.getId()%>"><button type = "submit" class="btn btn-danger">Remove</button></form></td>
    						</tr>	
    					<%}}%>
  						</tbody>
					</table>
					</div>				

				</div>
					
				
				<!-- COMENTARIOS -->
				<div class = "col-12">
					<h3 class = "display-3">Comentarios</h3>
					<hr width = "25%" align = "left"/>
					<br/>
				</div>
				
				<div class = "col-lg-4 col-md-6 col-sm-12">
					<form class = "form-group" action = "<%=request.getContextPath()%>/AddComment" method = "post">
						
						<input id = "input-id" type = "hidden" class="form-control" placeholder = "Introduce el ID del producto..." name = "<%=Comment.COMMENT_ID_PARAM%>">
						
						<label for="select-user-id">ID Voto</label>
    					<p><select class="form-control" id="select-user-id" name = "<%=Comment.COMMENT_VOTE_ID_PARAM %>" required>
      						<%
      						for(String id: votesReferences){
      							Vote c_vote = LoadDataByReference.vote(id);
      							if(c_vote != null){
      						%>
      						<option value = "<%=id %>"><%=id %></option>
							<%}} %>
    					</select></p>
    					
    					<label for="input-resume">Asunto: </label>
						<p><input id = "input-resume" type = "text" class="form-control" placeholder = "Introduce el asunto del comentario..." name = "<%=Comment.COMMENT_RESUME_PARAM%>" required></p>
						
						<label for="input-content">Contenido: </label>
						<p><textarea id = "input-content" class="form-control" placeholder = "Introduce el contenido del comentario..." name = "<%=Comment.COMMENT_CONTENT_PARAM %>" required></textarea></p>					

						<p><input id = "input-send" type = "submit" class="btn btn-primary" value = "Enviar"></p>
					
					</form>
				</div>
				
				<div class = "col-lg-8 col-md-6 col-sm-12">
					<div class = "table-responsive" style = " max-height: 400px !important; overflow: auto;">
					<table class="table table-striped">
  						<thead class = "thead-dark">
    						<tr>
      							<th scope="col">ID</th>
      							<th scope="col">ID_VOTO</th>
      							<th scope="col">Asunto</th>
      							<th scope="col">Contenido</th>
      							<th scope="col">Remove</th>
    						</tr>
  						</thead>
  						<tbody>
  						
  						<% 
  						
  						ArrayList<String> commentsReferences = new ArrayList<String>();
  						
  						LoadDataReferences.loadCommentsReferences(commentsReferences);
  									
  						for(int i = 0; i < commentsReferences.size(); ++i){
  							Comment c = LoadDataByReference.comment(commentsReferences.get(i));
  						%>
    						<tr>
      							<th scope="row"><%=c.getId() %></th>
      							<td><%=c.getVoteId().toString() %></td>
      							<td><%=c.getResume() %></td>
      							<td><%=c.getContent() %></td>
      							<td><form action = "<%=request.getContextPath()%>/RemoveComment" method = "POST"><input type = "hidden" name = "<%=Comment.COMMENT_ID_PARAM %>" value = "<%=c.getId()%>"><button type = "submit" class="btn btn-danger">Remove</button></form></td>
    						</tr>	
    					<%}%>
  						</tbody>
					</table>
					</div>				

				</div>

			</div>


				
        	<jsp:include page="/src/footer.html"></jsp:include>

    	</div>

    	<!-- Optional JavaScript -->
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="js/bootstrap.min.js"></script>

    </body>
</html>