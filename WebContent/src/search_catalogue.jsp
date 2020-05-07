<%@ page import = "edu.ucam.classes.*" %>
<%@ page import = "edu.ucam.database.*" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

        	<jsp:include page="/src/header.jsp"></jsp:include>

			<div class = "row" style = "padding-top: 15px; padding-left: 30px ; padding-right: 30px; height: 100%; ">
	
	<div class = "col-12">
		<h3 class = "display-2 text-center">Catálogo</h3>
		<hr width = "75%"/>
		<br/>
	</div>
							
	<%
		User currentUser = null;
		try{
			currentUser = (User)request.getSession().getAttribute(User.USER_PARAM);
		}catch(Exception t){
			
		}
		
		ArrayList<String> productsReferences = new ArrayList<String>();
		ArrayList<Vote> votes = new ArrayList<Vote>();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		LoadData.loadVotes(votes);
		LoadData.loadComments(comments);
		LoadDataReferences.loadProductsReferences(productsReferences);
		
		String search = request.getParameter("SEARCH");
					
		for(int i = 0; i < productsReferences.size(); ++i){
			
			Product p = LoadDataByReference.product(productsReferences.get(i));
			
			
			if(!(p.getName().toUpperCase().indexOf(search.toUpperCase())<0)){

	%>
					
	<div class="col-lg-4 col-md-6 col-sm-12" style = "padding-bottom: 10px;">
		<h2><%=p.getName()%></h2>
			
		<div class = "row">
			<div class = "col-6">
				<ul>
					<li><strong>Marca:</strong> <%try{out.println(p.getTrademark());}catch(Exception t){out.println("Not Found");}%></li>
					<li><strong>Modelo:</strong> <%try{out.println(p.getModel());}catch(Exception t){out.println("Not Found");}%></li>
					<li><strong>Precio:</strong> <%try{out.println(p.getPrice().toString() + " Euro(s)");}catch(Exception t){out.println("Not Found");}%></li>
				</ul>
			</div>
				
			<div class ="col-6">
				
				<img src = "img/products/<%=p.getImg_path()%>" alt = "<%=p.getImg_path()%>" width = "130px">
				
			</div>
				
			<div class = "col-12">
				<div>
					<p align = "justify"><%try{out.println(p.getDescription());}catch(Exception t){out.println("Not Found");}%></p>
				</div>
			</div>
			
			<div class = "col-12" style = "">
				<p>
				<%if(currentUser!=null){ %>
  					<a class="btn btn-primary" data-toggle="collapse" href="#collapse<%=i%>vote" role="button" aria-expanded="false" aria-controls="collapseExample">
    					Votar
  					</a>
  					<%} %>
  					<a class="btn btn-primary" data-toggle="collapse" href="#collapse<%=i%>comments" role="button" aria-expanded="false" aria-controls="collapseExample">
    					Todos los Votos
  					</a>
				</p>
				<%if(currentUser!=null){ %>
				<div class="collapse" id="collapse<%=i%>vote">
  					<form class="card card-body"  action = "<%=request.getContextPath()%>/AddVoteAndComment" method = "post">
  						<div>
  							<p>Estrellas:
  								<input type="radio" name="<%=Vote.VOTE_ASSESSMENT_PARAM %>" value="1" required/>1
            					<input type="radio" name="<%=Vote.VOTE_ASSESSMENT_PARAM %>" value="2"/>2
            					<input type="radio" name="<%=Vote.VOTE_ASSESSMENT_PARAM %>" value="3"/>3
            					<input type="radio" name="<%=Vote.VOTE_ASSESSMENT_PARAM %>" value="4"/>4
            					<input type="radio" name="<%=Vote.VOTE_ASSESSMENT_PARAM %>" value="5"/>5
            				</p>
  						</div>
  						
    					<label for="input-resume">Asunto: </label>
						<p><input id = "input-resume" type = "text" class="form-control" placeholder = "Introduce el asunto del comentario..." name = "<%=Comment.COMMENT_RESUME_PARAM%>" required></p>
						
						<label for="input-content">Contenido: </label>
						<p><textarea id = "input-content" class="form-control" placeholder = "Introduce el contenido del comentario..." name = "<%=Comment.COMMENT_CONTENT_PARAM %>" required></textarea></p>					

						<input type = "hidden" name = "<%=Vote.VOTE_PRODUCT_PARAM %>" value = "<%=p.getId()%>">
						<input type = "hidden" name = "<%=Vote.VOTE_USER_PARAM %>" value = "<%=currentUser.getId()%>">

    					<input type = "submit" value = "Enviar">
  					</form>
				</div>
				<%} %>
				<div class="collapse" id="collapse<%=i%>comments">
  					<div class="card card-body">
  						<%for(Vote v: votes){
  	  						User userOfVote = LoadDataByReference.user(v.getUserId()); 
  	  						if(v.getProductId().equals(p.getId())){	
  	  					%>
  	  					<p><strong><%if(userOfVote!=null)out.println(userOfVote.getUsername());else out.println("NULL");%>: </strong><%=v.getAssessment().toString()%> Estrellas. </p>
  	  					
  	  						<%
  	  							for(Comment c: comments){
  	  								if(c.getVoteId().equals(v.getId())){
  	  						%>
  	  							<label for="comment-content"><strong><%=c.getResume()%></strong></label>
								<p><textarea style = "resize:none;" id = "comment-content" class="form-control" name = "<%=Product.PRODUCT_DESCRIPTION_PARAM %>" required readonly><%=c.getContent()%></textarea></p>
						
  	  							
  	  						<%}} %>
  	  					<p><%if(v.getDate()!=null)out.println(v.getDate().toString()); %></p>
  	  					<hr/>
  	  					<%}}%>
    					
  					</div>
				</div>
			</div>	
		</div>
	</div>

				

<%}}%>	

</div>	

<br/><br/>

			<jsp:include page = "/src/login_form.jsp"></jsp:include>
			<jsp:include page = "/src/register_form.jsp"></jsp:include>
			
        	<jsp:include page="/src/footer.html"></jsp:include>

    	</div>

    	<!-- Optional JavaScript -->
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="js/bootstrap.min.js"></script>

    </body>
</html>


