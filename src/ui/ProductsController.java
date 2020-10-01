package ui;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getParameter("Add") != null) {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            ProductInfo productInfo = new ProductInfo(name, price);

            HttpSession session = request.getSession();
            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
            cart.add(productInfo);
            response.sendRedirect("products.jsp");
        } else if (request.getParameter("Order") != null) {
            // TODO place order
            response.sendRedirect("confirmation.jsp");
        }
    }

}
