package ui;

import bo.UserHandler;
import java.io.IOException;
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
        UserInfo userInfo = new UserInfo(username, password);

        if(userHandler.validate(userInfo)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", true);
            response.sendRedirect("products.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}