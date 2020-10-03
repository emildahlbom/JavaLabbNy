package ui;

import bo.UserHandler;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserHandler userHandler;

    public void init() {
        userHandler = new UserHandler();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || address.isEmpty()) {
            forwardErrorMessage(request, response, "Invalid input data.");
            return;
        }

        UserInfo userInfo = new UserInfo(username, password, name, address);

        if (userHandler.register(userInfo)) {
            response.sendRedirect("login.jsp");
        } else {
            forwardErrorMessage(request, response, "Username is already in use.");
        }
    }

    private void forwardErrorMessage(HttpServletRequest request, HttpServletResponse response, String message) {
        request.setAttribute("error", message);
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}