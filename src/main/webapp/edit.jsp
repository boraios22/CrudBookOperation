
<jsp:include page="header.jsp"/>

	<div class="container">

		<form action="bookOperation" method="post">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title" value=${book.getTitle() }>

			</div>
			<div class="form-group">
				<label for="author">Author</label> <input type="text"
					class="form-control" id="author" placeholder="Enter author"
					name="author" value="${book.getAuthor() }">
			</div>
			
			<input type="hidden" name="id" value="${book.getId() }"/>
			<input type="hidden" name="target" value="updateBook"/>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

<jsp:include page="footer.jsp"/>


