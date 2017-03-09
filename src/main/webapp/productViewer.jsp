<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>

</head>
<body>
	
		<div
			style="margin-left: 300px; margin-top: 110px; background-color: #5FB404; padding: 20px; width: 650px; height: 450px">
			<pre>
<p style="font-size: 20px">
NAME          	:${product.name}
DESCRIPTION   	:${product.description}
AVERAGE PRICE 	:${product.avgPrice}
HIGHEST PRICE 	:${product.highPrice}
LOWEST PRICE    :${product.lowPrice}
IDEAL PRICE	    :${product.idealPrice}

</p>
			</pre>
		</div>
</body>
</html>