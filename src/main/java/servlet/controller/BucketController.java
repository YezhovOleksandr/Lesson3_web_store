package servlet.controller;

import com.google.gson.Gson;
import dao.impl.BucketDaoImpl;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modules.BucketProduct;
import service.BucketService;
import service.impl.BucketServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
    private final BucketService bucketService;

    public BucketController() {
        bucketService = new BucketServiceImpl(new BucketDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        HttpSession session = req.getSession();
        List<Product> products = bucketService.getProducts((int) session.getAttribute("userId"));
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(products));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        BucketProduct bucketProduct = gson.fromJson(reader, BucketProduct.class);
        bucketService.addProduct(bucketProduct.bucketId, bucketProduct.productId);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bucketId =(int) req.getSession().getAttribute("userId");
        int productId = Integer.parseInt(req.getParameter("productId"));
        bucketService.removeProduct(bucketId, productId);
    }
}
