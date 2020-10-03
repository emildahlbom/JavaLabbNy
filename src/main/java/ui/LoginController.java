package ui;

import bo.UserHandler;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserHandler userHandler;

    public void init() {
        userHandler = new UserHandler();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(userHandler.validate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", true);
            UserInfo user = userHandler.getUser(username);
            session.setAttribute("user", user);
            response.sendRedirect("products.jsp");
        } else {
            request.setAttribute("error", "Invalid credentials.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}