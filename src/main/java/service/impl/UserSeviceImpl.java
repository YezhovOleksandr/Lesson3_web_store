package service.impl;

import dao.UserDao;
import entity.User;
import exceptions.IncorrectCredentialsException;
import modules.UserCredentials;
import service.UserSevice;

import java.sql.SQLException;
import java.util.Optional;

public class UserSeviceImpl implements UserSevice {
    private final UserDao userDao;

    public UserSeviceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        try {
            userDao.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User login(UserCredentials userCredentials) throws IncorrectCredentialsException {

        try {
            Optional<User> byEmail = userDao.getByEmail(userCredentials.getEmail());
            if (byEmail.isPresent()) {
                User user = byEmail.get();
                if (user.getPassword().equals(userCredentials.getPassword())) {
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IncorrectCredentialsException();
    }
}
