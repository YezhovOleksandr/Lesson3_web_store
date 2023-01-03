package filter;

import entity.Role;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modules.SessionParams;

public class FilterHelper {
    public static SessionParams getSessionValues(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        Object userRole = session.getAttribute("userRole");
        SessionParams sessionParams = new SessionParams(userId.toString(),userRole.toString());
        return sessionParams;
    }
}
