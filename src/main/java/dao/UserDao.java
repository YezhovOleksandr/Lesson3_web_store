package dao;

import entity.User;

import java.sql.SQLException;
import java.util.*;
public interface UserDao {
    Optional<User> getByEmail(String email) throws SQLException;

    int insert(User user) throws SQLException;

    Optional<User> getById(int id) throws SQLException;
 }
