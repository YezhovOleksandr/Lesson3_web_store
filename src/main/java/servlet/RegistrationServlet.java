package servlet;

import dao.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entity.User;
import service.UserSevice;
import service.impl.UserSeviceImpl;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private final UserSevice userSevice;

    public RegistrationServlet() {
        userSevice = new UserSeviceImpl(new UserDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(first_name,last_name,email,password);
        System.out.println(user);
        userSevice.save(user);
        resp.sendRedirect("login.jsp");
    }
}
