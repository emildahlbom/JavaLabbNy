<%@ page import="bo.ProductHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ui.ProductInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ui.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
<%
    UserInfo user = (UserInfo) request.getSession().getAttribute("user");
%>
<div align="center">
    <h2>Customer information:</h2>
    <div>Username: <%= user.getUsername() %></div>
    <div>Name: <%= user.getName() %></div>
    <div>Address: <%= user.getAddress() %></div>
    <h2>Products:</h2>
    <%
        List<ProductInfo> productInfos = ProductHandler.getProducts();

        for (ProductInfo productInfo : productInfos) {
            %>
                <div style="display: inline-block">
                    <span><%= productInfo.getName() %>, </span>
                    <span style="margin-bottom: 5px"><%= productInfo.getPrice() %>kr</span>
                </div>

                <form action="<%= request.getContextPath() %>/products" method="post">
                        <input type = "hidden" name="name" value="<%= productInfo.getName()  %>" />
                        <input type = "hidden" name="price" value="<%= productInfo.getPrice()  %>" />
                        <input style="margin-top: 5px" type = "submit" name="Add" value="Add to cart" />
                </form>
            <%
        }
    %>
    <h2>Cart:</h2>
        <%
            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) request.getSession().getAttribute("cart");
            if (cart != null) {
                int totalPrice = cart.stream().map(ProductInfo::getPrice).reduce(0, Integer::sum);
                %>
                <ui style="width: fit-content">
                <%
                for (ProductInfo productInfo : cart) {
                    %>
                    <li><%= productInfo.getName() %>, <%= productInfo.getPrice() %>kr</li>
                    <%
                }
                    %>
                    </ui>
                    <div style="margin-bottom: 5px">Total price: <%= totalPrice %> kr</div>
                    <%
            }
        %>
    <form action="<%=request.getContextPath()%>/products" method="post">
        <%
            if(cart == null || cart.isEmpty()) {
                %>
                <input type = "submit" value="Clear cart" disabled/>
                <input type="submit" value="Place order" disabled/>
                <%
            } else {
                %>
                <input type = "submit" name="Clear" value="Clear cart" />
                <input type="submit" name="Order" value="Place order"/>
                <%
            }
        %>
        <input type = "submit" name="Logout" value="Logout" />
    </form>
</div>
</body>
</html>
