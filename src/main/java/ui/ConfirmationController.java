package ui;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/confirmation")
public class ConfirmationController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("Continue") != null) {
            HttpSession session = request.getSession();
            ArrayList<ProductInfo> cart = (ArrayList<ProductInfo>) session.getAttribute("cart");
            if (cart != null) {
                cart.clear();
            }
            response.sendRedirect("products.jsp");
        } else if (request.getParameter("Logout") != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }

}
