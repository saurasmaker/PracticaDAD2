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

			<div class = "row" style = "padding: 30px;">
				<div class = "col-12">
					<h3 class = "display-2 text-center">Registro realizado con éxito.</h3>
					<hr width = "75%"/>
					<br/>
				</div>
		
		
				<div class = "col-12">
					<p>
						Felicidades, te has registrado con éxito. Ya puedes hacer login en nuestra página web. 
					</p>
				</div>
		
			</div>
			

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