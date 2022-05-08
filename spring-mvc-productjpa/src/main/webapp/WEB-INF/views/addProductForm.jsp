<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD PRODUCT</h1>
	<form action = "addProduct" method = "get">
	Enter Product name : <input type = "text" name = "name"></input>
	<br>
	Enter Category : 
	<select name = "category">
		<option value="ELECTRONICS">ELECTRONICS</option>
		<option value="TOYS">TOYS</option>
		<option value="SPORTS">SPORTS</option>
		<option value="SHOES">SHOES</option>
		<option value="STATIONARY">STATIONARY</option>
		<option value="APPARELS">APPARELS</option>
	</select>
	<br>
	Enter Brand : <input type ="text" name = "brand"></input>
	<br>
	Enter Price : <input type ="text" name = "price"></input>
	<br>
	<input type = "submit" value = "Add Product"></input>
	
	</form>

</body>
</html>