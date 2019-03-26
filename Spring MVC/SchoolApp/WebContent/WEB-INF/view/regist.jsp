<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrasi</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/filecss.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery-3.3.1.slim.min.js" />"></script>
    <script src="<c:url value="/resources/js/popper.min.js" />"></script>
    <style type="text/css">
	   .warna {
	   color: white;
	   }
	   .posisi {
			text-align: left;
		}
	</style>
</head>
<body>
	<div class="center-items">
		<div class="warna">
			<h1>Formulir Registrasi</h1>
			<hr>
		</div>
		<div class="jumbotron">
			<form:form method="POST" action="/SchoolApp/result" modelAttribute="siswa">
                <div class="form-group">
                	<div class="posisi">
                		<form:label path="nisn">NISN Siswa:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="nisn" class="form-control"/>
				    </div>
				</div>
				<div class="form-group">
                	<div class="posisi">
                		<form:label path="nama">Nama Siswa:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="nama" class="form-control"/>
				    </div>
				</div>
				<div class="form-group">
                	<div class="posisi">
                		<form:label path="tempatLahir">Tempat Lahir:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="tempatLahir" class="form-control"/>
				    </div>
				</div>
				<div class="form-group">
                	<div class="posisi">
                		<form:label path="tanggalLahir">Tanggal Lahir:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="tanggalLahir" class="form-control"/>
				    </div>
				</div>
                <div class="form-group">
                	<div class="posisi">
                		<form:label path="alamat">Alamat:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="alamat" class="form-control"/>
				    </div>
				</div>
				<div class="form-group">
                	<div class="posisi">
                		<form:label path="asalSekolah">Asal Sekolah:</form:label>
                	</div>
                	<div class="col-md-4">
				    	<form:input path="asalSekolah" class="form-control"/>
				    </div>
				</div>
                <button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>