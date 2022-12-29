package service;

import entity.User;
import exceptions.IncorrectCredentialsException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import modules.UserCredentials;

import java.sql.SQLException;

public interface UserSevice {
    void save(User user) throws UserAlreadyExistsException;

    User login(UserCredentials userCredentials) throws IncorrectCredentialsException;

    User getById(int id) throws UserNotFoundException, SQLException;
}
