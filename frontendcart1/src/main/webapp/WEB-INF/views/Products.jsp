<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<style type="text/css">
.form-group input {
	width: 50%;
}

.select-style select {
	width: 50%;
	padding: 16px 20px;
	border: none;
	border-radius: 4px;
	background-color: #f1f1f1;
}

#itemimage {
	width: 50%;
	padding: 16px 20px;
	border: none;
	border-radius: 4px;
}
</style>
<div id="content">
	<div class="container">


		<div class="flex-container">


			<h2 class="text-uppercase">Product</h2>

			<hr>

			<!-- LOOK HERE -->


			<h3>Add a Product</h3>


			<c:url var="addAction" value="/product/add"></c:url>
			<form:form action="${addAction}" commandName="products" 
			enctype="multipart/form-data"> 



				<div class="form-group">
					<c:choose>
						<c:when test="${!empty products.id}">

							<div class="form-group">
								<label for="name">ID</label>
								<div class="controls docs-input-sizes">
									<form:input placeholder="id" path="id" required="true"
										class="form-control" id="id" disabled="true" readonly="true" />
								</div>
							</div>

						</c:when>

						<c:otherwise>

							<div class="form-group">
								<form:input path="id" hidden="true" />
								<label for="id">ID</label>
								<div class="controls docs-input-sizes">
									<form:input placeholder="id" path="id" required="true"
										class="form-control" id="id"
										title="id should contains 6 to 7 characters" patttern=".{6,7}" />
								</div>
							</div>

						</c:otherwise>
					</c:choose>

				</div>

				<div class="form-group">
					<form:input path="id" hidden="true" />
					<label for="name">Name</label>
					<div class="controls docs-input-sizes">
						<form:input placeholder="name" path="name" required="true"
							class="form-control" id="name" />
					</div>
				</div>

				<div class="form-group">
					<label for="price"> <spring:message text="Price" />
					</label>
					<div class="controls docs-input-sizes">
						<form:input path="price" required="true" class="form-control"
							id="price" />
					</div>
				</div>

				<div class="form-group">
					<label for="description">Description</label>
					<div class="controls docs-input-sizes">
						<form:input placeholder="description" path="description"
							class="form-control" id="description" />
					</div>
				</div>


				<div class="form-group">
					<label for="suppliers">Suppliers</label>
					<div class="select-style">
						<form:select path="suppliers.name" items="${supplierList}"
							itemValue="name" itemLabel="name" />
					</div>
				</div>
 

				<div class="form-group">
					<label for="catagory">Catagory</label>
					<div class="select-style">
						<form:select path="catagory.catagory_name" items="${catagoryList}"
							itemValue="catagory_name" itemLabel="catagory_name" />
					</div>
				</div>

				<div class="form-group">
					<label for="description">Upload image</label>
					<div class="controls docs-input-sizes">
						<form:input id="itemimage" path="itemImage" type="file"
							class="form:input-large" />
					</div>
				</div> 
 

				<div class="form-group">
					<div class="controls docs-input-sizes">
						<c:if test="${!empty products.name}">

							<button type="submit" class="btn btn-template-main pull-left">
								<i class="fa fa-user-md"></i> Edit product
							</button>
						</c:if>
						<c:if test="${empty products.name}">

							<button type="submit" class="btn btn-template-main pull-left">
								<i class="fa fa-user-md"></i> Add product
							</button>
						</c:if>
					</div>
				</div>
			</form:form>


			<br>
			<br>



			<div class="all">
				<c:if test="${!empty productList}">
					<h3>Product List</h3>
					<table class="tg">
						<tr>
							<th width="80">Product ID</th>
							<th width="120">Product Name</th>
							<th width="200">Product Description</th>
							<th width="80">Price in Rs.</th>
							<th width="80">Product Catagory</th>
							<th width="80">Product Suppliers</th>
							<th width="60">Edit</th>
							<th width="60">Delete</th>
							<th width="60">Products Image</th>
						</tr>
						<c:forEach items="${productList}" var="products">
							<tr>
								<td>${products.id}</td>
								<td>${products.name}</td>
								<td>${products.description}</td>
								<td align=right>Rs.${products.price}</td>
								<td>${products.catagory_id}</td>
								<td>${products.suppliers.name}</td>
								<td><a href="<c:url value='product/edit/${products.id}' />">Edit</a></td>
								<td><a
									href="<c:url value='product/remove/${products.id}' />">Delete</a></td>
								<td><img
									src="<c:url value="/resources/images/product images/${products.id}.jpg"/>"
									height="142" width="142" alt="product images" /></td>
								<td><a
									href="<c:url value="/resources/images/product images/${products.id}.jpg"/>">Click
										here</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>

		</div>

		<br>
		<br>
		<br>

	</div>

</div>
