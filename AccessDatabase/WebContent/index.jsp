<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Local Twitter</title>
		<meta http-equiv="Content-Type" content="text/html" charset=ISO-8859-1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="materialize.min.css">
		<link rel="stylesheet" type="text/css" href="materialize.min.js">
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		
	</head>
	
	<body>
	<div class="navbar-fixed">
		<nav>
			<div class="nav-wrapper">
			<a href="http://twitter.com" class="brand-logo">Twitter</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#">Home</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
			</div>
		</nav>
	</div>
	
	<div class="container">
	<div class="row">

	<form class="col s12" action="SignIn" method="post">
	<fieldset>
	<legend><h4>Sign In</h4></legend>
	<div class="input-field col s12">
	<input placeholder="Enter your name" type="text" name="username">
	<label class="active" for="username">User Name</label>
	</div>
	<div class="input-field col s12">
	<input placeholder="Enter your password" type="password" name="password">
	<label class="active" for="password">Password</label>
	</div>
	<button class="btn waves-effect waves-light red lighten-2" type="submit" value="submit">Submit
    <i class="material-icons right">send</i>
  </button>
	</fieldset>
	</form>

	<form class="col s12" action="SignUp" method="post">
		<fieldset>
			<legend><h4>New user? Sign up for free</h4></legend>
			<div class="input-field col s12">
			<input type="text" name="newuser" class="validate" id="newuser">
			<span id="newuser_validate"></span>
			<label class="active" for="newsuser">User Name</label>
			</div>
			<div class="input-field col s12">
			<input class="validate" type="password" name="password1" id="password1">
			<span id="password1_message">Choosing strong password is advisable</span>
			<label class="active" for="password1">Choose Password</label>
			</div>
			<div class="input-field col s12">
			<input class="validate" type="password" name="password2" id="password2">
			<span id="password2_message">Passwords do not match</span>
			<label class="active" for="password2">Confirm Password</label>
			</div>
			<button class="btn waves-effect waves-light red lighten-2" type="submit" value="register">Register
			<i class="material-icons right">send</i>
			</button>
		</fieldset>
	</form>
	</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		 $("#password1_message").hide();
		$("#password2_message").hide(); 
		$("#newuser_validate").hide();
		
		var password1_length= null;
		var password1_value = null;
		var password2_value = null;
		
		$("#newuser").focusout(function(){
			var username= $("#newuser").val();
			$.ajax({
				type: 'POST',
				data : {newuser: newuser},
				url: 'SignUp',
				success: function(result){
					$("#newuser_validate").html(result);
				}
			});
		})
		
		$("#password1").focus(function(){
			$("#password1_message").show();
		});
		
		$("#password1").keyup(function(){
			password1_length = $("#password1").val().length;
			
			if(password1_length<4){
				$("#password1_message").css("color", "red");
				$("#password1_message").html("Weak");
			}
			else if(password1_length >=4 && password1_length < 7){
				$("#password1_message").css("color", "yellow");
				$("#password1_message").html("Intermediate");
			}
			else{
				$("#password1_message").css("color", "green");
				$("#password1_message").html("Strong");
			}
		})
		
		$("#password2").keyup(function(){
			password1_value = $("#password1").val();
			password2_value = $("#password2").val();
			
			if(password1_value != password2_value){
				$("#password2_message").show();
				$("#password2_message").css("color", "red");
				$("#password2_message").html("Passwords do not match");
			}
			else{
				$("#password2_message").css("color", "green");
				$("#password2_message").html("Passwords match");
			}
		})
		
	})
	</script>
	
	
	</body>

</html>
