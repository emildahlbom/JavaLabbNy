package ui;

import bo.OrderHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("Add") != null) {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            ProductInfo productInfo = new ProductInfo(name, price);

            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
            cart.add(productInfo);
            response.sendRedirect("products.jsp");
        } else if (request.getParameter("Order") != null) {
            // TODO bryt ut
            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) session.getAttribute("cart");
            if (cart != null) {
                String username = (String) session.getAttribute("username");
                long orderId = OrderHandler.placeOrder(new OrderInfo(cart, username, new Timestamp(System.currentTimeMillis())));
                session.setAttribute("ordernumber", orderId);
                response.sendRedirect("confirmation.jsp");
            }
        } else if (request.getParameter("Clear") != null) {
            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) session.getAttribute("cart");
            if (cart != null) {
                cart.clear();
            }
            response.sendRedirect("products.jsp");
        } else if (request.getParameter("Logout") != null) {
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }

}
