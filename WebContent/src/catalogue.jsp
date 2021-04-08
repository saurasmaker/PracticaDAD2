<%@ page import = "edu.ucam.classes.*" %>
<%@ page import = "edu.ucam.database.*" %>
<%@ page import = "edu.ucam.servlets.Control" %>
<%@ page import = "java.util.ArrayList" %>

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
		LoadData.loadVotes(request.getContextPath(), votes);
		LoadData.loadComments(request.getContextPath(), comments);
		LoadDataReferences.loadProductsReferences(request.getContextPath(), productsReferences);
		
					
		for(int i = 0; i < productsReferences.size(); ++i){
			Product p = LoadDataByReference.product(request.getContextPath(), productsReferences.get(i));

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
  					<form class="card card-body"  action = "<%=request.getContextPath()%>/Control" method = "post">
  						<input id = "<%=Control.PARAM_ACTION_ID%>" name = "<%=Control.PARAM_ACTION_ID%>" value = "AddVoteAndComment" type = "hidden">
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
  	  						User userOfVote = LoadDataByReference.user(request.getContextPath(), v.getUserId()); 
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
  	  					<%}} %>
    					
  					</div>
				</div>
			</div>	
		</div>
	</div>

				

<%}%>	

</div>	

<br/><br/>



    
    