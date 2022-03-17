<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Login</title>
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
		<div class="p-4" style="border: 1px solid black">
			<div class="row">
				<div class="col-sm-12 text-right">
					<button type="button" class="btn btn " data-toggle="modal"
						data-target="#myModal">Add Book</button>
				</div>
			</div>
			<div class="row mt-2">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
							<th scope="col">Book Code</th>
							<th scope="col">Book Name</th>
							<th scope="col">Author</th>
							<th scope="col">Date Added</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${list}">
							<tr>
								<td>${e.bookCode}</td>
								<td>${e.bookName}</td>
								<td>${e.author}</td>
								<td>${e.dateAdded}</td>

								<td><button type="button" class="btn btn ">
										<a href="editbook?id=${e.id}">Edit</a>
									</button>
									<button type="button" class="btn btn ">
										<a href="deletebook?id=${e.id}">Delete</a>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<!-- Modal for add user-->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Add Book</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>

					</div>
					<div class="modal-body">
						<form action="addbook" method="POST" class="border p-3">
							<div class="form-group">
								<label>Book Code</label> <input type="number"
									class="form-control" id="empcode" aria-describedby="empHelp"
									placeholder="Enter Book code" name="bookCode" required>
							</div>
							<div class="form-group">
								<label>Book Name</label> <input type="text" class="form-control"
									id="empname" aria-describedby="empnameHelp"
									placeholder="Enter Book name" name="bookName" required>
							</div>

							<div class="form-group">
								<label>Author</label> <input type="text" class="form-control"
									placeholder="Enter Author" name="author" required>
							</div>
							<div class="form-group">
								<label>Date Added</label> <input type="date"
									class="form-control" id="empdob" placeholder="Date Added"
									name="dateAdded" required>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary text-center">Add</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>



		<div class="row mt-2 mr-auto ml-auto"
			style="background-color: #c4dbff;">
			<div class="col-sm-12">
				<h1 class="text-center">Footer goes here</h1>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

	<script>
		var myModal = document.getElementById('myModal')
		var myInput = document.getElementById('myInput')

		myModal.addEventListener('shown.bs.modal', function() {
			myInput.focus()
		})
	</script>
</body>
</html>