<%@page import="edu.ucam.servlets.ActionLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import = "edu.ucam.classes.User" %>
<%@ page import = "edu.ucam.servlets.Controller" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<title>Ráfura - Autenticar</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../img/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../css/util.css">
	<link rel="stylesheet" type="text/css" href="../css/login_main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="<%= request.getContextPath()%>/Controller" method="POST">
					
					<input type="hidden" name="<%= Controller.PARAM_ACTION_ID %>" value="<%=ActionLogin.ACTION%>">
					
					<span class="login100-form-title">
						Autenticar
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Por favor, introduzca el nombre de usuario.">
						<input class="input100" type="text" name = "<%= User.USER_USERNAME_PARAM%>" placeholder="Nombre de Usuario">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Por favor, introduzca la contraseña.">
						<input class="input100" type="password"name = "<%= User.USER_PASSWORD_PARAM%>" placeholder="Contraseña">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							¿Olvidó su
						</span>

						<a href="#" class="txt2">
							Nombre de Usuario / Contraseña?
						</a>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Aceptar
						</button>
						<br/>
						<button href = "index.jsp" class="login100-form-btn">
							Cancelar
						</button>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							¿No tienes una cuenta?
						</span>

						<a href="#" class="txt3">
							Regístrate
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>