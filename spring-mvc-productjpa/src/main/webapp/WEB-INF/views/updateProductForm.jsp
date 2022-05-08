<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Product</h1>
	<form action = "updateProduct" method = "get">
	<input type="hidden" name="productId" value="${product.productId}"></input>
	Enter Product name : <input type = "text" name = "name" value="${product.name}"></input>
	<br>
	Enter Category : 
	<select name = "category">	
		<option value="${product.category}">${product.category}</option>
		<option value="ELECTRONICS">ELECTRONICS</option>
		<option value="TOYS">TOYS</option>
		<option value="SPORTS">SPORTS</option>
		<option value="SHOES">SHOES</option>
		<option value="STATIONARY">STATIONARY</option>
		<option value="APPARELS">APPARELS</option>
	</select>
	<br>
	Enter Brand : <input type ="text" name = "brand" value="${product.brand}"></input>
	<br>
	Enter Price : <input type ="text" name = "price" value="${product.price}"></input>
	<br>
	<input type = "submit" value = "Update Product"></input>
	
	</form>

</body>
</html>