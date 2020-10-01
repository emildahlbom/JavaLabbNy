package ui;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        boolean isLoggedIn = false;
        if(session.getAttribute("isLoggedIn") != null) {
            isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        }

        try {
            if (!isLoggedIn) {
                httpResponse.sendRedirect("login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
