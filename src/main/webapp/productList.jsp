<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all Products</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script type="text/javascript">

$(document).ready(function(){

    $.ajax(
    {
        type: "GET",
        url: "products",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
        var trHTML = '';
        $.each(data, function (i, item) {
            trHTML += '<tr><td>' + item.name + '</td><td><a href="viewProduct?id=' + item.id + '">View</a></td></tr>';
        });
        $('#products').append(trHTML);
        },
        error: function (msg) {
            alert(msg.responseText);
        }
    });
})
</script>
</head>
<body>
	
		<div
			style="margin-left: 300px; margin-top: 110px; background-color: #5FB404; padding: 20px; width: 650px; height: 450px">
			<a href = "index.jsp">Home</a>
			<h1>
				<center>All Products</center>
			</h1>
			<table id="products"></table>

		</div>
</body>
</html>