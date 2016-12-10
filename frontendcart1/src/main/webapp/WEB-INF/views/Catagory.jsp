<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false"%>

<style type="text/css">

.form-group input{
	width:50%;
}
</style>

		<div id="content">
			<div class="container">
			


			

			<section>
					<h2 class="text-uppercase">Catagory</h2>


					<hr>

					<!-- LOOK HERE -->

					<h3>Add a Catagory</h3>

					<c:url var="addAction" value="/catagory/add"></c:url>

					<form:form action="${addAction}" commandName="catagory">


						<div class="form-group">
							<c:choose>
								<c:when test="${!empty catagory.catagory_id}">

									<div class="form-group">
										<label for="name">ID</label>
										<div class="controls docs-input-sizes">
											<form:input placeholder="id" path="catagory_id" required="true"
												class="form-control" id="catagory_id" disabled="true" readonly="true" />
										</div>
									</div>

								</c:when>

								<c:otherwise>

									<div class="form-group">
										<form:input path="catagory_id" hidden="true" />
										<label for="id">ID</label>
										<div class="controls docs-input-sizes">
											<form:input placeholder="id" path="catagory_id" required="true"
												class="form-control" id="catagory_id"
												title="id should contains 6 to 7 characters"
												patttern=".{6,7}" />
										</div>
									</div>

								</c:otherwise>
							</c:choose>

						</div>

						<div class="form-group">
							<form:input path="catagory_id" hidden="true" />
							<label for="name">Name</label>
							<div class="controls docs-input-sizes">
								<form:input placeholder="name" path="catagory_name" required="true"
									class="form-control" id="catagory_name" />
							</div>
						</div>

						<div class="form-group">
							<label for="description">Description</label>
							<div class="controls docs-input-sizes">
								<form:input placeholder="description" path="catagory_description"
									class="form-control" id="catagory_description" />
							</div>
						</div>



						<div class="form-group">
							<div class="controls docs-input-sizes">
								<c:if test="${!empty catagory.catagory_name}">

									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-user-md"></i> Edit Catagory
									</button>
								</c:if>
								<c:if test="${empty catagory.catagory_name}">

									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-user-md"></i> Add Catagory
									</button>
								</c:if>
							</div>
						</div>
					</form:form>
				
<br><br>

			
					<div class="all">
						<c:if test="${!empty catagoryList}">
							<h3>Catagory List</h3>
							<table class="tg table-hover">
								<tr>
									<th width="80">Catagory ID</th>
									<th width="120">Catagory Name</th>
									<th width="120">Catagory description</th>
									<th width="60">Edit</th>
									<th width="60">Delete</th>
								</tr>
								<c:forEach items="${catagoryList}" var="catagory">
									<tr>
										<td>${catagory.catagory_id}</td>
										<td>${catagory.catagory_name}</td>
										<td>${catagory.catagory_description}</td>
										<td><a
											href="<c:url value='catagory/edit/${catagory.catagory_id}' />">Edit</a></td>
										<td><a
											href="<c:url value='catagory/remove/${catagory.catagory_id}' />">Delete</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<br> <br> <br>
			</div>
			</section>
			</div>

		</div>