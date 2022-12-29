package servlet.controller;

import com.google.gson.Gson;
import dao.impl.ProductDaoImpl;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;import lombok.SneakyThrows;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private final ProductService productService;

    public ProductController() {
        productService = new ProductServiceImpl(new ProductDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        Product product = gson.fromJson(reader, Product.class);
        try {
            productService.save(product);
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Gson gson = new Gson();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        List<Product> all = null;
        if (id != null) {
            Product product = productService.getById(Integer.parseInt(id));
            if (product == null) {
                resp.sendRedirect("404.jsp");
                return;
            }
            req.setAttribute("product",product);
            req.getRequestDispatcher("product-details.jsp").forward(req, resp);
        }

        try {
            all = productService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.print(gson.toJson(all));

    }
}
