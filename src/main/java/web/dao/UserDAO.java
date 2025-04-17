package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public void add(User user);

    public void delete(User user);

    public void edit(User user,int userId);

    public List<User> viewAllUsers();


}