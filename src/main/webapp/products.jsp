<%@ page import="bo.ProductHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ui.ProductInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>User: <%= session.getAttribute("username") %></h1>
<%
    List<ProductInfo> productInfos = ProductHandler.getProducts();

    for (ProductInfo productInfo : productInfos) {
        %>
            <h1><%= productInfo.getName() %></h1>
            <h1><%= productInfo.getPrice() %></h1>

            <form action="<%=request.getContextPath()%>/products" method="post">
                    <input type = "hidden" name="name" value="<%= productInfo.getName()  %>" />
                    <input type = "hidden" name="price" value="<%= productInfo.getPrice()  %>" />
                    <input type = "submit" name="Add" value="Add to cart" />
            </form>
        <%
    }
%>

<%
    ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) request.getSession().getAttribute("cart");
    if (cart != null) {
        for (ProductInfo productInfo : cart) {
            %>
            <div><%= productInfo.getName()  %></div>
            <%
        }
    }
%>

<form action="<%=request.getContextPath()%>/products" method="post">
    <input type = "submit" name="Order" value="Place order" />
</form>
</body>
</html>
