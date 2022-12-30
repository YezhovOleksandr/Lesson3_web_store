package service.impl;

import dao.BucketDao;
import dao.UserDao;
import dao.impl.BucketDaoImpl;
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
    private final BucketDao bucketDao;

    public UserSeviceImpl(UserDao userDao, BucketDao bucketDao) {
        this.userDao = userDao;
        this.bucketDao = bucketDao;
    }

    @Override
    public void save(User user) throws UserAlreadyExistsException {
        try {
            Optional<User> byEmail = userDao.getByEmail(user.getEmail());
            if (byEmail.isPresent()) {
                throw new UserAlreadyExistsException();
            }
            int saveId = userDao.insert(user);
            bucketDao.createBucket(saveId);
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
