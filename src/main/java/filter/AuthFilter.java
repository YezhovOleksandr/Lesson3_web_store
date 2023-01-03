package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(value = {"/user","/bucket.jsp","/create-product.jsp"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        Object userRole = session.getAttribute("role");
        if (userId != null || userRole != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
