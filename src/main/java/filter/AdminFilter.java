package filter;

import entity.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import modules.SessionParams;

import java.io.IOException;

@WebFilter("/create-product.jsp")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionParams sessionValues = FilterHelper.getSessionValues(servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("ROLE : " + sessionValues.userRole);
        if (!sessionValues.userRole.equals("ADMIN")) {
            response.setStatus(403);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
