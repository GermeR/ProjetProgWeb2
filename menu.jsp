<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
	<meta charset="utf-8">
	<meta content="IE=edge" http-equiv="X-UA-Compatible">
	<meta content="width=device-width, initial-scale=1" name="viewport">
	<title>GTB.com - Menu</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<div class="page-header">
<center>
	<h1 class="display-1">MENU PRINCIPAL</h1><br>
	<% if(session.getAttribute("personne").getRole().equals("etu"))
	out.println("<li role='presentation' class='btn btn-default btn-lg'><a href='Select'>Consulter vos absences</a></li>");
	%>
	<% if(session.getAttribute("personne").getRole().equals("prof") || session.getAttribute("personne").getRole().equals("secr"))
	out.println("<li role='presentation' class='btn btn-default btn-lg'><a href='Select'>Consulter toutes les absences</a></li>");
	%>
	<% if(session.getAttribute("personne").getRole().equals("prof"))
	out.println("<li role='presentation' class='btn btn-default btn-lg'><a href='Select'>Ajouter des absences</a></li>");
	%>
	<% if(session.getAttribute("personne").getRole().equals("secr"))
	out.println("<li role='presentation' class='btn btn-default btn-lg'><a href='Select'>Justifier des absences</a></li>");
	%>
</center>
</body>
</html>

