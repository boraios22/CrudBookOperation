<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div class="container">

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Title</th>
				<th scope="col">Author</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${ books }">


				<tr>
					<td>${book.getTitle()}</td>
					<td>${book.getAuthor()}</td>
					<!-- http://localhost:8080/CrudBookOperation/deleteBook?id=1 -->
					<td>
					
					<a href="${pageContext.request.contextPath}/deleteBook?id=${book.getId()}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
					
					<a href="${pageContext.request.contextPath}/editBook?id=${book.getId()}" >Edit</a>
					
					</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

</div>

<jsp:include page="footer.jsp" />
