package service.impl;

import dao.ProductDao;
import entity.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void save(Product product) throws SQLException {
        productDao.save(product);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> all = productDao.getAll();
        return all;
    }

    @Override
    public Product getById(int id) {
        try {
            Optional<Product> productById = productDao.getById(id);
            if(productById.isPresent()) {
                return productById.get();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
