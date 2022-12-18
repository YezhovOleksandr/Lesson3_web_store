package servlet;

import dao.impl.UserDaoImpl;
import exceptions.IncorrectCredentialsException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modules.UserCredentials;
import service.UserSevice;
import service.impl.UserSeviceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserSevice userSevice;

    public LoginServlet() {
        userSevice = new UserSeviceImpl(new UserDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCredentials userCredentials = new UserCredentials(req.getParameter("email"),req.getParameter("password"));
        try {
            userSevice.login(userCredentials);
            resp.sendRedirect("/");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            resp.sendRedirect("login.jsp?error");
        }
    }
}
