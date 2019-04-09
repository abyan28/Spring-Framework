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
	<div class="jumbotron">
			<h1>Detail Registrasi</h1>
			<hr>
		<div class="row">
	        <div class="col-md-6">
	          <table class="table table-bordered">
	            <tbody>
	              <tr>
		            <td>NISN Siswa:</td>
		            <td>${nisn}</td>
	              </tr>
	              <tr>
	                <td>Nama Siswa:</td>
            		<td>${nama}</td>
	              </tr>
	              <tr>
            		<td>Tempat Lahir:</td>
            		<td>${tempatLahir}</td>
        		  </tr>
	              <tr>
            		<td>Tanggal Lahir:</td>
           			<td>${tanggalLahir}</td>
        		  </tr>
        		  <tr>
            		<td>Alamat :</td>
            		<td>${alamat}</td>
        		  </tr>
        		  <tr>
            		<td>Asal Sekolah :</td>
            		<td>${asalSekolah}</td>
        		  </tr>
	            </tbody>
	          </table>
	        </div>
	    </div>
	<a href="/SchoolApp/">Kembali</a>
	</div>
</body>
</html>