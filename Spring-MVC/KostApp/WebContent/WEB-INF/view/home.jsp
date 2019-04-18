<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrasi</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value="/resources/css/filecss.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.3.1.slim.min.js" />"></script>
    <script src="<c:url value="/resources/js/popper.min.js" />"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Kost App</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/home" />">Home	|</a></li>
				<li><a href="<c:url value="/home" />">Kost Status	|</a></li>
				<li><a href="<c:url value="/home" />">Kost Member	|</a></li> 
				<li><a href="<c:url value="/home" />">Room	|</a></li>
				<li><a href="<c:url value="/regist" />">Administration</a></li> 
			</ul>
		</div>
	</nav>
	<div class="jumbotron">
			<h1>Selamat Datang di Kost App!</h1>
			<hr>
		<div class="row">
	        <div class="col-md-2">
	          <table >
	            <tbody>
	              <tr>
	                <td>Halo, </td>
            		<td> ${nama}!</td>
	              </tr>
	            </tbody>
	          </table>
	        </div>
	    </div>
	<a href="/KostApp/">Kembali</a>
	</div>
</body>
</html>