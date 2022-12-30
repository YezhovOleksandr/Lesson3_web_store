package service;

import entity.Product;

import java.sql.SQLException;
import java.util.*;
public interface BucketService {
    List<Product> getProducts(int bucketId);
    void addProduct(int bucketId, int productId) ;
    void removeProduct(int bucketId, int productId);
}
