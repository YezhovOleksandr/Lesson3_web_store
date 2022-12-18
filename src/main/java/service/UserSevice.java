package service;

import entity.User;
import exceptions.IncorrectCredentialsException;
import modules.UserCredentials;

public interface UserSevice {
    void save(User user);

    User login(UserCredentials userCredentials) throws IncorrectCredentialsException;
}
