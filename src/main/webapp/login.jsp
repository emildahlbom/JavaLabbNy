<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>Username</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <div style="display: inline-block">
            <input type="submit" name="login" value="Log in" />
            <a href="register.jsp">
                <button>Register</button>
            </a>
        </div>
    </form>
</div>
</body>
</html>