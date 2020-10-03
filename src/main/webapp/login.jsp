<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
    <h1>Login</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="margin-bottom: 10px">
            <tr>
                <td><input type="text" name="username" placeholder="Username"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Password"/></td>
            </tr>
        </table>
        <div style="display: inline-block">
            <input type="submit" name="login" value="Log in" />
        </div>
    </form>
    <a href="register.jsp">
        <button style="margin-top: 5px">Register</button>
    </a>
<%
    if (request.getAttribute("error") != null) {
        %>
            <h1>Error: <%= request.getAttribute("error") %></h1>
        <%
    }
%>
</div>
</body>
</html>