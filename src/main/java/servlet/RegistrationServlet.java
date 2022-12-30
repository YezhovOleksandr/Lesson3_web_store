package servlet;

import com.google.gson.Gson;
import dao.impl.BucketDaoImpl;
import dao.impl.UserDaoImpl;
import exceptions.UserAlreadyExistsException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entity.User;
import service.UserSevice;
import service.impl.UserSeviceImpl;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private final UserSevice userSevice;

    public RegistrationServlet() {
        userSevice = new UserSeviceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        BufferedReader reader = req.getReader();
        User user = gson.fromJson(reader, User.class);
        System.out.println(user);
        try {
            userSevice.save(user);
            resp.sendRedirect("login.jsp");
        } catch (UserAlreadyExistsException e) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
