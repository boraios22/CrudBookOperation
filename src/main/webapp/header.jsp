<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

<div class="row">
	<div class="col-4">
	<a class="btn btn-primary" href="home.jsp" role="button">Home</a>
	<a class="btn btn-primary" href="home.jsp" role="button">Create Book</a>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/bookOperation?target=bookListing" role="button">Book Listing</a>
	</div>
</div>
