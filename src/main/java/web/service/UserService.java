package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void delete(int id);

    void update(User user, int id);

    User findById(int id);

    List<User> viewAllUsers();
}