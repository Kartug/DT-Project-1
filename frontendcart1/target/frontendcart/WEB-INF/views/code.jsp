<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
img {
    height: 100px;
    width: 50%;
    
}
</style>
<c:forEach items="${productList}" var="products">
	<div class="item">
		<div class="row">
			<div class="col-sm-7" 
			height:10px;
					width:50px;>

				<img class="img-responsive"
					src="<c:url value="/resources/images/product images/${products.id}.jpg"/>"
					alt="">
					

			</div>
			<div class="col-sm-5">
				<h1>${products.name}</h1>
				<h2>Price:
					Rs.${products.price} </h2><br>
					
				<a href="<c:url value='/product/get/${products.id}'/>"  class="btn btn-template-main"> View details </a><br>
					
					
					<%-- <c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">
				<br> <a href="<c:url value="/usercart/cart/addItem/${product.id}"/>">Add
					to Cart</a> <br>
				<button>Buy</button>
				</c:if> --%>
			</div>
		</div>
	</div>
</c:forEach>