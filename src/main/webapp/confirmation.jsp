<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<div align="center">
    <h1>Thank you for your order</h1>
    <h2>Ordernumber: <%= session.getAttribute("ordernumber") %></h2>
    <form action="<%=request.getContextPath()%>/confirmation" method="post">
        <input type = "submit" name="Continue" value="Continue shopping" style="margin-bottom: 5px"/>
        <input type = "submit" name="Logout" value="Logout" />
    </form>
</div>
</body>
</html>
