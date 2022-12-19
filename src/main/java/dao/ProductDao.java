package dao;

import entity.Product;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.*;
public interface ProductDao {
    void save(Product product) throws SQLException;
    List<Product> getAll() throws SQLException;
    Optional<Product> getById(int id) throws SQLException;
}
