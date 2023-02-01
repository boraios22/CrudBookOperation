
<jsp:include page="header.jsp"/>

	<div class="container">

		<c:if test="${ MESSAGE != null }">
			<div class="alert alert-success mt-3" role="alert">${ MESSAGE }</div>
		</c:if>
		

		<form action="saveBook" method="post">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">

			</div>
			<div class="form-group">
				<label for="author">Author</label> <input type="text"
					class="form-control" id="author" placeholder="Enter author"
					name="author">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

<jsp:include page="footer.jsp"/>


