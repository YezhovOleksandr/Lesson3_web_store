package dao;
import entity.Product;

import java.sql.SQLException;
import java.util.*;
public interface BucketDao {
    void createBucket(int userId) throws SQLException;
    List<Product> getAllProducts(int bucketId) throws SQLException;
    void insertProductIntoBucket(int bucketId, int productId) throws SQLException;
    void removeProductFromBucket(int bucketId, int productId) throws SQLException;
}
