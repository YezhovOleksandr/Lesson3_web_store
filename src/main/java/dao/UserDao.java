package dao;

import entity.User;

import java.sql.SQLException;
import java.util.*;
public interface UserDao {
    Optional<User> getByEmail(String email) throws SQLException;

    void insert(User user) throws SQLException;
 }
