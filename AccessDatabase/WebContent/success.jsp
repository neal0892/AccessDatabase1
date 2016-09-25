<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="materialize.min.css">
		<link rel="stylesheet" type="text/css" href="materialize.min.js">
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Successful login</title>
</head>
<body>
<div class="navbar-fixed">
<nav>
<div class="nav-wrapper">
<a class="brand-logo" href="http://www.twitter.com">Twitter</a>
<ul class="right">
<li><a href="#">notifications</a></li>
<li><a href="#">messages</a></li>
<li><a href="#">settings</a></li>
</ul>
</div>
</nav>
</div>
<div class="container">
<div class="card-panel teal lighten-2"><h4>Welcome <%=session.getAttribute("name") %></h4></div><br>

<div class="row">
<form class="col s12" action="Article" method="post">

	<div class="input-field col s12">
	<textarea class="materialize-textarea" name="article" placeholder="What's happening?"></textarea><br>
	<label class="active" for="article" >What's in your mind</label>
	</div>
	
	<button class="btn waves-effect waves-light" type="submit" value="post">Post
	<i class="material-icons right">send</i>
	</button>
	
</form>
</div>

<%
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
//PreparedStatement ps = con.PrepareStatement("select (select name from credentials WHERE CREDENTIALS.ID=DATA.ID) as author, TWEET from data order by TIME")
Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
ResultSet rs=stmt.executeQuery("select (select name from credentials WHERE CREDENTIALS.ID=DATA.ID) as author, TWEET from data order by TIME desc");

while(rs.next()){
%>
<ul class="collection">
<a href="#" class="collection-item"><b><%=rs.getString("AUTHOR") %></b>
<li>Tweet: <%=rs.getString("TWEET") %></li></a>
</ul>
<%
}
rs.close();
stmt.close();
con.close();
}catch(Exception e){
	e.printStackTrace();
}
%>
</div>
</body>
</html>