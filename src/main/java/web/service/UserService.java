package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);

    public void delete(User user);

    public void edit(User user, int userId);

    public User findById(int id);
    public List<User> viewAllUsers();
}