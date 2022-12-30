package service.impl;

import dao.BucketDao;
import dao.UserDao;
import entity.Product;
import service.BucketService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BucketServiceImpl implements BucketService {
    private final BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public List<Product> getProducts(int bucketId)  {
        List<Product> allProducts = new ArrayList<>();
        try {
            allProducts = bucketDao.getAllProducts(bucketId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProducts;
    }

    @Override
    public void addProduct(int bucketId, int productId) {
        try {
            bucketDao.insertProductIntoBucket(bucketId, productId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeProduct(int bucketId, int productId)  {
        try {
            bucketDao.removeProductFromBucket(bucketId,productId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
