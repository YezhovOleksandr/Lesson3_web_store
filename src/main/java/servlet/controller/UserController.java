package servlet.controller;

import dao.impl.UserDaoImpl;
import entity.User;
import exceptions.UserNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserSevice;
import service.impl.UserSeviceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private final UserSevice userSevice;

    public UserController() {
        userSevice = new UserSeviceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect("login.jsp");
        }
        try {
            User user = userSevice.getById((int) userId);
        } catch (UserNotFoundException e) {
            resp.sendRedirect("login.jsp");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            resp.setStatus(500);
        }
    }
}
