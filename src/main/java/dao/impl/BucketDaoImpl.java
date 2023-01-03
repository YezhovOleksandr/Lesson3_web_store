package dao.impl;

import dao.BucketDao;
import entity.Product;
import jdbc.Connector;
import mapper.ProductMapper;

import java.sql.*;
import java.util.List;

public class BucketDaoImpl implements BucketDao {
    private final Connection connection;

    public BucketDaoImpl() {
        connection = Connector.getConnection();
    }

    @Override
    public void createBucket(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO bucket(id, created_date) VALUES (?,?)");
        statement.setInt(1,userId);
        statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        statement.execute();
        statement.close();

    }

    @Override
    public List<Product> getAllProducts(int bucketId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "select p.id, p.name, p.description ,p.price,p.image from bucket_product bd inner join product p on bd.product_id = p.id where bd.bucket_id = ?");
        statement.setInt(1,bucketId);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = ProductMapper.mapProductsFromResultSet(resultSet);
        statement.close();
        return products;
    }

    @Override
    public void insertProductIntoBucket(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO bucket_product values (?,?)");
        statement.setInt(1,bucketId);
        statement.setInt(2,productId);
        statement.execute();
        statement.close();
    }

    @Override
    public void removeProductFromBucket(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM bucket_product WHERE bucket_id = ? AND product_id = ?");
        statement.setInt(1,bucketId);
        statement.setInt(2,productId);
        statement.execute();
        statement.close();

    }
}
