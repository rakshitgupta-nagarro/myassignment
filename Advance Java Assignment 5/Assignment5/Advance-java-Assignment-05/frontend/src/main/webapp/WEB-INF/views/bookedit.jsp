<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row p-1 mb-2 mt-2  mr-auto ml-auto"
			style="background-color: #c4dbff;">
			<div class="col-sm-12">
				<h1 class="text-left">Header goes here</h1>
				<h4 class="text-right">
					Welcome ${name} !
					<button class="btn btn" onclick="location.href='sessionlogout'">Logout</button>
				</h4>
			</div>
		</div>
		<form action="afteredit" method="POST" class="border p-3 mt-4">
			<H4 class="text-center">Book Edit</H4>
			<div class="form-group">
				<input type="hidden" value="${e.id}"> <label>Book
					Code</label> <input type="number" class="form-control" id="empcode"
					aria-describedby="empHelp" placeholder="Enter Book code"
					value="${e.bookCode}" name="bookCode">
			</div>
			<div class="form-group">
				<label>Book Name</label> <input type="text" class="form-control"
					placeholder="Enter Book name" value="${e.bookName}" name="bookName">
			</div>

			<div class="form-group">
				<label>Author</label> <input type="text" class="form-control"
					placeholder="Enter Author" value="${e.author}" name="author">
			</div>
			<div class="form-group">
				<label>Date Added - ${e.dateAdded}</label> <input type="hidden"
					class="form-control" id="empdob" name="dateAdded"
					value="${e.dateAdded}">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary text-center">Update</button>
				<button type="cancel" class="btn btn-primary" data-dismiss="modal">Cancel</button>
			</div>
		</form>
		<div class="row mt-2 mr-auto ml-auto"
			style="background-color: #c4dbff;">
			<div class="col-sm-12">
				<h1 class="text-center">Footer goes here</h1>
			</div>
		</div>
	</div>
</body>
</html>