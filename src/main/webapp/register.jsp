<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div align="center">
    <h1>Register</h1>
    <form action="<%=request.getContextPath()%>/register" method="post">
        <table style="margin-bottom: 10px">
            <tr>
                <td><input type="text" name="username" placeholder="Username"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Password"/></td>
            </tr>
            <tr>
                <td><input type="text" name="name" placeholder="Name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="address" placeholder="Address"/></td>
            </tr>
        </table>
        <div style="display: inline-block">
            <input type="submit" name="register" value="Register" />
        </div>
    </form>
<%
    if (request.getAttribute("error") != null) {
        %>
            <h2>Error: <%= request.getAttribute("error") %></h2>
        <%
    }
%>
</div>
</body>
</html>
