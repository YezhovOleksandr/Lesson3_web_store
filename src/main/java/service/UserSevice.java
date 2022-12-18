package service;

import entity.User;
import exceptions.IncorrectCredentialsException;
import exceptions.UserAlreadyExistsException;
import modules.UserCredentials;

public interface UserSevice {
    void save(User user) throws UserAlreadyExistsException;

    User login(UserCredentials userCredentials) throws IncorrectCredentialsException;
}
