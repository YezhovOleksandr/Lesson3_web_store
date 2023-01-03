package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modules.SessionParams;

import java.io.IOException;

@WebFilter(value = {"/user","/bucket.jsp","/create-product.jsp"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SessionParams values = FilterHelper.getSessionValues(servletRequest);
        if (values.userId != null || values.userRole != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
