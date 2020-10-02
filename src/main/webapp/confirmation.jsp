<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<h1>Thank you for your order</h1>
<h1>Ordernumber: <%= session.getAttribute("ordernumber") %></h1>
<form action="<%=request.getContextPath()%>/confirmation" method="post">
    <input type = "submit" name="Continue" value="Continue shopping" />
</form>
<form action="<%=request.getContextPath()%>/confirmation" method="post">
    <input type = "submit" name="Logout" value="Logout" />
</form>
</body>
</html>
