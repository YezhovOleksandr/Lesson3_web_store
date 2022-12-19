package service.impl;

import dao.ProductDao;
import entity.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final String DEFAULT_IMAGE_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeHL3u0EubwNCoSV1e6yDdnzrVt33uCKnt0Q&usqp=CAU";
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void save(Product product) throws SQLException {
        String image = product.getImage();

        if (image == null) {
            product.setImage(DEFAULT_IMAGE_URL);
        }

        productDao.save(product);

    }

    @Override
    public List<Product> getAll() throws SQLException {
        return productDao.getAll();
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
