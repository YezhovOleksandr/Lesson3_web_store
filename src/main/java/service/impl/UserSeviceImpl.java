package service.impl;

import dao.UserDao;
import entity.User;
import exceptions.IncorrectCredentialsException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
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
    public void save(User user) throws UserAlreadyExistsException {
        try {
            Optional<User> byEmail = userDao.getByEmail(user.getEmail());
            if (byEmail.isPresent()) {
                throw new UserAlreadyExistsException();
            }
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

    @Override
    public User getById(int id) throws UserNotFoundException, SQLException {
        Optional<User> byId = userDao.getById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new UserNotFoundException();
    }
}
