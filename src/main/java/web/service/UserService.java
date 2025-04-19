package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);

    public void delete(int id);
    public void update (User user, int id);


    public User findById(int id);
    public List<User> viewAllUsers();
}