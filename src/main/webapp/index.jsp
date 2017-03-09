<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Product and its Price</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script type="text/javascript">
	function sendData() {
		var name = $('#name').val();
		var description = $('#description').val();
		var price = $('#price').val();
		var store = $('#store').val();
		var notes = $('#notes').val();

		var jsonDataObject = new Object();
		jsonDataObject.name = name;
		jsonDataObject.description = description;
		jsonDataObject.price = price;
		jsonDataObject.store = store;
		jsonDataObject.notes = notes;

		var jsonString = JSON.stringify(jsonDataObject);

		$.ajax({
			type : "POST",
			url : "/prizy-pricer/product",
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			data : jsonString,
			success : function(result) {
				$('#output').html(result);
			}
		});
	}
</script>
</head>
<body>
	<form name="form" onsubmit="sendData()">
		<div
			style="margin-left: 300px; margin-top: 110px; background-color: #5FB404; padding: 20px; width: 650px; height: 450px">
			<h1>
				<center>Enter As</center>
			</h1>
				<center>
					<pre>
<p>
<a href="/prizy-pricer/listProducts">Admin</a> OR <a href="/prizy-pricer/productEntry">Worker</a>
</p>
					</pre>
				</center>
	</form>
</body>
</html>