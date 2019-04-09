<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>School App</title>
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value="/resources/css/filecss.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.3.1.slim.min.js" />"></script>
    <script src="<c:url value="/resources/js/popper.min.js" />"></script>
    <style type="text/css">
	   .warna {
	   color: white;
	   }
	   .button {
			margin: auto;
			width: 10%;
			border: 3px solid green;
			padding: 10px;
			background-color: transparent;
			border: 1px solid #ffffff;
			font-weight: 300;
		}

			.button:hover {
				background-color: rgba(255, 255, 255, 0.2);
			}
	</style>
    
</head>
<body>
	<div class="jumbotron">
		<div class="center-items">
			<div class="warna">
				<h1>Selamat Datang di MTs. Tahfidz Yanbu'ul Qur'an Menawan</h1>
				<hr>
			</div>
			<div class="button">
				<a href="<c:url value="/regist" />">Daftar</a>
			</div>
		</div>
	</div>
</body>
</html>