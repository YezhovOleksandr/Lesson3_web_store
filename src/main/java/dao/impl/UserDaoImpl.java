package dao.impl;

import dao.UserDao;
import jdbc.Connector;
import mapper.UserMapper;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final Connection connection;

    public UserDaoImpl() {
        connection = Connector.getConnection();
    }


    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id,first_name,last_name, email, password, role FROM user WHERE email = ?");
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        User user = UserMapper.mapToUser(resultSet);
        statement.close();
        return Optional.ofNullable(user);
    }

    @Override
    public void insert(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO user(first_name, last_name, email, password, role) VALUES (?,?,?,?,?)"
        );
        statement.setString(1,user.getFirst_name());
        statement.setString(2,user.getLast_name());
        statement.setString(3,user.getEmail());
        statement.setString(4,user.getPassword());
        statement.setString(5,user.getRole().name());
        statement.execute();
        statement.close();
    }

    @Override
    public Optional<User> getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "select * from user where id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        User user = UserMapper.mapToUser(resultSet);
        statement.close();
        return Optional.ofNullable(user);
    }
}
